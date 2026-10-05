/*
 * Copyright 2026 TwedMediaInfo Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twedmediainfo.android;

import com.twedmediainfo.android.internal.NativeBridge;

/**
 * Wrapper de MediaInfoLib 26.05 para análisis de archivos multimedia en Android.
 * <p>
 * Esta clase expone las capacidades de MediaInfoLib a través de una API Java.
 * La capa nativa (MediaInfoLib, ZenLib y zlib) está enlazada estáticamente
 * en {@code libtwedmediainfo.so}.
 * <p>
 * Uso típico:
 * <pre>{@code
 * TwedMediaInfo mediaInfo = new TwedMediaInfo();
 * try {
 *     if (mediaInfo.open("/path/to/file.mp4")) {
 *         String format = mediaInfo.getGeneral("Format");
 *         int audioCount = mediaInfo.countStreams(StreamKind.AUDIO);
 *         for (int i = 0; i < audioCount; i++) {
 *             String audioFormat = mediaInfo.get(StreamKind.AUDIO, i, Audio.FORMAT);
 *             String bitrate = mediaInfo.get(StreamKind.AUDIO, i, Audio.BITRATE_STRING);
 *             String channels = mediaInfo.get(StreamKind.AUDIO, i, Audio.CHANNELS_STRING);
 *         }
 *     }
 * } finally {
 *     mediaInfo.destroy();
 * }
 * }</pre>
 * <p>
 * La API genérica {@link #get(int, int, String)} permite consultar cualquier parámetro expuesto por
 * MediaInfoLib 26.05. Los parámetros de audio más comunes están disponibles
 * como constantes en {@link com.twedmediainfo.android.parameters.Audio}.
 * Para la lista completa consultar los archivos .csv en
 * Source/Resource/Text/Stream/ en MediaInfoLib.
 */
public class TwedMediaInfo {

    private long handle;
    private boolean isOpen;

    /**
     * Crea una nueva instancia de TwedMediaInfo.
     * 
     * @throws IllegalStateException si no se puede crear la instancia nativa
     */
    public TwedMediaInfo() {
        this.handle = NativeBridge.nativeCreate();
        this.isOpen = false;
        
        if (handle == 0L) {
            throw new IllegalStateException("Failed to create native MediaInfo instance");
        }
    }

    /**
     * Abre un archivo multimedia para análisis.
     * <p>
     * Si ya hay un archivo abierto, lo cierra antes de abrir el nuevo.
     *
     * @param filePath Ruta absoluta al archivo.
     * @return {@code true} si el archivo se abrió correctamente, {@code false} en caso contrario.
     */
    public boolean open(String filePath) {
        if (isOpen) {
            close();
        }
        boolean result = NativeBridge.nativeOpen(handle, filePath);
        isOpen = result;
        return result;
    }

    /**
     * Obtiene información general del archivo (Stream_General, stream 0).
     * <p>
     * Equivalente a {@code get(StreamKind.GENERAL, 0, parameter)}.
     *
     * @param parameter Nombre del parámetro (ej: "Format", "Duration", "FileSize").
     * @return Valor del parámetro o string vacío si no existe.
     */
    public String getGeneral(String parameter) {
        if (!isOpen) {
            return "";
        }
        return NativeBridge.nativeGetGeneral(handle, parameter);
    }

    /**
     * Obtiene información de cualquier stream.
     *
     * @param streamKind Tipo de stream (usar constantes de {@link StreamKind}).
     * @param streamNumber Número de stream, 0-based.
     * @param parameter Nombre del parámetro (usar {@link com.twedmediainfo.android.parameters.Audio}
     *                  para audio, o el nombre directo de Audio.csv / Video.csv / etc.).
     * @return Valor del parámetro o string vacío si no existe.
     */
    public String get(int streamKind, int streamNumber, String parameter) {
        if (!isOpen) {
            return "";
        }
        return NativeBridge.nativeGet(handle, streamKind, streamNumber, parameter);
    }

    /**
     * Cuenta el número de streams de un tipo específico.
     *
     * @param streamKind Tipo de stream (usar constantes de {@link StreamKind}).
     * @return Número de streams de ese tipo, 0 si no hay streams o el archivo no está abierto.
     */
    public int countStreams(int streamKind) {
        if (!isOpen) {
            return 0;
        }
        return NativeBridge.nativeCountStreams(handle, streamKind);
    }

    /**
     * Cierra el archivo actualmente abierto.
     * <p>
     * No libera la instancia nativa; para liberarla usar {@link #destroy()}.
     */
    public void close() {
        if (isOpen) {
            NativeBridge.nativeClose(handle);
            isOpen = false;
        }
    }

    /**
     * Libera los recursos nativos.
     * <p>
     * Cierra el archivo si está abierto y destruye la instancia nativa.
     * Debe llamarse cuando ya no se necesite la instancia.
     */
    public void destroy() {
        close();
        if (handle != 0L) {
            NativeBridge.nativeDestroy(handle);
            handle = 0;
        }
    }

    /**
     * Obtiene la versión de MediaInfoLib embebida.
     * 
     * @return String con la versión de MediaInfoLib
     */
    public static String getMediaInfoVersion() {
        return NativeBridge.nativeGetMediaInfoVersion();
    }

    /**
     * Obtiene la versión de ZenLib embebida.
     * 
     * @return String con la versión de ZenLib
     */
    public static String getZenLibVersion() {
        return NativeBridge.nativeGetZenLibVersion();
    }
}