# TwedMediaInfo - Library R8 rules

# Public API
-keep public class com.twedmediainfo.android.TwedMediaInfo { *; }
-keep public class com.twedmediainfo.android.StreamKind { *; }
-keep public class com.twedmediainfo.android.parameters.** { *; }

# JNI bridge
-keep class com.twedmediainfo.android.internal.NativeBridge { *; }
-keep class com.twedmediainfo.android.internal.NativeLoader { *; }