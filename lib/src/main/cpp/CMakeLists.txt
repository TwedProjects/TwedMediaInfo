# Copyright 2026 TwedMediaInfo Contributors
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

cmake_minimum_required(VERSION 3.22.1)
project(TwedMediaInfo LANGUAGES C CXX)

# ==============================================================================
# Configuración global
# ==============================================================================
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)
set(CMAKE_POSITION_INDEPENDENT_CODE ON)

# Rutas base
set(TWED_ROOT_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../..)
set(THIRD_PARTY_DIR ${TWED_ROOT_DIR}/third_party)
set(ZLIB_DIR ${THIRD_PARTY_DIR}/zlib-1.3.2)
set(ZENLIB_DIR ${THIRD_PARTY_DIR}/ZenLib-0.4.41)
set(MEDIAINFOLIB_DIR ${THIRD_PARTY_DIR}/MediaInfoLib-26.05)
set(MI_SOURCE ${MEDIAINFOLIB_DIR}/Source)

# ==============================================================================
# 1. ZLIB - Compilado manualmente como biblioteca estática
# ==============================================================================
# En lugar de usar add_subdirectory(), compilamos zlib directamente para tener
# control total sobre qué se genera y evitar que Gradle empaquete libz.so
set(ZLIB_SOURCES
    ${ZLIB_DIR}/adler32.c
    ${ZLIB_DIR}/compress.c
    ${ZLIB_DIR}/crc32.c
    ${ZLIB_DIR}/deflate.c
    ${ZLIB_DIR}/gzclose.c
    ${ZLIB_DIR}/gzlib.c
    ${ZLIB_DIR}/gzread.c
    ${ZLIB_DIR}/gzwrite.c
    ${ZLIB_DIR}/infback.c
    ${ZLIB_DIR}/inffast.c
    ${ZLIB_DIR}/inflate.c
    ${ZLIB_DIR}/inftrees.c
    ${ZLIB_DIR}/trees.c
    ${ZLIB_DIR}/uncompr.c
    ${ZLIB_DIR}/zutil.c
)

add_library(zlib_static STATIC ${ZLIB_SOURCES})

target_include_directories(zlib_static PUBLIC
    ${ZLIB_DIR}
    ${ZLIB_DIR}/contrib/minizip  # Si MediaInfoLib lo necesita
)

# Definiciones para compilar zlib
# HAVE_UNISTD_H: necesario para que zconf.h incluya <unistd.h> y las funciones
# POSIX (write, read, close, lseek) estén declaradas en los archivos gz*.c
target_compile_definitions(zlib_static PRIVATE
    ZLIB_CONST
    HAVE_UNISTD_H
)

# ==============================================================================
# 2. ZENLIB - Biblioteca estática
# ==============================================================================
set(BUILD_SHARED_LIBS OFF CACHE BOOL "" FORCE)
set(ENABLE_UNICODE ON CACHE BOOL "" FORCE)
set(LARGE_FILES ON CACHE BOOL "" FORCE)
add_subdirectory(
    ${ZENLIB_DIR}/Project/CMake
    ${CMAKE_CURRENT_BINARY_DIR}/ZenLib
    EXCLUDE_FROM_ALL
)

# ==============================================================================
# 3. MEDIAINFOLIB - Compilado desde fuentes
# ==============================================================================

# --- ThirdParty sources (explícitas, basadas en el CMake oficial) ---
set(MEDIAINFO_THIRDPARTY_SOURCES
    ${MI_SOURCE}/ThirdParty/md5/md5.c
    ${MI_SOURCE}/ThirdParty/aes-gladman/aes_modes.c
    ${MI_SOURCE}/ThirdParty/aes-gladman/aes_ni.c
    ${MI_SOURCE}/ThirdParty/aes-gladman/aescrypt.c
    ${MI_SOURCE}/ThirdParty/aes-gladman/aeskey.c
    ${MI_SOURCE}/ThirdParty/aes-gladman/aestab.c
    ${MI_SOURCE}/ThirdParty/sha1-gladman/sha1.c
    ${MI_SOURCE}/ThirdParty/sha2-gladman/sha2.c
    ${MI_SOURCE}/ThirdParty/hmac-gladman/hmac.c
    ${MI_SOURCE}/ThirdParty/tfsxml/tfsxml.c
    ${MI_SOURCE}/ThirdParty/fmt/format.cc
    ${MI_SOURCE}/ThirdParty/tinyxml2/tinyxml2.cpp
)

