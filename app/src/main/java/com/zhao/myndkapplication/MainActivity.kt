package com.zhao.myndkapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
//        sample_text.text = JNIUtils.stringFromJNI()
        test()
    }

    fun test() {
//      调用jsoncpp.so生成json
        val outputJsonSo = JNIUtils.outputJsonSo("xong", "21", "man", "so")
        sample_text.text = outputJsonSo
//     调用jsoncpp.so解析json
      /*  val parseJsonSo = JNIUtils.parseJsonSo(outputJsonSo)
        sample_text.text = parseJsonSo*/
    }
}
