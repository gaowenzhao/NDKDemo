package com.zhao.gifapplication.glide

class Test {
    lateinit var bitmapDispatchers: Array<BitmapDispatcher?>
    private fun initBitmap() {
        bitmapDispatchers = arrayOfNulls(4)
        bitmapDispatchers[0]?.start()
    }
}
