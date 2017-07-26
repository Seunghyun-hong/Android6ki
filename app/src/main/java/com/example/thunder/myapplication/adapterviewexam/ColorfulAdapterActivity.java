package com.example.thunder.myapplication.adapterviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.thunder.myapplication.R;

import java.util.ArrayList;

public class ColorfulAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorful_adapter);

        //View
        ListView listView = (ListView) findViewById(R.id.list_view);

        //Data
        ArrayList<Position> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Position position = new Position("포지션 " + i);
            data.add(position);
        }

        //Adapter
        PositionAdapter adapter = new PositionAdapter(ColorfulAdapterActivity.this,data);

        listView.setAdapter(adapter);
    }
}
