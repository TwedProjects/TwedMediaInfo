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

#include "twedmediainfo_adapter.h"

#include <MediaInfo/MediaInfo.h>
#include <ZenLib/Ztring.h>
#include <ZenLib/Conf.h>

namespace twedmediainfo {

TwedMediaInfoAdapter::TwedMediaInfoAdapter()
    : nativeHandle_(nullptr)
    , isOpen_(false) {
}

TwedMediaInfoAdapter::~TwedMediaInfoAdapter() {
    close();
}

std::string TwedMediaInfoAdapter::getMediaInfoVersion() const {
    MediaInfoLib::MediaInfo mi;
    ZenLib::Ztring version = mi.Option_Static(__T("Info_Version"));
    return version.To_UTF8();
}

std::string TwedMediaInfoAdapter::getZenLibVersion() const {
    return "0.4.41";
}

bool TwedMediaInfoAdapter::open(const std::string& path) {
    if (isOpen_) {
        close();
    }

    auto* mi = new MediaInfoLib::MediaInfo();
    ZenLib::Ztring zPath = ZenLib::Ztring().From_UTF8(path);

    size_t result = mi->Open(zPath);
    if (result > 0) {
        nativeHandle_ = static_cast<void*>(mi);
        isOpen_ = true;
        return true;
    } else {
        delete mi;
        nativeHandle_ = nullptr;
        isOpen_ = false;
        return false;
    }
}

void TwedMediaInfoAdapter::close() {
    if (nativeHandle_ != nullptr) {
        auto* mi = static_cast<MediaInfoLib::MediaInfo*>(nativeHandle_);
        mi->Close();
        delete mi;
        nativeHandle_ = nullptr;
    }
    isOpen_ = false;
}

std::string TwedMediaInfoAdapter::getGeneralInfo(const std::string& parameter) const {
    return get(0, 0, parameter);  // Stream_General = 0, stream 0
}

std::string TwedMediaInfoAdapter::get(int streamKind, int streamNumber, const std::string& parameter) const {
    if (!isOpen_ || nativeHandle_ == nullptr) {
        return "";
    }

    auto* mi = static_cast<MediaInfoLib::MediaInfo*>(nativeHandle_);
    ZenLib::Ztring zParam = ZenLib::Ztring().From_UTF8(parameter);

    ZenLib::Ztring value = mi->Get(
        static_cast<MediaInfoLib::stream_t>(streamKind),
        static_cast<size_t>(streamNumber),
        zParam
    );

    return value.To_UTF8();
}

int TwedMediaInfoAdapter::countStreams(int streamKind) const {
    if (!isOpen_ || nativeHandle_ == nullptr) {
        return 0;
    }

    auto* mi = static_cast<MediaInfoLib::MediaInfo*>(nativeHandle_);
    
    size_t count = mi->Count_Get(
        static_cast<MediaInfoLib::stream_t>(streamKind)
    );

    return static_cast<int>(count);
}

} // namespace twedmediainfo