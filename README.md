# TwedMediaInfo

TwedMediaInfo es una biblioteca Android para analizar archivos multimedia y acceder a sus metadatos e información técnica mediante [MediaInfoLib](https://github.com/MediaArea/MediaInfoLib).

El proyecto adapta e integra tecnologías existentes para Android: una API pública en Java, una capa JNI y un AAR distribuible que ya incluye todo lo necesario para funcionar.

Para la guía de uso de la API, con ejemplos en Java y Kotlin, consulta [`DOC.md`](DOC.md).

## Instalación

El AAR oficial de TwedMediaInfo se distribuye únicamente mediante Maven Central. Asegúrate de tener `mavenCentral()` entre los repositorios de tu proyecto.

En el módulo de tu aplicación Android (Gradle Kotlin DSL):

```kotlin
dependencies {
    implementation("io.github.boludohh:twedmediainfo:0.1.0")
}
```

Con Gradle Groovy:

```groovy
dependencies {
    implementation 'io.github.boludohh:twedmediainfo:0.1.0'
}
```

No es necesario declarar MediaInfoLib, ZenLib ni zlib como dependencias adicionales. Sus componentes necesarios están enlazados dentro de la biblioteca nativa que distribuye el AAR.

## Entrada soportada en la versión 0.1.0

La entrada oficialmente soportada en la versión 0.1.0 es un archivo mediante `java.io.File`.

TwedMediaInfo también dispone de una API pública para trabajar con `android.net.Uri`. Sin embargo, esa funcionalidad no forma parte del soporte garantizado de la versión 0.1.0 y no debe considerarse una entrada oficialmente soportada.

Si necesitas analizar archivos mediante `Uri`, abre un [Issue](https://github.com/TwedProjects/TwedMediaInfo/issues) describiendo tu caso de uso. El soporte podrá ser investigado y mejorado en una versión posterior.

## Compatibilidad

- Min SDK: 24
- Compile SDK: 37
- Java/JVM: 17
- ABIs: `arm64-v8a`, `armeabi-v7a`
- Alineación ELF de 16 KB: las bibliotecas nativas están preparadas para dispositivos Android que la requieren.

Versiones de las bibliotecas nativas incluidas:

- MediaInfoLib: 26.05
- ZenLib: 0.4.41
- zlib: 1.3.2

## Documentación

- [`DOC`](DOC.md): documentación técnica de la API pública y ejemplos de uso.
- [`SUPPORTED`](SUPPORTED.md): formatos, tipos de stream y parámetros soportados.

## Software de terceros

TwedMediaInfo utiliza y redistribuye software desarrollado por terceros. Sus derechos de autor y condiciones de licencia se mantienen. El texto completo de cada licencia está en [`LICENSE_THIRD_PARTY/`](LICENSE_THIRD_PARTY/).

### MediaInfoLib

Copyright (c) 2002-2025 MediaArea.net SARL. All rights reserved.

Proporciona el motor principal utilizado para analizar archivos multimedia y obtener información técnica y metadatos.

Licencia: BSD 2-Clause License. Texto completo en [`MediaInfoLib-LICENSE`](LICENSE_THIRD_PARTY/MediaInfoLib-LICENSE).

### ZenLib

Copyright (c) 2002-2020 MediaArea.net SARL. All rights reserved.

Proporciona componentes utilizados por MediaInfoLib.

Licencia: ZenLib License. Texto completo en [`ZenLib-LICENSE`](LICENSE_THIRD_PARTY/ZenLib-LICENSE).

### zlib

Copyright (C) 1995-2026 Jean-loup Gailly and Mark Adler.

Proporciona componentes de compresión utilizados por MediaInfoLib.

Licencia: zlib License. Texto completo en [`zlib-LICENSE`](LICENSE_THIRD_PARTY/zlib-LICENSE).

## Licencia

TwedMediaInfo se distribuye bajo la Apache License 2.0. El texto completo está en [`LICENSE`](LICENSE).

## Proyecto

TwedMediaInfo es un proyecto independiente dentro de TwedProjects. La biblioteca usa Java para la API Android y C++ para la integración nativa mediante JNI.

Repositorio oficial: https://github.com/TwedProjects/TwedMediaInfo
