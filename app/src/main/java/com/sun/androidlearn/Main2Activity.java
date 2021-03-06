package com.sun.androidlearn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.sun.androidlearn.ui.day04.GuidanceActivity;
import com.sun.androidlearn.ui.day05.MyViewGroup;
import com.sun.androidlearn.ui.day06.DataActivity;
import com.sun.androidlearn.ui.day06.DateMyActivity;
import com.sun.androidlearn.ui.day06.LaunchModeActivity;
import com.sun.androidlearn.ui.day06.LaunchModeMyActivity;
import com.sun.androidlearn.ui.day06.User;
import com.sun.androidlearn.ui.day07.ImageActivity;
import com.sun.androidlearn.ui.day08.Employer;
import com.sun.androidlearn.ui.day08.JsonData;
import com.sun.androidlearn.ui.day08.MyApplication;
import com.sun.androidlearn.ui.day09.thread.ThreadActivity;
import com.sun.androidlearn.ui.day10.RequestActivity;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("https://www.bilibili.com/");

//        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this, LaunchModeActivity.class));
//            }
//        });
//
//        findViewById(R.id.loginmy).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              startActivity(new Intent(Main2Activity.this, DateMyActivity.class));
//            }
//        });

        findViewById(R.id.loginmy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(Main2Activity.this, RequestActivity.class));
            }
        });
        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Main2Activity.this, ImageActivity.class));
                List<Employer.VideosBean> videosBeans = JsonData.testGSON();


                for (Employer.VideosBean user : videosBeans) {
                    Log.e("Test","user:" + user.getFirstName() + "--" + user.getAge());
                }
            }
        });

//        getBaseContext().startActivity();

        this.getResources().getColor(R.color.colorAccent);
        this.getResources().getDrawable(R.drawable.ycy);
        this.getResources().getString(R.string.app_name);

        MyApplication.getAppContext().getResources().getString(R.string.app_name);

    }
}
