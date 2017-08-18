package com.example.thunder.myapplication.fragment.exam.suwonexam;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thunder.myapplication.R;
import com.example.thunder.myapplication.fragment.color.ColorFragment;

public class ColorExamActivity extends AppCompatActivity {

    private ColorFragment mFragment1 = ColorFragment.newInstance(Color.RED);
    private ColorFragment mFragment2 = ColorFragment.newInstance(Color.BLUE);
    private ColorFragment mFragment3 = ColorFragment.newInstance(Color.GREEN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_exam);
    }

    public void onclicked(View view) {
        ColorFragment fragment = null;
        int container = 0;
        switch (view.getId()) {
            case R.id.button_1:
                fragment = mFragment1;
                container = R.id.container_1;
                break;
            case R.id.button_2:
                fragment = mFragment2;
                container = R.id.container_2;
                break;
            case R.id.button_3:
                fragment = mFragment3;
                container = R.id.container_3;
                break;
        }
        // 안 붙었으면 붙이고 붙었으면 빼자!
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            transaction.replace(container, fragment);
        } else {
            transaction.remove(fragment);
        }
        transaction.commit();
    }
}
