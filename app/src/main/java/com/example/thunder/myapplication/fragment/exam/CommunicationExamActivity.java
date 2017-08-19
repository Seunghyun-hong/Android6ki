package com.example.thunder.myapplication.fragment.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thunder.myapplication.R;

public class CommunicationExamActivity extends AppCompatActivity implements SendDataFragment.SendData {

    private EditText mSendDataEditText;
    private TextView mGetDataTextView;
    private SendDataFragment mFragment;
    private SendDataFragment mFragmentLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_exam);
        mSendDataEditText = (EditText) findViewById(R.id.send_fragment_edit_text);
        mGetDataTextView = (TextView) findViewById(R.id.get_color_text);

        //프래그먼트도 가져와준다
        mFragment = (SendDataFragment) getSupportFragmentManager().findFragmentById(R.id.send_data_fragment);

        mFragmentLoad = (SendDataFragment) getSupportFragmentManager().findFragmentById(R.id.send_Activity_edit_text);
    }


    // 프래그먼트랑 통신할 수 있는 인터페이스 구현
    @Override
    public void onSandData(String text) {
        mGetDataTextView.setText(text);
        //액티비티에서 쌓이는건어떻게 할 수 있을까?
        //모르겠다 8월 19일
    }

    //액티비티에서 버튼을 누르면 나는 프래그먼트에 전달하고 싶어
    // 텍스트뷰를 가져오는 메소드를 이용해보자!
    public void onSendDataClicked(View view) {
        mFragment.getTextView(mSendDataEditText.getText().toString());
        mSendDataEditText.setText(""); //역시 초기화
    }

}
