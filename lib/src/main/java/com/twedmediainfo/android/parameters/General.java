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
 * Constantes para parámetros generales (contenedor) en MediaInfoLib 26.05.
 * <p>
 * Esta lista cubre los parámetros definidos en Source/Resource/Text/Stream/General.csv.
 * Se excluyen intencionalmente los parámetros marcados como "Deprecated, do not use in new projects"
 * (familia Codec, todas las listas *_Codec_List, Movie/Country) y los de uso interno
 * (Count, Status, StreamCount, StreamKind, StreamKindID, StreamKindPos, StreamOrder,
 * FirstPacketOrder, Inform).
 * <p>
 * El stream General describe el archivo/contenedor completo, no un stream individual.
 * Incluye conteos por tipo de stream, listas de formatos/idiomas, ruta del archivo,
 * tamaño, estructura del contenedor y metadatos ricos (títulos, entidades, clasificación,
 * fechas, identificadores, información legal, etc.).
 * <p>
 * Nota: {@link #FILE_SIZE} solo tiene variantes hasta {@code /String4}; no existe {@code /String5}.
 * <p>
 * La API genérica {@link com.twedmediainfo.android.TwedMediaInfo#getGeneral} permite consultar cualquier
 * parámetro por nombre. Esta lista solo incluye los más relevantes como constantes para evitar
 * errores de tipeo y mejorar el autocompletado.
 * <p>
 * Uso:
 * <pre>{@code
 * mediaInfo.getGeneral(General.FORMAT);
 * mediaInfo.getGeneral(General.FILE_SIZE);
 * mediaInfo.get(StreamKind.GENERAL, 0, General.AUDIO_COUNT);
 * }</pre>
 */
public final class General {
    // Identificación
    public static final String ID = "ID";
    public static final String ID_STRING = "ID/String";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID = "OriginalSourceMedium_ID";
    public static final String ORIGINAL_SOURCE_MEDIUM_ID_STRING = "OriginalSourceMedium_ID/String";
    public static final String UNIQUE_ID = "UniqueID";
    public static final String UNIQUE_ID_STRING = "UniqueID/String";
    public static final String MENU_ID = "MenuID";
    public static final String MENU_ID_STRING = "MenuID/String";

    // Conteos por tipo de stream
    public static final String GENERAL_COUNT = "GeneralCount";
    public static final String VIDEO_COUNT = "VideoCount";
    public static final String AUDIO_COUNT = "AudioCount";
    public static final String TEXT_COUNT = "TextCount";
    public static final String OTHER_COUNT = "OtherCount";
    public static final String IMAGE_COUNT = "ImageCount";
    public static final String MENU_COUNT = "MenuCount";

    // Listas de formatos e idiomas por tipo de stream
    public static final String VIDEO_FORMAT_LIST = "Video_Format_List";
    public static final String VIDEO_FORMAT_WITH_HINT_LIST = "Video_Format_WithHint_List";
    public static final String VIDEO_LANGUAGE_LIST = "Video_Language_List";
    public static final String AUDIO_FORMAT_LIST = "Audio_Format_List";
    public static final String AUDIO_FORMAT_WITH_HINT_LIST = "Audio_Format_WithHint_List";
    public static final String AUDIO_LANGUAGE_LIST = "Audio_Language_List";
    public static final String AUDIO_CHANNELS_TOTAL = "Audio_Channels_Total";
    public static final String TEXT_FORMAT_LIST = "Text_Format_List";
    public static final String TEXT_FORMAT_WITH_HINT_LIST = "Text_Format_WithHint_List";
    public static final String TEXT_LANGUAGE_LIST = "Text_Language_List";
    public static final String OTHER_FORMAT_LIST = "Other_Format_List";
    public static final String OTHER_FORMAT_WITH_HINT_LIST = "Other_Format_WithHint_List";
    public static final String OTHER_LANGUAGE_LIST = "Other_Language_List";
    public static final String IMAGE_FORMAT_LIST = "Image_Format_List";
    public static final String IMAGE_FORMAT_WITH_HINT_LIST = "Image_Format_WithHint_List";
    public static final String IMAGE_LANGUAGE_LIST = "Image_Language_List";
    public static final String MENU_FORMAT_LIST = "Menu_Format_List";
    public static final String MENU_FORMAT_WITH_HINT_LIST = "Menu_Format_WithHint_List";
    public static final String MENU_LANGUAGE_LIST = "Menu_Language_List";

    // Ruta y nombre de archivo
    public static final String COMPLETE_NAME = "CompleteName";
    public static final String FOLDER_NAME = "FolderName";
    public static final String FILE_NAME_EXTENSION = "FileNameExtension";
    public static final String FILE_NAME = "FileName";
    public static final String FILE_EXTENSION = "FileExtension";
    public static final String COMPLETE_NAME_LAST = "CompleteName_Last";
    public static final String FOLDER_NAME_LAST = "FolderName_Last";
    public static final String FILE_NAME_EXTENSION_LAST = "FileNameExtension_Last";
    public static final String FILE_NAME_LAST = "FileName_Last";
    public static final String FILE_EXTENSION_LAST = "FileExtension_Last";

    // Formato del contenedor
    public static final String FORMAT = "Format";
    public static final String FORMAT_STRING = "Format/String";
    public static final String FORMAT_INFO = "Format/Info";
    public static final String FORMAT_URL = "Format/Url";
    public static final String FORMAT_EXTENSIONS = "Format/Extensions";
    public static final String FORMAT_COMMERCIAL = "Format_Commercial";
    public static final String FORMAT_COMMERCIAL_IF_ANY = "Format_Commercial_IfAny";
    public static final String FORMAT_VERSION = "Format_Version";
    public static final String FORMAT_PROFILE = "Format_Profile";
    public static final String FORMAT_LEVEL = "Format_Level";
    public static final String FORMAT_COMPRESSION = "Format_Compression";
    public static final String FORMAT_SETTINGS = "Format_Settings";
    public static final String FORMAT_ADDITIONAL_FEATURES = "Format_AdditionalFeatures";
    public static final String INTERNET_MEDIA_TYPE = "InternetMediaType";

    // Codec ID
    public static final String CODEC_ID = "CodecID";
    public static final String CODEC_ID_STRING = "CodecID/String";
    public static final String CODEC_ID_INFO = "CodecID/Info";
    public static final String CODEC_ID_HINT = "CodecID/Hint";
    public static final String CODEC_ID_URL = "CodecID/Url";
    public static final String CODEC_ID_DESCRIPTION = "CodecID_Description";
    public static final String CODEC_ID_VERSION = "CodecID_Version";
    public static final String CODEC_ID_COMPATIBLE = "CodecID_Compatible";
    public static final String INTERLEAVED = "Interleaved";

    // Tamaño de archivo
    public static final String FILE_SIZE = "FileSize";
    public static final String FILE_SIZE_STRING = "FileSize/String";
    public static final String FILE_SIZE_STRING1 = "FileSize/String1";
    public static final String FILE_SIZE_STRING2 = "FileSize/String2";
    public static final String FILE_SIZE_STRING3 = "FileSize/String3";
    public static final String FILE_SIZE_STRING4 = "FileSize/String4";

    // Duración
    public static final String DURATION = "Duration";
    public static final String DURATION_STRING = "Duration/String";
    public static final String DURATION_STRING1 = "Duration/String1";
    public static final String DURATION_STRING2 = "Duration/String2";
    public static final String DURATION_STRING3 = "Duration/String3";
    public static final String DURATION_STRING4 = "Duration/String4";
    public static final String DURATION_STRING5 = "Duration/String5";
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

    // Bitrate global
    public static final String OVERALL_BITRATE_MODE = "OverallBitRate_Mode";
    public static final String OVERALL_BITRATE_MODE_STRING = "OverallBitRate_Mode/String";
    public static final String OVERALL_BITRATE = "OverallBitRate";
    public static final String OVERALL_BITRATE_STRING = "OverallBitRate/String";
    public static final String OVERALL_BITRATE_MINIMUM = "OverallBitRate_Minimum";
    public static final String OVERALL_BITRATE_MINIMUM_STRING = "OverallBitRate_Minimum/String";
    public static final String OVERALL_BITRATE_NOMINAL = "OverallBitRate_Nominal";
    public static final String OVERALL_BITRATE_NOMINAL_STRING = "OverallBitRate_Nominal/String";
    public static final String OVERALL_BITRATE_MAXIMUM = "OverallBitRate_Maximum";
    public static final String OVERALL_BITRATE_MAXIMUM_STRING = "OverallBitRate_Maximum/String";

    // Frame rate
    public static final String FRAME_RATE = "FrameRate";
    public static final String FRAME_RATE_STRING = "FrameRate/String";
    public static final String FRAME_RATE_NUM = "FrameRate_Num";
    public static final String FRAME_RATE_DEN = "FrameRate_Den";
    public static final String FRAME_COUNT = "FrameCount";

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

    // Stream size
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

    // Estructura del contenedor
    public static final String HEADER_SIZE = "HeaderSize";
    public static final String DATA_SIZE = "DataSize";
    public static final String FOOTER_SIZE = "FooterSize";
    public static final String IS_STREAMABLE = "IsStreamable";

    // ReplayGain de álbum
    public static final String ALBUM_REPLAYGAIN_GAIN = "Album_ReplayGain_Gain";
    public static final String ALBUM_REPLAYGAIN_GAIN_STRING = "Album_ReplayGain_Gain/String";
    public static final String ALBUM_REPLAYGAIN_PEAK = "Album_ReplayGain_Peak";

    // Encriptación
    public static final String ENCRYPTION = "Encryption";
    public static final String ENCRYPTION_FORMAT = "Encryption_Format";
    public static final String ENCRYPTION_LENGTH = "Encryption_Length";
    public static final String ENCRYPTION_METHOD = "Encryption_Method";
    public static final String ENCRYPTION_MODE = "Encryption_Mode";
    public static final String ENCRYPTION_PADDING = "Encryption_Padding";
    public static final String ENCRYPTION_INITIALIZATION_VECTOR = "Encryption_InitializationVector";

    // Universal Ad-ID
    public static final String UNIVERSAL_AD_ID_STRING = "UniversalAdID/String";
    public static final String UNIVERSAL_AD_ID_REGISTRY = "UniversalAdID_Registry";
    public static final String UNIVERSAL_AD_ID_VALUE = "UniversalAdID_Value";

    // Títulos (dominio Title)
    public static final String TITLE = "Title";
    public static final String TITLE_MORE = "Title_More";
    public static final String TITLE_URL = "Title/Url";
    public static final String DOMAIN = "Domain";
    public static final String COLLECTION = "Collection";
    public static final String SEASON = "Season";
    public static final String SEASON_POSITION = "Season_Position";
    public static final String SEASON_POSITION_TOTAL = "Season_Position_Total";
    public static final String MOVIE = "Movie";
    public static final String MOVIE_MORE = "Movie_More";
    public static final String MOVIE_URL = "Movie/Url";
    public static final String ALBUM = "Album";
    public static final String ALBUM_MORE = "Album_More";
    public static final String ALBUM_SORT = "Album/Sort";
    public static final String COMIC = "Comic";
    public static final String COMIC_MORE = "Comic_More";
    public static final String COMIC_POSITION_TOTAL = "Comic/Position_Total";
    public static final String PART = "Part";
    public static final String PART_POSITION = "Part/Position";
    public static final String PART_POSITION_TOTAL = "Part/Position_Total";
    public static final String REEL = "Reel";
    public static final String REEL_POSITION = "Reel/Position";
    public static final String REEL_POSITION_TOTAL = "Reel/Position_Total";
    public static final String TRACK = "Track";
    public static final String TRACK_MORE = "Track_More";
    public static final String TRACK_URL = "Track/Url";
    public static final String TRACK_SORT = "Track/Sort";
    public static final String TRACK_POSITION = "Track/Position";
    public static final String TRACK_POSITION_TOTAL = "Track/Position_Total";
    public static final String PACKAGE_NAME = "PackageName";
    public static final String GROUPING = "Grouping";
    public static final String CHAPTER = "Chapter";
    public static final String SUBTRACK = "SubTrack";
    public static final String ORIGINAL_ALBUM = "Original/Album";
    public static final String ORIGINAL_MOVIE = "Original/Movie";
    public static final String ORIGINAL_PART = "Original/Part";
    public static final String ORIGINAL_TRACK = "Original/Track";
    public static final String COMPILATION = "Compilation";
    public static final String COMPILATION_STRING = "Compilation/String";

    // Entidades (dominio Entity)
    public static final String ALBUM_PERFORMER = "Album/Performer";
    public static final String ALBUM_PERFORMER_SORT = "Album/Performer/Sort";
    public static final String ALBUM_PERFORMER_URL = "Album/Performer/Url";
    public static final String PERFORMER = "Performer";
    public static final String PERFORMER_SORT = "Performer/Sort";
    public static final String PERFORMER_URL = "Performer/Url";
    public static final String ORIGINAL_PERFORMER = "Original/Performer";
    public static final String ACCOMPANIMENT = "Accompaniment";
    public static final String COMPOSER = "Composer";
    public static final String COMPOSER_NATIONALITY = "Composer/Nationality";
    public static final String COMPOSER_SORT = "Composer/Sort";
    public static final String ARRANGER = "Arranger";
    public static final String LYRICIST = "Lyricist";
    public static final String ORIGINAL_LYRICIST = "Original/Lyricist";
    public static final String CONDUCTOR = "Conductor";
    public static final String DIRECTOR = "Director";
    public static final String CO_DIRECTOR = "CoDirector";
    public static final String ASSISTANT_DIRECTOR = "AssistantDirector";
    public static final String DIRECTOR_OF_PHOTOGRAPHY = "DirectorOfPhotography";
    public static final String SOUND_ENGINEER = "SoundEngineer";
    public static final String ART_DIRECTOR = "ArtDirector";
    public static final String PRODUCTION_DESIGNER = "ProductionDesigner";
    public static final String CHOREOGRAPHER = "Choreographer";
    public static final String COSTUME_DESIGNER = "CostumeDesigner";
    public static final String ACTOR = "Actor";
    public static final String ACTOR_CHARACTER = "Actor_Character";
    public static final String WRITTEN_BY = "WrittenBy";
    public static final String SCREENPLAY_BY = "ScreenplayBy";
    public static final String EDITED_BY = "EditedBy";
    public static final String COMMISSIONED_BY = "CommissionedBy";
    public static final String PRODUCER = "Producer";
    public static final String CO_PRODUCER = "CoProducer";
    public static final String EXECUTIVE_PRODUCER = "ExecutiveProducer";
    public static final String MUSIC_BY = "MusicBy";
    public static final String DISTRIBUTED_BY = "DistributedBy";
    public static final String ORIGINAL_SOURCE_FORM_DISTRIBUTED_BY = "OriginalSourceForm/DistributedBy";
    public static final String MASTERED_BY = "MasteredBy";
    public static final String ENCODED_BY = "EncodedBy";
    public static final String REMIXED_BY = "RemixedBy";
    public static final String PRODUCTION_STUDIO = "ProductionStudio";
    public static final String THANKS_TO = "ThanksTo";
    public static final String PUBLISHER = "Publisher";
    public static final String PUBLISHER_URL = "Publisher/URL";
    public static final String LABEL = "Label";

    // Clasificación (dominio Classification)
    public static final String GENRE = "Genre";
    public static final String PODCAST_CATEGORY = "PodcastCategory";
    public static final String MOOD = "Mood";
    public static final String CONTENT_TYPE = "ContentType";
    public static final String SUBJECT = "Subject";
    public static final String DESCRIPTION = "Description";
    public static final String KEYWORDS = "Keywords";
    public static final String SUMMARY = "Summary";
    public static final String SYNOPSIS = "Synopsis";
    public static final String PERIOD = "Period";
    public static final String LAW_RATING = "LawRating";
    public static final String LAW_RATING_REASON = "LawRating_Reason";
    public static final String ICRA = "ICRA";

    // Fechas (dominio Temporal)
    public static final String RELEASED_DATE = "Released_Date";
    public static final String ORIGINAL_RELEASED_DATE = "Original/Released_Date";
    public static final String RECORDED_DATE = "Recorded_Date";
    public static final String ENCODED_DATE = "Encoded_Date";
    public static final String TAGGED_DATE = "Tagged_Date";
    public static final String WRITTEN_DATE = "Written_Date";
    public static final String MASTERED_DATE = "Mastered_Date";
    public static final String FILE_CREATED_DATE = "File_Created_Date";
    public static final String FILE_CREATED_DATE_LOCAL = "File_Created_Date_Local";
    public static final String FILE_MODIFIED_DATE = "File_Modified_Date";
    public static final String FILE_MODIFIED_DATE_LOCAL = "File_Modified_Date_Local";

    // Ubicaciones (dominio Spatial)
    public static final String RECORDED_LOCATION = "Recorded_Location";
    public static final String WRITTEN_LOCATION = "Written_Location";
    public static final String ARCHIVAL_LOCATION = "Archival_Location";

    // Técnico (dominio Technical)
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
    public static final String ENCODED_OPERATING_SYSTEM_STRING = "Encoded_OperatingSystem/String";
    public static final String ENCODED_OPERATING_SYSTEM_COMPANY_NAME = "Encoded_OperatingSystem_CompanyName";
    public static final String ENCODED_OPERATING_SYSTEM_NAME = "Encoded_OperatingSystem_Name";
    public static final String ENCODED_OPERATING_SYSTEM_VERSION = "Encoded_OperatingSystem_Version";
    public static final String ENCODED_HARDWARE = "Encoded_Hardware";
    public static final String ENCODED_HARDWARE_STRING = "Encoded_Hardware/String";
    public static final String ENCODED_HARDWARE_COMPANY_NAME = "Encoded_Hardware_CompanyName";
    public static final String ENCODED_HARDWARE_NAME = "Encoded_Hardware_Name";
    public static final String ENCODED_HARDWARE_MODEL = "Encoded_Hardware_Model";
    public static final String ENCODED_HARDWARE_VERSION = "Encoded_Hardware_Version";
    public static final String CROPPED = "Cropped";
    public static final String DIMENSIONS = "Dimensions";
    public static final String DOTS_PER_INCH = "DotsPerInch";
    public static final String LIGHTNESS = "Lightness";
    public static final String ORIGINAL_SOURCE_MEDIUM = "OriginalSourceMedium";
    public static final String ORIGINAL_SOURCE_FORM = "OriginalSourceForm";
    public static final String ORIGINAL_SOURCE_FORM_NUM_COLORS = "OriginalSourceForm/NumColors";
    public static final String ORIGINAL_SOURCE_FORM_NAME = "OriginalSourceForm/Name";
    public static final String ORIGINAL_SOURCE_FORM_CROPPED = "OriginalSourceForm/Cropped";
    public static final String ORIGINAL_SOURCE_FORM_SHARPNESS = "OriginalSourceForm/Sharpness";
    public static final String TAGGED_APPLICATION = "Tagged_Application";
    public static final String BPM = "BPM";

    // Identificadores (dominio Identifier)
    public static final String ISRC = "ISRC";
    public static final String ISBN = "ISBN";
    public static final String ISAN = "ISAN";
    public static final String BAR_CODE = "BarCode";
    public static final String LCCN = "LCCN";
    public static final String UMID = "UMID";
    public static final String CATALOG_NUMBER = "CatalogNumber";
    public static final String LABEL_CODE = "LabelCode";

    // Legal (dominio Legal)
    public static final String OWNER = "Owner";
    public static final String COPYRIGHT = "Copyright";
    public static final String COPYRIGHT_URL = "Copyright/Url";
    public static final String PRODUCER_COPYRIGHT = "Producer_Copyright";
    public static final String TERMS_OF_USE = "TermsOfUse";
    public static final String SERVICE_NAME = "ServiceName";
    public static final String SERVICE_CHANNEL = "ServiceChannel";
    public static final String SERVICE_URL = "Service/Url";
    public static final String SERVICE_PROVIDER = "ServiceProvider";
    public static final String SERVICE_PROVIDER_URL = "ServiceProvider/Url";
    public static final String SERVICE_TYPE = "ServiceType";
    public static final String NETWORK_NAME = "NetworkName";
    public static final String ORIGINAL_NETWORK_NAME = "OriginalNetworkName";
    public static final String COUNTRY = "Country";
    public static final String TIME_ZONE = "TimeZone";

    // Info (dominio Info)
    public static final String COVER = "Cover";
    public static final String COVER_DESCRIPTION = "Cover_Description";
    public static final String COVER_TYPE = "Cover_Type";
    public static final String COVER_MIME = "Cover_Mime";
    public static final String COVER_DATA = "Cover_Data";
    public static final String LYRICS = "Lyrics";

    // Personal (dominio Personal)
    public static final String COMMENT = "Comment";
    public static final String RATING = "Rating";
    public static final String ADDED_DATE = "Added_Date";
    public static final String PLAYED_FIRST_DATE = "Played_First_Date";
    public static final String PLAYED_LAST_DATE = "Played_Last_Date";
    public static final String PLAYED_COUNT = "Played_Count";

    // EPG
    public static final String EPG_POSITIONS_BEGIN = "EPG_Positions_Begin";
    public static final String EPG_POSITIONS_END = "EPG_Positions_End";

    private General() {
        // Prevenir instanciación
    }
}