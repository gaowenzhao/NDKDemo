package com.zhao.gifapplication;

import android.util.Log;

public class Test {
    static synchronized void thread1(){
        Log.i("Test","11111 start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("Test","11111 end");
    }
    static synchronized void thread2(){

        Log.i("Test","2222 start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("Test","2222 end");
    }
}
