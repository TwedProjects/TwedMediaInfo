# Soporte y catálogos de TwedMediaInfo 0.1.0

Este documento explica qué representa cada catálogo público de parámetros y dónde consultar los formatos que se pueden analizar. Para aprender a usar la API, consulta [`DOC.md`](DOC.md).

## Catálogos de parámetros

Los catálogos agrupan los parámetros que se pueden consultar y se corresponden con los tipos de stream de `StreamKind`.

- **General**: información general del archivo o del contenedor completo, junto con sus metadatos generales. No describe un stream individual. Corresponde a `StreamKind.GENERAL`.
- **Video**: información de los streams de video del archivo. Corresponde a `StreamKind.VIDEO`.
- **Audio**: información de los streams de audio del archivo. Corresponde a `StreamKind.AUDIO`.
- **Image**: información de los streams de imagen del archivo. Corresponde a `StreamKind.IMAGE`.
- **Text**: información de los streams de texto de `StreamKind.TEXT`, es decir, subtítulos y texto temporizado dentro del archivo multimedia. No se refiere a archivos `.txt` ni `.lrc`.
- **Other**: información de los streams de `StreamKind.OTHER`, que agrupan elementos auxiliares del contenedor, como capítulos o timecodes embebidos. No significa "otros formatos de archivo".

## Consultar todos los parámetros

Si necesitas ver todos los parámetros disponibles, consulta directamente los archivos de la API pública:

- [General](lib/src/main/java/com/twedmediainfo/android/parameters/General.java)
- [Video](lib/src/main/java/com/twedmediainfo/android/parameters/Video.java)
- [Audio](lib/src/main/java/com/twedmediainfo/android/parameters/Audio.java)
- [Image](lib/src/main/java/com/twedmediainfo/android/parameters/Image.java)
- [Text](lib/src/main/java/com/twedmediainfo/android/parameters/Text.java)
- [Other](lib/src/main/java/com/twedmediainfo/android/parameters/Other.java)

## Contenedores, codecs y formatos

TwedMediaInfo no declara una matriz independiente de formatos soportados. El análisis depende de las capacidades de la MediaInfoLib integrada, que en esta versión es la 26.05.

Para conocer los formatos y las etiquetas que MediaInfo puede reconocer, consulta las referencias oficiales de MediaArea:

- [Formats](https://mediaarea.net/en/MediaInfo/Support/Formats)
- [Tags](https://mediaarea.net/en/MediaInfo/Support/Tags)

Estas páginas son referencias oficiales de MediaArea/MediaInfo y no constituyen una declaración independiente de soporte por parte de TwedMediaInfo.
