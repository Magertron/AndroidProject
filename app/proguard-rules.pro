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
-keep class com.iflytek.**{*;}
-keepattributes Signature
-keep class com.shdjrmyy.qgw.CompanyProject.BaseFolder.** { *; }
-keep class com.shdjrmyy.qgw.CompanyProject.DiseasePage.bean.** { *; }
-keep class com.shdjrmyy.qgw.CompanyProject.FollowUpPage.bean.** { *; }
-keep class com.shdjrmyy.qgw.CompanyProject.HomePage.bean.** { *; }
-keep class com.shdjrmyy.qgw.CompanyProject.PatientPage.bean.** { *; }
-keep class com.shdjrmyy.qgw.CompanyProject.PatientPage.bean.** { *; }
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}
-keep class com.zhy.http.**{*;}
-keep interface com.zhy.http.**{*;}
-keepattributes Signature
-keepattributes *Annotation*
-keep public class com.project.mocha_patient.login.SignResponseData { private *; }
-keepattributes *Annotation*
-keepclassmembers class ** { @org.greenrobot.eventbus.Subscribe <methods>; }
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent { <init>(java.lang.Throwable); } #glide
-keep public class * implements com.bumptech.glide.module.GlideModule
 -optimizationpasses 5
 -dontusemixedcaseclassnames
 -dontskipnonpubliclibraryclasses
 -dontskipnonpubliclibraryclassmembers
 -dontpreverify
 -verbose
 -printmapping proguardMapping.txt
 -optimizations !code/simplification/cast,!field/*,!class/merging/*
 -keepattributes *Annotation*,InnerClasses
 -keepattributes Signature
 -keepattributes SourceFile,LineNumberTable
  -keep public class * extends android.app.Activity
  -keep public class * extends android.app.Application
  -keep public class * extends android.app.Service
  -keep public class * extends android.content.BroadcastReceiver
  -keep public class * extends android.content.ContentProvider
  -keep public class * extends android.app.backup.BackupAgentHelper
  -keep public class * extends android.preference.Preference
  -keep public class * extends android.view.View
  -keep public class com.android.vending.licensing.ILicensingService
  -keep class android.support.** {*;}
  -keepclasseswithmembernames class * { native <methods>; }
  -keepclassmembers class * extends android.app.Activity{ public void *(android.view.View); }
  -keepclassmembers enum * { public static **[] values(); public static ** valueOf(java.lang.String); }
  -keep public class * extends android.view.View{ *** get*(); void set*(***); public <init>(android.content.Context); public <init>(android.content.Context, android.util.AttributeSet); public <init>(android.content.Context, android.util.AttributeSet, int); }
  -keepclasseswithmembers class * { public <init>(android.content.Context, android.util.AttributeSet); public <init>(android.content.Context, android.util.AttributeSet, int); }
  -keep class * implements android.os.Parcelable { public static final android.os.Parcelable$Creator *; }
  -keepclassmembers class * implements java.io.Serializable { static final long serialVersionUID; private static final java.io.ObjectStreamField[] serialPersistentFields; private void writeObject(java.io.ObjectOutputStream); private void readObject(java.io.ObjectInputStream); java.lang.Object writeReplace(); java.lang.Object readResolve(); }
  -keep class **.R$* { *; }
  -keepclassmembers class * { void *(**On*Event); }
  -keepclassmembers class fqcn.of.javascript.interface.for.Webview { public *; }
  -keepclassmembers class * extends android.webkit.WebViewClient { public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap); public boolean *(android.webkit.WebView, java.lang.String); }
  -keepclassmembers class * extends android.webkit.WebViewClient { public void *(android.webkit.WebView, jav.lang.String); }