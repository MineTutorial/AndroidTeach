package com.sun.androidlearn.ui.day04;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sun.androidlearn.R;

public class HandlerMyActivity extends AppCompatActivity {
    /**
     * 每个线程都有一个hander
     */
    Handler mHandler = new Handler();
    boolean isRefresh = true;
    /**
     * main/ui Thread主线程
     * 其他线程 。网络请求，图片加载，耗时操作
     * 线程就是运行在cpu，cpu只能运行一个线程，当运行到thread就会走到runnable,代码开始执行
     * @param savedInstanceState
     */
    @Override//onCreate是主线程，等等。。android是一个进程，一个app有很多线程，cpu只能一次处理一个线程
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_my);

        Runnable countDownRunnable = new Runnable() {
            @Override
            public void run() {
                //refresh刷新一次
                //启动下一个10s的 delay ... this 就是这个activity的意思
                //这里this指的是runnable，一个方法
                //intent是activ。。页面之间   handler为线程之间
                if(isRefresh) {
                    mHandler.postDelayed(this, 10 * 10000);//如果满足即true则刷新
                }
            }
        };

        mHandler.postDelayed(countDownRunnable,10 * 1000);//一个延迟


        Runnable target = new Runnable() {
            @Override
            public void run() {
//                this.wait();  这里this 指定的是thread
                mHandler.sendEmptyMessage(0);//发送一个空消息

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        };
        Thread thread = new Thread(target);
        thread.start();
        isRefresh = false;
    }

//    public static class MyHandler extends Handler{
//        @Override
//        public void handleMessage(Message msg){
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 0:
//                    //Toast下载完成
//                    break;
//            }
//        }
//    }


    public void test(){

    }

    public static class MyTast extends AsyncTask{
        //封装方法放在异步线程，(耗时）
        public MyTast(){
            super();
        }

        @Override//加载
        protected void onPreExecute() {
            super.onPreExecute();
            //Loading
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Object o) {
            super.onCancelled(o);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            //Loading finish
        }

        @Override//运行到后台时
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }
}
