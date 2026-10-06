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
 * Constantes para parámetros de streams "Other" en MediaInfoLib 26.05.
 * <p>
 * Esta lista cubre los parámetros definidos en Source/Resource/Text/Stream/Other.csv.
 * El stream Other agrupa capítulos, menús, timecodes embebidos y metadata auxiliar
 * de contenedores (típicamente MKV, MP4, MXF).
 * <p>
 * Se excluyen intencionalmente los parámetros marcados como "Deprecated, do not use in new projects"
 * (familia Video0_Delay) y los de uso interno (Count, Status, StreamCount, StreamKind,
 * StreamKindID, StreamKindPos, StreamOrder, FirstPacketOrder, Inform).
 * <p>
 * Notas específicas de Other:
 * <ul>
 *   <li>{@link #TYPE} indica el tipo específico del stream Other (Chapters, Menu, TimeCode, etc.).</li>
 *   <li>{@link #TIMESTAMP_FIRST_FRAME} es exclusivo de Other: timestamp absoluto del primer paquete.</li>
 *   <li>{@link #TIMECODE_STRIPPED} indica si el timecode está recortado (solo primer valor).</li>
 * </ul>
 * <p>
 * La API genérica {@link com.twedmediainfo.android.TwedMediaInfo#get} permite consultar cualquier
 * parámetro por nombre. Esta lista solo incluye los más relevantes como constantes para evitar
 * errores de tipeo y mejorar el autocompletado.
 * <p>
 * Uso:
 * <pre>{@code
 * mediaInfo.get(StreamKind.OTHER, 0, Other.TYPE);
 * mediaInfo.get(StreamKind.OTHER, 0, Other.TIMECODE_FIRST_FRAME);
 * mediaInfo.get(StreamKind.OTHER, 0, Other.LANGUAGE_STRING);
 * }</pre>
 */
public final class Other {
    // Identificación
    public static final String ID = "ID";
    public static final String ID_STRING = "ID/String";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID = "OriginalSourceMedium_ID";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID_STRING = "OriginalSourceMedium_ID/String";
    public static final String UNIQUE_ID = "UniqueID";
    public static final String UNIQUE_ID_STRING = "UniqueID/String";
    public static final String MENU_ID = "MenuID";
    public static final String MENU_ID_STRING = "MenuID/String";

    // Tipo (exclusivo de Other en este stream kind)
    public static final String TYPE = "Type";

    // Formato
    public static final String FORMAT = "Format";
    public static final String FORMAT_STRING = "Format/String";
    public static final String FORMAT_INFO = "Format/Info";
    public static final String FORMAT_URL = "Format/Url";
    public static final String FORMAT_COMMERCIAL = "Format_Commercial";
    public static final String FORMAT_COMMERCIAL_IF_ANY = "Format_Commercial_IfAny";
    public static final String FORMAT_VERSION = "Format_Version";
    public static final String FORMAT_PROFILE = "Format_Profile";
    public static final String FORMAT_COMPRESSION = "Format_Compression";
    public static final String FORMAT_SETTINGS = "Format_Settings";
    public static final String FORMAT_SETTINGS_WRAPPING = "Format_Settings_Wrapping";
    public static final String FORMAT_ADDITIONAL_FEATURES = "Format_AdditionalFeatures";

    // Muxing
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
    public static final String DURATION_START = "Duration_Start";
    public static final String DURATION_END = "Duration_End";

    // Source Duration
    public static final String SOURCE_DURATION = "Source_Duration";
    public static final String SOURCE_DURATION_STRING = "Source_Duration/String";
    public static final String SOURCE_DURATION_STRING1 = "Source_Duration/String1";
    public static final String SOURCE_DURATION_STRING2 = "Source_Duration/String2";
    public static final String SOURCE_DURATION_STRING3 = "Source_Duration/String3";
    public static final String SOURCE_DURATION_STRING4 = "Source_Duration/String4";
    public static final String SOURCE_DURATION_STRING5 = "Source_Duration/String5";
    public static final String SOURCE_DURATION_FIRST_FRAME = "Source_Duration_FirstFrame";
    public static final String SOURCE_DURATION_FIRST_FRAME_STRING = "Source_Duration_FirstFrame/String";
    public static final String SOURCE_DURATION_FIRST_FRAME_STRING1 = "Source_Duration_FirstFrame/String1";
    public static final String SOURCE_DURATION_FIRST_FRAME_STRING2 = "Source_Duration_FirstFrame/String2";
    public static final String SOURCE_DURATION_FIRST_FRAME_STRING3 = "Source_Duration_FirstFrame/String3";
    public static final String SOURCE_DURATION_FIRST_FRAME_STRING4 = "Source_Duration_FirstFrame/String4";
    public static final String SOURCE_DURATION_FIRST_FRAME_STRING5 = "Source_Duration_FirstFrame/String5";
    public static final String SOURCE_DURATION_LAST_FRAME = "Source_Duration_LastFrame";
    public static final String SOURCE_DURATION_LAST_FRAME_STRING = "Source_Duration_LastFrame/String";
    public static final String SOURCE_DURATION_LAST_FRAME_STRING1 = "Source_Duration_LastFrame/String1";
    public static final String SOURCE_DURATION_LAST_FRAME_STRING2 = "Source_Duration_LastFrame/String2";
    public static final String SOURCE_DURATION_LAST_FRAME_STRING3 = "Source_Duration_LastFrame/String3";
    public static final String SOURCE_DURATION_LAST_FRAME_STRING4 = "Source_Duration_LastFrame/String4";
    public static final String SOURCE_DURATION_LAST_FRAME_STRING5 = "Source_Duration_LastFrame/String5";

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

    // Frame Rate
    public static final String FRAME_RATE = "FrameRate";
    public static final String FRAME_RATE_STRING = "FrameRate/String";
    public static final String FRAME_RATE_NUM = "FrameRate_Num";
    public static final String FRAME_RATE_DEN = "FrameRate_Den";
    public static final String FRAME_COUNT = "FrameCount";
    public static final String SOURCE_FRAME_COUNT = "Source_FrameCount";

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
    public static final String DELAY_ORIGINAL_STRING1 = "Delay_Original/String1";
    public static final String DELAY_ORIGINAL_STRING2 = "Delay_Original/String2";
    public static final String DELAY_ORIGINAL_STRING3 = "Delay_Original/String3";
    public static final String DELAY_ORIGINAL_STRING4 = "Delay_Original/String4";
    public static final String DELAY_ORIGINAL_STRING5 = "Delay_Original/String5";
    public static final String DELAY_ORIGINAL_SETTINGS = "Delay_Original_Settings";
    public static final String DELAY_ORIGINAL_DROP_FRAME = "Delay_Original_DropFrame";
    public static final String DELAY_ORIGINAL_SOURCE = "Delay_Original_Source";

    // Video Delay (relativo al video)
    public static final String VIDEO_DELAY = "Video_Delay";
    public static final String VIDEO_DELAY_STRING = "Video_Delay/String";
    public static final String VIDEO_DELAY_STRING1 = "Video_Delay/String1";
    public static final String VIDEO_DELAY_STRING2 = "Video_Delay/String2";
    public static final String VIDEO_DELAY_STRING3 = "Video_Delay/String3";
    public static final String VIDEO_DELAY_STRING4 = "Video_Delay/String4";
    public static final String VIDEO_DELAY_STRING5 = "Video_Delay/String5";

    // TimeStamp (exclusivo de Other)
    public static final String TIMESTAMP_FIRST_FRAME = "TimeStamp_FirstFrame";
    public static final String TIMESTAMP_FIRST_FRAME_STRING = "TimeStamp_FirstFrame/String";
    public static final String TIMESTAMP_FIRST_FRAME_STRING1 = "TimeStamp_FirstFrame/String1";
    public static final String TIMESTAMP_FIRST_FRAME_STRING2 = "TimeStamp_FirstFrame/String2";
    public static final String TIMESTAMP_FIRST_FRAME_STRING3 = "TimeStamp_FirstFrame/String3";
    public static final String TIMESTAMP_FIRST_FRAME_STRING4 = "TimeStamp_FirstFrame/String4";
    public static final String TIMESTAMP_FIRST_FRAME_STRING5 = "TimeStamp_FirstFrame/String5";

    // TimeCode
    public static final String TIMECODE_FIRST_FRAME = "TimeCode_FirstFrame";
    public static final String TIMECODE_LAST_FRAME = "TimeCode_LastFrame";
    public static final String TIMECODE_DROP_FRAME = "TimeCode_DropFrame";
    public static final String TIMECODE_SETTINGS = "TimeCode_Settings";
    public static final String TIMECODE_STRIPPED = "TimeCode_Stripped";
    public static final String TIMECODE_STRIPPED_STRING = "TimeCode_Stripped/String";
    public static final String TIMECODE_SOURCE = "TimeCode_Source";

    // Stream Size
    public static final String STREAM_SIZE = "StreamSize";
    public static final String STREAM_SIZE_STRING = "StreamSize/String";
    public static final String STREAM_SIZE_STRING1 = "StreamSize/String1";
    public static final String STREAM_SIZE_STRING2 = "StreamSize/String2";
    public static final String STREAM_SIZE_STRING3 = "StreamSize/String3";
    public static final String STREAM_SIZE_STRING4 = "StreamSize/String4";
    public static final String STREAM_SIZE_STRING5 = "StreamSize/String5";
    public static final String STREAM_SIZE_PROPORTION = "StreamSize_Proportion";
    public static final String STREAM_SIZE_DEMUXED = "StreamSize_Demuxed";
    public static final String STREAM_SIZE_DEMUXED_STRING = "StreamSize_Demuxed/String";
    public static final String STREAM_SIZE_DEMUXED_STRING1 = "StreamSize_Demuxed/String1";
    public static final String STREAM_SIZE_DEMUXED_STRING2 = "StreamSize_Demuxed/String2";
    public static final String STREAM_SIZE_DEMUXED_STRING3 = "StreamSize_Demuxed/String3";
    public static final String STREAM_SIZE_DEMUXED_STRING4 = "StreamSize_Demuxed/String4";
    public static final String STREAM_SIZE_DEMUXED_STRING5 = "StreamSize_Demuxed/String5";
    public static final String SOURCE_STREAM_SIZE = "Source_StreamSize";
    public static final String SOURCE_STREAM_SIZE_STRING = "Source_StreamSize/String";
    public static final String SOURCE_STREAM_SIZE_STRING1 = "Source_StreamSize/String1";
    public static final String SOURCE_STREAM_SIZE_STRING2 = "Source_StreamSize/String2";
    public static final String SOURCE_STREAM_SIZE_STRING3 = "Source_StreamSize/String3";
    public static final String SOURCE_STREAM_SIZE_STRING4 = "Source_StreamSize/String4";
    public static final String SOURCE_STREAM_SIZE_STRING5 = "Source_StreamSize/String5";
    public static final String SOURCE_STREAM_SIZE_PROPORTION = "Source_StreamSize_Proportion";
    public static final String STREAM_SIZE_ENCODED = "StreamSize_Encoded";
    public static final String STREAM_SIZE_ENCODED_STRING = "StreamSize_Encoded/String";
    public static final String STREAM_SIZE_ENCODED_STRING1 = "StreamSize_Encoded/String1";
    public static final String STREAM_SIZE_ENCODED_STRING2 = "StreamSize_Encoded/String2";
    public static final String STREAM_SIZE_ENCODED_STRING3 = "StreamSize_Encoded/String3";
    public static final String STREAM_SIZE_ENCODED_STRING4 = "StreamSize_Encoded/String4";
    public static final String STREAM_SIZE_ENCODED_STRING5 = "StreamSize_Encoded/String5";
    public static final String STREAM_SIZE_ENCODED_PROPORTION = "StreamSize_Encoded_Proportion";
    public static final String SOURCE_STREAM_SIZE_ENCODED = "Source_StreamSize_Encoded";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING = "Source_StreamSize_Encoded/String";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING1 = "Source_StreamSize_Encoded/String1";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING2 = "Source_StreamSize_Encoded/String2";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING3 = "Source_StreamSize_Encoded/String3";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING4 = "Source_StreamSize_Encoded/String4";
    public static final String SOURCE_STREAM_SIZE_ENCODED_STRING5 = "Source_StreamSize_Encoded/String5";
    public static final String SOURCE_STREAM_SIZE_ENCODED_PROPORTION = "Source_StreamSize_Encoded_Proportion";

    // Título
    public static final String TITLE = "Title";

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

    private Other() {
        // Prevenir instanciación
    }
}