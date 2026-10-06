# TwedMediaInfo - Consumer R8 rules
#
# These rules are packaged inside the AAR and applied by R8
# when an application consumes TwedMediaInfo.
#
# Do not disable shrinking, obfuscation, or optimization globally.

# Public API
-keep public class com.twedmediainfo.android.TwedMediaInfo { *; }
-keep public class com.twedmediainfo.android.StreamKind { *; }

# Public parameter catalogs.
# These classes are part of the compile-time API exposed by TwedMediaInfo.
-keep public class com.twedmediainfo.android.parameters.** { *; }

# JNI bridge.
-keep class com.twedmediainfo.android.internal.NativeBridge { *; }

# Native library loader.
-keep class com.twedmediainfo.android.internal.NativeLoader { *; }