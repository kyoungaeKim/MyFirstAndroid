package com.kka.myfirstandroidapp.baseAdapter_prac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kka.myfirstandroidapp.R;

import java.util.List;

/**
 * Created by user on 2016-02-19.
 */
public class Adapter_2 extends BaseAdapter {

    private Context context;
    private List<item_2> data;
    private LayoutInflater inflater;

    public Adapter_2(Context context, List<item_2> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.item_list_2,parent,false);

            ImageView imageView= (ImageView) convertView.findViewById(R.id.imageview);
            TextView title= (TextView) convertView.findViewById(R.id.title11);
            TextView text= (TextView) convertView.findViewById(R.id.text11);

            holder.imageView = imageView;
            holder.title = title;
            holder.text = text;

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        //데이터 설정
        item_2 item = (item_2) getItem(position);

        holder.imageView.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        holder.text.setText(item.getText());
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView title;
        TextView text;

    }
}
