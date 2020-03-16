package com.sun.androidlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sun.androidlearn.ui.ListActivity;
import com.sun.androidlearn.ui.WechatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//second



        // 列表
        // ListView  很少很少
        // RecyclerView 用的比较多


        TextView view = findViewById(R.id.gotoListActivity);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListActivity.class));
            }
        });


        TextView view1 = findViewById(R.id.gotwechatActivity);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WechatActivity.class));
            }
        });




    }
}
