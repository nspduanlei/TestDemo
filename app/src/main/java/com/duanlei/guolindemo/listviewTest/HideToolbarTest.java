package com.duanlei.guolindemo.listviewTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.duanlei.guolindemo.R;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class HideToolbarTest extends AppCompatActivity {

    private String[] data = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_toolbar);

        //使用ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);


        for (int i = 0; i < 30; i++) {
            data[i] = "" + i;
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data));
    }

}
