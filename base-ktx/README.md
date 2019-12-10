# 基础扩展

## [Activity扩展](./src/main/java/com/sc/bk/ActivityKtx.kt)

| 作用 | 方法名 |
| --- | --- |
| 显示Toast | showToast(content:String) |
| 获取String资源value这个String有占位符 | getResString(@StringRes strId:Int)|
|获取String资源value这个String有**多个**占位符|getResStringPlaceholder(@StringRes strId:Int, vararg value: String)|
|全屏|fullScreen()|
|隐藏底部虚拟键盘|hideBottomUIMenuhideBottomUIMenu()|

## [Context扩展](./src/main/java/com/sc/bk/ContextKtx.kt)
| 作用 | 方法名 |
| --- | --- |
|判断某个Service是否已被被注册|isRunService(serviceName:String)|
| 显示Toast | showToast(content:String) |
| 获取String资源value这个String有占位符 | getResString(@StringRes strId:Int)|
|获取String资源value这个String有**多个**占位符|getResStringPlaceholder(@StringRes strId:Int, vararg value: String)|

## [String扩展](./src/main/java/com/sc/bk/StringKtx.kt)
| 作用 | 方法名 |
| --- | --- |
|转md5|md5()|
|打印日志|printLogError(tag:String = DEFAULT_TAG,</br>isPrint:Boolean = BuildConfig.DEBUG,</br>logLevel:Int = Log.ERROR)|
|判断是否是数字|isInteger()|
|字符串格式化成XML格式，一般用于打印更加美观|formatXML():String|
|字符串格式化成JSON格式，一般用于打印更加美观|formatJSON():String|