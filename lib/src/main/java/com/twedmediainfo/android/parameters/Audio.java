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

package com.twedmediainfo.android.parameters;

/**
 * Constantes para parámetros de audio en MediaInfoLib 26.05.
 * <p>
 * Esta lista cubre los parámetros definidos en Source/Resource/Text/Stream/Audio.csv.
 * Se excluyen intencionalmente los parámetros marcados como "Deprecated, do not use in new projects"
 * (familia Codec, Resolution, Video0_Delay).
 * <p>
 * La API genérica {@link com.twedmediainfo.android.TwedMediaInfo#get} permite consultar cualquier
 * parámetro por nombre, incluyendo estos y otros no listados aquí. Esta lista solo incluye
 * los parámetros más relevantes como constantes para evitar errores de tipeo y mejorar
 * el autocompletado.
 * <p>
 * Uso:
 * <pre>{@code
 * mediaInfo.get(StreamKind.AUDIO, 0, Audio.FORMAT);
 * mediaInfo.get(StreamKind.AUDIO, 0, Audio.BITRATE_STRING);
 * mediaInfo.get(StreamKind.AUDIO, 0, Audio.CHANNELS);
 * }</pre>
 */
public final class Audio {
    // Identificación
    public static final String ID = "ID";
    public static final String ID_STRING = "ID/String";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID = "OriginalSourceMedium_ID";
    public static final String UNIQUE_ID = "UniqueID";
    public static final String UNIQUE_ID_STRING = "UniqueID/String";
    public static final String MENU_ID = "MenuID";
    public static final String MENU_ID_STRING = "MenuID/String";

    // Formato
    public static final String FORMAT = "Format";
    public static final String FORMAT_STRING = "Format/String";
    public static final String FORMAT_INFO = "Format/Info";
    public static final String FORMAT_URL = "Format/Url";
    public static final String FORMAT_COMMERCIAL = "Format_Commercial";
    public static final String FORMAT_COMMERCIAL_IF_ANY = "Format_Commercial_IfAny";
    public static final String FORMAT_VERSION = "Format_Version";
    public static final String FORMAT_PROFILE = "Format_Profile";
    public static final String FORMAT_LEVEL = "Format_Level";
    public static final String FORMAT_COMPRESSION = "Format_Compression";
    public static final String FORMAT_SETTINGS = "Format_Settings";
    public static final String FORMAT_SETTINGS_SBR = "Format_Settings_SBR";
    public static final String FORMAT_SETTINGS_SBR_STRING = "Format_Settings_SBR/String";
    public static final String FORMAT_SETTINGS_PS = "Format_Settings_PS";
    public static final String FORMAT_SETTINGS_PS_STRING = "Format_Settings_PS/String";
    public static final String FORMAT_SETTINGS_MODE = "Format_Settings_Mode";
    public static final String FORMAT_SETTINGS_MODE_EXTENSION = "Format_Settings_ModeExtension";
    public static final String FORMAT_SETTINGS_EMPHASIS = "Format_Settings_Emphasis";
    public static final String FORMAT_SETTINGS_FLOOR = "Format_Settings_Floor";
    public static final String FORMAT_SETTINGS_FIRM = "Format_Settings_Firm";
    public static final String FORMAT_SETTINGS_ENDIANNESS = "Format_Settings_Endianness";
    public static final String FORMAT_SETTINGS_SIGN = "Format_Settings_Sign";
    public static final String FORMAT_SETTINGS_LAW = "Format_Settings_Law";
    public static final String FORMAT_SETTINGS_ITU = "Format_Settings_ITU";
    public static final String FORMAT_SETTINGS_WRAPPING = "Format_Settings_Wrapping";
    public static final String FORMAT_ADDITIONAL_FEATURES = "Format_AdditionalFeatures";
    public static final String MATRIX_FORMAT = "Matrix_Format";
    public static final String INTERNET_MEDIA_TYPE = "InternetMediaType";
    public static final String MUXING_MODE = "MuxingMode";
    public static final String MUXING_MODE_MORE_INFO = "MuxingMode_MoreInfo";

