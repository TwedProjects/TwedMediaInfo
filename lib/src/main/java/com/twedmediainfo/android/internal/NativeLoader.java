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
 * Carga la biblioteca nativa libtwedmediainfo.so
 * <p>
 * Esta clase garantiza que la biblioteca se cargue exactamente una vez
 * antes de utilizar cualquier método JNI.
 */
final class NativeLoader {
    static {
        System.loadLibrary("twedmediainfo");
    }

    /**
     * Fuerza la carga de la biblioteca nativa.
     * Llamar a este método garantiza que la biblioteca esté cargada.
     */
    static void ensureLoaded() {
        // El bloque static se ejecuta automáticamente al acceder a esta clase
    }

    private NativeLoader() {
        // Prevenir instanciación
    }
}