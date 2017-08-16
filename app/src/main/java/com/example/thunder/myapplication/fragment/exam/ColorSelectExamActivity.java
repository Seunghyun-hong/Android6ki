package com.example.thunder.myapplication.fragment.exam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.thunder.myapplication.R;

public class ColorSelectExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_select_exam);
    }
    public void Fragment1Clicked(View view) {
        ColorfulFragment fragment = ColorfulFragment.newInstance(Color.RED, "1번 프래그먼트");

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_1, fragment)
                .commit();

    }

    public void Fragment2Clicked(View view) {
        ColorfulFragment fragment = ColorfulFragment.newInstance(Color.argb(255, 100, 40, 100), "2번 프래그먼트");
        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_2, fragment)
                .commit();
    }

    public void Fragment3Clicked(View view) {
        ColorfulFragment fragment = ColorfulFragment.newInstance(Color.BLUE, "3번 프래그먼트");
        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_3, fragment)
                .commit();
    }
}