    // Codec ID
    public static final String CODEC_ID = "CodecID";
    public static final String CODEC_ID_STRING = "CodecID/String";
    public static final String CODEC_ID_INFO = "CodecID/Info";
    public static final String CODEC_ID_HINT = "CodecID/Hint";
    public static final String CODEC_ID_URL = "CodecID/Url";
    public static final String CODEC_ID_DESCRIPTION = "CodecID_Description";

    // Duración
    public static final String DURATION = "Duration";
    public static final String DURATION_STRING = "Duration/String";
    public static final String DURATION_STRING1 = "Duration/String1";
    public static final String DURATION_STRING2 = "Duration/String2";
    public static final String DURATION_STRING3 = "Duration/String3";
    public static final String DURATION_STRING4 = "Duration/String4";
    public static final String DURATION_STRING5 = "Duration/String5";
    public static final String DURATION_FIRST_FRAME = "Duration_FirstFrame";
    public static final String DURATION_FIRST_FRAME_STRING = "Duration_FirstFrame/String";
    public static final String DURATION_LAST_FRAME = "Duration_LastFrame";
    public static final String DURATION_LAST_FRAME_STRING = "Duration_LastFrame/String";
    public static final String SOURCE_DURATION = "Source_Duration";
    public static final String SOURCE_DURATION_STRING = "Source_Duration/String";
    public static final String SOURCE_DURATION_FIRST_FRAME = "Source_Duration_FirstFrame";
    public static final String SOURCE_DURATION_LAST_FRAME = "Source_Duration_LastFrame";

    // Bitrate
    public static final String BITRATE_MODE = "BitRate_Mode";
    public static final String BITRATE_MODE_STRING = "BitRate_Mode/String";
    public static final String BITRATE = "BitRate";
    public static final String BITRATE_STRING = "BitRate/String";
    public static final String BITRATE_MINIMUM = "BitRate_Minimum";
    public static final String BITRATE_MINIMUM_STRING = "BitRate_Minimum/String";
    public static final String BITRATE_NOMINAL = "BitRate_Nominal";
    public static final String BITRATE_NOMINAL_STRING = "BitRate_Nominal/String";
    public static final String BITRATE_MAXIMUM = "BitRate_Maximum";
    public static final String BITRATE_MAXIMUM_STRING = "BitRate_Maximum/String";
    public static final String BITRATE_ENCODED = "BitRate_Encoded";
    public static final String BITRATE_ENCODED_STRING = "BitRate_Encoded/String";

    // Canales
    public static final String CHANNELS = "Channel(s)";
    public static final String CHANNELS_STRING = "Channel(s)/String";
    public static final String CHANNELS_ORIGINAL = "Channel(s)_Original";
    public static final String CHANNELS_ORIGINAL_STRING = "Channel(s)_Original/String";
    public static final String MATRIX_CHANNELS = "Matrix_Channel(s)";
    public static final String MATRIX_CHANNELS_STRING = "Matrix_Channel(s)/String";
    public static final String CHANNEL_POSITIONS = "ChannelPositions";
    public static final String CHANNEL_POSITIONS_ORIGINAL = "ChannelPositions_Original";
    public static final String CHANNEL_POSITIONS_STRING2 = "ChannelPositions/String2";
    public static final String CHANNEL_POSITIONS_ORIGINAL_STRING2 = "ChannelPositions_Original/String2";
    public static final String MATRIX_CHANNEL_POSITIONS = "Matrix_ChannelPositions";
    public static final String MATRIX_CHANNEL_POSITIONS_STRING2 = "Matrix_ChannelPositions/String2";
    public static final String CHANNEL_LAYOUT = "ChannelLayout";
    public static final String CHANNEL_LAYOUT_ORIGINAL = "ChannelLayout_Original";
    public static final String CHANNEL_LAYOUT_ID = "ChannelLayoutID";
    public static final String SAMPLES_PER_FRAME = "SamplesPerFrame";