# --- MediaInfo core sources (GLOB por directorio, coincide con el CMake oficial) ---
file(GLOB MI_CORE_SOURCES ${MI_SOURCE}/MediaInfo/*.cpp)
file(GLOB MI_ARCHIVE_SOURCES ${MI_SOURCE}/MediaInfo/Archive/*.cpp)
file(GLOB MI_AUDIO_SOURCES ${MI_SOURCE}/MediaInfo/Audio/*.cpp)
file(GLOB MI_DUPLICATE_SOURCES ${MI_SOURCE}/MediaInfo/Duplicate/*.cpp)
file(GLOB MI_EXPORT_SOURCES ${MI_SOURCE}/MediaInfo/Export/*.cpp)
file(GLOB MI_IMAGE_SOURCES ${MI_SOURCE}/MediaInfo/Image/*.cpp)
file(GLOB MI_MULTIPLE_SOURCES ${MI_SOURCE}/MediaInfo/Multiple/*.cpp)
file(GLOB MI_READER_SOURCES ${MI_SOURCE}/MediaInfo/Reader/*.cpp)
file(GLOB MI_TAG_SOURCES ${MI_SOURCE}/MediaInfo/Tag/*.cpp)
file(GLOB MI_TEXT_SOURCES ${MI_SOURCE}/MediaInfo/Text/*.cpp)
file(GLOB MI_VIDEO_SOURCES ${MI_SOURCE}/MediaInfo/Video/*.cpp)

# Combinar todas las fuentes de MediaInfoLib
set(MEDIAINFO_ALL_SOURCES
    ${MI_CORE_SOURCES}
    ${MI_ARCHIVE_SOURCES}
    ${MI_AUDIO_SOURCES}
    ${MI_DUPLICATE_SOURCES}
    ${MI_EXPORT_SOURCES}
    ${MI_IMAGE_SOURCES}
    ${MI_MULTIPLE_SOURCES}
    ${MI_READER_SOURCES}
    ${MI_TAG_SOURCES}
    ${MI_TEXT_SOURCES}
    ${MI_VIDEO_SOURCES}
    ${MEDIAINFO_THIRDPARTY_SOURCES}
)

# Excluir archivos que no necesitamos
list(FILTER MEDIAINFO_ALL_SOURCES EXCLUDE REGEX ".*MediaInfoDLL\\.cpp$")
list(FILTER MEDIAINFO_ALL_SOURCES EXCLUDE REGEX ".*MediaInfoJNI\\.cpp$")
list(FILTER MEDIAINFO_ALL_SOURCES EXCLUDE REGEX ".*MediaInfoJS\\.cpp$")

# Crear target estático de MediaInfoLib
add_library(mediainfo_static STATIC ${MEDIAINFO_ALL_SOURCES})

# Include directories
target_include_directories(mediainfo_static PRIVATE
    ${MI_SOURCE}
    ${MI_SOURCE}/MediaInfo
    ${MI_SOURCE}/ThirdParty
    ${MI_SOURCE}/ThirdParty/md5
    ${MI_SOURCE}/ThirdParty/base64
    ${MI_SOURCE}/ThirdParty/aes-gladman
    ${MI_SOURCE}/ThirdParty/sha1-gladman
    ${MI_SOURCE}/ThirdParty/sha2-gladman
    ${MI_SOURCE}/ThirdParty/hmac-gladman
    ${MI_SOURCE}/ThirdParty/tinyxml2
    ${ZENLIB_DIR}/Source
    ${ZLIB_DIR}
)

# Compile definitions
target_compile_definitions(mediainfo_static PRIVATE
    MEDIAINFO_LIBMMS_NO
    MEDIAINFO_LIBCURL_DLL_RUNTIME
    MEDIAINFO_GRAPHVIZ_DLL_RUNTIME
    MEDIAINFO_JNI_NO
    FMT_UNICODE=0
)

# Precompiled headers (CMake >= 3.16)
if(NOT CMAKE_VERSION VERSION_LESS "3.16")
    target_precompile_headers(mediainfo_static PRIVATE
        ${MI_SOURCE}/MediaInfo/PreComp.h
    )
    set_source_files_properties(
        ${MI_SOURCE}/MediaInfo/TimeCode.cpp
        ${MEDIAINFO_THIRDPARTY_SOURCES}
        PROPERTIES SKIP_PRECOMPILE_HEADERS ON
    )
endif()

# Link MediaInfoLib contra ZenLib y zlib
target_link_libraries(mediainfo_static PRIVATE
    zen
    zlib_static
)

# ==============================================================================
# 4. TWEDMEDIAINFO - Shared library final
# ==============================================================================

set(TWED_SOURCES
    ${CMAKE_CURRENT_SOURCE_DIR}/jni/twedmediainfo_jni.cpp
    ${CMAKE_CURRENT_SOURCE_DIR}/adapter/twedmediainfo_adapter.cpp
)

add_library(twedmediainfo SHARED ${TWED_SOURCES})

target_include_directories(twedmediainfo PRIVATE
    ${CMAKE_CURRENT_SOURCE_DIR}
    ${MI_SOURCE}
    ${MI_SOURCE}/MediaInfo
    ${ZENLIB_DIR}/Source
)

target_link_libraries(twedmediainfo PRIVATE
    mediainfo_static
    zen
    zlib_static
    log
)

# ==============================================================================
# 5. 16 KB Page Size - Linker flags
# ==============================================================================
if(ANDROID_ABI STREQUAL "arm64-v8a")
    target_link_options(twedmediainfo PRIVATE
        "-Wl,-z,max-page-size=16384"
    )
endif()

if(ANDROID_ABI STREQUAL "armeabi-v7a")
    target_link_options(twedmediainfo PRIVATE
        "-Wl,-z,max-page-size=16384"
    )
endif()

# ==============================================================================
# 6. Flags de optimización
# ==============================================================================
target_compile_options(twedmediainfo PRIVATE
    -Wall
    -Wextra
    -Wno-unused-parameter
)

if(CMAKE_BUILD_TYPE STREQUAL "Release")
    target_link_options(twedmediainfo PRIVATE "-Wl,--strip-all")
endif()