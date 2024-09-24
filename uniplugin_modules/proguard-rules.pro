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
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference

-keep public class * extends io.dcloud.weex.AppHookProxy {*;}
-keep public class * extends io.dcloud.feature.uniapp.UniAppHookProxy {*;}
-keep public class * extends io.dcloud.feature.uniapp.common.UniModule {*;}
-keep public class * extends io.dcloud.feature.uniapp.ui.component.UniComponent {*;}

# 开源库依赖的其它库---start---
-dontwarn java.lang.invoke.**
-keep class java.lang.invoke.** {*;}
