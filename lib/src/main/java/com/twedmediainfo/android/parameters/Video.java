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
 * Constantes para parámetros de video en MediaInfoLib 26.05.
 * <p>
 * Esta lista cubre los parámetros definidos en Source/Resource/Text/Stream/Video.csv.
 * Se excluyen intencionalmente los parámetros marcados como "Deprecated, do not use in new projects"
 * (familia Codec, Resolution, Colorimetry, Interlacement).
 * <p>
 * La API genérica {@link com.twedmediainfo.android.TwedMediaInfo#get} permite consultar cualquier
 * parámetro por nombre, incluyendo estos y otros no listados aquí. Esta lista solo incluye
 * los parámetros más relevantes como constantes para evitar errores de tipeo y mejorar
 * el autocompletado.
 * <p>
 * Uso:
 * <pre>{@code
 * mediaInfo.get(StreamKind.VIDEO, 0, Video.FORMAT);
 * mediaInfo.get(StreamKind.VIDEO, 0, Video.WIDTH);
 * mediaInfo.get(StreamKind.VIDEO, 0, Video.FRAME_RATE_STRING);
 * }</pre>
 */
public final class Video {
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
    public static final String FORMAT_LEVEL = "Format_Level";
    public static final String FORMAT_TIER = "Format_Tier";
    public static final String FORMAT_COMPRESSION = "Format_Compression";
    public static final String FORMAT_ADDITIONAL_FEATURES = "Format_AdditionalFeatures";
    public static final String MULTI_VIEW_BASE_PROFILE = "MultiView_BaseProfile";
    public static final String MULTI_VIEW_COUNT = "MultiView_Count";
    public static final String MULTI_VIEW_LAYOUT = "MultiView_Layout";

    // HDR Format
    public static final String HDR_FORMAT = "HDR_Format";
    public static final String HDR_FORMAT_STRING = "HDR_Format/String";
    public static final String HDR_FORMAT_COMMERCIAL = "HDR_Format_Commercial";
    public static final String HDR_FORMAT_VERSION = "HDR_Format_Version";
    public static final String HDR_FORMAT_PROFILE = "HDR_Format_Profile";
    public static final String HDR_FORMAT_LEVEL = "HDR_Format_Level";
    public static final String HDR_FORMAT_SETTINGS = "HDR_Format_Settings";
    public static final String HDR_FORMAT_COMPRESSION = "HDR_Format_Compression";
    public static final String HDR_FORMAT_COMPATIBILITY = "HDR_Format_Compatibility";

    // Format Settings
    public static final String FORMAT_SETTINGS = "Format_Settings";
    public static final String FORMAT_SETTINGS_BVOP = "Format_Settings_BVOP";
    public static final String FORMAT_SETTINGS_BVOP_STRING = "Format_Settings_BVOP/String";
    public static final String FORMAT_SETTINGS_QPEL = "Format_Settings_QPel";
    public static final String FORMAT_SETTINGS_QPEL_STRING = "Format_Settings_QPel/String";
    public static final String FORMAT_SETTINGS_GMC = "Format_Settings_GMC";
    public static final String FORMAT_SETTINGS_GMC_STRING = "Format_Settings_GMC/String";
    public static final String FORMAT_SETTINGS_MATRIX = "Format_Settings_Matrix";
    public static final String FORMAT_SETTINGS_MATRIX_STRING = "Format_Settings_Matrix/String";
    public static final String FORMAT_SETTINGS_MATRIX_DATA = "Format_Settings_Matrix_Data";
    public static final String FORMAT_SETTINGS_CABAC = "Format_Settings_CABAC";
    public static final String FORMAT_SETTINGS_CABAC_STRING = "Format_Settings_CABAC/String";
    public static final String FORMAT_SETTINGS_REF_FRAMES = "Format_Settings_RefFrames";
    public static final String FORMAT_SETTINGS_REF_FRAMES_STRING = "Format_Settings_RefFrames/String";
    public static final String FORMAT_SETTINGS_PULLDOWN = "Format_Settings_Pulldown";
    public static final String FORMAT_SETTINGS_ENDIANNESS = "Format_Settings_Endianness";
    public static final String FORMAT_SETTINGS_PACKING = "Format_Settings_Packing";
    public static final String FORMAT_SETTINGS_FRAME_MODE = "Format_Settings_FrameMode";
    public static final String FORMAT_SETTINGS_GOP = "Format_Settings_GOP";
    public static final String FORMAT_SETTINGS_PICTURE_STRUCTURE = "Format_Settings_PictureStructure";
    public static final String FORMAT_SETTINGS_WRAPPING = "Format_Settings_Wrapping";
    public static final String FORMAT_SETTINGS_SLICE_COUNT = "Format_Settings_SliceCount";
    public static final String FORMAT_SETTINGS_SLICE_COUNT_STRING = "Format_Settings_SliceCount/String";

    // Internet Media Type
    public static final String INTERNET_MEDIA_TYPE = "InternetMediaType";

    // Muxing Mode
    public static final String MUXING_MODE = "MuxingMode";

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

    // Dimensiones
    public static final String WIDTH = "Width";
    public static final String WIDTH_STRING = "Width/String";
    public static final String WIDTH_OFFSET = "Width_Offset";
    public static final String WIDTH_OFFSET_STRING = "Width_Offset/String";
    public static final String WIDTH_ORIGINAL = "Width_Original";
    public static final String WIDTH_ORIGINAL_STRING = "Width_Original/String";
    public static final String WIDTH_CLEAN_APERTURE = "Width_CleanAperture";
    public static final String WIDTH_CLEAN_APERTURE_STRING = "Width_CleanAperture/String";
    public static final String HEIGHT = "Height";
    public static final String HEIGHT_STRING = "Height/String";
    public static final String HEIGHT_OFFSET = "Height_Offset";
    public static final String HEIGHT_OFFSET_STRING = "Height_Offset/String";
    public static final String HEIGHT_ORIGINAL = "Height_Original";
    public static final String HEIGHT_ORIGINAL_STRING = "Height_Original/String";
    public static final String HEIGHT_CLEAN_APERTURE = "Height_CleanAperture";
    public static final String HEIGHT_CLEAN_APERTURE_STRING = "Height_CleanAperture/String";
    public static final String STORED_WIDTH = "Stored_Width";
    public static final String STORED_HEIGHT = "Stored_Height";
    public static final String SAMPLED_WIDTH = "Sampled_Width";
    public static final String SAMPLED_HEIGHT = "Sampled_Height";

    // Pixel Aspect Ratio
    public static final String PIXEL_ASPECT_RATIO = "PixelAspectRatio";
    public static final String PIXEL_ASPECT_RATIO_STRING = "PixelAspectRatio/String";
    public static final String PIXEL_ASPECT_RATIO_ORIGINAL = "PixelAspectRatio_Original";
    public static final String PIXEL_ASPECT_RATIO_ORIGINAL_STRING = "PixelAspectRatio_Original/String";
    public static final String PIXEL_ASPECT_RATIO_CLEAN_APERTURE = "PixelAspectRatio_CleanAperture";
    public static final String PIXEL_ASPECT_RATIO_CLEAN_APERTURE_STRING = "PixelAspectRatio_CleanAperture/String";

    // Display Aspect Ratio
    public static final String DISPLAY_ASPECT_RATIO = "DisplayAspectRatio";
    public static final String DISPLAY_ASPECT_RATIO_STRING = "DisplayAspectRatio/String";
    public static final String DISPLAY_ASPECT_RATIO_ORIGINAL = "DisplayAspectRatio_Original";
    public static final String DISPLAY_ASPECT_RATIO_ORIGINAL_STRING = "DisplayAspectRatio_Original/String";
    public static final String DISPLAY_ASPECT_RATIO_CLEAN_APERTURE = "DisplayAspectRatio_CleanAperture";
    public static final String DISPLAY_ASPECT_RATIO_CLEAN_APERTURE_STRING = "DisplayAspectRatio_CleanAperture/String";

    // Active Format Description
    public static final String ACTIVE_FORMAT_DESCRIPTION = "ActiveFormatDescription";
    public static final String ACTIVE_FORMAT_DESCRIPTION_STRING = "ActiveFormatDescription/String";
    public static final String ACTIVE_FORMAT_DESCRIPTION_MUXING_MODE = "ActiveFormatDescription_MuxingMode";
    public static final String ACTIVE_WIDTH = "Active_Width";
    public static final String ACTIVE_WIDTH_STRING = "Active_Width/String";
    public static final String ACTIVE_HEIGHT = "Active_Height";
    public static final String ACTIVE_HEIGHT_STRING = "Active_Height/String";
    public static final String ACTIVE_DISPLAY_ASPECT_RATIO = "Active_DisplayAspectRatio";
    public static final String ACTIVE_DISPLAY_ASPECT_RATIO_STRING = "Active_DisplayAspectRatio/String";

    // Rotation
    public static final String ROTATION = "Rotation";
    public static final String ROTATION_STRING = "Rotation/String";

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
    public static final String FRAME_RATE_REAL = "FrameRate_Real";
    public static final String FRAME_RATE_REAL_STRING = "FrameRate_Real/String";
    public static final String FRAME_COUNT = "FrameCount";
    public static final String SOURCE_FRAME_COUNT = "Source_FrameCount";

    // Standard
    public static final String STANDARD = "Standard";

    // Color
    public static final String COLOR_SPACE = "ColorSpace";
    public static final String CHROMA_SUBSAMPLING = "ChromaSubsampling";
    public static final String CHROMA_SUBSAMPLING_STRING = "ChromaSubsampling/String";
    public static final String CHROMA_SUBSAMPLING_POSITION = "ChromaSubsampling_Position";
    public static final String BIT_DEPTH = "BitDepth";
    public static final String BIT_DEPTH_STRING = "BitDepth/String";

    // Scan Type
    public static final String SCAN_TYPE = "ScanType";
    public static final String SCAN_TYPE_STRING = "ScanType/String";
    public static final String SCAN_TYPE_ORIGINAL = "ScanType_Original";
    public static final String SCAN_TYPE_ORIGINAL_STRING = "ScanType_Original/String";
    public static final String SCAN_TYPE_STORE_METHOD = "ScanType_StoreMethod";
    public static final String SCAN_TYPE_STORE_METHOD_FIELDS_PER_BLOCK = "ScanType_StoreMethod_FieldsPerBlock";
    public static final String SCAN_TYPE_STORE_METHOD_STRING = "ScanType_StoreMethod/String";

    // Scan Order
    public static final String SCAN_ORDER = "ScanOrder";
    public static final String SCAN_ORDER_STRING = "ScanOrder/String";
    public static final String SCAN_ORDER_STORED = "ScanOrder_Stored";
    public static final String SCAN_ORDER_STORED_STRING = "ScanOrder_Stored/String";
    public static final String SCAN_ORDER_STORED_DISPLAYED_INVERTED = "ScanOrder_StoredDisplayedInverted";
    public static final String SCAN_ORDER_ORIGINAL = "ScanOrder_Original";
    public static final String SCAN_ORDER_ORIGINAL_STRING = "ScanOrder_Original/String";

    // Compression
    public static final String COMPRESSION_MODE = "Compression_Mode";
    public static final String COMPRESSION_MODE_STRING = "Compression_Mode/String";
    public static final String COMPRESSION_RATIO = "Compression_Ratio";
    public static final String BITS_PIXEL_FRAME = "Bits-(Pixel*Frame)";

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

    // TimeStamp
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
    public static final String TIMECODE_SOURCE = "TimeCode_Source";
    public static final String GOP_OPEN_CLOSED = "Gop_OpenClosed";
    public static final String GOP_OPEN_CLOSED_STRING = "Gop_OpenClosed/String";
    public static final String GOP_OPEN_CLOSED_FIRST_FRAME = "Gop_OpenClosed_FirstFrame";
    public static final String GOP_OPEN_CLOSED_FIRST_FRAME_STRING = "Gop_OpenClosed_FirstFrame/String";

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

    // Alignment
    public static final String ALIGNMENT = "Alignment";
    public static final String ALIGNMENT_STRING = "Alignment/String";

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

    // Buffer
    public static final String BUFFER_SIZE = "BufferSize";

    // Color Description
    public static final String COLOUR_DESCRIPTION_PRESENT = "colour_description_present";
    public static final String COLOUR_DESCRIPTION_PRESENT_SOURCE = "colour_description_present_Source";
    public static final String COLOUR_DESCRIPTION_PRESENT_ORIGINAL = "colour_description_present_Original";
    public static final String COLOUR_DESCRIPTION_PRESENT_ORIGINAL_SOURCE = "colour_description_present_Original_Source";
    public static final String COLOUR_RANGE = "colour_range";
    public static final String COLOUR_RANGE_SOURCE = "colour_range_Source";
    public static final String COLOUR_RANGE_ORIGINAL = "colour_range_Original";
    public static final String COLOUR_RANGE_ORIGINAL_SOURCE = "colour_range_Original_Source";
    public static final String COLOUR_PRIMARIES = "colour_primaries";
    public static final String COLOUR_PRIMARIES_SOURCE = "colour_primaries_Source";
    public static final String COLOUR_PRIMARIES_ORIGINAL = "colour_primaries_Original";
    public static final String COLOUR_PRIMARIES_ORIGINAL_SOURCE = "colour_primaries_Original_Source";
    public static final String TRANSFER_CHARACTERISTICS = "transfer_characteristics";
    public static final String TRANSFER_CHARACTERISTICS_SOURCE = "transfer_characteristics_Source";
    public static final String TRANSFER_CHARACTERISTICS_ORIGINAL = "transfer_characteristics_Original";
    public static final String TRANSFER_CHARACTERISTICS_ORIGINAL_SOURCE = "transfer_characteristics_Original_Source";
    public static final String MATRIX_COEFFICIENTS = "matrix_coefficients";
    public static final String MATRIX_COEFFICIENTS_SOURCE = "matrix_coefficients_Source";
    public static final String MATRIX_COEFFICIENTS_ORIGINAL = "matrix_coefficients_Original";
    public static final String MATRIX_COEFFICIENTS_ORIGINAL_SOURCE = "matrix_coefficients_Original_Source";

    // Mastering Display
    public static final String MASTERING_DISPLAY_COLOR_PRIMARIES = "MasteringDisplay_ColorPrimaries";
    public static final String MASTERING_DISPLAY_COLOR_PRIMARIES_SOURCE = "MasteringDisplay_ColorPrimaries_Source";
    public static final String MASTERING_DISPLAY_COLOR_PRIMARIES_ORIGINAL = "MasteringDisplay_ColorPrimaries_Original";
    public static final String MASTERING_DISPLAY_COLOR_PRIMARIES_ORIGINAL_SOURCE = "MasteringDisplay_ColorPrimaries_Original_Source";
    public static final String MASTERING_DISPLAY_LUMINANCE = "MasteringDisplay_Luminance";
    public static final String MASTERING_DISPLAY_LUMINANCE_SOURCE = "MasteringDisplay_Luminance_Source";
    public static final String MASTERING_DISPLAY_LUMINANCE_MIN = "MasteringDisplay_Luminance_Min";
    public static final String MASTERING_DISPLAY_LUMINANCE_MAX = "MasteringDisplay_Luminance_Max";
    public static final String MASTERING_DISPLAY_LUMINANCE_ORIGINAL = "MasteringDisplay_Luminance_Original";
    public static final String MASTERING_DISPLAY_LUMINANCE_ORIGINAL_SOURCE = "MasteringDisplay_Luminance_Original_Source";
    public static final String MASTERING_DISPLAY_LUMINANCE_ORIGINAL_MIN = "MasteringDisplay_Luminance_Original_Min";
    public static final String MASTERING_DISPLAY_LUMINANCE_ORIGINAL_MAX = "MasteringDisplay_Luminance_Original_Max";

    // MaxCLL / MaxFALL
    public static final String MAX_CLL = "MaxCLL";
    public static final String MAX_CLL_STRING = "MaxCLL/String";
    public static final String MAX_CLL_SOURCE = "MaxCLL_Source";
    public static final String MAX_CLL_ORIGINAL = "MaxCLL_Original";
    public static final String MAX_CLL_ORIGINAL_STRING = "MaxCLL_Original/String";
    public static final String MAX_CLL_ORIGINAL_SOURCE = "MaxCLL_Original_Source";
    public static final String MAX_FALL = "MaxFALL";
    public static final String MAX_FALL_STRING = "MaxFALL/String";
    public static final String MAX_FALL_SOURCE = "MaxFALL_Source";
    public static final String MAX_FALL_ORIGINAL = "MaxFALL_Original";
    public static final String MAX_FALL_ORIGINAL_STRING = "MaxFALL_Original/String";
    public static final String MAX_FALL_ORIGINAL_SOURCE = "MaxFALL_Original_Source";

    private Video() {
        // Prevenir instanciación
    }
}