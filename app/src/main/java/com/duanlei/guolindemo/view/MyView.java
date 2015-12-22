package com.duanlei.guolindemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: duanlei
 * Date: 2015-12-22
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //View类默认的onMeasure方法只支持EXACTLY模式
        //所以如果在自定义控件的时候不重写onMeasure方法的话，就只能使用EXACTLY模式
        //而如果要让自定义的View支持wrap_content属性，那么就必须重写onMeasure方法
        //来指定warp_content的大小

        //通过MeasureSpec这个类，我们就获取了View的测量模式和View想要绘制的大小。
        //有了这些信息，我们就可以控制View最后显示的大小

        setMeasuredDimension(
                measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec)
        );


    }

    private int measureHeight(int heightMeasureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;

            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;

            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
