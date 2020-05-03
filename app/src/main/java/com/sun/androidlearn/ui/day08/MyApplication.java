package com.sun.androidlearn.ui.day08;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Author: jfson sun
 * Create on:  2020/5/3
 * Question:
 * Description:
 * Train of thought: App 的入口
 */
public class MyApplication extends Application {
   static Context mContext;

    /**
     * 最实用场景
     * 1.context 伴随整个app的生命周期
     * 2.初始化
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mContext = this;
    }

    public static Context getAppContext(){
        return mContext;
    }
}
