package com.sun.androidlearn.ui.day07;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sun.androidlearn.R;

public class ImageActivity extends AppCompatActivity {

    /**
     * 用 Glide 加载一张图片
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        SimpleDraweeView image = findViewById(R.id.head);

        Uri uri = Uri.parse("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3899339818,2424000553&fm=26&gp=0.jpg");
        image.setImageURI(uri);

    }
}