    // Sampling
    public static final String SAMPLING_RATE = "SamplingRate";
    public static final String SAMPLING_RATE_STRING = "SamplingRate/String";
    public static final String SAMPLING_COUNT = "SamplingCount";
    public static final String SOURCE_SAMPLING_COUNT = "Source_SamplingCount";
    public static final String FRAME_RATE = "FrameRate";
    public static final String FRAME_RATE_STRING = "FrameRate/String";
    public static final String FRAME_RATE_NUM = "FrameRate_Num";
    public static final String FRAME_RATE_DEN = "FrameRate_Den";
    public static final String FRAME_COUNT = "FrameCount";
    public static final String SOURCE_FRAME_COUNT = "Source_FrameCount";

    // Profundidad de bit
    public static final String BIT_DEPTH = "BitDepth";
    public static final String BIT_DEPTH_STRING = "BitDepth/String";
    public static final String BIT_DEPTH_DETECTED = "BitDepth_Detected";
    public static final String BIT_DEPTH_DETECTED_STRING = "BitDepth_Detected/String";
    public static final String BIT_DEPTH_STORED = "BitDepth_Stored";
    public static final String BIT_DEPTH_STORED_STRING = "BitDepth_Stored/String";

    // Compresión
    public static final String COMPRESSION_MODE = "Compression_Mode";
    public static final String COMPRESSION_MODE_STRING = "Compression_Mode/String";
    public static final String COMPRESSION_RATIO = "Compression_Ratio";

    // Delay
    public static final String DELAY = "Delay";
    public static final String DELAY_STRING = "Delay/String";
    public static final String DELAY_STRING1 = "Delay/String1";
    public static final String DELAY_STRING2 = "Delay/String2";
    public static final String DELAY_STRING3 = "Delay/String3";
    public static final String DELAY_STRING4 = "Delay/String4";
    public static final String DELAY_STRING5 = "Delay/String5";
    public static final String DELAY_SETTINGS = "Delay_Settings";
    public static final String DELAY_DROP_FRAME = "Delay_DropFrame";
    public static final String DELAY_SOURCE = "Delay_Source";
    public static final String DELAY_SOURCE_STRING = "Delay_Source/String";
    public static final String DELAY_ORIGINAL = "Delay_Original";
    public static final String DELAY_ORIGINAL_STRING = "Delay_Original/String";
    public static final String DELAY_ORIGINAL_SETTINGS = "Delay_Original_Settings";
    public static final String DELAY_ORIGINAL_DROP_FRAME = "Delay_Original_DropFrame";
    public static final String DELAY_ORIGINAL_SOURCE = "Delay_Original_Source";
    public static final String VIDEO_DELAY = "Video_Delay";
    public static final String VIDEO_DELAY_STRING = "Video_Delay/String";
    public static final String VIDEO_DELAY_STRING3 = "Video_Delay/String3";

    // TimeCode
    public static final String TIMECODE_FIRST_FRAME = "TimeCode_FirstFrame";
    public static final String TIMECODE_LAST_FRAME = "TimeCode_LastFrame";
    public static final String TIMECODE_DROP_FRAME = "TimeCode_DropFrame";
    public static final String TIMECODE_SETTINGS = "TimeCode_Settings";
    public static final String TIMECODE_SOURCE = "TimeCode_Source";

    // ReplayGain
    public static final String REPLAYGAIN_GAIN = "ReplayGain_Gain";
    public static final String REPLAYGAIN_GAIN_STRING = "ReplayGain_Gain/String";
    public static final String REPLAYGAIN_PEAK = "ReplayGain_Peak";

