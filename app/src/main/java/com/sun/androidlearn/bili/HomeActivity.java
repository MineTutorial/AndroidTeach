package com.sun.androidlearn.bili;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sun.androidlearn.R;
import com.sun.androidlearn.ui.day02.ViewPagerActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ConstraintLayout mConstraintLayout;
    ConstraintLayout mBibiConstrainLayout;
    ViewPagerActivity.MyPagerAdapter myPagerAdapter;
    ImageView imageOne, imageTwo, imageThree, imageFour;
    TextView textOne, textTwo, textThree, textFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        mBibiConstrainLayout =findViewById(R.id.layout_bottom);
        ArrayList<View> aList = new ArrayList<>();
//        LayoutInflater li = getLayoutInflater();
//        aList.add(li.inflate(R.layout.pager_view_one,null,false));
//        aList.add(li.inflate(R.layout.pager_view_one,null,false));
//        aList.add(li.inflate(R.layout.pager_view_one,null,false));
//        myPagerAdapter = new ViewPagerActivity.MyPagerAdapter();

//        mBibiViewPager.setAdapter(myPagerAdapter);//绑定



        imageOne = findViewById(R.id.page_one);
        imageTwo = findViewById(R.id.page_two);
        imageThree = findViewById(R.id.page_three);
        imageFour = findViewById(R.id.page_four);

        textOne = findViewById(R.id.bili_text_one);
        textTwo = findViewById(R.id.bili_text_two);
        textThree = findViewById(R.id.bili_text_three);
        textFour = findViewById(R.id.bili_text_four);

//        mBibiViewPager.setCurrentItem(0);
//        imageOne.setSelected(true);
//        imageTwo.setSelected(false);
//        imageThree.setSelected(false);
//        imageFour.setSelected(false);
//
        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOne.setSelected(true);
                imageTwo.setSelected(false);
                imageThree.setSelected(false);
                imageFour.setSelected(false);

                textOne.setSelected(true);
                textTwo.setSelected(false);
                textThree.setSelected(false);
                textFour.setSelected(false);
            }
        });


        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOne.setSelected(false);
                imageTwo.setSelected(true);
                imageThree.setSelected(false);
                imageFour.setSelected(false);

                textOne.setSelected(false);
                textTwo.setSelected(true);
                textThree.setSelected(false);
                textFour.setSelected(false);
            }
        });
        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOne.setSelected(false);
                imageTwo.setSelected(false);
                imageThree.setSelected(true);
                imageFour.setSelected(false);

                textOne.setSelected(false);
                textTwo.setSelected(false);
                textThree.setSelected(true);
                textFour.setSelected(false);
            }
        });

        imageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageOne.setSelected(false);
                imageTwo.setSelected(false);
                imageThree.setSelected(false);
                imageFour.setSelected(true);

                textOne.setSelected(false);
                textTwo.setSelected(false);
                textThree.setSelected(false);
                textFour.setSelected(true);
            }
        });


//        mBibiConstrainLayout.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//            switch (i){
//                case 0:
//                    imageOne.setSelected(true);
//                    imageTwo.setSelected(false);
//                    imageThree.setSelected(false);
//                    imageFour.setSelected(false);
//                    break;
//                case 1:
//                    imageOne.setSelected(false);
//                    imageTwo.setSelected(true);
//                    imageThree.setSelected(false);
//                    imageFour.setSelected(false);
//                    break;
//                case 2:
//                    imageOne.setSelected(false);
//                    imageTwo.setSelected(false);
//                    imageThree.setSelected(true);
//                    imageFour.setSelected(false);
//                    break;
//                case 3:
//                    imageOne.setSelected(false);
//                    imageTwo.setSelected(false);
//                    imageThree.setSelected(false);
//                    imageFour.setSelected(true);
//                    break;
//
//                }
//            }
//            //
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
    }
}
