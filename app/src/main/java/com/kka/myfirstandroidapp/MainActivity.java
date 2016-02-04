package com.kka.myfirstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //부모한테 가져온거고 밑은 추가로 할꺼
        //화면에 레이아웃 표시 -  부모가 준거
        // R 이 res 폴더 가리킴
        setContentView(R.layout.item_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "클릭 완전 잘 됨", Toast.LENGTH_SHORT).show();
            }
        };

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(listener);
    }

    // item_button.xml에 연결됨
    public void onClick(View view) {
        Log.d(TAG, "클릭 잘 됨");
        Toast.makeText(MainActivity.this, "클릭 잘 됨", Toast.LENGTH_SHORT).show();
    }
}
