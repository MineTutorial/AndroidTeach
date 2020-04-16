package com.sun.androidlearn.ui.day04;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.sun.androidlearn.R;
import com.sun.androidlearn.ui.day02.ViewPagerActivityMy;

import java.util.ArrayList;

public class GuidanceMyActivity extends AppCompatActivity {
    ViewPager mViewPager;
    ViewPagerActivityMy.MyPagerAdapter myPagerAdapterMy;
    View pointOneMy, pointTwoMy, pointThreeMy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance_my);


        mViewPager = findViewById(R.id.pagermy);//添加适配器
        ArrayList<View> aList = new ArrayList<>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.pager_view_myone,null,false));
        aList.add(li.inflate(R.layout.pager_view_mytwo,null,false));
        aList.add(li.inflate(R.layout.pager_view_mythree,null,false));

        myPagerAdapterMy = new ViewPagerActivityMy.MyPagerAdapter(aList);
        mViewPager.setAdapter(myPagerAdapterMy);//绑定Adapter

        //初始化
         pointOneMy = findViewById(R.id.point_myone);
         pointTwoMy = findViewById(R.id.point_mytwo);
         pointThreeMy = findViewById(R.id.point_mythree);

        mViewPager.setCurrentItem(0);//初始化完成，自动选中第一个
        pointOneMy.setSelected(true);
        pointTwoMy.setSelected(false);
        pointThreeMy.setSelected(false);

        //设置监听事件，当改变的时候换个色
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                //i = position.选中时
                switch (i){
                    case 0:
                        pointOneMy.setSelected(true);
                        pointTwoMy.setSelected(false);
                        pointThreeMy.setSelected(false);
                    case 1:
                        pointOneMy.setSelected(false);
                        pointTwoMy.setSelected(true);
                        pointThreeMy.setSelected(false);
                    case 2:
                        pointOneMy.setSelected(false);
                        pointTwoMy.setSelected(false);
                        pointThreeMy.setSelected(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
