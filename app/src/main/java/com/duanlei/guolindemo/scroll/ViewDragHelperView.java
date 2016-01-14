package com.duanlei.guolindemo.scroll;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class ViewDragHelperView extends ViewGroup {

    public ViewDragHelperView(Context context) {
        this(context, null);
    }

    public ViewDragHelperView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDragHelperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private ViewDragHelper mViewDragHelper;

    private View mMainView;
    private View mMenuView;

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, callback);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }


    //何时开始检测触摸事件
    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {

            //如果当前触摸的child是mMainView是开始检测

            return mMainView == child;
        }
    };



}
