package com.sun.androidlearn.ui.day02;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import com.sun.androidlearn.R;

import java.util.concurrent.Delayed;

public class AnimActivity_myone extends AppCompatActivity {
    TextView mViewMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_myone);

        mViewMy = findViewById(R.id.view_my);
////        translationX();
////        translationY();
////        alpha();
//          scale();
//          rotation();
        animSet();
    }

    /**
     * 动画集合
     * 组合动画
     */

    private void animSet(){
        ObjectAnimator rotation = ObjectAnimator.ofFloat(mViewMy, View.ROTATION, 0,720);
        rotation.setDuration(3000);
        rotation.start();

        ObjectAnimator trans = ObjectAnimator.ofFloat(mViewMy,"translationY",0,300f);
        trans.setDuration(3000);
        trans.start();

        ObjectAnimator alpha = ObjectAnimator.ofFloat(mViewMy,View.ALPHA,0,1);
        alpha.setRepeatMode(ObjectAnimator.REVERSE);
        alpha.setRepeatCount(ObjectAnimator.INFINITE);
        alpha.start();
    }

    //my动画，属性动画。。动画拆分4中
    //平移
    //透明
    //缩放
    //旋转

    public void rotation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mViewMy,View.ROTATION, 0,720);
        animator.setStartDelay(2000);
        animator.setDuration(3000);
        animator.start();
    }

    public void scale(){
        ObjectAnimator animationX = ObjectAnimator.ofFloat(mViewMy, View.SCALE_X,0,5F);//缩放
        animationX.setDuration(1000);
        animationX.start();

        ObjectAnimator animationY = ObjectAnimator.ofFloat(mViewMy, View.SCALE_Y, 0,2f);
        animationY.setDuration(1000);
        animationY.start();
    }


    public void  translationX(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mViewMy, "translationX", 300f);//300f,为像素（距离）
        animator.setDuration(1000);//移动时长1m
//        animator.setStartDelay(500);//延迟
        animator.setInterpolator(new AccelerateInterpolator());//插值器
        animator.setRepeatCount(ObjectAnimator.INFINITE);//重复次数，这个是无线，可调几次
        animator.setRepeatMode(ObjectAnimator.RESTART);//重复模式，，REVERSE重复是来回
        animator.start();

        animator.cancel();//停止
        animator.addListener(new AnimatorListenerAdapter() {
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
        ObjectAnimator animator = ObjectAnimator.ofFloat(mViewMy, "translationY", 300f);
        animator.setDuration(1000);
        animator.start();
    }

    public void alpha(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mViewMy, View.ALPHA,0,1);//透明0-1单位
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

}
