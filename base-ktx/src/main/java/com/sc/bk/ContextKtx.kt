package com.sc.bk

import android.annotation.TargetApi
import android.app.ActivityManager
import android.content.Context
import androidx.annotation.StringRes
import com.sc.bk.widget.CustomToast

/**
 * 文件描述：Context扩展
 * 文件创建人：ChenXinLei
 * 文件创建人联系方式：502616659(QQ)
 * 创建时间：2019 年 12月 09 日
 * 文件版本：v1.0
 * 版本描述：创建文件
 */

/**
 * 判断某Service是否被注册
 * 该方法只适合在{@link android.os.Build.VERSION_CODES#O}下使用
 * @param serviceName 服务名称如：com.**.**.server.StandbyService
 */
@TargetApi(android.os.Build.VERSION_CODES.O)
fun Context.isRunService(serviceName:String):Boolean{
    val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
        if (serviceName == service.service.className) {
            return true
        }
    }
    return false
}

/**
 * 显示自定义Toast
 */
fun Context.showToast(content:String){
    CustomToast(this.applicationContext, content).show()
}


/**
 * 获取String资源value
 * 这个String有占位符
 */
fun Context.getResString(@StringRes strId:Int):String = getString(strId)


/**
 * 获取String资源value
 * 这个String有占位符
 */
fun Context.getResStringPlaceholder(@StringRes strId:Int,vararg value: String):String {
    return String.format(getString(strId),*value)
}