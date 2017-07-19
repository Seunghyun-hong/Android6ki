package com.example.thunder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {

    public static final int Min_Quntity = 0;
    //field 전역변수
    private TextView mQuantityTextView;// 이걸 바꿀꺼니까 다른 지역변수에들도 쓸 수 있게 밖으로 빼줌.
    private int mQuantity = 1;
    private TextView mPriceNum;
    private int mPrice = 0;

    //메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //레이아웃 설정
        setContentView(R.layout.activity_coffee);

        // XML 에 있는 View 의 레퍼런스를 가져오는 방법
        mQuantityTextView = (TextView) findViewById(R.id.count_coffee);
//        Button minusButton = (Button) findViewById(R.id.minus_button);
//        Button plusButton = (Button) findViewById(R.id.plus_button);
//        mQuantityTextView.setText(String.valueOf(mQuantity));
        mQuantityTextView.setText(" " + mQuantity);
        mPriceNum = (TextView) findViewById(R.id.prise_num);
        mPriceNum.setText(" " + mPrice);
    }

    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
//        mQuantityTextView.setText(mQuantity-1);//흑 누르니까 앱종료되버렸어..ㅠㅠ이코드가 아닌가봐(혼자해봄)
        //내가 코딩한거..
//        if (mQuantity > 0) {
//            mQuantity--;
//            mQuantityTextView.setText(" " + mQuantity);
//        } else {
//            mQuantity = 0;
//            mQuantityTextView.setText(" " + mQuantity);
//        }
        //근데 그지같애..ㅋㅋ
        //원장님 버전
        mQuantity--;
        if (mQuantity < Min_Quntity) {
            mQuantity = Min_Quntity;
        }
        mQuantityTextView.setText(" " + mQuantity);
        //맥스로 해도 Math.Max 도 있데..
/////////////////////////////이번엔 가격을 조정해보자!!////////////
        mPrice = mPrice - 3000;
        if (mPrice < 0) {
            mPrice = 0;
        }
        mPriceNum.setText(mPrice + "원");

    }

    public void pulsButtenClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
        mQuantity++;
        mQuantityTextView.setText(" " + mQuantity);
        mPrice = mPrice + 3000;
        mPriceNum.setText(" " + mPrice + "원");

        //히히 스스로 했당!!! 히히히히히히히 신나><
    }
}
