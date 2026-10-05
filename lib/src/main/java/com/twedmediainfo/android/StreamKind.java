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

/**
 * Tipos de stream disponibles en MediaInfoLib 26.05.
 * <p>
 * Estos valores corresponden al enum {@code stream_t} de MediaInfoLib
 * y se utilizan como primer parámetro en {@link TwedMediaInfo#get} y {@link TwedMediaInfo#countStreams}.
 */
public final class StreamKind {
    public static final int GENERAL = 0;
    public static final int VIDEO = 1;
    public static final int AUDIO = 2;
    public static final int TEXT = 3;
    public static final int OTHER = 4;
    public static final int IMAGE = 5;
    public static final int MENU = 6;

    private StreamKind() {
        // Prevenir instanciación
    }
}