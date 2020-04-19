package com.sun.androidlearn.ui.day06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sun.androidlearn.R;
import com.sun.androidlearn.ui.day04.GuidanceActivity;

public class LaunchModeActivity extends AppCompatActivity {

    /**
     * Activity的4种启动模式
     * 单进程。单app
     * Activity 栈: 用来维护Activity 【1，2，3，4】 后进先出特性
     *【Activity1，Activity2，Activity3，Activity4，Activity5，Activity6】
     *【Activity2，Activity2，Activity2，Activity2】standard
     * singleTop  : [MainActivity2,LaunchModeActivity] 当Activity在栈顶的时候，进行复用
     * singleTask :  [MainActivity2,LaunchModeActivity,DataActivity，DataActivity] 栈内复用,会把栈内LaunchModeActivity之上的页面都销毁掉。复用
     * singleInstance 多app复用。微信支付。
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch_mode);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

        findViewById(R.id.launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchModeActivity.this, LaunchModeActivity.class));
            }
        });
        findViewById(R.id.data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchModeActivity.this, DataActivity.class));
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this,"onNewIntent",Toast.LENGTH_LONG).show();
    }
}
