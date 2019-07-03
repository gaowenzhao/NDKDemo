package com.zhao.gifapplication

import android.graphics.Bitmap
import android.graphics.Picture
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Message
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    private val mHandler = MyHandler()
    private lateinit var bitmap:Bitmap
    var gifInfo:Long = 0
    val test by lazy { Test() }
    private val path = Environment.getExternalStorageDirectory().absolutePath+ File.separator+ "Pictures"+ File.separator+"welcome.gif"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            play()
        }
    }


    private fun play(){
        Log.i("MainActivity",path)
        gifInfo =  GifUtils.openFile(path)
        bitmap = Bitmap.createBitmap(GifUtils.getWidth(gifInfo), GifUtils.getHeight(gifInfo),Bitmap.Config.ARGB_8888)
        val delay =  GifUtils.renderFrame(gifInfo,bitmap)
        iv_gif.setImageBitmap(bitmap)
        mHandler.sendEmptyMessageDelayed(0,delay)
        Log.i("MainActivity","delay=$delay")
    }
   inner class  MyHandler:Handler(){
       override fun handleMessage(msg: Message?) {
           showBitmap()
       }
   }
    fun showBitmap(){
        val delay =  GifUtils.renderFrame(gifInfo,bitmap)
        if(delay>0){
            iv_gif.setImageBitmap(bitmap)
            mHandler.sendEmptyMessageDelayed(0,delay)
            Log.i("MainActivity","delay=$delay")
        }else{
            mHandler.removeMessages(0)
            Log.i("MainActivity","delay=$delay")
        }

    }
}
