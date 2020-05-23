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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sun.androidlearn.R;
import com.sun.androidlearn.bili.view.LiveViewGroup;
import com.sun.androidlearn.data.BiliBiliData;
import com.sun.androidlearn.data.LiveDataModel;

import java.util.ArrayList;
import java.util.List;

public class BiFragment extends Fragment {

    /**
     * 作业1：引导。10个小圈。
     * 数据model: live_list,follow_list,radio_list
     *
     * 作业2：mRecommendView，mFireView，改成自定义View
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
//        mLiveView = inflater.inflate(R.layout.pager_live, null, false);
        mLiveView = new LiveViewGroup(getContext());
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
        initBanner();
        return root;

    }

    private void initBanner(){
//        mBannerViewPager = mLiveView.findViewById(R.id.turn_banner);
//        ArrayList<View> bannerList = new ArrayList<>();
//        bannerList.add(getLayoutInflater().inflate(R.layout.banner_one,null,false));
//
//        LiveDataModel data = getData();
//        List<LiveDataModel.StyleData.StyleList> list = data.getStyle_list().getList();

    }

    private LiveDataModel getData(){
        String liveList = BiliBiliData.getLiveList();
        Gson gson = new Gson();
        LiveDataModel reTest = gson.fromJson(liveList, LiveDataModel.class);
        reTest.getStyle_list();//
        return reTest;
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
            View root = viewLists.get(position);
            container.addView(root);
//           ImageView imae =   root.findViewById(R.id.image);
//            TextView textView = find
//          Model =   tabList.get(position);
//            textView.setText("");

            return root;
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
