package com.sun.androidlearn;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.sun.androidlearn.ui.day05.MyViewGroup;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ConstraintLayout root = findViewById(R.id.root);

//        MyViewGroup group = findViewById(R.id.group);
//        MyViewGroup group = new MyViewGroup();
//        group.initViewGroup(this,root);
        LayoutInflater.from(this).inflate(R.layout.pager_view_myone, root, false);
    }
}
