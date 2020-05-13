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
    Fragment biFragment;

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



        biFragment();
        biFragmentChange();
        }


    private void biFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        biFragment = new BiFragment();
        fragmentTransaction.add(R.id.layout_middle, biFragment);
        fragmentTransaction.commit();
    }
    private void biFragmentChange(){
        ImageView imageViewOne = findViewById(R.id.page_one);
        ImageView imageViewTwo = findViewById(R.id.page_two);
        ImageView imageViewThree = findViewById(R.id.page_three);
        ImageView imageViewFour = findViewById(R.id.page_four);

        imageViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biFragment();
            }
        });

        imageViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BiFragmentTwo biFragmentTwo = new BiFragmentTwo();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_middle,biFragmentTwo);
                transaction.commit();
            }
        });

        imageViewThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BiFragmentThree biFragmentThree = new BiFragmentThree();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_middle,biFragmentThree);
                transaction.commit();
            }
        });

        imageViewFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BiFragmentFour biFragmentFour = new BiFragmentFour();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_middle,biFragmentFour);
                transaction.commit();
            }
        });
    }


}
