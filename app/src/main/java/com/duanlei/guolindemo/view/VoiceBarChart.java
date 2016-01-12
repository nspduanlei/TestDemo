package com.duanlei.guolindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.duanlei.guolindemo.utils.ScreenUtils;

/**
 * Author: duanlei
 * Date: 2016-01-12
 */
public class VoiceBarChart extends View {
    public VoiceBarChart(Context context) {
        this(context, null);
    }

    public VoiceBarChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VoiceBarChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private Context mContext;

    private void init() {
        mWidth =-ScreenUtils.getScreenWidth(mContext);
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, mRectHeight);
//    }

    private int mRectCount = 10;
    //屏幕的宽度
    private int mWidth;

    //条形的宽度
    private int mRectWidth = 40;

    //这个控件的高度
    private int mRectHeight = 200;

    private int offset = 10;

    private Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < mRectCount; i++) {

            float currentHeight = (float) (mRectHeight * Math.random());

            canvas.drawRect(
                    (float)(mWidth*0.2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth*0.2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint
            );
        }
    }
}
