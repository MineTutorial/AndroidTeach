package com.sun.androidlearn.ui.day09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.sun.androidlearn.R;

import java.util.List;

/**
 * Android 架构模式
 * MVC,MVP,MVVM
 * 最基础的模式MVC;(例子：ListActivity -- controller;--> Model --> xml);最常用. 耦合性比较高
 * MVP: 接口；解耦合
 * MVVM: data-binding,响应式
 */
public class MVPActivity extends AppCompatActivity implements MvpContract.IMVPActivity{
    MVPPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_v_c);
        mvpPresenter = new MVPPresenter(this);

        RecyclerView recyclerView;//findViewbyid;Adapter,
        //initData()
        //View层 需要数据了 --》 P 层
        mvpPresenter.initListData();

    }

    @Override
    public void refreshRecyclerView(List<String> strings) {
        //adapter.setData
        //notify
        // data.addAll(data2);
        //  mAdapter.notifyDataSetChanged();
    }
}
