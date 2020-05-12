package com.sun.androidlearn.bili;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.sun.androidlearn.R;
import com.sun.androidlearn.ui.day02.ViewPagerActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ViewPager mViewPager;
    ViewPagerActivity.MyPagerAdapter myPagerAdapter;
    View imageOne, imageTwo, imageThree, imageFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        mViewPager =findViewById(R.id.layout_bottom);
        ArrayList<View> aList = new ArrayList<>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.pager_view_one,null,false));
        aList.add(li.inflate(R.layout.pager_view_one,null,false));
        aList.add(li.inflate(R.layout.pager_view_one,null,false));
        myPagerAdapter = new ViewPagerActivity.MyPagerAdapter();

        mViewPager.setAdapter(myPagerAdapter);//绑定



        imageOne = findViewById(R.id.page_one);
        imageTwo = findViewById(R.id.page_two);
        imageThree = findViewById(R.id.page_three);
        imageFour =findViewById(R.id.page_four);

        mViewPager.setCurrentItem(0);
        imageOne.setSelected(true);
        imageTwo.setSelected(false);
        imageThree.setSelected(false);
        imageFour.setSelected(false);



        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
            switch (i){
                case 0:
                    imageOne.setSelected(true);
                    imageTwo.setSelected(false);
                    imageThree.setSelected(false);
                    imageFour.setSelected(false);
                    break;
                case 1:
                    imageOne.setSelected(false);
                    imageTwo.setSelected(true);
                    imageThree.setSelected(false);
                    imageFour.setSelected(false);
                    break;
                case 2:
                    imageOne.setSelected(false);
                    imageTwo.setSelected(false);
                    imageThree.setSelected(true);
                    imageFour.setSelected(false);
                    break;
                case 3:
                    imageOne.setSelected(false);
                    imageTwo.setSelected(false);
                    imageThree.setSelected(false);
                    imageFour.setSelected(true);
                    break;

                }
            }
            //

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
