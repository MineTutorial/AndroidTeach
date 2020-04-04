package com.sun.androidlearn.ui.day01;

public class ViewListenerTwo {
    private Listener mListener;

    public void setOnClickLisenter(Listener lisenter){
        this.mListener = lisenter;
    }

    public void pause(){
        if (mListener != null){
            mListener.onclick();//如果不为空调用onclick方法
        }
    }


    public interface Listener{
        void onclick();//接口回调一个onclick
    }
}
