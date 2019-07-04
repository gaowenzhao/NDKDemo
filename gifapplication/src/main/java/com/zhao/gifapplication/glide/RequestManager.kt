package com.zhao.gifapplication.glide

import java.util.concurrent.LinkedBlockingQueue

class RequestManager {
    companion object{
        val instance by lazy { RequestManager() }
    }
    private val linkedBlockingQueue  = LinkedBlockingQueue<BitmapRequest>()
    private val bitmapDispatchers: Array<BitmapDispatcher?> = arrayOfNulls(2)
    private constructor(){
        start()
    }

   private fun start() {
       stop()
       for(i in 0..1){
           val bitmapDispatcher = BitmapDispatcher(linkedBlockingQueue)
           bitmapDispatcher.start()
           bitmapDispatchers[i] = bitmapDispatcher
       }
   }
   fun stop(){
     for (item in bitmapDispatchers){
         item?.interrupt()
     }
   }

    fun add(bitmapRequest: BitmapRequest){
        linkedBlockingQueue.put(bitmapRequest)
    }

}