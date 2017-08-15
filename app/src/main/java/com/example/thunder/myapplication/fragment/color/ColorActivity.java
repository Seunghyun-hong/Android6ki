package com.example.thunder.myapplication.fragment.color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thunder.myapplication.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void onCreateFragmentButtonClicked(View view) {
        // 새로운 프래그먼트 생성

        ColorFragment fragment = new ColorFragment();

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
