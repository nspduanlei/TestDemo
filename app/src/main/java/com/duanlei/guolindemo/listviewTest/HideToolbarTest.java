package com.duanlei.guolindemo.listviewTest;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.duanlei.guolindemo.R;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class HideToolbarTest extends AppCompatActivity {

    private String[] data = new String[300];
    private Toolbar mToolbar;

    @SuppressLint("PrivateResource")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_toolbar);

        //使用ToolBar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(mToolbar);


        for (int i = 0; i < data.length; i++) {
            data[i] = "" + i;
        }
        ListView listView = (ListView) findViewById(R.id.listView_1);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data));

        listView.setOnTouchListener(myTouchLister);

        //系统认为的最低滑动距离
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();

        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.abc_action_bar_default_height_material)
        ));
        listView.addHeaderView(header);

    }


    //private float mFirstY;
    private float mCurrentY;
    private int mTouchSlop;
    private boolean mShow;
    private int direction;


    View.OnTouchListener myTouchLister = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:

                    Log.d("test01", "event.getY() : " + event.getY());

                    if (event.getY() - mCurrentY > mTouchSlop) {//下滑

                        Log.d("test01", "下滑--------");

                        direction = 1;
                    } else if (mCurrentY - event.getY() > mTouchSlop) {

                        Log.d("test01", "上滑--------");

                        direction = 0;
                    }

                    mCurrentY = event.getY();

                    if (direction == 1) {
                        toolbarAnim(0);
                    } else {
                        toolbarAnim(1);
                    }

                    break;

                case MotionEvent.ACTION_UP:
                    break;
            }

            return false;
        }
    };

    private ObjectAnimator mAnimator;

    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }

        if (flag == 0) { //显示
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(), 0);
        } else { //隐藏
            mAnimator = ObjectAnimator.ofFloat(mToolbar,
                    "translationY", mToolbar.getTranslationY(), -mToolbar.getHeight());
        }
        mAnimator.start();
    }


}
