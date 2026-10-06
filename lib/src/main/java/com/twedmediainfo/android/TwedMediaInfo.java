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

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.database.Cursor;

import com.twedmediainfo.android.internal.NativeBridge;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Wrapper de MediaInfoLib 26.05 para análisis de archivos multimedia en Android.
 * <p>
 * Esta clase expone las capacidades de MediaInfoLib a través de una API Java.
 * La capa nativa (MediaInfoLib, ZenLib y zlib) está enlazada estáticamente
 * en {@code libtwedmediainfo.so}.
 * <p>
 * TwedMediaInfo admite el análisis mediante Uri cuando el proveedor de contenido
 * proporciona acceso de lectura compatible con el procesamiento requerido por MediaInfoLib.
 * <p>
 * Uso típico con File:
 * <pre>{@code
 * TwedMediaInfo mediaInfo = new TwedMediaInfo();
 * try {
 *     if (mediaInfo.open("/path/to/file.mp4")) {
 *         String format = mediaInfo.getGeneral("Format");
 *         int audioCount = mediaInfo.countStreams(StreamKind.AUDIO);
 *         for (int i = 0; i < audioCount; i++) {
 *             String audioFormat = mediaInfo.get(StreamKind.AUDIO, i, Audio.FORMAT);
 *         }
 *     }
 * } finally {
 *     mediaInfo.destroy();
 * }
 * }</pre>
 * <p>
 * Uso típico con Uri:
 * <pre>{@code
 * TwedMediaInfo mediaInfo = new TwedMediaInfo(context);
 * try {
 *     if (mediaInfo.open(uri)) {
 *         String format = mediaInfo.getGeneral("Format");
 *         // ... mismas consultas que con File
 *     }
 * } finally {
 *     mediaInfo.destroy();
 * }
 * }</pre>
 */
public class TwedMediaInfo {

    private long handle;
    private boolean isOpen;
    private final Context context;

    /**
     * Crea una nueva instancia de TwedMediaInfo sin Context.
     * <p>
     * Este constructor permite usar {@link #open(String)} para rutas de archivo.
     * Para usar {@link #open(Uri)} se requiere el constructor con Context.
     * 
     * @throws IllegalStateException si no se puede crear la instancia nativa
     */
    public TwedMediaInfo() {
        this.context = null;
        this.handle = NativeBridge.nativeCreate();
        this.isOpen = false;
        
        if (handle == 0L) {
            throw new IllegalStateException("Failed to create native MediaInfo instance");
        }
    }

    /**
     * Crea una nueva instancia de TwedMediaInfo con Context para soporte de Uri.
     * <p>
     * Este constructor permite usar tanto {@link #open(String)} como {@link #open(Uri)}.
     * El Context se guarda internamente como applicationContext para evitar retener
     * referencias a Activity/Service.
     * 
     * @param context Context de Android (se usará getApplicationContext())
     * @throws IllegalStateException si no se puede crear la instancia nativa
     */
    public TwedMediaInfo(Context context) {
        this.context = context.getApplicationContext();
        this.handle = NativeBridge.nativeCreate();
        this.isOpen = false;
        
        if (handle == 0L) {
            throw new IllegalStateException("Failed to create native MediaInfo instance");
        }
    }

