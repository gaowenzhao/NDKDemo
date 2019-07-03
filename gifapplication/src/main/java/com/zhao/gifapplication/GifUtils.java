package com.zhao.gifapplication;

import android.graphics.Bitmap;

public class GifUtils {
    static {
        System.loadLibrary("android_gif");
    }
    public static native long openFile(String pathName);

    public static native long renderFrame(long gifInfo, Bitmap bitmap);

    public static native int getWidth(long gifInfo);

    public static native int getHeight(long gifInfo);

}
