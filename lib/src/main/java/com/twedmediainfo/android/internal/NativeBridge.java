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

package com.twedmediainfo.android.internal;

/**
 * Puente JNI hacia la biblioteca nativa libtwedmediainfo.so
 * <p>
 * Esta clase proporciona acceso directo a las funciones nativas de MediaInfoLib.
 * NO es parte de la API pública y puede cambiar sin previo aviso.
 */
public final class NativeBridge {
    static {
        NativeLoader.ensureLoaded();
    }

    /**
     * Obtiene la versión de MediaInfoLib.
     */
    public static native String nativeGetMediaInfoVersion();

    /**
     * Obtiene la versión de ZenLib.
     */
    public static native String nativeGetZenLibVersion();

    /**
     * Crea una nueva instancia nativa de MediaInfo.
     * @return Handle nativo (puntero como long) o 0 si falla.
     */
    public static native long nativeCreate();

    /**
     * Abre un archivo para análisis.
     * @param handle Handle nativo devuelto por nativeCreate()
     * @param path Ruta absoluta al archivo
     * @return true si el archivo se abrió correctamente
     */
    public static native boolean nativeOpen(long handle, String path);

    /**
     * Inicializa el buffer para análisis mediante stream.
     * @param handle Handle nativo
     * @param fileSize Tamaño total del archivo (-1 si desconocido)
     * @return true si se inicializó correctamente
     */
    public static native boolean nativeOpenBufferInit(long handle, long fileSize);

    /**
     * Continúa el análisis pasando un buffer de datos.
     * @param handle Handle nativo
     * @param buffer Buffer con datos del archivo
     * @param size Número de bytes válidos en el buffer
     * @return Bitfield de estado:
     *         bit 0: Is Accepted (formato conocido)
     *         bit 1: Is Filled (datos principales recolectados)
     *         bit 2: Is Updated (algunos datos actualizados)
     *         bit 3: Is Finalized (no se necesitan más datos)
     */
    public static native int nativeOpenBufferContinue(long handle, byte[] buffer, int size);

    /**
     * Obtiene la posición de seek solicitada por MediaInfo.
     * @param handle Handle nativo
     * @return Offset solicitado, o -1 si no hay seek pendiente,
     *         o fileSize si no se necesitan más bytes
     */
    public static native long nativeOpenBufferGoToGet(long handle);

    /**
     * Finaliza el análisis del buffer.
     * @param handle Handle nativo
     * @return true si se finalizó correctamente
     */
    public static native boolean nativeOpenBufferFinalize(long handle);

    /**
     * Obtiene información general del archivo (Stream_General, stream 0).
     * @param handle Handle nativo
     * @param parameter Nombre del parámetro (ej: "Format", "Duration")
     * @return Valor del parámetro o string vacío
     */
    public static native String nativeGetGeneral(long handle, String parameter);

    /**
     * Obtiene información de cualquier stream.
     * @param handle Handle nativo
     * @param streamKind Tipo de stream (0=General, 1=Video, 2=Audio, 3=Text, etc.)
     * @param streamNumber Número de stream (0-based)
     * @param parameter Nombre del parámetro
     * @return Valor del parámetro o string vacío
     */
    public static native String nativeGet(long handle, int streamKind, int streamNumber, String parameter);

    /**
     * Cuenta el número de streams de un tipo específico.
     * @param handle Handle nativo
     * @param streamKind Tipo de stream (0=General, 1=Video, 2=Audio, 3=Text, etc.)
     * @return Número de streams de ese tipo
     */
    public static native int nativeCountStreams(long handle, int streamKind);

    /**
     * Cierra el archivo actualmente abierto.
     * @param handle Handle nativo
     */
    public static native void nativeClose(long handle);

    /**
     * Destruye la instancia nativa y libera memoria.
     * @param handle Handle nativo
     */
    public static native void nativeDestroy(long handle);

    private NativeBridge() {
        // Prevenir instanciación
    }
}