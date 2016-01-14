package com.duanlei.guolindemo.listviewTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.duanlei.guolindemo.R;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class FlexibleListViewTest extends Activity {

    private FlexibleListView mFlexibleListView;
    private String[] data = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexible_listview);
        for (int i = 0; i < 30; i++) {
            data[i] = "" + i;
        }
        mFlexibleListView = (FlexibleListView) findViewById(R.id.flexible_listView);
        mFlexibleListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data));
    }
}
