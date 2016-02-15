package com.kka.myfirstandroidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mCallBtn;
    private Button mWebBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        mCallBtn = (Button) findViewById(R.id.call_btn);
        mWebBtn = (Button) findViewById(R.id.web_btn);

        mCallBtn.setOnClickListener(this);
        mWebBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call_btn:
                dialPhoneNumber("010-3017-4644");

                break;
            case R.id.web_btn:
                openWebPage("http://www.naver.com");

                break;
        }
    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent =  new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager())!= null) {
            startActivity(intent);
        }
    }
}
