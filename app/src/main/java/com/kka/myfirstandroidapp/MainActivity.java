package com.kka.myfirstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //부모한테 가져온거고 밑은 추가로 할꺼
        //화면에 레이아웃 표시 -  부모가 준거
        // R 이 res 폴더 가리킴
        setContentView(R.layout.check);
        mTextView = (TextView) findViewById(R.id.msg_text_view);
        ((CheckBox) findViewById(R.id.check_box)).setOnCheckedChangeListener(this);


//        Button button2 = (Button) findViewById(R.id.button2);
//        Button button1 = (Button) findViewById(R.id.button1);
//        findViewById(R.id.button1).setOnClickListener(this);
//        findViewById(R.id.button2).setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button1.setOnClickListener(this);


//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "클릭 완전 잘 됨", Toast.LENGTH_SHORT).show();
//            }
//        });
//

//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "클릭 완전 잘 됨", Toast.LENGTH_SHORT).show();
//            }
//        };

//        Button button2 = (Button) findViewById(R.id.button2);
//        button2.setOnClickListener(listener);
    }

    // item_button.xml에 연결됨
    public void onClick(View v) {
//        //view v 는 다형성으로 버튼 받은거
//        switch (v.getId()) {
//            case R.id.button1:
//                Toast.makeText(MainActivity.this, "첫번째 버튼", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button2:
//                Toast.makeText(MainActivity.this, "두우번째 버튼", Toast.LENGTH_SHORT).show();
//                break;
//        }
    }

    //체크박스가 들어옴
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(MainActivity.this, "check : isChecked", Toast.LENGTH_SHORT).show();
        if (isChecked) {
            mTextView.setVisibility(View.VISIBLE);
        } else {
            mTextView.setVisibility(View.INVISIBLE);
        }

    }
}
