package com.zhao.myndkapplication

object JNIApiUtils {
    init{
        System.loadLibrary("jniapi")
    }
    external fun findClass(className:String):Class<*>
    external fun setIntValue(activity:MainActivity, fieldName:String,value:Int):Int
    external fun setStringValue(activity:MainActivity, fieldName:String,value:String):String
    external fun setObjectsValue(activity:MainActivity, fieldName:String,any: Any):Any

    external fun getMethodIDAndCall(activity:MainActivity,methodName:String,toast:String)

    external fun newString(text:String):String
}