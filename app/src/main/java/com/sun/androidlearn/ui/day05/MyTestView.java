package com.sun.androidlearn.ui.day05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sun.androidlearn.R;

/**
 * Author: jfson sun
 * Create on:  2020/4/18
 * Question:
 * Description:
 * Train of thought: 自定义View
 */
public class MyTestView extends View {
    /**
     * 1. 直接继承 View/ViewGroup
     * 2. 自己画View: onMeasure,onLayout,onDraw
     */

    Paint paint;

    public MyTestView(Context context) {
        super(context);
        init();
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(getContext().getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(10);
    }

    /**
     * 绘制
     *
     */
    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawLine(0,0,300,0,paint);
        canvas.drawCircle(200,200,100,paint);
    }


    /**
     * 确定宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //100  ,50
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 确定位置
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


}
