package com.kka.myfirstandroidapp.exam_fab_dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kka.myfirstandroidapp.R;

public class FabAndDialogActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_and_dialog);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(FabAndDialogActivity.this, "눌림", Toast.LENGTH_SHORT).show();
        //다이얼로그
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안드로이드");
        builder.setIcon(R.drawable.kdw);
        builder.setMessage("종료 하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //버튼에서 기능 여러가지 해줄때
                if (which == AlertDialog.BUTTON_POSITIVE) {
                    Toast.makeText(FabAndDialogActivity.this, "확인", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
        builder.setNegativeButton("닫기", null);
        builder.show();
    }
}
