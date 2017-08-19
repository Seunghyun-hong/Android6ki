package com.example.thunder.myapplication.fragment.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thunder.myapplication.R;

public class CommunicationExamActivity extends AppCompatActivity implements SendDataFragment.SendData {

    private EditText mSendData;
    private TextView mGetData;
    private SendDataFragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_exam);
        mSendData = (EditText) findViewById(R.id.send_fragment_edit_text);
        mGetData = (TextView) findViewById(R.id.get_color_text);

        //프래그먼트도 가져와준다
        mFragment = (SendDataFragment) getSupportFragmentManager().findFragmentById(R.id.send_data_fragment);
    }


    // 프래그먼트랑 통신할 수 있는 인터페이스 구현
    @Override
    public void onSandData(String text) {
        Toast.makeText(this, "메세지 받아줭", Toast.LENGTH_SHORT).show();
        mGetData.setText(text);
    }

    //액티비티에서 버튼을 누르면 나는 프래그먼트에 전달하고 싶어
    // 텍스트뷰를 가져오는 메소드를 이용해보자!
    public void onSendDataClicked(View view) {
        mFragment.getTextview(mSendData.getText().toString());
    }

}
