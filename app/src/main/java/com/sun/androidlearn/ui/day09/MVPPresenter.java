package com.sun.androidlearn.ui.day09;

import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/7
 * Question:
 * Description:
 * Train of thought:
 */
public class MVPPresenter {
    MvpContract.IMVPActivity mvpActivity;
    MvpContract.IMVPModel mvpModel;


    public MVPPresenter(MVPActivity mvpActivity) {
        this.mvpActivity = mvpActivity;
        this.mvpModel = new MVPModel();
    }


    public void initListData(){
        mvpModel.requestListData(new MVPModel.Listener() {
            @Override
            public void dataFinish( List<String> str) {
                mvpActivity.refreshRecyclerView(str);
            }
        });
    }




}