    /**
     * Abre un archivo multimedia para análisis mediante ruta de archivo.
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
     * Abre un archivo multimedia para análisis mediante Uri.
     * <p>
     * Utiliza ContentResolver para obtener acceso al contenido del Uri.
     * Requiere que esta instancia haya sido creada con {@link #TwedMediaInfo(Context)}.
     * <p>
     * Si ya hay un archivo abierto, lo cierra antes de abrir el nuevo.
     * <p>
     * Nota: No todos los Uri son compatibles. El proveedor de contenido debe proporcionar
     * acceso de lectura y, preferiblemente, capacidad de seek para análisis completo.
     *
     * @param uri Uri del archivo multimedia (content://, file://, etc.)
     * @return {@code true} si el archivo se abrió correctamente, {@code false} en caso contrario.
     * @throws IllegalStateException si esta instancia fue creada sin Context
     */
    public boolean open(Uri uri) {
        if (context == null) {
            throw new IllegalStateException(
                "open(Uri) requires TwedMediaInfo(Context) constructor. " +
                "Use new TwedMediaInfo(context) instead of new TwedMediaInfo()."
            );
        }
        if (uri == null) {
            return false;
        }
        
        if (isOpen) {
            close();
        }
        
        ParcelFileDescriptor pfd = null;
        FileInputStream fis = null;
        FileChannel channel = null;
        
        try {
            // Abrir el descriptor de archivo
            pfd = context.getContentResolver().openFileDescriptor(uri, "r");
            if (pfd == null) {
                return false;
            }
            
            // Obtener el tamaño del archivo
            long fileSize = pfd.getStatSize();
            if (fileSize <= 0) {
                // Intentar obtener tamaño via ContentResolver query
                fileSize = getFileSizeFromContentResolver(uri);
            }
            
            // Obtener FileChannel
            FileDescriptor fd = pfd.getFileDescriptor();
            fis = new FileInputStream(fd);
            channel = fis.getChannel();
            
            // Verificar si el canal es seekable
            boolean seekable = isChannelSeekable(channel);
            
            // Inicializar el buffer de MediaInfo
            if (!NativeBridge.nativeOpenBufferInit(handle, fileSize)) {
                return false;
            }
            
            // Buffer de lectura (64 KiB)
            byte[] buffer = new byte[64 * 1024];
            ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
            boolean finalized = false;
            long currentOffset = 0;
            
            while (!finalized) {
                // Leer datos del canal
                byteBuffer.clear();
                int bytesRead = channel.read(byteBuffer);
                
                if (bytesRead <= 0) {
                    // EOF o error
                    break;
                }
                
                // Pasar datos a MediaInfo
                int status = NativeBridge.nativeOpenBufferContinue(handle, buffer, bytesRead);
                currentOffset += bytesRead;
                
                // Verificar si MediaInfo finalizó (bit 3: Is Finalized)
                if ((status & 0x08) != 0) {
                    finalized = true;
                    break;
                }
                
                // Verificar si MediaInfo solicita un seek
                long goTo = NativeBridge.nativeOpenBufferGoToGet(handle);
                
                if (goTo >= 0 && goTo < fileSize) {
                    // MediaInfo solicita seek a esta posición
                    if (!seekable) {
                        // No se puede hacer seek, fallar controladamente
                        return false;
                    }
                    
                    // Hacer seek
                    channel.position(goTo);
                    currentOffset = goTo;
                    
                    // Re-inicializar buffer con nuevo offset
                    NativeBridge.nativeOpenBufferInit(handle, fileSize);
                }
            }
            
            // Finalizar el análisis
            boolean result = NativeBridge.nativeOpenBufferFinalize(handle);
            isOpen = result;
            return result;
            
        } catch (Exception e) {
            return false;
        } finally {
            // Cerrar recursos en orden inverso
            if (channel != null) {
                try { channel.close(); } catch (IOException e) { /* ignorar */ }
            }
            if (fis != null) {
                try { fis.close(); } catch (IOException e) { /* ignorar */ }
            }
            if (pfd != null) {
                try { pfd.close(); } catch (IOException e) { /* ignorar */ }
            }
        }
    }

    /**
     * Verifica si un FileChannel soporta operaciones de seek.
     */
    private boolean isChannelSeekable(FileChannel channel) {
        try {
            long pos = channel.position();
            channel.position(pos);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Intenta obtener el tamaño del archivo mediante ContentResolver query.
     */
    private long getFileSizeFromContentResolver(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(
                uri,
                new String[]{OpenableColumns.SIZE},
                null,
                null,
                null
            );
            
            if (cursor != null && cursor.moveToFirst()) {
                int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
                if (sizeIndex >= 0 && !cursor.isNull(sizeIndex)) {
                    return cursor.getLong(sizeIndex);
                }
            }
        } catch (Exception e) {
            // Ignorar errores de query
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return -1;
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