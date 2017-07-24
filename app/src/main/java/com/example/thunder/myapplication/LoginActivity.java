package com.example.thunder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        final EditText id = (EditText) findViewById(R.id.id_edit);
        final EditText password = (EditText) findViewById(R.id.password_edit);


        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면 새로 띄우는 코드
                Intent intent = new Intent(LoginActivity.this,
                        AdministerActivity.class);
                startActivity(intent);
            }
        });

        // 데이터 전송
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "아이디: " + id.getText().toString();
                message += "\n비밀번호: " + password.getText().toString();
                Intent intent = new Intent(LoginActivity.this,
                        AdministerActivity.class);
                intent.putExtra("data", message);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 &&
                resultCode == RESULT_OK &&
                data != null) {
            String message = data.getStringExtra("data");
            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
        }
    }
}
