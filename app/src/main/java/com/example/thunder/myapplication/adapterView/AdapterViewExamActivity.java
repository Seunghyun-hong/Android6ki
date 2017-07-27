package com.example.thunder.myapplication.adapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thunder.myapplication.R;

import java.util.ArrayList;

public class AdapterViewExamActivity extends AppCompatActivity {

    private static final String TAG = AdapterViewExamActivity.class.getSimpleName();
    private ArrayList<People> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);

        //View
        ListView listView = (ListView) findViewById(R.id.list_view);

        //Data
        data = new ArrayList<>();  //원래 다 필드로 빼줘야 한다...
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.beach;
            } else {
                picture = R.drawable.beach2;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            data.add(people);
        }

        //Adapter
        PeopleAdapter adapter = new PeopleAdapter(AdapterViewExamActivity.this, data);
        /**
         * 우리가 아까 피플어댑터를 만들때 베이스어탭터를 상속받았는데
         * 피플어댑터 가보니까 ListAdapter 구현하고 있었음.
         * 그래서 그냥 아까 쓰던대로
         * listview.setAdapter 해도 잘 작동이 됨!
         */

        listView.setAdapter(adapter);

        // OnItemClickListener // 터치가 되면 각각 움직이는 걸 만들고 싶어
//        listView.setOnClickListener(); // 그런데 이걸로 하면 각각 먹는게 아니라 그냥 한번에 먹어버리기때문에 안쓸꺼임
        // 그래서 아이템!별로 클릭리스터를 만들어줄끄야.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//parent는 listView 에 대한 레퍼런스  // view 는 내가 눌른 레이아웃(뷰)의 레퍼런스 // position 내가 눌른 위치 /==/ id 는 우리가 걍 포지션으로 정함
//                Toast.makeText(AdapterViewExamActivity.this, " " + position, Toast.LENGTH_SHORT).show();
                // 그런데 우리는 궁극적으로 눌른것에 대한 정보를 얻고 싶고 그걸 이용하고 싶단 말이지...
                // 그럼 우선 정보를 알고 싶은데 어떻게 알 수 있을까??
                // 위에 데이터가 있으니까 그걸로 가져오면 되지 않을까/??
                // 이걸 가져 오면 되겠지?==> data.get(position);
//                People people = data.get(position);
                // 그런데 이것의 문제가 중간에 삭제? 이런게 될 수 있나봐..
                // 그래서 파이널로 묶어 달라고(고정) 요청이 들어와.. 안하면 빌드가 안됨.
// 또하나의 방법은..
                //어탭터를 이용해서 얻을 수 있어.
//                parent.getAdapter()
//                parent.getAdapter().getItem(position);
                // 이렇게 하면 되지 않을까?
                People people = (People) parent.getAdapter().getItem(position);
                // 이렇게 하면 data를 파이널로 박지 않아도 되징..
                // 아무거나 하나 쓰면 된데.
                // 그리고 data를 전역변수로 해버리면 파이널 안 붙이고도 사용할 수 있데.
                // 원래 위에 있는것들 다 전역으로 빼야 하는데 지금 실습하는거라 딱히 안해둔거임..
                Toast.makeText(AdapterViewExamActivity.this, people.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
