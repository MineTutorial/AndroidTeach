package com.sun.androidlearn.bili;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.sun.androidlearn.R;
import com.sun.androidlearn.data.BiliBiliData;
import com.sun.androidlearn.data.LiveDataModel;

import java.util.ArrayList;

public class BiFragment extends Fragment {

    /**
     * 作业：引导。10个小圈。
     * 数据model: live_list,follow_list,radio_list
     *
     */
    TabLayout mTabLayout;
    View mLiveView,mRecommendView,mFireView;
    ViewPager biliViewPage;
    ViewPager mBannerViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_bi_fragment, container, false);
        biliViewPage = root.findViewById(R.id.bili_view_pager);

        mTabLayout = root.findViewById(R.id.bili_tab);

        ArrayList<View> list = new ArrayList<>();
        mLiveView = inflater.inflate(R.layout.pager_live, null, false);
        mRecommendView = inflater.inflate(R.layout.pager_recommend, null, false);
        mFireView = inflater.inflate(R.layout.pager_fire, null, false);
        list.add(mLiveView);//pager_live
        list.add(mRecommendView);//pager_live
        list.add(mFireView);//pager_live

        MyPagerAdapter mAdapter = new MyPagerAdapter(list);
        biliViewPage.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(biliViewPage);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        getData();
        return root;

    }

    private void initBanner(){
        mBannerViewPager = mLiveView.findViewById(R.id.turn_banner);
        ArrayList<View> bannerList = new ArrayList<>();
//        bannerList.add(getLayoutInflater().inflate(R.layout.xxx,null,false));

    }

    private String getData(){
        String liveList = BiliBiliData.getLiveList();
        Gson gson = new Gson();
        LiveDataModel reTest = gson.fromJson(liveList, LiveDataModel.class);
        reTest.getStyle_list();//
        return liveList;
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
