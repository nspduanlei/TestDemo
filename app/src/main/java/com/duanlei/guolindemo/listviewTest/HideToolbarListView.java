package com.duanlei.guolindemo.listviewTest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class HideToolbarListView extends ListView {
    public HideToolbarListView(Context context) {
        this(context, null);
    }

    public HideToolbarListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HideToolbarListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
