package com.sun.androidlearn.ui.day04;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.sun.androidlearn.R;
import com.sun.androidlearn.ui.day02.ViewPagerActivity;

import java.util.ArrayList;

public class GuidanceActivity extends AppCompatActivity {
    ViewPager mViewPager;
    ViewPagerActivity.MyPagerAdapter myPagerAdapter;
    View pointOne, pointTwo, pointThree;

    /**
     * 用RecycleView实现点。做一个 banner 控件。6个点
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance);

        mViewPager = findViewById(R.id.pager);
        ArrayList<View> aList = new ArrayList<>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.pager_view_one, null, false));
        aList.add(li.inflate(R.layout.pager_view_two, null, false));
        aList.add(li.inflate(R.layout.pager_view_three, null, false));
        myPagerAdapter = new ViewPagerActivity.MyPagerAdapter(aList);
        mViewPager.setAdapter(myPagerAdapter);



        pointOne = findViewById(R.id.point_one);
        pointTwo = findViewById(R.id.point_two);
        pointThree = findViewById(R.id.point_three);

        mViewPager.setCurrentItem(0);
        pointOne.setSelected(true);
        pointTwo.setSelected(false);
        pointThree.setSelected(false);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //i position
                switch (i) {
                    case 0:
                        pointOne.setSelected(true);
                        pointTwo.setSelected(false);
                        pointThree.setSelected(false);
                        break;
                    case 1:
                        pointOne.setSelected(false);
                        pointTwo.setSelected(true);
                        pointThree.setSelected(false);
                        break;
                    case 2:
                        pointOne.setSelected(false);
                        pointTwo.setSelected(false);
                        pointThree.setSelected(true);
                        break;
                    default:
//                        pointOne.setSelected(true);
//                        pointTwo.setSelected(false);
//                        pointThree.setSelected(false);
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


}
