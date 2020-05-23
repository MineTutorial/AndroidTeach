package com.sun.androidlearn.bili.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.androidlearn.R;

/**
 * Author: jfson sun
 * Create on:  2020/5/23
 * Question:
 * Description: 自定义View
 * Train of thought:
 */
public class LiveViewGroup extends ConstraintLayout {
    TextView title;

    public LiveViewGroup(Context context) {
        super(context);
        initView();
    }

    public LiveViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LiveViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.pager_live, this);
        setBackgroundColor(getContext().getResources().getColor(R.color.colorYellow));
        title = findViewById(R.id.live_title);
        title.setText("findViewById Live");
    }







}
