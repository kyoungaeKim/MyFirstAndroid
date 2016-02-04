package com.kka.myfirstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //부모한테 가져온거고 밑은 추가로 할꺼
        //화면에 레이아웃 표시 -  부모가 준거
        // R 이 res 폴더 가리킴
        setContentView(R.layout.item_button);
    }

    // item_button.xml에 연결됨
    public void onClick(View view) {
        Log.d(TAG, "클릭 잘 됨");
    }
}
