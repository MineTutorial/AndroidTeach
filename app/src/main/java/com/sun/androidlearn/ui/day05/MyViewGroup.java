package com.sun.androidlearn.ui.day05;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.sun.androidlearn.R;


/**
 * Author: jfson sun
 * Create on:  2020/4/18
 * Question:
 * Description:
 * Train of thought:
 */
public class MyViewGroup  {
//    public MyViewGroup(Context context) {
//        super(context);
//    }
//
//    public MyViewGroup(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    public void initViewGroup(Context context,ViewGroup root) {
        LayoutInflater.from(context).inflate(R.layout.pager_view_myone, root, false);

    }


}