    // StreamSize
    public static final String STREAM_SIZE = "StreamSize";
    public static final String STREAM_SIZE_STRING = "StreamSize/String";
    public static final String STREAM_SIZE_PROPORTION = "StreamSize_Proportion";
    public static final String STREAM_SIZE_DEMUXED = "StreamSize_Demuxed";
    public static final String SOURCE_STREAM_SIZE = "Source_StreamSize";
    public static final String SOURCE_STREAM_SIZE_STRING = "Source_StreamSize/String";
    public static final String SOURCE_STREAM_SIZE_PROPORTION = "Source_StreamSize_Proportion";
    public static final String STREAM_SIZE_ENCODED = "StreamSize_Encoded";
    public static final String STREAM_SIZE_ENCODED_STRING = "StreamSize_Encoded/String";
    public static final String STREAM_SIZE_ENCODED_PROPORTION = "StreamSize_Encoded_Proportion";
    public static final String SOURCE_STREAM_SIZE_ENCODED = "Source_StreamSize_Encoded";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING = "Source_StreamSize_Encoded/String";
    public static final String SOURCE_STREAM_SIZE_ENCODED_PROPORTION = "Source_StreamSize_Encoded_Proportion";

    // Alignment / Interleave
    public static final String ALIGNMENT = "Alignment";
    public static final String ALIGNMENT_STRING = "Alignment/String";
    public static final String INTERLEAVE_VIDEO_FRAMES = "Interleave_VideoFrames";
    public static final String INTERLEAVE_DURATION = "Interleave_Duration";
    public static final String INTERLEAVE_DURATION_STRING = "Interleave_Duration/String";
    public static final String INTERLEAVE_PRELOAD = "Interleave_Preload";
    public static final String INTERLEAVE_PRELOAD_STRING = "Interleave_Preload/String";

    // Metadata / Tags
    public static final String TITLE = "Title";
    public static final String ENCODED_APPLICATION = "Encoded_Application";
    public static final String ENCODED_APPLICATION_STRING = "Encoded_Application/String";
    public static final String ENCODED_APPLICATION_COMPANY_NAME = "Encoded_Application_CompanyName";
    public static final String ENCODED_APPLICATION_NAME = "Encoded_Application_Name";
    public static final String ENCODED_APPLICATION_VERSION = "Encoded_Application_Version";
    public static final String ENCODED_APPLICATION_URL = "Encoded_Application_Url";
    public static final String ENCODED_LIBRARY = "Encoded_Library";
    public static final String ENCODED_LIBRARY_STRING = "Encoded_Library/String";
    public static final String ENCODED_LIBRARY_COMPANY_NAME = "Encoded_Library_CompanyName";
    public static final String ENCODED_LIBRARY_NAME = "Encoded_Library_Name";
    public static final String ENCODED_LIBRARY_VERSION = "Encoded_Library_Version";
    public static final String ENCODED_LIBRARY_DATE = "Encoded_Library_Date";
    public static final String ENCODED_LIBRARY_SETTINGS = "Encoded_Library_Settings";
    public static final String ENCODED_OPERATING_SYSTEM = "Encoded_OperatingSystem";

    // Lenguaje
    public static final String LANGUAGE = "Language";
    public static final String LANGUAGE_STRING = "Language/String";
    public static final String LANGUAGE_STRING1 = "Language/String1";
    public static final String LANGUAGE_STRING2 = "Language/String2";
    public static final String LANGUAGE_STRING3 = "Language/String3";
    public static final String LANGUAGE_STRING4 = "Language/String4";
    public static final String LANGUAGE_MORE = "Language_More";
    public static final String SERVICE_KIND = "ServiceKind";
    public static final String SERVICE_KIND_STRING = "ServiceKind/String";

    // Flags
    public static final String DISABLED = "Disabled";
    public static final String DISABLED_STRING = "Disabled/String";
    public static final String DEFAULT = "Default";
    public static final String DEFAULT_STRING = "Default/String";
    public static final String FORCED = "Forced";
    public static final String FORCED_STRING = "Forced/String";
    public static final String ALTERNATE_GROUP = "AlternateGroup";
    public static final String ALTERNATE_GROUP_STRING = "AlternateGroup/String";

    // Fechas
    public static final String ENCODED_DATE = "Encoded_Date";
    public static final String TAGGED_DATE = "Tagged_Date";

    // Encriptación
    public static final String ENCRYPTION = "Encryption";

    private Audio() {
        // Prevenir instanciación
    }
}