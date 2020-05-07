package com.sun.androidlearn.ui.day09;

import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/7
 * Question:
 * Description:
 * Train of thought:
 */
public interface MvpContract {
    interface IMVPActivity{
        void refreshRecyclerView(List<String> strings);
    }

    interface IMVPModel{
        void requestListData(MVPModel.Listener listener);
    }
}
