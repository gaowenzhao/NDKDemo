package com.zhao.myndkapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var textString:String = "gaowenzhao"
    var textInt:Int = 2
    var textBean:TextBean = TextBean() //实体类不能用by lazy 初始化
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        sample_text.text = JNIUtils.stringFromJNI()
//        sample_text.text = JNIApiUtils.findClass(MainActivity::class.java.canonicalName).canonicalName
//        JNIApiUtils.getMethodID(ArrayList::class.java,"add")
//        sample_text.text = JNIApiUtils.setIntValue(this,"textInt",100).toString()
//        sample_text.text = JNIApiUtils.setStringValue(this,"textString","老婆")
//        textBean.age = 100
//        textBean.name = "hahahahahh"
//        sample_text.text = (JNIApiUtils.setObjectsValue(this,"textBean",textBean) as TextBean).name
//        JNIApiUtils.getMethodIDAndCall(this,"toast","hahahah")
        sample_text.text = JNIApiUtils.newString("gaowenzhao")
    }

    fun toast(text:String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
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
