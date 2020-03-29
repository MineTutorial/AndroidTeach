package com.sun.androidlearn.ui.day02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.sun.androidlearn.R;

public class AnimActivity extends AppCompatActivity {
    TextView mView;

    /**
     * 作业：动画集合
     * 平移x: 0-500
     * alpha: 0-1  只执行1遍
     * rotation： 1圈
     *
     * 上面执行3000ms;后，最后，缩放x,y 3倍
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);


        mView = findViewById(R.id.view);
//        scale();
//        rotation();
//        translationX();
//        translationY();
//        alpha();
        animSet();
    }


    /**
     * 动画集合
     * 组合动画 AnimatorSet
     *
     */

    private void animSet(){

        ObjectAnimator rotation = ObjectAnimator.ofFloat(mView, View.ROTATION, 0,720);
        rotation.setDuration(3000);// 1000 ms =  1s
        rotation.start();

        ObjectAnimator trans = ObjectAnimator.ofFloat(mView, "translationY", 0,300f);
        trans.setDuration(1000);
        trans.start();

        ObjectAnimator alpha = ObjectAnimator.ofFloat(mView, View.ALPHA, 0,1);
        alpha.setDuration(1000);// 1000 ms =  1s
//        animation.setStartDelay(500);// 500ms = 0.5s
        alpha.setRepeatCount(ObjectAnimator.INFINITE);//无限次重复
        alpha.setRepeatMode(ObjectAnimator.REVERSE);
        alpha.start();


        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation,trans);
        set.play(alpha).after(trans);
        set.start();

     }

    /**
     * 属性动画
     * 动画都是拆分为4种
     * 平移:translation
     * 透明：alpha
     * 缩放：scale
     * 旋转：rotation
     */


    public void rotation(){
        //一圈：360度
        ObjectAnimator animationX = ObjectAnimator.ofFloat(mView, View.ROTATION, 0,720);
        animationX.setStartDelay(2000);
        animationX.setDuration(3000);// 1000 ms =  1s
        animationX.start();


    }


    public void scale(){
        ObjectAnimator animationX = ObjectAnimator.ofFloat(mView, View.SCALE_X, 0,2f);
        animationX.setDuration(1000);// 1000 ms =  1s
//        animation.setStartDelay(500);// 500ms = 0.5s
//        animation.setInterpolator(new AccelerateInterpolator());  ;//插值器
        animationX.start();

        ObjectAnimator animationY = ObjectAnimator.ofFloat(mView, View.SCALE_Y, 0,2f);
        animationY.setDuration(1000);// 1000 ms =  1s
//        animation.setStartDelay(500);// 500ms = 0.5s
//        animation.setInterpolator(new AccelerateInterpolator());  ;//插值器
        animationY.start();

    }


    public void translationX(){
        ObjectAnimator animation = ObjectAnimator.ofFloat(mView, View.TRANSLATION_X, 0,300f);
        animation.setDuration(1000);// 1000 ms =  1s
//        animation.setStartDelay(500);// 500ms = 0.5s
        animation.setRepeatCount(ObjectAnimator.INFINITE);//无限次重复
        animation.setRepeatMode(ObjectAnimator.REVERSE);
        animation.setInterpolator(new AccelerateInterpolator());  ;//插值器
        animation.start();

        animation.cancel();//停止

        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });
    }

    public void translationY(){
        ObjectAnimator animation = ObjectAnimator.ofFloat(mView, "translationY", 0,300f);
        animation.setDuration(1000);
        animation.start();
    }

    public void alpha(){
        ObjectAnimator animation = ObjectAnimator.ofFloat(mView, View.ALPHA, 0,1);
        animation.setDuration(1000);// 1000 ms =  1s
//        animation.setStartDelay(500);// 500ms = 0.5s
        animation.setRepeatCount(ObjectAnimator.INFINITE);//无限次重复
        animation.setRepeatMode(ObjectAnimator.REVERSE);
        animation.start();
    }


}
