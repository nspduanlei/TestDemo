package com.duanlei.guolindemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.duanlei.guolindemo.utils.ScreenUtils;

/**
 * Author: duanlei
 * Date: 2016-01-12
 */
public class MyProgress extends View {

    private Context mContext;

    public MyProgress(Context context) {
        this(context, null);
    }

    public MyProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    //屏幕宽度
    private int length;
    //控件宽度
    private int mCircleXY;

    //内部圆半径
    private float mRadius;

    //绘制弧线，需要指定其椭圆的外接矩形
    private RectF mArcRectF;

    private Paint mCirclePaint;
    private Paint mArcPaint;

    //弧线角度，进度
    private float mSweepAngle = 90;

    private String mShowText = "myProgress";

    private int mShowTextSize = 60;

    private Paint mTextPaint;

    private void init() {
        length = ScreenUtils.getScreenWidth(mContext);
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);

        mArcRectF = new RectF((float)(length*0.1), (float)(length*0.1),
                (float)(length*0.9), (float)(length*0.9));

        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true); //消除锯齿
        mCirclePaint.setColor(Color.LTGRAY);

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true); //消除锯齿
        mArcPaint.setColor(Color.BLUE);
        mArcPaint.setStyle(Paint.Style.STROKE); //绘制空心圆
        mArcPaint.setStrokeWidth(60);

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.RED);
        mTextPaint.setTextSize(mShowTextSize);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制弧线
        canvas.drawArc(mArcRectF, 270, mSweepAngle, false, mArcPaint);

        //绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);

        //绘制文字
//        canvas.drawText(mShowText, 0, mShowText.length(),
//                mCircleXY, mCircleXY + (mShowTextSize / 4), mTextPaint);

        canvas.drawText(mShowText, 0, mShowText.length(),
                mCircleXY - (mShowTextSize/4)*mShowText.length(), mCircleXY + mShowTextSize/4, mTextPaint);
    }

    public void setSweepAngle(float sweepAngle) {
        if (sweepAngle != 0) {
            mSweepAngle = sweepAngle;
        } else {
            mSweepAngle = 25;
        }
        this.invalidate();
    }
}
