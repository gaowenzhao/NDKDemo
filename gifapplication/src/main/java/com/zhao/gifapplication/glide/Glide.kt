package com.zhao.gifapplication.glide

import android.content.Context

object Glide {
    fun with(context: Context):BitmapRequest{
        return BitmapRequest(context)
    }
}