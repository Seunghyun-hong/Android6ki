package com.example.thunder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.thunder.myapplication.adapterView.AdapterViewExamActivity;
import com.example.thunder.myapplication.adapterviewexam.ColorfulAdapterActivity;
import com.example.thunder.myapplication.fragment.basketball.BasketBallActivity;
import com.example.thunder.myapplication.fragment.color.ColorActivity;
import com.example.thunder.myapplication.fragment.exam.ColorSelectExamActivity;
import com.example.thunder.myapplication.fragment.exam.suwonexam.ColorExamActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivityActivity extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String CLASS = "class";

    private List<Map<String, Object>> mDataList;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_activity);

//        ListView listView = (ListView) findViewById(R.id.list_view);

        //date (눌렀을때 그 아이템이 들고있는 정보는 제목, 설명, 실제로 이동하는 대상)
        //(화면에 보이는건 제목 설명 만 보이면 되고)
        // 대상은 인텐트로 가져오면 된다!
        // 그래서 우리가 원하는건 스트링 2개에 클래스파일 1개가 필요하다.

        // 심플타입어탭터가 원하는 모양대로 데이터를 만들어 준다.(리스트원함)

        mDataList = new ArrayList<>();
        addItem("커피 앱", "Activity 의 기본, 암시적 인텐트, 옵션 메뉴, 리소스 분기", CoffeeActivity.class);
        addItem("농구점수 앱", "", CountCounterActivity.class);
        addItem("액티비티 버튼만 있음.ㅋ", "", ActivityMoveActivity.class);
        addItem("화면 전환 과제", "", LoginActivity.class);
        addItem("인텐트를 해보자", "", ImplicitIntentActivity.class);
        addItem("나만의 웹브라우저", "", MyWebBrowserActivity.class);
        addItem("SignUpExam", "", SignUpExamActivity.class);
        addItem("연락처", "", AdapterViewExamActivity.class);
        addItem("알록달록리스트뷰", "", ColorfulAdapterActivity.class);
        addItem("액티비티생명주기", "", LifeCycleActivity.class);
        addItem("프래그먼트농구점수", "", BasketBallActivity.class);
        addItem("동적인 프래그먼트 (컬러/랜덤)", "", ColorActivity.class);
        addItem("동적인 프래그먼트 과제", "", ColorSelectExamActivity.class);
        addItem("동적인 프래그먼트 과제(원장님버전 더하고 빼고)", "", ColorExamActivity.class);



        // adapter
        mAdapter = new SimpleAdapter(this,
                mDataList,
                android.R.layout.simple_list_item_2,
                new String[]{TITLE, DESCRIPTION},
                new int[]{android.R.id.text1, android.R.id.text2});

        // view
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);


        // 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class cls = (Class) mDataList.get(position).get(CLASS);
                Intent intent = new Intent(ListViewActivityActivity.this, cls);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Class cls = (Class) mDataList.get(position).get(CLASS);
                Toast.makeText(ListViewActivityActivity.this, cls.getName(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }



    private void addItem(String title, String description, Class cls) {
        Map<String, Object> data = new HashMap<>();
        data.put(TITLE, title);
        data.put(DESCRIPTION, description);
        data.put(CLASS, cls);

        mDataList.add(data);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.action_sort) {
//            Collections.reverse(mDataList);
//            mAdapter.notifyDataSetChanged();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//====================================================================//
    //어댑터를 만들때 보통은 따로 빼지만 귀찮으니까 그냥 여기에 만듭니다.ㅋㅋㅋ
    //내부 클래스는 무조건 스태틱으로 만들어 줍니다.
//    private static class My
    // 그런데 우린 심플어탭터로 쓴다고 했으니 안만들어도 되겠군.
}
