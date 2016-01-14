package com.duanlei.guolindemo.interceptTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Author: duanlei
 * Date: 2016-01-13
 */
public class TestViewGroupA extends LinearLayout {

    public TestViewGroupA(Context context) {
        super(context);
    }

    public TestViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("test", "ViewGroupA dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("test", "ViewGroupA onInterceptTouchEvent" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("test", "ViewGroupA onTouchEvent" + event.getAction());
        return super.onTouchEvent(event);
    }
}
