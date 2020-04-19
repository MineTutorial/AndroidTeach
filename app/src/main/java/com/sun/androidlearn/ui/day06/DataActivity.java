package com.sun.androidlearn.ui.day06;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sun.androidlearn.Main2Activity;
import com.sun.androidlearn.R;


/**
 * 数据持久化，存一些信息
 * 文件，图片，代码级别字段String,Int,Boolean
 * 场景：首次启动的时候，引导页。Boolean -- 是否是第一次。存起来，
 * 用户登录，记住登录密码
 * 方式：1.Shared Preferences
 * 2.文件--视频，图片，文本。  --- 清除缓存。文件目录，删除维护的文件夹
 * app-应用内的文件目录（Internal Storage），应用外的文件目录（文件管理app）（External Storage）
 * 3.SQLite Databases -- sq -- 建表
 * //app/cache/file-image-video-text-music-http
 *
 */
public class DataActivity extends AppCompatActivity {
    EditText name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        name = findViewById(R.id.username);//12345
        password = findViewById(R.id.password);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setSp(getBaseContext());
                startActivity(new Intent(DataActivity.this, LaunchModeActivity.class));
            }
        });

//        Button getPassword = findViewById(R.id.getPassword);
//        getPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        getSp(getBaseContext());
    }

    private void setSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences("DataActivity", Context.MODE_PRIVATE);
        //可以创建一个新的SharedPreference来对储存的文件进行操作
        //像SharedPreference中写入数据需要使用Editor
        SharedPreferences.Editor editor = sp.edit();
        //类似键值对
        editor.putString("name", name.getText().toString());  // sp   name : xx
        editor.putString("password", password.getText().toString());// pw  : xx
        //editor.apply();
        editor.apply();
    }

    private void getSp(Context context){
        SharedPreferences sp = context.getSharedPreferences("DataActivity", Context.MODE_PRIVATE);
        String spname = sp.getString("name",null);
        String sppassword = sp.getString("password",null);

        if (name != null){
            name.setText(spname);
        }

        if (sppassword != null){
            password.setText(sppassword);
        }
    }

}
