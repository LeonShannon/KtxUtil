package com.sc.bk

import android.app.Activity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.StringRes
import com.sc.bk.widget.CustomToast

/**
 * 文件描述：Activity的扩展
 * 文件创建人：ChenXinLei
 * 文件创建人联系方式：502616659(QQ)
 * 创建时间：2019 年 12月 09 日
 * 文件版本：v1.0
 * 版本描述：创建文件
 */

/**
 * 显示toast
 * @param content 显示的内容
 */
fun Activity.showToast(content:String){
    CustomToast(this.applicationContext, content).show()
}

/**
 * 获取String资源value
 * 这个String有占位符
 */
fun Activity.getResString(@StringRes strId:Int):String = getString(strId)


/**
 * 获取String资源value
 * 这个String有占位符
 */
fun Activity.getResStringPlaceholder(@StringRes strId:Int, vararg value: String):String {
    return String.format(getString(strId),*value)
}


/**
 * 全屏
 */
fun Activity.fullScreen(){
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    window.setFlags(
        WindowManager.LayoutParams. FLAG_FULLSCREEN ,
        WindowManager.LayoutParams. FLAG_FULLSCREEN);
}

/**
 * 隐藏底部
 */
fun Activity.hideBottomUIMenu(){
    val  params = window.attributes;
    params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    window.attributes = params;
}