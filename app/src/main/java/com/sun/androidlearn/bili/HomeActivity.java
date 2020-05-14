package com.sun.androidlearn.bili;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sun.androidlearn.R;
import com.sun.androidlearn.ui.day01.TestFragment;
import com.sun.androidlearn.ui.day02.ViewPagerActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ConstraintLayout mBibiConstrainLayout;
    ImageView imageOne, imageTwo, imageThree, imageFour;
    TextView textOne, textTwo, textThree, textFour;
    BiFragment biFragmentOne;
    BiFragmentTwo biFragmentTwo;
    BiFragmentThree biFragmentThree;
    BiFragmentFour biFragmentFour;
//    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageOne = findViewById(R.id.page_one);
        imageTwo = findViewById(R.id.page_two);
        imageThree = findViewById(R.id.page_three);
        imageFour = findViewById(R.id.page_four);

        textOne = findViewById(R.id.bili_text_one);
        textTwo = findViewById(R.id.bili_text_two);
        textThree = findViewById(R.id.bili_text_three);
        textFour = findViewById(R.id.bili_text_four);
        mBibiConstrainLayout = findViewById(R.id.layout_middle);

        biFragmentOne = new BiFragment();
        biFragmentTwo = new BiFragmentTwo();
        biFragmentThree = new BiFragmentThree();
        biFragmentFour = new BiFragmentFour();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.layout_middle, biFragmentOne);
        fragmentTransaction.add(R.id.layout_middle, biFragmentTwo);
        fragmentTransaction.add(R.id.layout_middle, biFragmentThree);
        fragmentTransaction.add(R.id.layout_middle, biFragmentFour);

        fragmentTransaction.show(biFragmentOne);
        fragmentTransaction.hide(biFragmentTwo);
        fragmentTransaction.hide(biFragmentThree);
        fragmentTransaction.hide(biFragmentFour);//初始化
        fragmentTransaction.commit();

        imageOne.setSelected(true);
        imageTwo.setSelected(false);
        imageThree.setSelected(false);
        imageFour.setSelected(false);

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

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.show(biFragmentOne);
                fragmentTransaction.hide(biFragmentTwo);
                fragmentTransaction.hide(biFragmentThree);
                fragmentTransaction.hide(biFragmentFour);
                fragmentTransaction.commit();
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

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(biFragmentOne);
                fragmentTransaction.show(biFragmentTwo);
                fragmentTransaction.hide(biFragmentThree);
                fragmentTransaction.hide(biFragmentFour);
                fragmentTransaction.commit();
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

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(biFragmentOne);
                fragmentTransaction.hide(biFragmentTwo);
                fragmentTransaction.show(biFragmentThree);
                fragmentTransaction.hide(biFragmentFour);
                fragmentTransaction.commit();
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

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.hide(biFragmentOne);
                fragmentTransaction.hide(biFragmentTwo);
                fragmentTransaction.hide(biFragmentThree);
                fragmentTransaction.show(biFragmentFour);
                fragmentTransaction.commit();
            }
        });


    }
}
