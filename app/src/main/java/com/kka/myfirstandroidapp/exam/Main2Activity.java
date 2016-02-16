package com.kka.myfirstandroidapp.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kka.myfirstandroidapp.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public int cnt = 0;
    private TextView textView4;
    public int price = 1500;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    public int sum =0;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.button).setOnClickListener(this);  // -
        findViewById(R.id.button3).setOnClickListener(this);  // +
        findViewById(R.id.button4).setOnClickListener(this);  // 주문
        textView4 = (TextView) findViewById(R.id.textView4);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        editText = (EditText)findViewById(R.id.editText);
        ((CheckBox) findViewById(R.id.checke_Box)).setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (cnt > 0) {
                    cnt--;
                    textView4.setText("" + cnt);

                } else {
                    Toast.makeText(Main2Activity.this, "0보다 작을 수 없습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button3:
                cnt++;
                textView4.setText("" + cnt);
                break;
            case R.id.button4:
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView7.setText("이름:" + editText.getText().toString());
                textView8.setVisibility(View.VISIBLE);
                textView8.setText("수량:" + cnt);
                textView9.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                textView10.setText("합계:"+(price*cnt+sum));
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true) {
            sum = 500;
            textView9.setText("휘핑크림추가여부"+isChecked);
        }else if(isChecked == false) {
            textView9.setText("휘핑크림추가여부"+isChecked);
        }
    }



}
