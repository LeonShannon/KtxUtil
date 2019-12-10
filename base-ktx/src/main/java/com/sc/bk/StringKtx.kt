package com.sc.bk

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.regex.Pattern
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

/**
 * 描    述：String的扩展
 * 作    者：陈鑫磊
 * 创建时间：2019-年-03-月-13-日 11:56
 * 版    本：v1.0
 * 版本概述：创建
 */

/**
 * 转md5
 */
fun String.md5() :String {
    try {
        val instance: MessageDigest = MessageDigest.getInstance("MD5")//获取md5加密对象
        val digest:ByteArray = instance.digest(toByteArray())//对字符串加密，返回字节数组
        val sb : StringBuffer = StringBuffer()
        for (b in digest) {
            val i :Int = b.toInt() and 0xff//获取低八位有效值
            var hexString = Integer.toHexString(i)//将整数转化为16进制
            if (hexString.length < 2) {
                hexString = "0$hexString"//如果是一位的话，补0
            }
            sb.append(hexString)
        }
        return sb.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}


/**
 * 打印日志类型Error自定义TAG
 */
var DEFAULT_TAG= "BASE-KTX"
/**
 * 打印日志
 */
fun String.printLogError(tag:String = DEFAULT_TAG,
                         isPrint:Boolean = BuildConfig.DEBUG,
                         logLevel:Int = Log.ERROR){
    if (isPrint){
        Log.println(logLevel,tag,"")
        Log.println(logLevel,tag,"************************************************************")
        Log.println(logLevel,tag,"输出地址-> "+getStackTraceInfo())
        if (length>4000){
            Log.println(logLevel,tag,this.substring(0,2000))
            Log.println(logLevel,tag,this.substring(2000))
        }else{
            Log.println(logLevel,tag,this)
        }
        Log.println(logLevel,tag,"------------------------------------------------------------")
    }
}

/**
 * 获取堆栈信息
 */
fun getStackTraceInfo():String{
    val stack= getTargetStackTraceElement()
    return if (stack==null){
        ""
    }else{
        "(${stack.fileName}:${stack.lineNumber})"
    }
}

private fun getTargetStackTraceElement(): StackTraceElement? {
    // find the target invoked method
    var targetStackTrace: StackTraceElement? = null
    var shouldTrace = false
    val stackTrace = Thread.currentThread().stackTrace
    for (stackTraceElement in stackTrace) {
        val isLogMethod = stackTraceElement.className == "com.sc.bk.StringExt"
        if (shouldTrace && !isLogMethod) {
            targetStackTrace = stackTraceElement
            break
        }
        shouldTrace = isLogMethod
    }
    return targetStackTrace
}

/**
 * 判断是否是数字
 */
fun String.isInteger():Boolean{
    val pattern = Pattern.compile("^[-+]?[\\d]*$");
    return pattern.matcher(this).matches()
}


/**
 * ping服务器地址
 */
fun String.ping():Boolean{
    return try {
        //ping -c 3 -w 100  中  ，-c 是指ping的次数 3是指ping 3次 ，-w 100  以秒为单位指定超时间隔，是指超时时间为100秒
        val p = Runtime.getRuntime().exec("ping -c 3 -w 100 $this" )
        val status = p.waitFor()
        status == 0
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

/**
 * 格式化XML字符串
 */
fun String.formatXML():String{
    return try {
        val xmlInput= StreamSource(StringReader(this))
        val xmlOutput =  StreamResult( StringWriter())
        val transformer = TransformerFactory.newInstance().newTransformer()
        transformer.setOutputProperty(OutputKeys.INDENT, "yes")
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
        transformer.transform(xmlInput, xmlOutput)
        xmlOutput.writer.toString().replaceFirst(">", ">\n")
    }catch (e:Exception){
        e.printStackTrace()
        this
    }
}

/**
 * 格式化Json字符串
 */
fun String.formatJSON():String{
    if (BuildConfig.DEBUG){
        var message: String
        message = try {
            when {
                this.startsWith("{") -> {
                    val  jsonObject =  JSONObject(this)
                    jsonObject.toString(4)
                }
                this.startsWith("[") -> {
                    val jsonArray =  JSONArray(this)
                    jsonArray.toString(4)
                }
                else -> this
            }
        } catch ( e: JSONException) {
            this
        }
        message = System.getProperty("line.separator")+ message
        val lines = message.split(System.getProperty("line.separator")?:"/")
        val sb=StringBuffer()
        lines.forEach {
           sb.append(it).append("\n")
        }
        return sb.toString()
    }else{
        return ""
    }
}