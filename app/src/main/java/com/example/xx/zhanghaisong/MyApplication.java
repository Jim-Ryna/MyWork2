package com.example.xx.zhanghaisong;

import android.app.Application;
import android.content.Context;

/**
 * Created by xx on 2015/5/31.
 */
public class MyApplication extends Application{
    private static Context mContext;
    public void onCreate(){
        mContext = getApplicationContext();
    }
    public static Context getContext(){
        return mContext;
    }
}

