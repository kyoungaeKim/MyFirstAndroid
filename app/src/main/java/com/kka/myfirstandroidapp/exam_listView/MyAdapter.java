package com.kka.myfirstandroidapp.exam_listView;

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
 * Created by user on 2016-02-17.
 */
public class MyAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<MyItem> mData;
    private final LayoutInflater minflater;

    public MyAdapter(Context context, List<MyItem> data) {
        mContext = context;
        mData = data;
        minflater = LayoutInflater.from(mContext);

    }


    //getCount 아이템의 갯수를 지정
    @Override
    public int getCount() {
        return mData.size();
    }

    //겟 아이템은 포지션에 있는 아이템을 리턴
    @Override
    public Object getItem(int position) {

        return mData.get(position);
    }

    // 포지션번째 아이템의 아이디 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    //아이템 한개의 뷰를 완성하는 곳
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
        if (convertView == null) {
            //최초 로드할때
//            holder = new ViewHolder();
            //레이아웃을 가져오게 하는 객체
            convertView = minflater.inflate(R.layout.item_list, parent, false); //파인드뷰와 같은 역활 레이아웃을 들고와서 여기 붙인거
            //액티비티가 아닌곳에서는 항상 이렇게 붙여야한다.

        //데이터를 연결할 뷰
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.text1);

//        holder.imageView = imageView;
//        holder.title = title;
//        holder.description = description;
//
//        convertView.setTag(holder);
    }else {
//            holder =  convertView.getTag();
        }
        // 데이터
        MyItem item = (MyItem) getItem(position);

        // 데이터 설정
//        holder.imageView.setImageResource(item.getImageRes());
//        title.setText(item.getTitle());
//        description.setText(item.getDescription());

        return convertView;


//    private static class ViewHolder {
//        //내부클래스는 무조건 static으로 설정한다
//        ImageView imageView;
//        TextView title;
//        TextView description;

    }
}
