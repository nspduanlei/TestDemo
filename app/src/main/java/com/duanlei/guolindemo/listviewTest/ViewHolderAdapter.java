package com.duanlei.guolindemo.listviewTest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.duanlei.guolindemo.R;

import java.util.ArrayList;

/**
 * Author: duanlei
 * Date: 2016-01-14
 */
public class ViewHolderAdapter extends BaseAdapter {

    private ArrayList<String> mData;
    private LayoutInflater mInflater;

    public ViewHolderAdapter(ArrayList<String> datas, LayoutInflater inflater) {
        mData = datas;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        //判断是否缓存
        if (convertView == null) {
            holder = new ViewHolder();
            //通过LayoutInflater实例化布局
            convertView = mInflater.inflate(R.layout.viewholder_item, null);

            holder.img = (ImageView) convertView.findViewById(R.id.imageView);
            holder.title = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(holder);

        } else {
            //通过tag找到缓存的布局
            holder = (ViewHolder) convertView.getTag();
        }

        //设置布局中控件的显示的视图

        holder.img.setImageResource(R.mipmap.ic_launcher);
        holder.title.setText(mData.get(position));

        return convertView;
    }

    public final class ViewHolder {
        public ImageView img;
        public TextView title;
    }

}
