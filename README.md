# TwedMediaInfo

Biblioteca Android que proporciona una interfaz moderna y reutilizable para trabajar con [MediaInfoLib](https://github.com/MediaArea/MediaInfoLib).

TwedMediaInfo está diseñada como una biblioteca de propósito general para aplicaciones Android y no está vinculada exclusivamente a una aplicación concreta.

## Características

- API orientada a Android para Kotlin/Java.
- Acceso a información técnica y metadatos multimedia.
- Modelo basado en streams para representar la información de MediaInfoLib.
- Puente JNI entre Android y MediaInfoLib.
- Compilación nativa mediante CMake y Android NDK.
- Soporte inicial para `arm64-v8a` y `armeabi-v7a`.
- Distribución mediante AAR.
- Compatibilidad objetivo con Android API 27 o superior.
- Preparada para la compatibilidad con páginas de memoria de 16 KB.

## Arquitectura

```text
Aplicación Android
        │
        ▼
   API TwedMediaInfo
        │
        ▼
        JNI
        │
        ▼
    MediaInfoLib
       /    \
   ZenLib   zlib
```

TwedMediaInfo proporciona la interfaz adaptada a Android, mientras que MediaInfoLib continúa siendo responsable del análisis de archivos multimedia y de la extracción de información.

## Versiones de dependencias

Actualmente el proyecto utiliza:

- MediaInfoLib `26.05`
- ZenLib `0.4.41`
- zlib `1.3.2`

Las versiones se mantienen fijadas para facilitar compilaciones reproducibles y controlar las actualizaciones de las dependencias nativas.

## Requisitos

- Android API 27 o superior.
- Kotlin o Java.
- Android NDK.
- CMake.

## Instalación

Una vez publicada una versión estable en Maven Central, podrá añadirse como una dependencia normal:

```kotlin
dependencies {
    implementation("com.twedmediainfo:twedmediainfo:<version>")
}
```

> La publicación en Maven Central puede no estar disponible todavía durante la etapa de desarrollo.

## Uso básico

Ejemplo conceptual de lectura de información:

```kotlin
val mediaInfo = TwedMediaInfo()

mediaInfo.open(file)

val title = mediaInfo.get(
    streamKind = StreamKind.General,
    streamNumber = 0,
    parameter = "Title"
)

val duration = mediaInfo.get(
    streamKind = StreamKind.General,
    streamNumber = 0,
    parameter = "Duration"
)

mediaInfo.close()
```

La API busca ofrecer tanto operaciones sencillas para los casos habituales como acceso suficientemente general para aplicaciones que necesiten información más detallada de MediaInfoLib.

## ABI compatibles

Actualmente se contemplan:

- `arm64-v8a`
- `armeabi-v7a`

No se incluyen `x86` ni `x86_64` en la configuración inicial.

## Estado del proyecto

**En desarrollo.**

La API pública puede sufrir cambios antes de alcanzar una primera versión estable.

Las características y plataformas anunciadas deben considerarse parte del objetivo actual del proyecto hasta que hayan sido verificadas mediante compilaciones y pruebas.

## Licencia

TwedMediaInfo se distribuye bajo su propia licencia.

El proyecto incorpora software de terceros, incluyendo MediaInfoLib, ZenLib y zlib. Las licencias y avisos de copyright correspondientes deben conservarse y distribuirse de acuerdo con sus respectivas condiciones.

La información sobre las licencias de terceros se encuentra en:

```text
THIRD_PARTY_LICENSES/
```

## Proyecto relacionado

- [MediaInfoLib](https://github.com/MediaArea/MediaInfoLib) — biblioteca utilizada por TwedMediaInfo para el análisis de archivos multimedia.

TwedMediaInfo es un proyecto independiente y no es un proyecto oficial de MediaArea.

## Contribuciones

Las contribuciones, informes de errores y sugerencias son bienvenidos.

Para cambios importantes en la API pública, la capa JNI o la integración nativa, se recomienda discutir primero la propuesta mediante un issue.

## Objetivo

El objetivo de TwedMediaInfo es proporcionar una integración Android reutilizable de MediaInfoLib, evitando que cada aplicación tenga que implementar por separado la integración entre Android, JNI, CMake, NDK y la biblioteca nativa.

La biblioteca está diseñada para que el consumidor pueda trabajar principalmente desde Kotlin/Java sin tener que interactuar directamente con las APIs internas de C++ de MediaInfoLib.
