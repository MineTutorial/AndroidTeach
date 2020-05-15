package com.sun.androidlearn.bili;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.sun.androidlearn.R;

import java.util.ArrayList;

public class BiFragment extends Fragment {

    TabLayout mTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_bi_fragment, container, false);
        ViewPager biliViewPage = root.findViewById(R.id.bili_view_pager);

        mTabLayout = root.findViewById(R.id.bili_tab);

        ArrayList list = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        list.add(li.inflate(R.layout.pager_live, null, false));//pager_live
        list.add(li.inflate(R.layout.pager_recommend, null, false));
        list.add(li.inflate(R.layout.pager_fire, null, false));
        MyPagerAdapter mAdapter = new MyPagerAdapter(list);
        biliViewPage.setAdapter(mAdapter);

        initTab();

        mTabLayout.setupWithViewPager(biliViewPage);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        return root;

    }

    private void initTab(){
        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("直播");
        tabList.add("推荐");
        tabList.add("热门");

//        for (int i = 0; i < tabList.size() ; i++) {
//            mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(i)));
//        }
    }

    private static class MyPagerAdapter extends PagerAdapter {

        private ArrayList<View> viewLists;//维护view   lg：直播，追番。。。
        private ArrayList<String> tabList;

        public MyPagerAdapter(ArrayList<View> viewLists) {
                super();
                this.viewLists = viewLists;
                tabList = new ArrayList<>();
                tabList.add("直播");
                tabList.add("推荐");
                tabList.add("热门");
        }

        @Override
        public int getCount() {
            return viewLists.size();
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewLists.get(position));
            return viewLists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewLists.get(position));
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position);
        }

    }
}
