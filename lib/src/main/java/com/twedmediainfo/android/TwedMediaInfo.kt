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

package com.twedmediainfo.android

import com.twedmediainfo.android.internal.NativeBridge

/**
 * Wrapper de MediaInfoLib 26.05 para análisis de archivos multimedia en Android.
 *
 * Esta clase expone las capacidades de MediaInfoLib a través de una API Kotlin.
 * La capa nativa (MediaInfoLib, ZenLib y zlib) está enlazada estáticamente
 * en `libtwedmediainfo.so`.
 *
 * Uso típico:
 * ```kotlin
 * val mediaInfo = TwedMediaInfo()
 * try {
 *     if (mediaInfo.open("/path/to/file.mp4")) {
 *         val format = mediaInfo.getGeneral("Format")
 *         val audioCount = mediaInfo.countStreams(StreamKind.Audio)
 *         for (i in 0 until audioCount) {
 *             val audioFormat = mediaInfo.get(StreamKind.Audio, i, Audio.FORMAT)
 *             val bitrate = mediaInfo.get(StreamKind.Audio, i, Audio.BITRATE_STRING)
 *             val channels = mediaInfo.get(StreamKind.Audio, i, Audio.CHANNELS_STRING)
 *         }
 *     }
 * } finally {
 *     mediaInfo.destroy()
 * }
 * ```
 *
 * La API genérica [get] permite consultar cualquier parámetro expuesto por
 * MediaInfoLib 26.05. Los parámetros de audio más comunes están disponibles
 * como constantes en [com.twedmediainfo.android.parameters.Audio].
 * Para la lista completa consultar los archivos .csv en
 * Source/Resource/Text/Stream/ en MediaInfoLib.
 */
class TwedMediaInfo {

    private var handle: Long = NativeBridge.nativeCreate()
    private var isOpen: Boolean = false

    init {
        if (handle == 0L) {
            throw IllegalStateException("Failed to create native MediaInfo instance")
        }
    }

    /**
     * Abre un archivo multimedia para análisis.
     *
     * Si ya hay un archivo abierto, lo cierra antes de abrir el nuevo.
     *
     * @param filePath Ruta absoluta al archivo.
     * @return `true` si el archivo se abrió correctamente, `false` en caso contrario.
     */
    fun open(filePath: String): Boolean {
        if (isOpen) {
            close()
        }
        val result = NativeBridge.nativeOpen(handle, filePath)
        isOpen = result
        return result
    }

    /**
     * Obtiene información general del archivo (Stream_General, stream 0).
     *
     * Equivalente a `get(StreamKind.General, 0, parameter)`.
     *
     * @param parameter Nombre del parámetro (ej: "Format", "Duration", "FileSize").
     * @return Valor del parámetro o string vacío si no existe.
     */
    fun getGeneral(parameter: String): String {
        if (!isOpen) return ""
        return NativeBridge.nativeGetGeneral(handle, parameter)
    }

    /**
     * Obtiene información de cualquier stream.
     *
     * @param streamKind Tipo de stream (usar constantes de [StreamKind]).
     * @param streamNumber Número de stream, 0-based.
     * @param parameter Nombre del parámetro (usar [com.twedmediainfo.android.parameters.Audio]
     *                  para audio, o el nombre directo de Audio.csv / Video.csv / etc.).
     * @return Valor del parámetro o string vacío si no existe.
     */
    fun get(streamKind: Int, streamNumber: Int, parameter: String): String {
        if (!isOpen) return ""
        return NativeBridge.nativeGet(handle, streamKind, streamNumber, parameter)
    }

    /**
     * Cuenta el número de streams de un tipo específico.
     *
     * @param streamKind Tipo de stream (usar constantes de [StreamKind]).
     * @return Número de streams de ese tipo, 0 si no hay streams o el archivo no está abierto.
     */
    fun countStreams(streamKind: Int): Int {
        if (!isOpen) return 0
        return NativeBridge.nativeCountStreams(handle, streamKind)
    }

    /**
     * Cierra el archivo actualmente abierto.
     *
     * No libera la instancia nativa; para liberarla usar [destroy].
     */
    fun close() {
        if (isOpen) {
            NativeBridge.nativeClose(handle)
            isOpen = false
        }
    }

    /**
     * Libera los recursos nativos.
     *
     * Cierra el archivo si está abierto y destruye la instancia nativa.
     * Debe llamarse cuando ya no se necesite la instancia.
     */
    fun destroy() {
        close()
        if (handle != 0L) {
            NativeBridge.nativeDestroy(handle)
            handle = 0
        }
    }

    companion object {
        /**
         * Obtiene la versión de MediaInfoLib embebida.
         */
        fun getMediaInfoVersion(): String = NativeBridge.nativeGetMediaInfoVersion()

        /**
         * Obtiene la versión de ZenLib embebida.
         */
        fun getZenLibVersion(): String = NativeBridge.nativeGetZenLibVersion()
    }
}