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
 * Constantes para parámetros de texto (subtítulos) en MediaInfoLib 26.05.
 * <p>
 * Esta lista cubre los parámetros definidos en Source/Resource/Text/Stream/Text.csv.
 * Se excluyen intencionalmente los parámetros marcados como "Deprecated, do not use in new projects"
 * (familia Codec, Resolution, Video0_Delay) y los de uso interno (Count, Status, StreamCount,
 * StreamKind, StreamKindID, StreamKindPos, FirstPacketOrder, Inform).
 * <p>
 * Notas específicas de Text:
 * <ul>
 *   <li>{@link #WIDTH} y {@link #HEIGHT} se miden en <b>caracteres</b> (columnas/filas), no píxeles.</li>
 *   <li>Incluye campos exclusivos de subtítulos como {@link #ELEMENT_COUNT}, {@link #EVENTS_TOTAL},
 *       {@link #LINES_COUNT} y {@link #FIRST_DISPLAY_TYPE}.</li>
 *   <li>Incluye variantes extendidas de Duration: {@link #DURATION_START_2_END},
 *       {@link #DURATION_START}, {@link #DURATION_END}, {@link #DURATION_START_COMMAND},
 *       {@link #DURATION_END_COMMAND} y {@link #DURATION_BASE}.</li>
 * </ul>
 * <p>
 * La API genérica {@link com.twedmediainfo.android.TwedMediaInfo#get} permite consultar cualquier
 * parámetro por nombre. Esta lista solo incluye los más relevantes como constantes para evitar
 * errores de tipeo y mejorar el autocompletado.
 * <p>
 * Uso:
 * <pre>{@code
 * mediaInfo.get(StreamKind.TEXT, 0, Text.FORMAT);
 * mediaInfo.get(StreamKind.TEXT, 0, Text.LANGUAGE_STRING);
 * mediaInfo.get(StreamKind.TEXT, 0, Text.LINES_COUNT);
 * }</pre>
 */
public final class Text {
    // Identificación
    public static final String ID = "ID";
    public static final String ID_STRING = "ID/String";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID = "OriginalSourceMedium_ID";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID_STRING = "OriginalSourceMedium_ID/String";
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
    public static final String FORMAT_COMPRESSION = "Format_Compression";
    public static final String FORMAT_SETTINGS = "Format_Settings";
    public static final String FORMAT_SETTINGS_WRAPPING = "Format_Settings_Wrapping";
    public static final String FORMAT_ADDITIONAL_FEATURES = "Format_AdditionalFeatures";

    // Internet Media Type / Muxing
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

    // Duración (estándar)
    public static final String DURATION = "Duration";
    public static final String DURATION_STRING = "Duration/String";
    public static final String DURATION_STRING1 = "Duration/String1";
    public static final String DURATION_STRING2 = "Duration/String2";
    public static final String DURATION_STRING3 = "Duration/String3";
    public static final String DURATION_STRING4 = "Duration/String4";
    public static final String DURATION_STRING5 = "Duration/String5";

    // Duración extendida (exclusiva de Text)
    public static final String DURATION_START_2_END = "Duration_Start2End";
    public static final String DURATION_START_2_END_STRING = "Duration_Start2End/String";
    public static final String DURATION_START_2_END_STRING1 = "Duration_Start2End/String1";
    public static final String DURATION_START_2_END_STRING2 = "Duration_Start2End/String2";
    public static final String DURATION_START_2_END_STRING3 = "Duration_Start2End/String3";
    public static final String DURATION_START_2_END_STRING4 = "Duration_Start2End/String4";
    public static final String DURATION_START_2_END_STRING5 = "Duration_Start2End/String5";
    public static final String DURATION_START = "Duration_Start";
    public static final String DURATION_START_STRING = "Duration_Start/String";
    public static final String DURATION_START_STRING1 = "Duration_Start/String1";
    public static final String DURATION_START_STRING2 = "Duration_Start/String2";
    public static final String DURATION_START_STRING3 = "Duration_Start/String3";
    public static final String DURATION_START_STRING4 = "Duration_Start/String4";
    public static final String DURATION_START_STRING5 = "Duration_Start/String5";
    public static final String DURATION_END = "Duration_End";
    public static final String DURATION_END_STRING = "Duration_End/String";
    public static final String DURATION_END_STRING1 = "Duration_End/String1";
    public static final String DURATION_END_STRING2 = "Duration_End/String2";
    public static final String DURATION_END_STRING3 = "Duration_End/String3";
    public static final String DURATION_END_STRING4 = "Duration_End/String4";
    public static final String DURATION_END_STRING5 = "Duration_End/String5";
    public static final String DURATION_START_COMMAND = "Duration_Start_Command";
    public static final String DURATION_START_COMMAND_STRING = "Duration_Start_Command/String";
    public static final String DURATION_START_COMMAND_STRING1 = "Duration_Start_Command/String1";
    public static final String DURATION_START_COMMAND_STRING2 = "Duration_Start_Command/String2";
    public static final String DURATION_START_COMMAND_STRING3 = "Duration_Start_Command/String3";
    public static final String DURATION_START_COMMAND_STRING4 = "Duration_Start_Command/String4";
    public static final String DURATION_START_COMMAND_STRING5 = "Duration_Start_Command/String5";
    public static final String DURATION_END_COMMAND = "Duration_End_Command";
    public static final String DURATION_END_COMMAND_STRING = "Duration_End_Command/String";
    public static final String DURATION_END_COMMAND_STRING1 = "Duration_End_Command/String1";
    public static final String DURATION_END_COMMAND_STRING2 = "Duration_End_Command/String2";
    public static final String DURATION_END_COMMAND_STRING3 = "Duration_End_Command/String3";
    public static final String DURATION_END_COMMAND_STRING4 = "Duration_End_Command/String4";
    public static final String DURATION_END_COMMAND_STRING5 = "Duration_End_Command/String5";
    public static final String DURATION_BASE = "Duration_Base";

    // Duración de frames específicos
    public static final String DURATION_FIRST_FRAME = "Duration_FirstFrame";
    public static final String DURATION_FIRST_FRAME_STRING = "Duration_FirstFrame/String";
    public static final String DURATION_FIRST_FRAME_STRING1 = "Duration_FirstFrame/String1";
    public static final String DURATION_FIRST_FRAME_STRING2 = "Duration_FirstFrame/String2";
    public static final String DURATION_FIRST_FRAME_STRING3 = "Duration_FirstFrame/String3";
    public static final String DURATION_FIRST_FRAME_STRING4 = "Duration_FirstFrame/String4";
    public static final String DURATION_FIRST_FRAME_STRING5 = "Duration_FirstFrame/String5";
    public static final String DURATION_LAST_FRAME = "Duration_LastFrame";
    public static final String DURATION_LAST_FRAME_STRING = "Duration_LastFrame/String";
    public static final String DURATION_LAST_FRAME_STRING1 = "Duration_LastFrame/String1";
    public static final String DURATION_LAST_FRAME_STRING2 = "Duration_LastFrame/String2";
    public static final String DURATION_LAST_FRAME_STRING3 = "Duration_LastFrame/String3";
    public static final String DURATION_LAST_FRAME_STRING4 = "Duration_LastFrame/String4";
    public static final String DURATION_LAST_FRAME_STRING5 = "Duration_LastFrame/String5";

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

    // Geometría (en caracteres, no píxeles)
    public static final String WIDTH = "Width";
    public static final String WIDTH_STRING = "Width/String";
    public static final String HEIGHT = "Height";
    public static final String HEIGHT_STRING = "Height/String";

    // Aspect Ratio
    public static final String DISPLAY_ASPECT_RATIO = "DisplayAspectRatio";
    public static final String DISPLAY_ASPECT_RATIO_STRING = "DisplayAspectRatio/String";
    public static final String DISPLAY_ASPECT_RATIO_ORIGINAL = "DisplayAspectRatio_Original";
    public static final String DISPLAY_ASPECT_RATIO_ORIGINAL_STRING = "DisplayAspectRatio_Original/String";

    // Frame Rate
    public static final String FRAME_RATE_MODE = "FrameRate_Mode";
    public static final String FRAME_RATE_MODE_STRING = "FrameRate_Mode/String";
    public static final String FRAME_RATE_MODE_ORIGINAL = "FrameRate_Mode_Original";
    public static final String FRAME_RATE_MODE_ORIGINAL_STRING = "FrameRate_Mode_Original/String";
    public static final String FRAME_RATE = "FrameRate";
    public static final String FRAME_RATE_STRING = "FrameRate/String";
    public static final String FRAME_RATE_NUM = "FrameRate_Num";
    public static final String FRAME_RATE_DEN = "FrameRate_Den";
    public static final String FRAME_RATE_MINIMUM = "FrameRate_Minimum";
    public static final String FRAME_RATE_MINIMUM_STRING = "FrameRate_Minimum/String";
    public static final String FRAME_RATE_NOMINAL = "FrameRate_Nominal";
    public static final String FRAME_RATE_NOMINAL_STRING = "FrameRate_Nominal/String";
    public static final String FRAME_RATE_MAXIMUM = "FrameRate_Maximum";
    public static final String FRAME_RATE_MAXIMUM_STRING = "FrameRate_Maximum/String";
    public static final String FRAME_RATE_ORIGINAL = "FrameRate_Original";
    public static final String FRAME_RATE_ORIGINAL_STRING = "FrameRate_Original/String";
    public static final String FRAME_RATE_ORIGINAL_NUM = "FrameRate_Original_Num";
    public static final String FRAME_RATE_ORIGINAL_DEN = "FrameRate_Original_Den";

    // Contadores (exclusivos de Text: ElementCount)
    public static final String FRAME_COUNT = "FrameCount";
    public static final String ELEMENT_COUNT = "ElementCount";
    public static final String SOURCE_FRAME_COUNT = "Source_FrameCount";

    // Color (aplica a subtítulos bitmap/PGS/SUP)
    public static final String COLOR_SPACE = "ColorSpace";
    public static final String CHROMA_SUBSAMPLING = "ChromaSubsampling";
    public static final String BIT_DEPTH = "BitDepth";
    public static final String BIT_DEPTH_STRING = "BitDepth/String";

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

    // TimeCode
    public static final String TIMECODE_FIRST_FRAME = "TimeCode_FirstFrame";
    public static final String TIMECODE_LAST_FRAME = "TimeCode_LastFrame";
    public static final String TIMECODE_DROP_FRAME = "TimeCode_DropFrame";
    public static final String TIMECODE_SETTINGS = "TimeCode_Settings";
    public static final String TIMECODE_SOURCE = "TimeCode_Source";
    public static final String TIMECODE_MAX_FRAME_NUMBER = "TimeCode_MaxFrameNumber";
    public static final String TIMECODE_MAX_FRAME_NUMBER_THEORY = "TimeCode_MaxFrameNumber_Theory";

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

    // Título / Metadatos técnicos
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

    // Summary
    public static final String SUMMARY = "Summary";

    // Fechas
    public static final String ENCODED_DATE = "Encoded_Date";
    public static final String TAGGED_DATE = "Tagged_Date";

    // Encriptación
    public static final String ENCRYPTION = "Encryption";

    // Eventos de subtítulo (exclusivos de Text)
    public static final String EVENTS_TOTAL = "Events_Total";
    public static final String EVENTS_MIN_DURATION = "Events_MinDuration";
    public static final String EVENTS_MIN_DURATION_STRING = "Events_MinDuration/String";
    public static final String EVENTS_MIN_DURATION_STRING1 = "Events_MinDuration/String1";
    public static final String EVENTS_MIN_DURATION_STRING2 = "Events_MinDuration/String2";
    public static final String EVENTS_MIN_DURATION_STRING3 = "Events_MinDuration/String3";
    public static final String EVENTS_MIN_DURATION_STRING4 = "Events_MinDuration/String4";
    public static final String EVENTS_MIN_DURATION_STRING5 = "Events_MinDuration/String5";
    public static final String EVENTS_POP_ON = "Events_PopOn";
    public static final String EVENTS_ROLL_UP = "Events_RollUp";
    public static final String EVENTS_PAINT_ON = "Events_PaintOn";

    // Métricas de líneas (exclusivas de Text)
    public static final String LINES_COUNT = "Lines_Count";
    public static final String LINES_MAX_COUNT_PER_EVENT = "Lines_MaxCountPerEvent";
    public static final String LINES_MAX_CHARACTER_COUNT = "Lines_MaxCharacterCount";

    // Primer display (exclusivo de Text)
    public static final String FIRST_DISPLAY_DELAY_FRAMES = "FirstDisplay_Delay_Frames";
    public static final String FIRST_DISPLAY_TYPE = "FirstDisplay_Type";

    private Text() {
        // Prevenir instanciación
    }
}