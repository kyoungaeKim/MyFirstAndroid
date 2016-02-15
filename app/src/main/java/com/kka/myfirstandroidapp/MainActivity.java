package com.kka.myfirstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final int REQUEST_CODE_PICTURE = 1000;
    public static final int REQUEST_CODE_CAMERA = 2000;
    private TextView mTextView;

    //이름, 나이
    private EditText mNameEditText;
    private EditText mAgeEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //부모한테 가져온거고 밑은 추가로 할꺼
        //화면에 레이아웃 표시 -  부모가 준거
        // R 이 res 폴더 가리킴
        setContentView(R.layout.check);
        mTextView = (TextView) findViewById(R.id.msg_text_view);

        //이름 , 나이
        mNameEditText = (EditText) findViewById(R.id.name_edit_text);
        mAgeEditText = (EditText) findViewById(R.id.age_edit_text);


        ((CheckBox) findViewById(R.id.check_box)).setOnCheckedChangeListener(this);
        findViewById(R.id.Next_activity_button).setOnClickListener(this);

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


    @Override
    public void onClick(View v) {
        //이름, 나이 가져오기

        Toast.makeText(MainActivity.this, mNameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
        // 세컨트액티비티로 전환하겠다는 인텐트
        Intent intent = new Intent(this, SecondActivity.class);

        //이름 나이 가져와서 인텐트에 추가

        intent.putExtra("name",mNameEditText.getText().toString());
        intent.putExtra("age",mAgeEditText.getText().toString());
        //인텐트의 정보를 토대로 다른 액티비티 시작
        startActivityForResult(intent, REQUEST_CODE_PICTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_PICTURE || resultCode == RESULT_OK || data != null) {
            String result = data.getStringExtra("result");
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }else if (requestCode == REQUEST_CODE_CAMERA) {

        }
    }

    //결과를 처리
//    @Override//                          1000
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == REQUEST_CODE_PICTURE || resultCode == RESULT_OK || data!= null) {
//            String result = data.getStringExtra("result");
//            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
//            //사진을 선택
//        }else if(requestCode== REQUEST_CODE_CAMERA) {
//            //사진찍어서 받을때 처리
//        }
//    }

    // item_button.xml에 연결됨
   // public void onClick(View v) {
//        //view v 는 다형성으로 버튼 받은거
//        switch (v.getId()) {
//            case R.id.button1:
//                Toast.makeText(MainActivity.this, "첫번째 버튼", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.button2:
//                Toast.makeText(MainActivity.this, "두우번째 버튼", Toast.LENGTH_SHORT).show();
//                break;
//        }
  //  }

    //체크박스가 들어옴
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(MainActivity.this, "check : " + isChecked, Toast.LENGTH_SHORT).show();
        if (isChecked) {
            mTextView.setVisibility(View.VISIBLE);
        } else {
            mTextView.setVisibility(View.INVISIBLE);
        }

    }
}
