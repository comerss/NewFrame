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
-ignorewarnings


	-keep class com.bytedance.sdk.openadsdk.**{ *; }
	-keep class com.androidquery.**{*;}

	-keep public class pl.droidsonroids.gif.GifIOException{<init>(int);}
	-keep class pl.droidsonroids.gif.GifInfoHandle{<init>(long,int,int,int);}
	-keepclassmembers enum * {public static **[] values();public static ** valueOf(java.lang.String);}

	-keep class com.baidu.mobads..* { *; }
	-keep class com.donews.*.* { *; }
	-keep class com.qq.e.** { public protected *; }


	#-----
	-keep class com.bytedance.*.**{*;}

	-dontwarn  com.baidu.**
	-dontwarn  com.bytedance.**
	-dontwarn  com.androidquery.auth.**
	-dontwarn  com.donews.sdk.**
	-dontwarn  com.qq.**

 -keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference



#保持注解继承类不混淆
-keep class * extends java.lang.annotation.Annotation {*;}

#保持Serializable实现类不被混淆
-keepnames class * implements java.io.Serializable
#保持Serializable不被混淆并且enum 类也不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

#自定义组件不被混淆
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}