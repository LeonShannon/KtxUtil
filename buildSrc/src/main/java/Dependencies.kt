
object AndroidConfig{
    /**
     * SDK编译版本
     * compileSdkVersion 告诉 Gradle 用哪个 Android SDK 版本编译你的应用。
     * 使用任何新添加的 API 就需要使用对应 Level 的 Android SDK。
     */
    const val compileSdkVersion =29
    /**
     *  android构建工具的版本,在SDK Manager中安装选择版本，
     *  buildToolsVersion的版本需要>=CompileSdkVersion;
     *  高版本的build-tools 可以构建低版本编译的android程序；
     */
    const val buildToolsVersion ="29.0.2"
    /**
     * 最小的SDK版本
     */
    const val minSdkVersion = 24
    /**
     * targetSdkVersion 是 Android 提供向前兼容的主要依据，
     * 在应用的 targetSdkVersion 没有更新之前系统不会应用最新的行为变化。这允许你在适应新的行为变化之前就可以使用新的 API
     */
    const val targetSdkVersion = 29
}

object Versions{
    object Androidx {
        const val appcompatVersion = "1.1.0"
        const val coreKtxVersion = "1.1.0"
        const val constraintLayoutVersion = "1.1.3"
        const val cardViewVersion="1.0.0"
        const val materialVersion="1.0.0-rc01"
        const val coordinatorLayoutVersion="1.0.0"
        const val multiDexVersion="2.0.1"
        const val recyclerViewVersion="1.0.0"
        const val roomVersion="2.2.1"
        //room 非Androidx依赖
        const val roomVersionNoAndroidx="1.1.1"
        const val lifecycleVersion="2.1.0"
        const val navigationVersion="2.1.0"
    }
    object Test {
        const val junitVersion ="4.12"
        const val androidTestJunitVersion="1.1.1"
        const val androidTestEspresso = "3.2.0"
    }
    const val gsonVersion="2.8.6"
    const val okhttpVersion="4.2.1"
    object Glide{
        const val glideVersion="4.10.0"
        const val glideCompilerVersion="4.10.0"
    }
    object Kotlin{
        const val kotlinVersion="1.3.50"
        const val anko = "0.10.8"
        const val kotlinCoroutinesVersion="1.3.2"
    }
    const val brvhVersion="2.9.50"
    const val materialDialogsVersion = "3.1.1"
}

object Libs{

    /**
     * 使用说明和依赖引用详见：https://developer.android.com/jetpack/androidx/releases/lifecycle
     */
    object Lifecycle{
        //viewModel 和 LiveData 合体版
        const val viewModelAndLiveData="androidx.lifecycle:lifecycle-extensions:${Versions.Androidx.lifecycleVersion}"
        //只包含ViewModel
        const val viewModel="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.lifecycleVersion}"
        //只包含LiveData
        const val liveData="androidx.lifecycle:lifecycle-livedata:${Versions.Androidx.lifecycleVersion}"
        //只包含lifecycle不包含viewModel和LiveData
        const val lifecycleRuntime="androidx.lifecycle:lifecycle-runtime:${Versions.Androidx.lifecycleVersion}"
    }


