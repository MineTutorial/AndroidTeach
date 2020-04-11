package com.sun.androidlearn.ui.day02;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import com.sun.androidlearn.R;

import java.util.ArrayList;

public class ViewPagerActivityMy extends AppCompatActivity {
    TabLayout mTab;


//滑动页面ViewPager
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_my);

        mTab = findViewById(R.id.tabmy);
        ViewPager viewPager = findViewById(R.id.pagemy);

        ArrayList<View> aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.pager_view_myone,null,false));
        aList.add(li.inflate(R.layout.pager_view_mytwo,null,false));
        aList.add(li.inflate(R.layout.pager_view_mythree,null,false));
        MyPagerAdapter mAdapter = new MyPagerAdapter(aList);
        viewPager.setAdapter(mAdapter);



        initTab();

        mTab.setupWithViewPager(viewPager);//tab与viwpager进行绑定，联动
    }

    public void initTab(){ //页面中的滑动
        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("推荐");
        tabList.add("热门");
        tabList.add("直播");

//        for (int i = 0; i < tabList.size(); i++) {
//            mTab.addTab(mTab.newTab().setText(tabList.get(i)));
//        }
    }

    public static class MyPagerAdapter extends PagerAdapter {
        private ArrayList<View> viewLists; //list 连接接口
        private ArrayList<String> tabList;

        public MyPagerAdapter(){
            tabList = new ArrayList<>();
            tabList.add("推荐");
            tabList.add("热门");
            tabList.add("直播");
        }

        public MyPagerAdapter(ArrayList<View> viewLists){
            super();
            this.viewLists = viewLists;
            tabList = new ArrayList<>();
            tabList.add("推荐");
            tabList.add("热门");
            tabList.add("直播");
        }

        @Override
        public int getCount(){
            return viewLists.size();
        }

        @Override
        public boolean isViewFromObject(View view,Object object){
            return  view == object;
        }

        @Override
        public  Object instantiateItem(ViewGroup container, int position){
            container.addView(viewLists.get(position));
            return  viewLists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            container.removeView(viewLists.get(position));
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            return tabList.get(position);
        }

    }
}
