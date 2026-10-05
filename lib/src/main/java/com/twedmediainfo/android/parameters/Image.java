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
 * Constantes para parámetros de imagen en MediaInfoLib 26.05.
 * <p>
 * Esta lista cubre los parámetros definidos en Source/Resource/Text/Stream/Image.csv.
 * Se excluyen intencionalmente los parámetros marcados como "Deprecated, do not use in new projects"
 * (familia Codec, Resolution) y los de uso interno (Count, Status, StreamCount, StreamKind,
 * StreamKindID, StreamKindPos, FirstPacketOrder, Inform).
 * <p>
 * Nota: a diferencia de Video y Audio, el stream Image de MediaInfoLib 26.05
 * NO expone Duration, BitRate ni FrameRate. Sí expone campos exclusivos como
 * {@link #TYPE} y {@link #SUMMARY}.
 * <p>
 * La API genérica {@link com.twedmediainfo.android.TwedMediaInfo#get} permite consultar cualquier
 * parámetro por nombre, incluyendo estos y otros no listados aquí. Esta lista solo incluye
 * los parámetros más relevantes como constantes para evitar errores de tipeo y mejorar
 * el autocompletado.
 * <p>
 * Uso:
 * <pre>{@code
 * mediaInfo.get(StreamKind.IMAGE, 0, Image.FORMAT);
 * mediaInfo.get(StreamKind.IMAGE, 0, Image.WIDTH);
 * mediaInfo.get(StreamKind.IMAGE, 0, Image.BIT_DEPTH_STRING);
 * }</pre>
 */
public final class Image {
    // Identificación
    public static final String ID = "ID";
    public static final String ID_STRING = "ID/String";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID = "OriginalSourceMedium_ID";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID_STRING = "OriginalSourceMedium_ID/String";
    public static final String UNIQUE_ID = "UniqueID";
    public static final String UNIQUE_ID_STRING = "UniqueID/String";
    public static final String MENU_ID = "MenuID";
    public static final String MENU_ID_STRING = "MenuID/String";

    // Tipo (exclusivo de Image)
    public static final String TYPE = "Type";
    public static final String TYPE_STRING = "Type/String";

    // Título
    public static final String TITLE = "Title";

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
    public static final String FORMAT_ADDITIONAL_FEATURES = "Format_AdditionalFeatures";

    // HDR Format
    public static final String HDR_FORMAT = "HDR_Format";
    public static final String HDR_FORMAT_STRING = "HDR_Format/String";
    public static final String HDR_FORMAT_COMMERCIAL = "HDR_Format_Commercial";
    public static final String HDR_FORMAT_VERSION = "HDR_Format_Version";
    public static final String HDR_FORMAT_PROFILE = "HDR_Format_Profile";
    public static final String HDR_FORMAT_LEVEL = "HDR_Format_Level";
    public static final String HDR_FORMAT_SETTINGS = "HDR_Format_Settings";
    public static final String HDR_FORMAT_COMPATIBILITY = "HDR_Format_Compatibility";

    // Format Settings
    public static final String FORMAT_SETTINGS = "Format_Settings";
    public static final String FORMAT_SETTINGS_ENDIANNESS = "Format_Settings_Endianness";
    public static final String FORMAT_SETTINGS_PACKING = "Format_Settings_Packing";
    public static final String FORMAT_SETTINGS_WRAPPING = "Format_Settings_Wrapping";

    // Muxing / Internet Media Type
    public static final String MUXING_MODE = "MuxingMode";
    public static final String INTERNET_MEDIA_TYPE = "InternetMediaType";

    // Codec ID
    public static final String CODEC_ID = "CodecID";
    public static final String CODEC_ID_STRING = "CodecID/String";
    public static final String CODEC_ID_INFO = "CodecID/Info";
    public static final String CODEC_ID_HINT = "CodecID/Hint";
    public static final String CODEC_ID_URL = "CodecID/Url";
    public static final String CODEC_ID_DESCRIPTION = "CodecID_Description";

    // Dimensiones
    public static final String WIDTH = "Width";
    public static final String WIDTH_STRING = "Width/String";
    public static final String WIDTH_OFFSET = "Width_Offset";
    public static final String WIDTH_OFFSET_STRING = "Width_Offset/String";
    public static final String WIDTH_ORIGINAL = "Width_Original";
    public static final String WIDTH_ORIGINAL_STRING = "Width_Original/String";
    public static final String HEIGHT = "Height";
    public static final String HEIGHT_STRING = "Height/String";
    public static final String HEIGHT_OFFSET = "Height_Offset";
    public static final String HEIGHT_OFFSET_STRING = "Height_Offset/String";
    public static final String HEIGHT_ORIGINAL = "Height_Original";
    public static final String HEIGHT_ORIGINAL_STRING = "Height_Original/String";

    // Aspect Ratio
    public static final String PIXEL_ASPECT_RATIO = "PixelAspectRatio";
    public static final String PIXEL_ASPECT_RATIO_STRING = "PixelAspectRatio/String";
    public static final String PIXEL_ASPECT_RATIO_ORIGINAL = "PixelAspectRatio_Original";
    public static final String PIXEL_ASPECT_RATIO_ORIGINAL_STRING = "PixelAspectRatio_Original/String";
    public static final String DISPLAY_ASPECT_RATIO = "DisplayAspectRatio";
    public static final String DISPLAY_ASPECT_RATIO_STRING = "DisplayAspectRatio/String";
    public static final String DISPLAY_ASPECT_RATIO_ORIGINAL = "DisplayAspectRatio_Original";
    public static final String DISPLAY_ASPECT_RATIO_ORIGINAL_STRING = "DisplayAspectRatio_Original/String";
    public static final String ACTIVE_WIDTH = "Active_Width";
    public static final String ACTIVE_WIDTH_STRING = "Active_Width/String";
    public static final String ACTIVE_HEIGHT = "Active_Height";
    public static final String ACTIVE_HEIGHT_STRING = "Active_Height/String";
    public static final String ACTIVE_DISPLAY_ASPECT_RATIO = "Active_DisplayAspectRatio";
    public static final String ACTIVE_DISPLAY_ASPECT_RATIO_STRING = "Active_DisplayAspectRatio/String";

    // Color
    public static final String COLOR_SPACE = "ColorSpace";
    public static final String CHROMA_SUBSAMPLING = "ChromaSubsampling";
    public static final String BIT_DEPTH = "BitDepth";
    public static final String BIT_DEPTH_STRING = "BitDepth/String";

    // Compresión
    public static final String COMPRESSION_MODE = "Compression_Mode";
    public static final String COMPRESSION_MODE_STRING = "Compression_Mode/String";
    public static final String COMPRESSION_RATIO = "Compression_Ratio";

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

    // Encoded Library
    public static final String ENCODED_LIBRARY = "Encoded_Library";
    public static final String ENCODED_LIBRARY_STRING = "Encoded_Library/String";
    public static final String ENCODED_LIBRARY_NAME = "Encoded_Library_Name";
    public static final String ENCODED_LIBRARY_VERSION = "Encoded_Library_Version";
    public static final String ENCODED_LIBRARY_DATE = "Encoded_Library_Date";
    public static final String ENCODED_LIBRARY_SETTINGS = "Encoded_Library_Settings";

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

    // Summary (exclusivo de Image)
    public static final String SUMMARY = "Summary";

    // Fechas
    public static final String ENCODED_DATE = "Encoded_Date";
    public static final String TAGGED_DATE = "Tagged_Date";

    // Encriptación
    public static final String ENCRYPTION = "Encryption";

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

    private Image() {
        // Prevenir instanciación
    }
}