package com.example.thunder.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {

    public static final int MIN_QUANTITY = 1;
    public static final int DEFAULT_QUANTITY = 1;
    public static final int COFFEE_PRICE = 3000;

    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private CheckBox mWippedCreamCheckBox;
    private int mQuantity = DEFAULT_QUANTITY;
    private EditText mNameEditText;

    private DecimalFormat mFormat = new DecimalFormat("#,##0");

    // 메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레이아웃 설정
        setContentView(R.layout.activity_coffee);

        // XML에 있는 View의 레퍼런스를 가져오는 방법
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text);
        mPriceTextView = (TextView) findViewById(R.id.price_text);
        mWippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        mNameEditText = (EditText) findViewById(R.id.name_edit);
//        mQuantityTextView.setText(String.valueOf(mQuantity));
        display();
    }

    private void display() {
        mQuantityTextView.setText("" + mQuantity);

        String message = "주문자 : " + mNameEditText.getText().toString();
        message += "\n====================";
        message += "\n휘핑 크림 추가 여부 : " + mWippedCreamCheckBox.isChecked();
        message += "\n갯수 : " + mQuantity;
        message += "\n가격 : " + mFormat.format(mQuantity * COFFEE_PRICE) + "원";

        mPriceTextView.setText(message);
    }

    public void minusButtonClicked(View view) {
        mQuantity--;
        if (mQuantity < MIN_QUANTITY) {
            mQuantity = MIN_QUANTITY;
        }
        display();
    }

    public void plusButtonClicked(View view) {
        mQuantity++;
        display();
    }

    public void onCheckBoxClicked(View view) {
        display();
    }


    //원장님버전 (이메일로 보내는 거고 mailto는 반드시 들어가야 하네..)
    public void orderButtonClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setType("text/plaint");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"a123@gmail.com"});
        intent.putExtra(Intent.EXTRA_TITLE, "주문이요");
        intent.putExtra(Intent.EXTRA_TEXT, mPriceTextView.getText().toString());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
        //내버전

//    public void sendTextMessage(String message) {
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setType("text/plaint");
//        intent.putExtra(Intent.EXTRA_TEXT, message);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }
//
//    public void orderButtonClicked(View view) {
//        mQuantityTextView.setText("" + mQuantity);
//
//        String message = "주문자 : " + mNameEditText.getText().toString();
//        message += "\n====================";
//        message += "\n휘핑 크림 추가 여부 : " + mWippedCreamCheckBox.isChecked();
//        message += "\n갯수 : " + mQuantity;
//        message += "\n가격 : " + mFormat.format(mQuantity * COFFEE_PRICE) + "원";
//
//        mPriceTextView.setText(message);
//
//        sendTextMessage(message);
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_item1:
                Toast.makeText(this, "잘될까?", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_item2:
                return true;
            case R.id.action_item3:
                return true;
            case R.id.action_item4:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}


