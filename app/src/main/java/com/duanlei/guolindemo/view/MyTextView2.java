package com.duanlei.guolindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author: duanlei
 * Date: 2015-12-25
 */
public class MyTextView2 extends TextView {

    public MyTextView2(Context context) {
        this(context, null);
    }

    public MyTextView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();

            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0,
                        new int[] {
                                Color.BLUE, 0xffffffff, Color.BLUE
                        }, null, Shader.TileMode.CLAMP);

                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    private int mTranslate;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth/5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }

            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}
