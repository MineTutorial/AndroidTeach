package com.sun.androidlearn.ui.day03;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sun.androidlearn.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        /**
         * 作业：ListActivity页面图片都替换成网络的
         */


        final ImageView imageView = findViewById(R.id.image);
        //Main 线程--主线程； 所有View操作、UI操作都在主线程


        //起个异步线程，子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程
                String imageUrl = "http://img1.imgtn.bdimg.com/it/u=2682884981,2475921480&fm=26&gp=0.jpg";
                final Bitmap bitmap = getURLimage(imageUrl);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //UI 操作必须在主线程
                        imageView.setImageBitmap(bitmap);
                    }
                });

//                imageView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //UI 操作必须在主线程
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });

            }
        }).start();
    }

    /**
     * 从网络访问/下载图片
     */
    public static Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }
}
