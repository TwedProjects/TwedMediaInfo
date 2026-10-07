# TwedMediaInfo 0.1.0 — Documentación de la API

Este documento describe la **API pública** de TwedMediaInfo 0.1.0. Complementa al [README](README.md), que contiene la introducción general, la instalación, las atribuciones y la distribución. Aquí solo se documenta cómo usar la API.

## Contenido

1. [Introducción](#1-introducción)
2. [API pública](#2-api-pública)
3. [Ejemplos de uso](#3-ejemplos-de-uso)
4. [Catálogos de parámetros](#4-catálogos-de-parámetros)
5. [Uri (sin soporte garantizado en 0.1.0)](#5-uri-sin-soporte-garantizado-en-010)
6. [Limitaciones conocidas](#6-limitaciones-conocidas)
7. [Arquitectura de alto nivel](#7-arquitectura-de-alto-nivel)
8. [Compatibilidad](#8-compatibilidad)
9. [Licencia](#9-licencia)

---

## 1. Introducción

TwedMediaInfo es una biblioteca para Android, con API Java, que permite analizar archivos multimedia y consultar sus metadatos e información técnica (por ejemplo, formato, duración, resolución o canales de audio).

Es una adaptación/integración para Android basada en [MediaInfoLib](https://github.com/MediaArea/MediaInfoLib), desarrollada por MediaArea.net SARL. TwedMediaInfo no reimplementa el análisis: lo delega en MediaInfoLib 26.05, enlazada de forma estática en la biblioteca nativa `libtwedmediainfo.so`.

En esta versión, la entrada oficialmente soportada para abrir un archivo es una **ruta de archivo** (`File`/`String`).

---

## 2. API pública

### 2.1 Paquetes

| Paquete | Contenido |
|---|---|
| `com.twedmediainfo.android` | `TwedMediaInfo`, `StreamKind` |
| `com.twedmediainfo.android.parameters` | Catálogos de constantes: `General`, `Video`, `Audio`, `Image`, `Text`, `Other` |
| `com.twedmediainfo.android.internal` | `NativeBridge`, `NativeLoader`. **No forman parte de la API pública** (ver [sección 7](#7-arquitectura-de-alto-nivel)). |

### 2.2 Clase `TwedMediaInfo`

```java
package com.twedmediainfo.android;

public class TwedMediaInfo
```

Es la clase principal. Cada instancia mantiene una instancia nativa de MediaInfo y, como máximo, un archivo abierto a la vez.

#### Constructores públicos

| Constructor | Descripción |
|---|---|
| `TwedMediaInfo()` | Crea una instancia sin `Context`. Permite abrir archivos por ruta con `open(String)`. |
| `TwedMediaInfo(Context context)` | Crea una instancia con `Context` (se guarda `context.getApplicationContext()`). Existe para la API de `Uri`, ver [sección 5](#5-uri-sin-soporte-garantizado-en-010). |

Ambos lanzan `IllegalStateException` si no se puede crear la instancia nativa.

#### Métodos públicos

| Método | Retorno | Descripción |
|---|---|---|
| `open(String filePath)` | `boolean` | Abre un archivo por ruta absoluta. Devuelve `true` si se abrió correctamente y `false` en caso contrario. Si ya había un archivo abierto, lo cierra antes. |
| `getGeneral(String parameter)` | `String` | Consulta un parámetro del stream General (stream 0). Equivale a `get(StreamKind.GENERAL, 0, parameter)`. |
| `get(int streamKind, int streamNumber, String parameter)` | `String` | Consulta un parámetro de cualquier stream. |
| `countStreams(int streamKind)` | `int` | Número de streams de un tipo. |
| `close()` | `void` | Cierra el archivo abierto. No libera la instancia nativa. |
| `destroy()` | `void` | Cierra el archivo si está abierto y libera la instancia nativa. Debe llamarse cuando la instancia ya no se necesite. |
| `static getMediaInfoVersion()` | `String` | Versión de MediaInfoLib embebida. |
| `static getZenLibVersion()` | `String` | Versión de ZenLib embebida. |

La clase también declara `open(Uri uri)`, que no tiene soporte garantizado en 0.1.0 (ver [sección 5](#5-uri-sin-soporte-garantizado-en-010)).

### 2.3 Cómo se abre y se analiza un archivo

Se llama a `open(String)` con la ruta absoluta del archivo. El método devuelve `true` si el archivo se abrió y `false` si no. Una vez abierto, se consulta la información con `getGeneral(...)`, `get(...)` y `countStreams(...)`. Al terminar, se llama a `destroy()`.

`TwedMediaInfo` no implementa `AutoCloseable`, por lo que no se puede usar con `try-with-resources` (Java) ni con `use { }` (Kotlin). Usa `try`/`finally`.

### 2.4 Cómo se consulta la información

Todas las consultas devuelven `String`. Los parámetros se identifican por su nombre, y para evitar errores de tipeo se pueden usar las constantes de los [catálogos](#4-catálogos-de-parámetros).

```text
get(streamKind, streamNumber, parameter)
     │           │             └─ nombre del parámetro (por ejemplo, Video.WIDTH)
     │           └─ índice del stream, base 0
     └─ tipo de stream (StreamKind.*)
```

### 2.5 Tipos de stream: `StreamKind`

`StreamKind` es una clase final con constantes `int` que se usan como primer argumento de `get(...)` y de `countStreams(...)`. Corresponden al enum `stream_t` de MediaInfoLib.

| Constante | Valor | Catálogo de parámetros |
|---|---|---|
| `StreamKind.GENERAL` | 0 | `General` |
| `StreamKind.VIDEO` | 1 | `Video` |
| `StreamKind.AUDIO` | 2 | `Audio` |
| `StreamKind.TEXT` | 3 | `Text` |
| `StreamKind.OTHER` | 4 | `Other` |
| `StreamKind.IMAGE` | 5 | `Image` |
| `StreamKind.MENU` | 6 | No hay clase de catálogo en 0.1.0 |

### 2.6 Índices de stream

- Los índices de stream son **base 0**.
- Para saber cuántos streams hay de un tipo, usa `countStreams(streamKind)`; los índices válidos van de `0` a `count - 1`.
- El stream General es único y se consulta con índice `0` (`getGeneral(...)` ya lo hace por ti).

### 2.7 Valores devueltos y ausencia de datos

- `open(String)` devuelve `false` si no se pudo abrir el archivo.
- `getGeneral(...)` y `get(...)` devuelven una cadena vacía (`""`) si no hay archivo abierto. La documentación del código indica además que devuelven cadena vacía si el parámetro no existe.
- `countStreams(...)` devuelve `0` si no hay archivo abierto.

Por tanto, un valor vacío significa que no hay dato disponible (o que no hay archivo abierto). Comprueba `isEmpty()` antes de usar un valor.

---

## 3. Ejemplos de uso

Los ejemplos abren un archivo mediante `File`, que es la entrada oficialmente soportada en 0.1.0.

### 3.1 Abrir un archivo y consultar información General, Video y Audio

**Java**

```java
import com.twedmediainfo.android.StreamKind;
import com.twedmediainfo.android.TwedMediaInfo;
import com.twedmediainfo.android.parameters.Audio;
import com.twedmediainfo.android.parameters.General;
import com.twedmediainfo.android.parameters.Video;

import java.io.File;

public final class MediaInspector {

    public static void inspect(File file) {
        TwedMediaInfo mediaInfo = new TwedMediaInfo();
        try {
            if (!mediaInfo.open(file.getAbsolutePath())) {
                System.out.println("No se pudo abrir el archivo");
                return;
            }

            // General
            String format = mediaInfo.getGeneral(General.FORMAT);
            String duration = mediaInfo.getGeneral(General.DURATION_STRING);
            String fileSize = mediaInfo.getGeneral(General.FILE_SIZE);
            System.out.println("Formato: " + format + ", duración: " + duration
                    + ", tamaño (bytes): " + fileSize);

            // Video
            int videoCount = mediaInfo.countStreams(StreamKind.VIDEO);
            for (int i = 0; i < videoCount; i++) {
                String vFormat = mediaInfo.get(StreamKind.VIDEO, i, Video.FORMAT);
                String width = mediaInfo.get(StreamKind.VIDEO, i, Video.WIDTH);
                String height = mediaInfo.get(StreamKind.VIDEO, i, Video.HEIGHT);
                String fps = mediaInfo.get(StreamKind.VIDEO, i, Video.FRAME_RATE_STRING);
                System.out.println("Video " + i + ": " + vFormat + " " + width + "x" + height
                        + " @ " + fps);
            }

            // Audio
            int audioCount = mediaInfo.countStreams(StreamKind.AUDIO);
            for (int i = 0; i < audioCount; i++) {
                String aFormat = mediaInfo.get(StreamKind.AUDIO, i, Audio.FORMAT);
                String channels = mediaInfo.get(StreamKind.AUDIO, i, Audio.CHANNELS);
                String bitrate = mediaInfo.get(StreamKind.AUDIO, i, Audio.BITRATE_STRING);
                String language = mediaInfo.get(StreamKind.AUDIO, i, Audio.LANGUAGE_STRING);
                System.out.println("Audio " + i + ": " + aFormat + ", canales: " + channels
                        + ", bitrate: " + bitrate + ", idioma: " + language);
            }
        } finally {
            mediaInfo.destroy();
        }
    }
}
```

**Kotlin**

```kotlin
import com.twedmediainfo.android.StreamKind
import com.twedmediainfo.android.TwedMediaInfo
import com.twedmediainfo.android.parameters.Audio
import com.twedmediainfo.android.parameters.General
import com.twedmediainfo.android.parameters.Video
import java.io.File

fun inspect(file: File) {
    val mediaInfo = TwedMediaInfo()
    try {
        if (!mediaInfo.open(file.absolutePath)) {
            println("No se pudo abrir el archivo")
            return
        }

        // General
        val format = mediaInfo.getGeneral(General.FORMAT)
        val duration = mediaInfo.getGeneral(General.DURATION_STRING)
        val fileSize = mediaInfo.getGeneral(General.FILE_SIZE)
        println("Formato: $format, duración: $duration, tamaño (bytes): $fileSize")

        // Video
        for (i in 0 until mediaInfo.countStreams(StreamKind.VIDEO)) {
            val vFormat = mediaInfo.get(StreamKind.VIDEO, i, Video.FORMAT)
            val width = mediaInfo.get(StreamKind.VIDEO, i, Video.WIDTH)
            val height = mediaInfo.get(StreamKind.VIDEO, i, Video.HEIGHT)
            val fps = mediaInfo.get(StreamKind.VIDEO, i, Video.FRAME_RATE_STRING)
            println("Video $i: $vFormat ${width}x$height @ $fps")
        }

        // Audio
        for (i in 0 until mediaInfo.countStreams(StreamKind.AUDIO)) {
            val aFormat = mediaInfo.get(StreamKind.AUDIO, i, Audio.FORMAT)
            val channels = mediaInfo.get(StreamKind.AUDIO, i, Audio.CHANNELS)
            val bitrate = mediaInfo.get(StreamKind.AUDIO, i, Audio.BITRATE_STRING)
            val language = mediaInfo.get(StreamKind.AUDIO, i, Audio.LANGUAGE_STRING)
            println("Audio $i: $aFormat, canales: $channels, bitrate: $bitrate, idioma: $language")
        }
    } finally {
        mediaInfo.destroy()
    }
}
```

### 3.2 Otros tipos de stream: Text, Image y Other

La API pública permite consultar los streams `TEXT`, `IMAGE` y `OTHER` con los mismos métodos.

**Java**

```java
import com.twedmediainfo.android.StreamKind;
import com.twedmediainfo.android.TwedMediaInfo;
import com.twedmediainfo.android.parameters.Image;
import com.twedmediainfo.android.parameters.Other;
import com.twedmediainfo.android.parameters.Text;

TwedMediaInfo mediaInfo = new TwedMediaInfo();
try {
    if (mediaInfo.open(file.getAbsolutePath())) {
        // Subtítulos
        for (int i = 0; i < mediaInfo.countStreams(StreamKind.TEXT); i++) {
            String textFormat = mediaInfo.get(StreamKind.TEXT, i, Text.FORMAT);
            String textLanguage = mediaInfo.get(StreamKind.TEXT, i, Text.LANGUAGE_STRING);
        }

        // Imágenes
        for (int i = 0; i < mediaInfo.countStreams(StreamKind.IMAGE); i++) {
            String imgFormat = mediaInfo.get(StreamKind.IMAGE, i, Image.FORMAT);
            String imgWidth = mediaInfo.get(StreamKind.IMAGE, i, Image.WIDTH);
            String imgHeight = mediaInfo.get(StreamKind.IMAGE, i, Image.HEIGHT);
            String bitDepth = mediaInfo.get(StreamKind.IMAGE, i, Image.BIT_DEPTH_STRING);
        }

        // Otros (capítulos, timecodes, etc.)
        for (int i = 0; i < mediaInfo.countStreams(StreamKind.OTHER); i++) {
            String otherType = mediaInfo.get(StreamKind.OTHER, i, Other.TYPE);
        }
    }
} finally {
    mediaInfo.destroy();
}
```

**Kotlin**

```kotlin
import com.twedmediainfo.android.StreamKind
import com.twedmediainfo.android.TwedMediaInfo
import com.twedmediainfo.android.parameters.Other
import com.twedmediainfo.android.parameters.Text
import com.twedmediainfo.android.parameters.Image as ImageParams

val mediaInfo = TwedMediaInfo()
try {
    if (mediaInfo.open(file.absolutePath)) {
        // Subtítulos
        for (i in 0 until mediaInfo.countStreams(StreamKind.TEXT)) {
            val textFormat = mediaInfo.get(StreamKind.TEXT, i, Text.FORMAT)
            val textLanguage = mediaInfo.get(StreamKind.TEXT, i, Text.LANGUAGE_STRING)
        }

        // Imágenes
        for (i in 0 until mediaInfo.countStreams(StreamKind.IMAGE)) {
            val imgFormat = mediaInfo.get(StreamKind.IMAGE, i, ImageParams.FORMAT)
            val imgWidth = mediaInfo.get(StreamKind.IMAGE, i, ImageParams.WIDTH)
            val imgHeight = mediaInfo.get(StreamKind.IMAGE, i, ImageParams.HEIGHT)
            val bitDepth = mediaInfo.get(StreamKind.IMAGE, i, ImageParams.BIT_DEPTH_STRING)
        }

        // Otros (capítulos, timecodes, etc.)
        for (i in 0 until mediaInfo.countStreams(StreamKind.OTHER)) {
            val otherType = mediaInfo.get(StreamKind.OTHER, i, Other.TYPE)
        }
    }
} finally {
    mediaInfo.destroy()
}
```

> En Android, el nombre `Image` puede coincidir con otras clases (por ejemplo, `android.media.Image`). Si te ocurre, importa el catálogo con un alias, como en el ejemplo de Kotlin, o usa el nombre completo `com.twedmediainfo.android.parameters.Image`.

### 3.3 Consultar un parámetro por nombre

Las constantes de los catálogos son `String` con el nombre del parámetro. Por eso las siguientes consultas son equivalentes:

**Java**

```java
String a = mediaInfo.get(StreamKind.VIDEO, 0, Video.FRAME_RATE_STRING);
String b = mediaInfo.get(StreamKind.VIDEO, 0, "FrameRate/String");
```

**Kotlin**

```kotlin
val a = mediaInfo.get(StreamKind.VIDEO, 0, Video.FRAME_RATE_STRING)
val b = mediaInfo.get(StreamKind.VIDEO, 0, "FrameRate/String")
```

### 3.4 Versiones de las bibliotecas embebidas

**Java**

```java
String mediaInfoVersion = TwedMediaInfo.getMediaInfoVersion();
String zenLibVersion = TwedMediaInfo.getZenLibVersion();
```

**Kotlin**

```kotlin
val mediaInfoVersion = TwedMediaInfo.getMediaInfoVersion()
val zenLibVersion = TwedMediaInfo.getZenLibVersion()
```

---

## 4. Catálogos de parámetros

El paquete `com.twedmediainfo.android.parameters` contiene seis clases `final` con constructor privado, que agrupan constantes `public static final String`:

| Clase | Stream | Se usa con |
|---|---|---|
| `General` | Contenedor / archivo completo | `getGeneral(...)` o `StreamKind.GENERAL` |
| `Video` | Video | `StreamKind.VIDEO` |
| `Audio` | Audio | `StreamKind.AUDIO` |
| `Image` | Imagen | `StreamKind.IMAGE` |
| `Text` | Texto (subtítulos) | `StreamKind.TEXT` |
| `Other` | Otros (capítulos, menús, timecodes, etc.) | `StreamKind.OTHER` |

### Cómo funcionan

- El valor de cada constante es el nombre del parámetro de MediaInfoLib 26.05 (definidos en los archivos `Source/Resource/Text/Stream/*.csv`). Por ejemplo, `Video.WIDTH` vale `"Width"` y `Audio.CHANNELS` vale `"Channel(s)"`.
- Las constantes con sufijo `_STRING` corresponden a la variante `/String` del parámetro (valor formateado para mostrar), por ejemplo `Video.FRAME_RATE` (`"FrameRate"`) y `Video.FRAME_RATE_STRING` (`"FrameRate/String"`).
- Varias clases comparten nombres de constantes con el mismo valor (por ejemplo `FORMAT` vale `"Format"` en todas). Lo que determina de qué stream se lee es el `StreamKind` que pasas a `get(...)`, no la clase de la constante.
- Los catálogos incluyen los parámetros más relevantes, no todos. Se excluyeron intencionalmente los marcados como obsoletos en MediaInfoLib (por ejemplo, la familia `Codec` y `Resolution`) y los de uso interno. Cualquier otro parámetro se puede consultar pasando su nombre como `String`.

### Ejemplos representativos

| Clase | Constante | Valor |
|---|---|---|
| `General` | `FORMAT` | `"Format"` |
| `General` | `FILE_SIZE` | `"FileSize"` |
| `General` | `DURATION_STRING` | `"Duration/String"` |
| `General` | `VIDEO_COUNT` | `"VideoCount"` |
| `General` | `AUDIO_COUNT` | `"AudioCount"` |
| `General` | `TEXT_COUNT` | `"TextCount"` |
| `Video` | `WIDTH` | `"Width"` |
| `Video` | `HEIGHT` | `"Height"` |
| `Video` | `FRAME_RATE_STRING` | `"FrameRate/String"` |
| `Video` | `BITRATE_STRING` | `"BitRate/String"` |
| `Audio` | `CHANNELS` | `"Channel(s)"` |
| `Audio` | `SAMPLING_RATE` | `"SamplingRate"` |
| `Audio` | `BITRATE_STRING` | `"BitRate/String"` |
| `Audio` | `LANGUAGE_STRING` | `"Language/String"` |
| `Image` | `TYPE` | `"Type"` |
| `Image` | `BIT_DEPTH_STRING` | `"BitDepth/String"` |
| `Image` | `SUMMARY` | `"Summary"` |
| `Text` | `LINES_COUNT` | `"Lines_Count"` |
| `Text` | `LANGUAGE_STRING` | `"Language/String"` |
| `Other` | `TYPE` | `"Type"` |
| `Other` | `TIMECODE_FIRST_FRAME` | `"TimeCode_FirstFrame"` |

### Notas por clase

- **`General`**: describe el archivo completo, no un stream individual. Incluye los conteos por tipo de stream (`VIDEO_COUNT`, `AUDIO_COUNT`, `TEXT_COUNT`, etc.). `FILE_SIZE` solo tiene variantes hasta `/String4`.
- **`Image`**: en MediaInfoLib 26.05 el stream Image no expone `Duration`, `BitRate` ni `FrameRate`.
- **`Text`**: `WIDTH` y `HEIGHT` se miden en caracteres (columnas y filas), no en píxeles.
- **`Other`**: `TYPE` indica el tipo específico del stream (capítulos, menú, timecode, etc.).

---

## 5. Uri (sin soporte garantizado en 0.1.0)

> **Importante:** la entrada oficialmente soportada en TwedMediaInfo 0.1.0 es la **ruta de archivo** (`File`/`String`). Aunque la API contiene métodos relacionados con `Uri`, **no forman parte del soporte garantizado de 0.1.0**, porque su implementación no superó las pruebas necesarias.

La API pública incluye:

- El constructor `TwedMediaInfo(Context context)`.
- El método `boolean open(Uri uri)`.

No se recomienda usarlos en producción con esta versión, y no se documentan ejemplos de uso.

**¿Necesitas soporte para `Uri`?** Abre un Issue en el repositorio, [github.com/TwedProjects/TwedMediaInfo/issues](https://github.com/TwedProjects/TwedMediaInfo/issues), describiendo tu caso de uso.

---

## 6. Limitaciones conocidas

- **`Uri` no está soportado de forma garantizada** en 0.1.0 (ver [sección 5](#5-uri-sin-soporte-garantizado-en-010)).
- **ABIs incluidas:** solo `arm64-v8a` y `armeabi-v7a`. No se incluyen otras ABIs (por ejemplo, `x86` o `x86_64`).
- **Las consultas de información (`getGeneral` y `get`) devuelven siempre `String`.** No hay tipos numéricos ni objetos estructurados; la conversión corre por cuenta del llamador.
- **Los catálogos no cubren todos los parámetros de MediaInfoLib.** Los parámetros no listados se consultan por nombre como `String`.
- **No hay clase de catálogo para `StreamKind.MENU`** en 0.1.0.
- **`TwedMediaInfo` no implementa `AutoCloseable`:** hay que liberar la instancia con `destroy()`.
- **`open(String)` solo indica éxito o fallo** mediante un `boolean`; no informa el motivo del fallo.

---

## 7. Arquitectura de alto nivel

```text
API Java  →  JNI  →  capa nativa  →  MediaInfoLib
```

- **API Java:** las clases públicas descritas en este documento.
- **JNI:** la clase `NativeBridge` (paquete `com.twedmediainfo.android.internal`) declara los métodos nativos, y `NativeLoader` carga la biblioteca con `System.loadLibrary("twedmediainfo")`. Estas clases **no son API pública** y pueden cambiar sin previo aviso, aunque `NativeBridge` esté declarada como `public` por necesidades técnicas.
- **Capa nativa:** `libtwedmediainfo.so`, que incluye MediaInfoLib, ZenLib y zlib enlazadas de forma estática.

---

## 8. Compatibilidad

Datos de la versión 0.1.0:

| Elemento | Valor |
|---|---|
| `minSdk` | 24 |
| `compileSdk` | 37 |
| Java/JVM | 17 |
| ABIs | `arm64-v8a`, `armeabi-v7a` |
| NDK | 28.2.13676358 |
| CMake | 3.22.1 |
| MediaInfoLib | 26.05 |
| ZenLib | 0.4.41 |
| zlib | 1.3.2 |
| Tamaño de página ELF | Compatible con 16 KB |

---

## 9. Licencia

El código de TwedMediaInfo se distribuye bajo la licencia Apache 2.0. Las licencias de las bibliotecas de terceros (MediaInfoLib, ZenLib y zlib) están en la carpeta [`LICENSE_THIRD_PARTY/`](LICENSE_THIRD_PARTY/) y no se repiten en este documento.
