package com.example.thunder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CoffeeActivity extends AppCompatActivity {
    //메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //레이아웃 설정
        setContentView(R.layout.activity_coffee);

        // XML 에 있는 View 의 레퍼런스를 가져오는 방법
        TextView quantityTextView = (TextView) findViewById(R.id.count_coffee);
//        Button minusButton = (Button) findViewById(R.id.minus_button);
//        Button plusButton = (Button) findViewById(R.id.plus_button);
    }

    public void minusButtonClicked(View view) {
        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
    }

    public void pulsButtenClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
    }
}
