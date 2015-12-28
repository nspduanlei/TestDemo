package com.duanlei.guolindemo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.duanlei.guolindemo.R;

/**
 * Author: duanlei
 * Date: 2015-12-28
 */
public class TopBar extends RelativeLayout {

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    private int mTitleTextColor;
    private float mTitleSize;
    private String mTitle;

    private TopbarClickLister mListener;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //通过这个方法，将你在atts.xml 中定义的 declare-styleable
        //的所有属性的值存储在TypedArray中

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        //从TypedArray中取出对应的值来为要设置的属性赋值

        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);

        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);

        mTitleTextColor = ta.getColor(R.styleable.TopBar_myTitleTextColor, 0);
        mTitleSize = ta.getDimension(R.styleable.TopBar_myTitleTextSize, 10);
        mTitle = ta.getString(R.styleable.TopBar_myTitle);

        //获取完TypedArray的值后，一般要调用recyle方法来避免重新创建的时候的错误
        ta.recycle();

        init();
    }

    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleView;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void init() {
        mLeftButton = new Button(getContext());
        mRightButton = new Button(getContext());
        mTitleView = new TextView(getContext());


        //为创建的组件元素赋值
        //值就来源于我们在引用的xml文件中给对应属性的赋值

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleSize);
        mTitleView.setGravity(Gravity.CENTER);

        //为组件元素设置相应的布局元素
        final LayoutParams mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //添加到ViewGroup
        addView(mLeftButton, mLeftParams);

        LayoutParams mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        //添加到ViewGroup
        addView(mRightButton, mRightParams);

        LayoutParams mTitleParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        //添加到ViewGroup
        addView(mTitleView, mTitleParams);

        //点击事件监听
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });
    }

    //接口对象，实现回调机制，在回调方法中
    //通过映射的接口对象调用接口中的方法
    //而不用去考虑如何实现，具体实现由调用者去创建

    public interface TopbarClickLister {
        void leftClick();
        void rightClick();
    }

    //暴露一个方法给调用者注册接口回调
    //通过接口来获取回调者对接口方法的实现
    public void setOnTopbarClickListener(TopbarClickLister mListener) {
        this.mListener = mListener;
    }

    /**
     * 设置按钮的显示与否
     * @param id 区分按钮 0 左边按钮， 非零 右边按钮
     * @param flag 是否显示
     */
    public void setButtonVisable(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftButton.setVisibility(View.VISIBLE);
            } else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftButton.setVisibility(View.GONE);
            } else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }


}
