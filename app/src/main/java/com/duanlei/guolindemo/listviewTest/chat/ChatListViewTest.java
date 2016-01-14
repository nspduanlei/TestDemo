package com.duanlei.guolindemo.listviewTest.chat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.duanlei.guolindemo.R;

import java.util.ArrayList;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class ChatListViewTest extends Activity {

    private ArrayList<ChatItemListViewBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_listview);

        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            if (i % 5 == 0) {
                mData.add(new ChatItemListViewBean(1, "faffafaf===", null));
            } else {
                mData.add(new ChatItemListViewBean(0, "faffafaf", null));
            }


        }


        ListView listView = (ListView) findViewById(R.id.lv_chat);
        listView.setAdapter(new ChatItemListViewAdapter(mData, getLayoutInflater()));

    }

}
