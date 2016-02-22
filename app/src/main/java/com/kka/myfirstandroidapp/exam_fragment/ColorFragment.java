package com.kka.myfirstandroidapp.exam_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kka.myfirstandroidapp.R;

public class ColorFragment extends Fragment {


    private ImageView imageView;

    public ColorFragment() {
        // Required empty public constructor
    }

    public static ColorFragment newInstance() {
        ColorFragment fragment = new ColorFragment();
        return fragment;
        //생성자 역할
    }

    @Override //뷰를 만드는 부분
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
        //특정레이아웃 불러오기
    }//위에 뷰가 밑에 뷰크리에이트의 뷰에 들어간다

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState); //얘를 쓰면 여기서 색을 바꾸면 된다
        imageView = (ImageView) view.findViewById(R.id.color_image);

    }

    public void setColor (int color) {
        imageView.setBackgroundColor(color);
    }
}
