package com.zhao.gifapplication.glide

import android.util.Log
import java.util.concurrent.LinkedBlockingQueue

class BitmapDispatcher(private val linkedBlockingQueue: LinkedBlockingQueue<BitmapRequest>) : Thread() {
    private val tag:String = "BitmapDispatcher"
    override fun run() {
        super.run()
        while (!isInterrupted) {
            val bitmapRequest = linkedBlockingQueue.take()
            Log.i(tag, "图片处理start")
            Log.i(tag, "bitmapRequest.url =${bitmapRequest.url}")
            sleep(3000)
            Log.i(tag, "图片处理end")
        }
    }
}