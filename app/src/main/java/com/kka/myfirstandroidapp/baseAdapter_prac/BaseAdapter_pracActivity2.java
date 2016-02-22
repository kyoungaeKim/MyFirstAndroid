package com.kka.myfirstandroidapp.baseAdapter_prac;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.kka.myfirstandroidapp.R;

public class BaseAdapter_pracActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_prac2);

        editText1 = (EditText) findViewById(R.id.editText2);
        editText2 = (EditText) findViewById(R.id.editText3);
        image = (ImageView) findViewById(R.id.imageView1);
        button1 = (Button) findViewById(R.id.button5);
        button2 = (Button) findViewById(R.id.button6);
        button3 = (Button) findViewById(R.id.button7);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                //사진 첨부
                break;
            case R.id.button6:
                //저장
                Intent intent = new Intent(this,BaseAdapter_pracActivity.class);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.id.imageView1);
                intent.putExtra("image",bitmap);
                intent.putExtra("title",editText1.getText().toString());
                intent.putExtra("text",editText2.getText().toString());
                startActivity(intent);
                break;
            case R.id.button7:
                //취소
                finish();
                break;
        }
    }
}
