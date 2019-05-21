package com.zhao.myndkapplication

object JNIUtils {
    init {
        System.loadLibrary("nativetest")
    }
    external fun stringFromJNI(): String

    external fun outputJsonSo(name: String, age: String, sex: String, type: String): String

    external fun parseJsonSo(json_str: String): String
}