package com.duanlei.guolindemo.listviewTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.duanlei.guolindemo.R;

import java.util.ArrayList;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class ListViewTestActivity extends Activity {

    private ListView mListView;

    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_test);

        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add(String.valueOf(i));
        }

        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ViewHolderAdapter(mData, getLayoutInflater()));

        mListView.setEmptyView(findViewById(R.id.empty_view));

    }



}
