package com.sun.androidlearn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.sun.androidlearn.ui.day04.GuidanceActivity;
import com.sun.androidlearn.ui.day05.MyViewGroup;
import com.sun.androidlearn.ui.day06.DataActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("https://www.bilibili.com/");

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, DataActivity.class));
            }
        });

    }
}
