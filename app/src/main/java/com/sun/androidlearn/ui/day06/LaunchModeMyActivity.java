package com.sun.androidlearn.ui.day06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sun.androidlearn.R;

public class LaunchModeMyActivity extends AppCompatActivity {


    /**
     * 注：自己还要多看看
     *
     * Activity zai 维护activity 也就是维护页面（逻辑）
     * 1，2,3,4，后进先出
     *1.standard
     *
     * 2.singTop zhai顶时复用
     * 3.singTask zhia【mainactivity，Lacunch。。，main，Launch】zhai内复用，把zhai内LaunchModeActivity之上的页面干掉如何复用
     * 4.singInstance 手机内复用，软件间
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_launch_mode_my);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

        findViewById(R.id.launchmy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //自己跳自己
                startActivity(new Intent(LaunchModeMyActivity.this, LaunchModeMyActivity.class));
            }
        });
        findViewById(R.id.data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchModeMyActivity.this,DateMyActivity.class));
            }
        });

//        @Override
//        protected void onNewIntent(Intent intent) {
//            super.onNewIntent(intent);
//            Toast.makeText(this,"onNewIntent",Toast.LENGTH_LONG).show();
//        }
    }
}
