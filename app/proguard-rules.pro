# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.google.errorprone.annotations.** { *; }
# Retain generated class which implement Unbinder.
-keep public class * implements butterknife.Unbinder { public <init>(**, android.view.View); }

# Prevent obfuscation of types which use ButterKnife annotations since the simple name
# is used to reflectively look up the generated ViewBinding.
-keep class butterknife.*
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }

#### -- Picasso --
 -dontwarn com.squareup.picasso.**

 #### -- OkHttp --

 -dontwarn com.squareup.okhttp.internal.**

 #### -- Apache Commons --

 -dontwarn org.apache.commons.logging.**

 # Retrofit 2.X
 ## https://square.github.io/retrofit/ ##

 -dontwarn retrofit2.**
 -keep class retrofit2.** { *; }
 -keepattributes Signature
 -keepattributes Exceptions

 -keepclasseswithmembers class * {
     @retrofit2.http.* <methods>;
 }

 # BlueSquare
 -keep class com.bluelinelabs.logansquare.** { *; }
 -keep @com.bluelinelabs.logansquare.annotation.JsonObject class *
 -keep class **$$JsonObjectMapper { *; }

 # rxjava
 -keep class rx.schedulers.Schedulers {
     public static <methods>;
 }
 -keep class rx.schedulers.ImmediateScheduler {
     public <methods>;
 }
 -keep class rx.schedulers.TestScheduler {
     public <methods>;
 }
 -keep class rx.schedulers.Schedulers {
     public static ** test();
 }
 -keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
     long producerIndex;
     long consumerIndex;
 }
 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
     long producerNode;
     long consumerNode;
 }

 -dontwarn okio.**
 -dontwarn com.squareup.okhttp3.**
 -keep class com.squareup.okhttp3.** { *; }
 -keep interface com.squareup.okhttp3.* { *; }
 -dontwarn javax.annotation.Nullable
 -dontwarn javax.annotation.ParametersAreNonnullByDefault