    const val appCompat = "androidx.appcompat:appcompat:${Versions.Androidx.appcompatVersion}"
    const val corektx ="androidx.core:core-ktx:${Versions.Androidx.coreKtxVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Androidx.constraintLayoutVersion}"
    const val cardView = "androidx.cardview:cardview:${Versions.Androidx.cardViewVersion}"
    const val material = "com.google.android.material:material:${Versions.Androidx.materialVersion}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.Androidx.recyclerViewVersion}"
    const val multiDex = "androidx.multidex:multidex:${Versions.Androidx.multiDexVersion}"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.Androidx.coordinatorLayoutVersion}"

    /**
     * 引入示例
     * <code>
     *     dependencies {
     *     ...
     *      testImplementation Libs.Test.junit
     *      androidTestImplementation Libs.Test.androidTestJunit
     *      androidTestImplementation Libs.Test.androidTestEspresso
     *     }
     * </code>
     */

    const val junit = "junit:junit:${Versions.Test.junitVersion}"
    const val androidTestJunit = "androidx.test.ext:junit:${Versions.Test.androidTestJunitVersion}"
    const val androidTestEspresso = "androidx.test.espresso:espresso-core:${Versions.Test.androidTestEspresso}"

    const val KotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.kotlinVersion}"
    const val KotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.kotlinCoroutinesVersion}"
    const val KotlinAnkoCommons = "org.jetbrains.anko:anko-commons:${Versions.Kotlin.kotlinVersion}"
    const val KotlinAnkoSQLite = "org.jetbrains.anko:anko-sqlite:${Versions.Kotlin.kotlinVersion}"


    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"


    const val glide = "com.github.bumptech.glide:glide:${Versions.Glide.glideVersion}"
    //需要使用注解引入kapt
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Glide.glideCompilerVersion}"

    //https://github.com/CymChad/BaseRecyclerViewAdapterHelper
    const val brvh = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.brvhVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    //https://github.com/greenrobot/EventBus
    const val eventBus = "org.greenrobot:eventbus:3.1.1"
    //https://github.com/JessYanCoding/AndroidAutoSize
    const val autoSize = "me.jessyan:autosize:1.1.2"
    //轻量级对象存储框架https://github.com/orhanobut/hawk
    const val hawk = "com.orhanobut:hawk:2.0.1"
    //https://github.com/amitshekhariitbhu/Android-Debug-Database
    const val deBugDB="com.amitshekhar.android:debug-db:1.0.6"
    const val glideOkHttp = "com.github.bumptech.glide:okhttp3-integration:1.4.0@aar"
    //https://github.com/cshzhang/largeimageview
    const val largeImageView = "com.shizhefei:LargeImageView:1.1.0"
    //https://github.com/Clans/FloatingActionButton
    const val fab = "com.github.clans:fab:1.6.4"

    /**
     *FlycoDialog_Master(Dialog):https://github.com/H07000223/FlycoDialog_Master
     */
    const val flycoDialog = "com.flyco.dialog:FlycoDialog_Lib:1.2.2@aar"
    const val flycoDialogAnimation = "com.flyco.animation:FlycoAnimation_Lib:1.0.0@aar"
    const val nineoldAndroids = "com.nineoldandroids:library:2.4.0"

    /**
     * Material Dialogs: https://github.com/afollestad/material-dialogs
     */
    const val materialDialogsCore = "com.afollestad.material-dialogs:core:${Versions.materialDialogsVersion}"
    const val materialDialogsInput = "com.afollestad.material-dialogs:input:${Versions.materialDialogsVersion}"
    const val materialDialogsFiles = "com.afollestad.material-dialogs:files:${Versions.materialDialogsVersion}"
    const val materialDialogsColor = "com.afollestad.material-dialogs:color:${Versions.materialDialogsVersion}"
    const val materialDialogsDateTime = "com.afollestad.material-dialogs:datetime:${Versions.materialDialogsVersion}"
    const val materialDialogsBottomSheets = "com.afollestad.material-dialogs:bottomsheets:${Versions.materialDialogsVersion}"
    const val materialDialogsLifecycle = "com.afollestad.material-dialogs:lifecycle:${Versions.materialDialogsVersion}"
    /**
     * 使用说明和依赖引用详见：https://developer.android.google.cn/jetpack/androidx/releases/room?hl=en
     */
    //基础包
    const val roomRuntime = "androidx.room:room-runtime:${Versions.Androidx.roomVersion}"
    //对于Kotlin，请使用kapt代替注解处理器
    const val roomCompiler = "androidx.room:room-compiler:${Versions.Androidx.roomVersion}"
    //可选-Kotlin扩展和协程对Room的支持
    const val roomKtx = "androidx.room:room-ktx:${Versions.Androidx.roomVersion}"
    //可选-RxJava对Room的支持
    const val roomRxJava2 = "androidx.room:room-rxjava2:${Versions.Androidx.roomVersion}"
    //可选-guava对Room的支持，包括Optional和ListenableFuture
    const val roomGuava = "androidx.room:room-guava:${Versions.Androidx.roomVersion}"
    //测试助手
    const val roomTesting = "androidx.room:room-testing:${Versions.Androidx.roomVersion}"

}

