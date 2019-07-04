package com.zhao.gifapplication.glide

import android.content.Context
import android.widget.ImageView

class BitmapRequest(context: Context){

    var url:String =""

    var defResId:Int = 0

    var listener: RequestListener? = null

    lateinit var imageView:ImageView
    fun load(url:String):BitmapRequest{
        this.url = url
        return this
    }
    fun placeHolder(defResId:Int):BitmapRequest{
        this.defResId = defResId
        return this
    }
    fun into(view:ImageView){
        imageView = view
        imageView.setImageResource(defResId)
        //把请求添加到队列
        RequestManager.instance.add(this)
    }
}