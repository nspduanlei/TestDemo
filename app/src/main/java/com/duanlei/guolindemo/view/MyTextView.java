package com.duanlei.guolindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author: duanlei
 * Date: 2015-12-22
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint1;
    private Paint mPaint2;

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制外层矩形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
        //绘制内层矩形
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);

        canvas.save();

        //绘制文字前平移10px
        canvas.translate(10, 0);

        //父类完成的方法，即绘制文本
        super.onDraw(canvas);

        canvas.restore();
    }
}
