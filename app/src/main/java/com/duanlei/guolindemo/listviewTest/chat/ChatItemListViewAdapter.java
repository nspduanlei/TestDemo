package com.duanlei.guolindemo.listviewTest.chat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.duanlei.guolindemo.R;

import java.util.List;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class ChatItemListViewAdapter extends BaseAdapter {

    private List<ChatItemListViewBean> mData;
    private LayoutInflater mInflater;

    public ChatItemListViewAdapter(List<ChatItemListViewBean> data,
                                   LayoutInflater inflater) {
        mData = data;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        ChatItemListViewBean bean = mData.get(position);

        Log.d("test02", "bean.getType() : " + bean.getType());

        return bean.getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {

            Log.d("test02", "position : " + position);

            if (getItemViewType(position) == 0) {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.chat_item_left, null);
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon_left);
                viewHolder.text = (TextView) convertView.findViewById(R.id.tv_left);
            } else {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.chat_item_right, null);
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon_right);
                viewHolder.text = (TextView) convertView.findViewById(R.id.tv_right);
            }

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.text.setText(mData.get(position).getText());

        return convertView;
    }

    public final class ViewHolder {
        public ImageView icon;
        public TextView text;
    }
}
