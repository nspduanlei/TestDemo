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
public class TestViewGroupB extends LinearLayout {

    public TestViewGroupB(Context context) {
        super(context);
    }

    public TestViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("test", "ViewGroupB dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("test", "ViewGroupB onInterceptTouchEvent" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("test", "ViewGroupB onTouchEvent" + event.getAction());
        return super.onTouchEvent(event);
    }
}
