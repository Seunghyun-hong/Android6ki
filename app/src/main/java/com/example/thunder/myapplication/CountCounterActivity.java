package com.example.thunder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CountCounterActivity extends AppCompatActivity {


    private TextView mAPoint;
    private int aPoint = 0;
    private TextView mBPoint;
    private int bPoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 설정
        setContentView(R.layout.activity_count_counter);

        mAPoint = (TextView) findViewById(R.id.apoint_text);
        mBPoint = (TextView) findViewById(R.id.bpoint_text);

        mAPoint.setText(" " + aPoint);
        mBPoint.setText(" " + bPoint);


    }

    public void aPlus3ButtonClicked(View view) {
        aPoint = aPoint + 3;
        mAPoint.setText(" " + aPoint);
    }

    public void aPlus2ButtonClicked(View view) {
        aPoint = aPoint + 2;
        mAPoint.setText(" " + aPoint);
    }

    public void aPlus1ButtonClicked(View view) {
        aPoint ++;
        mAPoint.setText(" " + aPoint);
    }

    public void bPlus3ButtonClicked(View view) {
        bPoint = bPoint +3;
        mBPoint.setText(" " + bPoint);
    }

    public void bPlus2ButtonClicked(View view) {
        bPoint = bPoint +2;
        mBPoint.setText(" " + bPoint);
    }

    public void bPlus1ButtonClicked(View view) {
        bPoint ++;
        mBPoint.setText(" " + bPoint);
    }

    public void resetButtonClicked(View view) {
        aPoint = 0;
        bPoint = 0;
        mAPoint.setText(" " + aPoint);
        mBPoint.setText(" " + bPoint);
    }
}