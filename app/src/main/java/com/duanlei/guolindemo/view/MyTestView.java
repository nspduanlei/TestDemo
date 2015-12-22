package com.duanlei.guolindemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author: duanlei
 * Date: 2015-12-22
 */
public class MyTestView extends TextView {
    public MyTestView(Context context) {
        this(context, null);
    }

    public MyTestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
   private void init() {


    }
}
