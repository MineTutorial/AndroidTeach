package com.sun.androidlearn.ui.day03;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sun.androidlearn.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PermissionActivityMy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_my);

        final ImageView imageView = findViewById(R.id.imagemy);
        //UI 操作必须在主线程内



        //网络基础权限————>


        //起个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程
                String iamgeUrl = "http://img1.imgtn.bdimg.com/it/u=2682884981,2475921480&fm=26&gp=0.jpg";
                final Bitmap bitmap = getURLimage(iamgeUrl);

                //Main 线程--主线程：所有View操作，UI操作都在主线程
                //两种方法
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //UI 操作必须在主线程内
                        imageView.setImageBitmap(bitmap);//将子线程内改到主线程内
                    }
                });
//                imageView.post(new Runnable() {
////                    @Override
////                    public void run() {
////
////                    }
////                });

            }
        });

    }

    /**
     * 从网络访问图片,下载
     * @param url
     * @return
     */
    public static Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            //获取连接     HttpURLConnection官方提供框架
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is =conn.getInputStream();//获取图片数据流
            bmp = BitmapFactory.decodeStream(is);//拿到bmp后，可设置image图
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }
}
