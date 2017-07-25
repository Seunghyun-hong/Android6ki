package com.example.thunder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SignUpMessageActivity extends AppCompatActivity {

    private TextView mInputId;
    private TextView mInputPassword;
    private TextView mInputEmail;
    private TextView mInputGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_exam2);
        mInputId = (TextView) findViewById(R.id.input_id_text);
        mInputPassword = (TextView) findViewById(R.id.input_password_text);
        mInputEmail = (TextView) findViewById(R.id.input_email_text);
        mInputGender = (TextView) findViewById(R.id.input_gender_text);


        // 넘어온 데이터를 받자!
        Intent intent = getIntent();
        if (intent != null) { // 이건 항상 해주는게 좋아!
            String message1 = intent.getStringExtra("id");
            String message2 = intent.getStringExtra("password");
            String message3 = intent.getStringExtra("email");
            String message4 = intent.getStringExtra("gender");
            mInputId.setText(message1);
            mInputPassword.setText(message2);
            mInputEmail.setText(message3);
            mInputGender.setText(message4);
        }
    }

    // 확인 버튼 누르면 다시 전달
    public void checkClicked(View view) {
        setResult(RESULT_OK);
        finish();
    }


    
    
}
