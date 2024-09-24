# 优化通道
-optimizationpasses 5
# 包名不混合大小写
-dontusemixedcaseclassnames
# 不忽略非公共的库类
-dontskipnonpubliclibraryclasses
# 不忽略非公共的库的类成员
-dontskipnonpubliclibraryclassmembers
# 不进行预检验
-dontpreverify
# 输出混淆日志
-verbose

# 优化规则
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

# 优化时允许访问并修改有修饰符的类和类的成
-allowaccessmodification

# 不进行优化
-dontoptimize

# 不混淆子类
-keep public class * extends android.**
-keep public class * extends io.dcloud.common.DHInterface.**

-dontwarn io.dcloud.feature.audio.**
-keep class io.dcloud.feature.audio.** {*;}

-keep class io.dcloud.feature.speech.** {*;}
-keep class io.dcloud.net.** {*;}
-keep class io.dcloud.common.constant.** {*;}
-keep class io.dcloud.common.sonic.** {*;}
-keep class io.dcloud.common.DHInterface.** {*;}
-keep class io.dcloud.common.util.** {*;}
-keep class io.dcloud.common.adapter.** {*;}
-keep class io.dcloud.feature.internal.reflect.** {*;}
-keep class io.dcloud.feature.internal.sdk.** {*;}
-keep class io.dcloud.feature.payment.** {*;}
-keep class io.dcloud.sdk.** {*;}
-keep class com.** {*;}
-keep class io.dcloud.nineoldandroids.** {*;}
-keep class vi.com.gdi.** {*;}
-keep class androidx.** {*;}
-dontwarn pl.droidsonroids.gif.**

-keepclasseswithmembers class * extends io.dcloud.js.geolocation.GeoManagerBase {
    <methods>;
}

-keep class io.dcloud.share.AbsWebviewClient
-keepclasseswithmembers class io.dcloud.share.AbsWebviewClient {
    <methods>;
}

-keep class io.dcloud.share.ShareAuthorizeView
-keepclasseswithmembers class io.dcloud.share.ShareAuthorizeView {
    <methods>;
}
-keep class io.dcloud.share.IFShareApi
-keep public class * extends io.dcloud.share.IFShareApi
-keepclasseswithmembers class io.dcloud.share.IFShareApi {
    <methods>;
}

-keepattributes Exceptions,InnerClasses,Signature,Deprecated, SourceFile,LineNumberTable,*Annotation*,EnclosingMethod

-keep class io.dcloud.appstream.*
-keepclasseswithmembers class io.dcloud.appstream.* {
    public protected <methods>;
}

-keep class io.dcloud.common.DHInterface.IReflectAble
-keep public class * extends io.dcloud.common.DHInterface.IReflectAble{
  public protected <methods>;
  public protected *;
}
-keep class **.R
-keep class **.R$* {
    public static <fields>;
}
-keep public class * extends io.dcloud.common.DHInterface.IJsInterface{
  public protected <methods>;
  public protected *;
}

-keepclasseswithmembers class io.dcloud.EntryProxy {
    <methods>;
}

-keep class * implements android.os.IInterface {
  <methods>;
}

-keepclasseswithmembers class *{
  public static java.lang.String getJsContent();
}
-keepclasseswithmembers class io.dcloud.appstream.* {
    <methods>;
}
-keepclasseswithmembers class *{
	public static void onReceiver1(android.content.Intent, android.content.Context);
}

-keepclasseswithmembers class *{
  public static io.dcloud.share.AbsWebviewClient getWebviewClient(io.dcloud.share.ShareAuthorizeView);
}
-keepclasseswithmembers class *{
	public java.lang.String exec(java.lang.String,java.lang.String,java.lang.String[]);
}
-keepattributes Exceptions,InnerClasses,Signature,Deprecated, SourceFile,LineNumberTable,*Annotation*,EnclosingMethod

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keep public class * extends android.app.Application{
  public static <methods>;
  public *;
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
   public static <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepattributes Signature
-keep class io.dcloud.encryption.** {*;}
-dontwarn com.igexin.**
-keep class org.json.** { *; }
-dontwarn com.amap.**
-dontwarn org.apache.commons.**
-dontwarn com.sina.weibo.sdk.**

-keep class uni.** {*;}
-keep class pl.** {*;}
-keep class io.** {*;}
-keep class org.mozilla.**{*;}

-keep class androidtranscoder.**{*;}
-keep class XI.**{*;}

# 开源库依赖的其它库---start---
-dontwarn com.google.android.material.**
-keep class com.google.android.material.** {*;}
-dontwarn com.google.common.collect.**
-keep class com.google.common.collect.** {*;}
-dontwarn java.awt.**
-keep class java.awt.** {*;}
-dontwarn javax.money.**
-keep class javax.money.** {*;}
-dontwarn javax.servlet.**
-keep class javax.servlet.** {*;}
-dontwarn javax.ws.**
-keep class javax.ws.** {*;}
-dontwarn org.glassfish.jersey.**
-keep class org.glassfish.jersey.** {*;}
-dontwarn org.javamoney.moneta.**
-keep class org.javamoney.moneta.** {*;}
-dontwarn org.joda.time.**
-keep class org.joda.time.** {*;}
-dontwarn org.springframework.**
-keep class org.springframework.** {*;}
-dontwarn springfox.documentation.spring.web.json.**
-keep class springfox.documentation.spring.web.json.** {*;}

# retrofit2---start---
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.** <methods>;
}
# retrofit2---end---
