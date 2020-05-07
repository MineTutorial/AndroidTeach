package com.sun.androidlearn.ui.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/7
 * Question:
 * Description:
 * Train of thought:
 */
public class MVPModel implements MvpContract.IMVPModel{

    @Override
    public void requestListData(Listener listener) {
        //request ... 耗时
        List<String> str = new ArrayList<>();
        str.add("233333");
        listener.dataFinish(str);
    }


    interface Listener{
        void dataFinish( List<String> str );
    }
}
