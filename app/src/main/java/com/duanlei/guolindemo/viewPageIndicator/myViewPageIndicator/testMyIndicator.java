package com.duanlei.guolindemo.viewPageIndicator.myViewPageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.duanlei.guolindemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duanlei on 2016/4/7.
 */
public class testMyIndicator extends FragmentActivity {

    private ViewPagerIndicator mIndicator;
    private ViewPager mViewPager;
    private List<String> titles = Arrays.asList("短信1", "收藏2", "推荐3", "短信4",
            "收藏5", "推荐6", "短信7", "收藏8", "推荐9");
    private List<VpSimpleFragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_my_indicator);

        initView();
        initData();

        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager, 0, titles, 5);
    }

    private void initData() {
        for (String title : titles) {
            fragments.add(VpSimpleFragment.newInstance(title));
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return titles.size();
            }
        };
    }

    private void initView() {
        mIndicator = (ViewPagerIndicator) findViewById(R.id.vp_indicator);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }
}
