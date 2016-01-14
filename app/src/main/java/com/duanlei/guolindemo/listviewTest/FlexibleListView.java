package com.duanlei.guolindemo.listviewTest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ListView;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class FlexibleListView extends ListView {

    public FlexibleListView(Context context) {
        this(context, null);
    }

    public FlexibleListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlexibleListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private int mMaxOverDistance = 50;

    private void initView() {
        mMaxOverDistance = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                mMaxOverDistance, getResources().getDisplayMetrics());
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY,
                                   int scrollX, int scrollY,
                                   int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY,
                                   boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX,
                scrollY, scrollRangeX, scrollRangeY,
                maxOverScrollX, mMaxOverDistance, isTouchEvent);
    }
}


