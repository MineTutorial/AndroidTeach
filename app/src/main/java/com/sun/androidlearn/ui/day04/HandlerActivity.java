package com.sun.androidlearn.ui.day04;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sun.androidlearn.R;

public class HandlerActivity extends AppCompatActivity {
    /**
     * 每个线程都有一个handler
     */
//    MyHandler mHandler = new MyHandler(); //主线程的handler
    Handler mHandler = new Handler(); //主线程的handler
  boolean isRefrsh = true;
    /**
     * //main/ui Thread
     * //网络请求，图片加载，耗时操作，i/o .:异步操作，其他线程
     *
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);


        Runnable countDownRunnable = new Runnable() {
            @Override
            public void run() {
                //refresh
                //启动下一个10s delay
                //this -- Runnable
                if (isRefrsh){
                    mHandler.postDelayed(this,10 * 1000);
                }
            }
        };
        mHandler.postDelayed(countDownRunnable,10 * 1000);//1000ms = 1s


        Runnable target = new Runnable() {
            @Override
            public void run() {
                //download ...
//               this --指的Thread
                mHandler.sendEmptyMessage(0);

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


//        isRefrsh = false;

    }

    public void test(){
    }

    public static class MyTast extends AsyncTask{

        public MyTast() {
            super();
        }

        @Override
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

        @Override
        protected Object doInBackground(Object[] objects) {
            //
            return null;
        }
    }

//    public static class MyHandler extends Handler{
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case 0:
//                    //Toast 下载完成
//                    break;
//            }
//        }
//    }
}
