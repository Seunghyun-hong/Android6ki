package com.example.thunder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AdministerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administer);


        // 넘어온 데이터 받기
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("data");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }

    public void crmOnClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "고객관리");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void smOnclicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "매출관리");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void mcOnClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "물품관리");
        setResult(RESULT_OK,intent);
        finish();
    }
}

