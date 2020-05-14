package com.sun.androidlearn.bili;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sun.androidlearn.R;

public class HomeActivity extends AppCompatActivity {

    ConstraintLayout mBibiConstrainLayout;
    ImageView mImageOne, mImageTwo, mImageThree, mImageFour;
    TextView mTextOne, mTextTwo, mTextThree, mTextFour;
    BiFragment mBiFragmentOne;
    BiFragmentTwo mBiFragmentTwo;
    BiFragmentThree mBiFragmentThree;
    BiFragmentFour mBiFragmentFour;
//    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        view();//所以view
        initFragment();//初始化

        mImageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragmentOne();

            }
        });


        mImageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragmentTwo();

            }
        });
        mImageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragmentThere();
            }
        });

        mImageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragmentFour();

            }
        });

    }

    private void initFragment() {
        mBiFragmentOne = new BiFragment();
        mBiFragmentTwo = new BiFragmentTwo();
        mBiFragmentThree = new BiFragmentThree();
        mBiFragmentFour = new BiFragmentFour();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.layout_middle, mBiFragmentOne);
        fragmentTransaction.add(R.id.layout_middle, mBiFragmentTwo);
        fragmentTransaction.add(R.id.layout_middle, mBiFragmentThree);
        fragmentTransaction.add(R.id.layout_middle, mBiFragmentFour);

        fragmentTransaction.show(mBiFragmentOne);
        fragmentTransaction.hide(mBiFragmentTwo);
        fragmentTransaction.hide(mBiFragmentThree);
        fragmentTransaction.hide(mBiFragmentFour);//初始化
        fragmentTransaction.commit();

        mImageOne.setSelected(true);
        mImageTwo.setSelected(false);
        mImageThree.setSelected(false);
        mImageFour.setSelected(false);

    }

    private void view() {
        mImageOne = findViewById(R.id.page_one);
        mImageTwo = findViewById(R.id.page_two);
        mImageThree = findViewById(R.id.page_three);
        mImageFour = findViewById(R.id.page_four);

        mTextOne = findViewById(R.id.bili_text_one);
        mTextTwo = findViewById(R.id.bili_text_two);
        mTextThree = findViewById(R.id.bili_text_three);
        mTextFour = findViewById(R.id.bili_text_four);
        mBibiConstrainLayout = findViewById(R.id.layout_middle);

    }

    private void selectFragmentOne() {


        mImageOne.setSelected(true);
        mImageTwo.setSelected(false);
        mImageThree.setSelected(false);
        mImageFour.setSelected(false);

        mTextOne.setSelected(true);
        mTextTwo.setSelected(false);
        mTextThree.setSelected(false);
        mTextFour.setSelected(false);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(mBiFragmentOne);
        fragmentTransaction.hide(mBiFragmentTwo);
        fragmentTransaction.hide(mBiFragmentThree);
        fragmentTransaction.hide(mBiFragmentFour);
        fragmentTransaction.commit();
    }

    private void selectFragmentTwo() {

        mImageOne.setSelected(false);
        mImageTwo.setSelected(true);
        mImageThree.setSelected(false);
        mImageFour.setSelected(false);

        mTextOne.setSelected(false);
        mTextTwo.setSelected(true);
        mTextThree.setSelected(false);
        mTextFour.setSelected(false);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(mBiFragmentOne);
        fragmentTransaction.show(mBiFragmentTwo);
        fragmentTransaction.hide(mBiFragmentThree);
        fragmentTransaction.hide(mBiFragmentFour);
        fragmentTransaction.commit();
    }

    private void selectFragmentThere() {

        mImageOne.setSelected(false);
        mImageTwo.setSelected(false);
        mImageThree.setSelected(true);
        mImageFour.setSelected(false);

        mTextOne.setSelected(false);
        mTextTwo.setSelected(false);
        mTextThree.setSelected(true);
        mTextFour.setSelected(false);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(mBiFragmentOne);
        fragmentTransaction.hide(mBiFragmentTwo);
        fragmentTransaction.show(mBiFragmentThree);
        fragmentTransaction.hide(mBiFragmentFour);
        fragmentTransaction.commit();
    }

    private void selectFragmentFour() {
        mImageOne.setSelected(false);
        mImageTwo.setSelected(false);
        mImageThree.setSelected(false);
        mImageFour.setSelected(true);

        mTextOne.setSelected(false);
        mTextTwo.setSelected(false);
        mTextThree.setSelected(false);
        mTextFour.setSelected(true);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(mBiFragmentOne);
        fragmentTransaction.hide(mBiFragmentTwo);
        fragmentTransaction.hide(mBiFragmentThree);
        fragmentTransaction.show(mBiFragmentFour);
        fragmentTransaction.commit();
    }
}
