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

#ifndef TWEDMEDIAINFO_ADAPTER_H
#define TWEDMEDIAINFO_ADAPTER_H

#include <string>

namespace twedmediainfo {

/**
 * Adapter para MediaInfoLib 26.05
 * Proporciona una interfaz C++ limpia sobre MediaInfoLib para uso desde JNI.
 */
class TwedMediaInfoAdapter {
public:
    TwedMediaInfoAdapter();
    ~TwedMediaInfoAdapter();

    // Prevent copying
    TwedMediaInfoAdapter(const TwedMediaInfoAdapter&) = delete;
    TwedMediaInfoAdapter& operator=(const TwedMediaInfoAdapter&) = delete;

    /**
     * Obtiene la versión de MediaInfoLib.
     */
    std::string getMediaInfoVersion() const;

    /**
     * Obtiene la versión de ZenLib.
     */
    std::string getZenLibVersion() const;

    /**
     * Abre un archivo para análisis.
     * @param path Ruta absoluta al archivo.
     * @return true si el archivo fue abierto correctamente.
     */
    bool open(const std::string& path);

    /**
     * Cierra el archivo actualmente abierto.
     */
    void close();

    /**
     * Obtiene información general del archivo (Stream_General, stream 0).
     * @param parameter Nombre del parámetro (ej: "Format", "Duration").
     * @return Valor del parámetro o string vacío.
     */
    std::string getGeneralInfo(const std::string& parameter) const;

    /**
     * Obtiene información de cualquier stream.
     * @param streamKind Tipo de stream (0=General, 1=Video, 2=Audio, 3=Text, etc.)
     * @param streamNumber Número de stream (0-based)
     * @param parameter Nombre del parámetro
     * @return Valor del parámetro o string vacío
     */
    std::string get(int streamKind, int streamNumber, const std::string& parameter) const;

    /**
     * Cuenta el número de streams de un tipo específico.
     * @param streamKind Tipo de stream (0=General, 1=Video, 2=Audio, 3=Text, etc.)
     * @return Número de streams de ese tipo
     */
    int countStreams(int streamKind) const;

private:
    void* nativeHandle_;  // MediaInfo* internally
    bool isOpen_;
};

} // namespace twedmediainfo

#endif // TWEDMEDIAINFO_ADAPTER_H