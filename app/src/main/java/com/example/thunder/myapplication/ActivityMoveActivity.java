package com.example.thunder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        //2 그 다음 애들을 준비해야 하고
        //그래서 뷰에 온클릭리스너라는 인터페이스가 있어서
        //이걸 이용하려고 하는데
        //인터페이스라서 단독으로 만들 수가 없어 어딘가 담아줘야됭....
        View.OnClickListener listener = new MyClickLinsterner();
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityMoveActivity.this, "잘 된다", Toast.LENGTH_SHORT).show();
            }
        };

        //3 그다음 적어주면 되지...
        //흐름의 순서는 반대지만.. 내가 버튼의 주소를 가지고 왔고
        //그 버튼을 쓸려고 온클릭이 된다면을 하는데..
        //저 안에 파라미터를 넣어줘야 하네?!
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(listener);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(listener2);

    }
    //1 이게 먼저 되어야 하고..
    //그래서 원래는 클래스를 따로 만들어줘야 하지만,,
    //간단하게 여기서 클래스를 만든다면
    //뷰온클릭리스터를 상속받는 클래스를 만들어주고
    //onClick을 오버라이드 해주면 되겠지??
    //그리고 토어스트로 해서 시험작업을 해보자!
    class MyClickLinsterner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(ActivityMoveActivity.this, "잘되나?", Toast.LENGTH_SHORT).show();
        }
    }

}
