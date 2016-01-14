package com.duanlei.guolindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

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
        mPaint = new Paint();
        //mPaint.setColor(Color.BLUE);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, mRectHeight);
//    }

    private int mRectCount = 20;
    //屏幕的宽度
    private int mWidth;

    //条形的宽度
    private int mRectWidth;

    //这个控件的高度
    private int mRectHeight;

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

    private LinearGradient mLinearGradient;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = getWidth();
        mRectHeight = getHeight();

        mRectWidth = (int) (mWidth*0.6/mRectCount);
        mLinearGradient = new LinearGradient(
                0, 0, mRectWidth, mRectHeight, Color.YELLOW,
                Color.BLUE, Shader.TileMode.CLAMP
        );

        mPaint.setShader(mLinearGradient);
    }
}

