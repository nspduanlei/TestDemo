package com.duanlei.guolindemo.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class DragView extends View {

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
    }

    private Scroller mScroller;
    private int lastX;
    private int lastY;



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点位置

                lastX = rawX;
                lastY = rawY;


                break;

            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;

                //在当前left,top,right,bottom 的基础上加上偏移量

//                layout(
//                        getLeft() + offsetX,
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY
//                );

//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

                ((View)getParent()).scrollBy(-offsetX, -offsetY);

                //重新设置初始坐标
                lastX = rawX;
                lastY = rawY;

                break;

            case MotionEvent.ACTION_UP:

                View viewGroup = (View) getParent();
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY()
                );
                invalidate();

                break;
        }

        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        //判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());

            //通过重绘来不断调用computeScroll
            invalidate();
        }
    }
}
