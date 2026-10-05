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

#include <jni.h>
#include <string>
#include <android/log.h>

#include "../adapter/twedmediainfo_adapter.h"

#define LOG_TAG "TwedMediaInfo"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

// ==============================================================================
// JNI Helper: Convertir std::string a jstring
// ==============================================================================
static jstring toJString(JNIEnv* env, const std::string& str) {
    return env->NewStringUTF(str.c_str());
}

// ==============================================================================
// JNI Helper: Convertir jstring a std::string
// ==============================================================================
static std::string fromJString(JNIEnv* env, jstring jstr) {
    if (jstr == nullptr) {
        return "";
    }
    const char* chars = env->GetStringUTFChars(jstr, nullptr);
    std::string result(chars);
    env->ReleaseStringUTFChars(jstr, chars);
    return result;
}

// ==============================================================================
// JNI Methods
// ==============================================================================

extern "C" {

JNIEXPORT jstring JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeGetMediaInfoVersion(
        JNIEnv* env, jclass /* clazz */) {
    twedmediainfo::TwedMediaInfoAdapter adapter;
    std::string version = adapter.getMediaInfoVersion();
    LOGI("MediaInfoLib version: %s", version.c_str());
    return toJString(env, version);
}

JNIEXPORT jstring JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeGetZenLibVersion(
        JNIEnv* env, jclass /* clazz */) {
    twedmediainfo::TwedMediaInfoAdapter adapter;
    std::string version = adapter.getZenLibVersion();
    return toJString(env, version);
}

JNIEXPORT jlong JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeCreate(
        JNIEnv* env, jclass /* clazz */) {
    auto* adapter = new twedmediainfo::TwedMediaInfoAdapter();
    LOGI("Native adapter created");
    return reinterpret_cast<jlong>(adapter);
}

JNIEXPORT jboolean JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeOpen(
        JNIEnv* env, jclass /* clazz */, jlong handle, jstring path) {
    if (handle == 0) {
        LOGE("nativeOpen: invalid handle");
        return JNI_FALSE;
    }

    auto* adapter = reinterpret_cast<twedmediainfo::TwedMediaInfoAdapter*>(handle);
    std::string filePath = fromJString(env, path);

    if (filePath.empty()) {
        LOGE("nativeOpen: empty path");
        return JNI_FALSE;
    }

    bool result = adapter->open(filePath);
    if (result) {
        LOGI("File opened: %s", filePath.c_str());
    } else {
        LOGE("Failed to open file: %s", filePath.c_str());
    }
    return result ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT jstring JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeGetGeneral(
        JNIEnv* env, jclass /* clazz */, jlong handle, jstring parameter) {
    if (handle == 0) {
        LOGE("nativeGetGeneral: invalid handle");
        return toJString(env, "");
    }

    auto* adapter = reinterpret_cast<twedmediainfo::TwedMediaInfoAdapter*>(handle);
    std::string param = fromJString(env, parameter);
    std::string value = adapter->getGeneralInfo(param);
    return toJString(env, value);
}

JNIEXPORT jstring JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeGet(
        JNIEnv* env, jclass /* clazz */, jlong handle, 
        jint streamKind, jint streamNumber, jstring parameter) {
    if (handle == 0) {
        LOGE("nativeGet: invalid handle");
        return toJString(env, "");
    }

    auto* adapter = reinterpret_cast<twedmediainfo::TwedMediaInfoAdapter*>(handle);
    std::string param = fromJString(env, parameter);
    std::string value = adapter->get(streamKind, streamNumber, param);
    return toJString(env, value);
}

JNIEXPORT jint JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeCountStreams(
        JNIEnv* env, jclass /* clazz */, jlong handle, jint streamKind) {
    if (handle == 0) {
        LOGE("nativeCountStreams: invalid handle");
        return 0;
    }

    auto* adapter = reinterpret_cast<twedmediainfo::TwedMediaInfoAdapter*>(handle);
    int count = adapter->countStreams(streamKind);
    return static_cast<jint>(count);
}

JNIEXPORT void JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeClose(
        JNIEnv* env, jclass /* clazz */, jlong handle) {
    if (handle == 0) {
        return;
    }

    auto* adapter = reinterpret_cast<twedmediainfo::TwedMediaInfoAdapter*>(handle);
    adapter->close();
    LOGI("File closed");
}

JNIEXPORT void JNICALL
Java_com_twedmediainfo_android_internal_NativeBridge_nativeDestroy(
        JNIEnv* env, jclass /* clazz */, jlong handle) {
    if (handle == 0) {
        return;
    }

    auto* adapter = reinterpret_cast<twedmediainfo::TwedMediaInfoAdapter*>(handle);
    delete adapter;
    LOGI("Native adapter destroyed");
}

} // extern "C"