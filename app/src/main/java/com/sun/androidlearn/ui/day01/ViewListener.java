package com.sun.androidlearn.ui.day01;

/**
 * Author: jfson sun
 * Create on:  2020/3/28
 * Question:
 * Description:
 * Train of thought: 接口回调 setOnClickListener
 */
public class ViewListener {
    private Listener mListener;


    public void setOnClickLisenter(Listener lisenter){
        this.mListener = lisenter;
    }

    public void pause(){
        if (mListener != null){
            mListener.onClick();
        }
    }


    public interface Listener{
        void onClick();
    }
}
