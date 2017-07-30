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
                Toast.makeText(AdapterViewExamActivity.this, "그냥 클릭", Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onItemClick: " + people.toString());    // debug 의 약자
//                //개발중일때만 보이는 로그 // 누군가가 어플을 다운받고 여기서 실행한다고 해도 로그는 뜨지 않음!
//                Log.e(TAG, "onItemClick: 에러 ");    // error
//                // 제품이 나가도 이건 보이는거.
//                Log.i(TAG, "onItemClick: 정보");    // information
//                // 일반적으로 보이는 정보들...
//                Log.w(TAG, "onItemClick: 경고");  // warning
            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭", Toast.LENGTH_SHORT).show();
                return false;
                // 리턴 값이 나오는데 트루하면 롱클릭을 했을때 롱클릭이라고 잘 나옴.
                // 그런데 사람이 롱클릭을 하고 싶지 않을때 그럴 수 도 있잖여~
                // 롱클릭이 되었다고 알려주긴 하지만 시스템에는 롱클릭이 안되었어요 라고 전달하는게 폴스!
                // 폴스로 하고 롱클릭 하면 롱클릭도 출력되고 그냥클릭도 출력됨.
                // 그러니까 시스템은 롱클릭이 되지 않았다고 생각을 해서 "그냥클릭"이 된걸로 인식을 한다.
                /// 이런걸 :이벤트 소비제어: 라고 한다
                // 그래서 트루로 하면 이벤트를 소비하겠다 더이상 이벤트가 흘러가지 않는다~
                // 아주 중요한 거니까 기억해둬.
            }
        });
    }
}
