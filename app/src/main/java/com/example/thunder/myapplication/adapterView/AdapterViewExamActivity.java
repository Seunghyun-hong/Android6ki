package com.example.thunder.myapplication.adapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.thunder.myapplication.R;

import java.util.ArrayList;

public class AdapterViewExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);

        //View
        ListView listView = (ListView) findViewById(R.id.list_view);

        //Data
        ArrayList<People> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int picture;
            if(i % 2 == 0){
                picture = R.drawable.beach;
            } else {
                picture = R.drawable.beach2;
            }
            People people = new People("아무개 " + i, "전화번호 " + i,picture);
            data.add(people);
        }

        //Adapter



//        listView.setAdapter(adapter);

    }
}
