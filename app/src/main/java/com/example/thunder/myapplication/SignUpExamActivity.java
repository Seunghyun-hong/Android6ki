package com.example.thunder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpExamActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mId;
    private EditText mPassword1;
    private EditText mPassword2;
    private EditText mEmail;
    private RadioGroup mRadioGroup;
//    private RadioButton mMale;
//    private RadioButton mFmale;
    private RadioButton mGender;
    private LinearLayout mEditgroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_exam);

        // 받아오는건 필드로 올리자!
        mId = (EditText) findViewById(R.id.id_edit);
        mPassword1 = (EditText) findViewById(R.id.password_edit);
        mPassword2 = (EditText) findViewById(R.id.password2_edit);
        mEmail = (EditText) findViewById(R.id.email_edit);
        mRadioGroup = (RadioGroup) findViewById(R.id.malefe_button);
//        mMale = (RadioButton) findViewById(R.id.male_button);
//        mFmale = (RadioButton) findViewById(R.id.female_button);
//        mEditgroup = (LinearLayout) findViewById(R.id.edit_group);


        // 버튼들은 이렇게?!
        findViewById(R.id.reset_button).setOnClickListener(this);
        findViewById(R.id.join_button).setOnClickListener(this);

//        mGender = (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reset_button:
                reset();
                break;
            case R.id.join_button:
                join();
                break;
        }

    }

    private void reset() {
        mId.setText(null);
        mPassword1.setText(null);
        mPassword2.setText(null);
        mEmail.setText(null);
//        mRadioGroup.setOnClickListener(null); ////라디오버튼 어떻게 초기화하는지 모르클. 넘어가!
//        mGender.setText(null);  // 위에껀 안죽는데 이건 앱이 죽어버리네..ㅠㅠ
        mRadioGroup.clearCheck();  //예!!!! 초기화 했다!!!!
    }


    //데이터 전달
    private void join() {
        if (mId.getText().toString().equals("") || mPassword1.getText().toString().equals("")
                || mPassword2.getText().toString().equals("") || mEmail.getText().toString().equals("")
                || !findViewById(R.id.male_button).isClickable()) {
            Toast.makeText(this, "모두 입력해주셔야 합니다", Toast.LENGTH_SHORT).show();
        } else if (!mPassword1.getText().toString().equals(mPassword2.getText().toString())) {
            Toast.makeText(this, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(SignUpExamActivity.this, SignUpMessageActivity.class);
            intent.putExtra("id", mId.getText().toString());
            intent.putExtra("password", mPassword1.getText().toString());
            intent.putExtra("email", mEmail.getText().toString());
//        intent.putExtra("gender", mRadioGroup.getCheckedRadioButtonId());// 안넘어가네.. 에잇.
//        intent.putExtra(("gender",mMale.getText().toString());
//        intent.putExtra("gender",mGender.getText().toString());//이거 쓰면 죽엉
            int id = mRadioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(id);
            intent.putExtra("gender", radioButton.getText().toString());
            startActivityForResult(intent, 1000);

        }
    }

    //넘어온 데이터 받기

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "확인 버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
    }

}
