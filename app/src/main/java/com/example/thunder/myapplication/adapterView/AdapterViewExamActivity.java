package com.example.thunder.myapplication.adapterView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thunder.myapplication.R;

import java.util.ArrayList;

public class AdapterViewExamActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final String TAG = AdapterViewExamActivity.class.getSimpleName();
    private ArrayList<People> data;
    private ArrayList<People> mPeopleData;
    private PeopleAdapter mAdapter;
    private ListView mListView;
    private EditText mWeatherEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);

        //View
        mListView = (ListView) findViewById(R.id.list_view);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        //Data
        mPeopleData = new ArrayList<>();  //원래 다 필드로 빼줘야 한다...
        for (int i = 0; i < 100; i++) {
            int picture;
            if (i % 2 == 0) {
                picture = R.drawable.beach;
            } else {
                picture = R.drawable.beach2;
            }
            People people = new People("아무개 " + i, "전화번호 " + i, picture);
            mPeopleData.add(people);
        }

        //Adapter
        mAdapter = new PeopleAdapter(AdapterViewExamActivity.this, mPeopleData);

        /**
         * 우리가 아까 피플어댑터를 만들때 베이스어탭터를 상속받았는데
         * 피플어댑터 가보니까 ListAdapter 구현하고 있었음.
         * 그래서 그냥 아까 쓰던대로
         * listview.setAdapter 해도 잘 작동이 됨!
         */

        mListView.setAdapter(mAdapter);

        gridView.setAdapter(mAdapter);
        spinner.setAdapter(mAdapter);

        // OnItemClickListener // 터치가 되면 각각 움직이는 걸 만들고 싶어

//        listView.setOnClickListener(); // 그런데 이걸로 하면 각각 먹는게 아니라 그냥 한번에 먹어버리기때문에 안쓸꺼임
        // 그래서 아이템!별로 클릭리스터를 만들어줄끄야.
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

                Intent intent = new Intent(AdapterViewExamActivity.this,
                        DetailAddressActivity.class);
                intent.putExtra("name", people.getName());
                intent.putExtra("phone", people.getPhone());
                intent.putExtra("picture", people.getPicture());
                startActivity(intent);
            }
        });


//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterViewExamActivity.this, "롱 클릭", Toast.LENGTH_SHORT).show();
//                return false;
//                // 리턴 값이 나오는데 트루하면 롱클릭을 했을때 롱클릭이라고 잘 나옴.
//                // 그런데 사람이 롱클릭을 하고 싶지 않을때 그럴 수 도 있잖여~
//                // 롱클릭이 되었다고 알려주긴 하지만 시스템에는 롱클릭이 안되었어요 라고 전달하는게 폴스!
//                // 폴스로 하고 롱클릭 하면 롱클릭도 출력되고 그냥클릭도 출력됨.
//                // 그러니까 시스템은 롱클릭이 되지 않았다고 생각을 해서 "그냥클릭"이 된걸로 인식을 한다.
//                /// 이런걸 :이벤트 소비제어: 라고 한다
//                // 그래서 트루로 하면 이벤트를 소비하겠다 더이상 이벤트가 흘러가지 않는다~
//                // 아주 중요한 거니까 기억해둬.
//            }
//        });


        // Context 메뉴 연결
        registerForContextMenu(mListView);
        //롱클릭 활성화되면 이게 먹질 않으니까 롱클릭 메뉴는 잠시 꺼두자.


        // SharedPreference 데이터 복원
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(AdapterViewExamActivity.this);
        //원래 여기엔 아무것도 존재하지 않는데... 그래서 디폴드 값을 초기값을 줘서 만들어주는거래.
        String weather = settings.getString("weather", "맑음"); //디폴드 값은 암케나~

        mWeatherEditText = (EditText) findViewById(R.id.weather_eidt);
        mWeatherEditText.setText(weather); // 셋텍스트에 워더를 넣어주면 디폴트 값으로 맑음이 들어가겠지.

        //그럼 이제 뭘 할때 저 위에 날씨가 저장이 되는지 설정을 해볼까??
        // 뒤로가기 키를 눌렀을때 저장되게 하자!!!

    }

    ////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_address, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id = item.getItemId();

        switch (id) {
            case R.id.action_add:
                Intent intent = new Intent(AdapterViewExamActivity.this,
                        DetailAddressActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
///////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_coffee, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //info 는 눌린애의 정보를 가지고 있데
        // 포지션하고 타겟뷰 정도 정보를 얻을 수있음
        switch (item.getItemId()) {
            case R.id.action_item1:
                Toast.makeText(this, "action 1", Toast.LENGTH_SHORT).show();
                showDefaultDialog(info);

//                // 위에 경고창만들었으니까 위로 보내자! 밑에 삭제 및 업데이트를...
//                // 삭제
//                mPeopleData.remove(info.position);
//                // 업데이트
//                // 어뎁터에게 알려준다 야! 데이터 바뀌었어!!!
//                mAdapter.notifyDataSetChanged();
/////////////////////이게 최선의 방법 ///////////////////////
//                // 안좋은 방법은
//                mListView.setAdapter(new PeopleAdapter(this, mPeopleData));
//                //또는
//                mListView.setAdapter(mAdapter);
//                // 그런데 새로 만드는 거라서 중간에서 삭제 하면 위로 올라가버리고(새로만드니까)
//                //좋지 않다.

                return true;
            case R.id.action_item2:
                Toast.makeText(this, "action 2", Toast.LENGTH_SHORT).show();

                //다이얼로그 만든걸 가져온다면.. 아 위에 꺼랑 겹치네.. showDefaltDialog 라는 이름으로 메소트 만들어서 뺌
                showCustomDialog();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showCustomDialog() {
        // 우선 앞어처럼 대화상자를 만들어주고
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //아까 만든걸 가져와서 붙인다.
        //레이아웃을 가져올려고 하면 어떻게해야하지??
        //파인드뷰아이디 못써!
        // 레이아웃 인플레이터를 쓰면 된다.
        // 붙일 부모를 찾는데.. 그건 null해주면 된데.
//       View view = LayoutInflater.from(this).inflate(R.layout.dialog_signin, null, false);

        //액티비티가 인플레이터레이아웃을 내장하고 있데.
        //그래서 저 위에 껄로 안하고
        View view = getLayoutInflater().inflate(R.layout.dialog_signin, null);

//붙이는것도 위로 올려줌
        builder.setView(view);
        final AlertDialog dialog = builder.create(); // 밑에서 하던걸 위로 올리고

        //버튼도 붙여줭

//        builder.setPositiveButton("예",null);
//        builder.setNegativeButton("아니오",null);
//        //그런데 사장님은 이거 싫데.. 예는 왼 아니오는 오른쪽에 고정되었으면 좋겠데.
//        // 그럼 위에꺼 못씀.
        //아까 레이아웃에 가서 편집을 하고! 그리고 버튼을 가지고온다
        view.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdapterViewExamActivity.this, "잘눌림", Toast.LENGTH_SHORT).show();

                //다이얼로그 닫기
                dialog.dismiss();

            }
        });

        view.findViewById(R.id.negative_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //다이얼로그 닫기
                dialog.dismiss();
            }
        });

//        // 그럼 이제 붙여!
//        builder.setView(view);
//        //보여줭
//        builder.create().show();

        builder.show();

    }

    private void showDefaultDialog(final AdapterView.AdapterContextMenuInfo info) {
        // 물어보자 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(AdapterViewExamActivity.this);
        builder.setTitle("삭제");
        builder.setMessage("정말로 삭제하시겠습니까?");
//                builder.setAdapter(); 셋어뎁터가 된다는 것은 리스트뷰를 사용할 수 있다는 거겠지?
        // 바깥 부분 클릭 했을 때 닫기
        builder.setCancelable(false); //해버리면 밖에 클릭해도 대화상자 사라지지 않음!
        builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "onClick: " + which); // 위치가 뭔 역할이지?  모르겠으면 찍어보자!!
                // which는 다이얼로그 인터페이스에 정의가 되어있어.
                // 그래서 이 상수를 이용해서 뭔가를 할 수 있겠지..
                // 위에 클래스에 DialogInterface.OnClickListener 인플리먼트 하고 알트엔터하면
                // public void onClick(DialogInterface dialog, int which)  이거 만들어서
                // 여기서 스위치 문으로 돌릴 수 도 있지..
                // 맨밑에 해본거 있음. 참고 해봐..

                // 삭제
                mPeopleData.remove(info.position);
                // 업데이트
                // 어뎁터에게 알려준다 야! 데이터 바뀌었어!!!
                mAdapter.notifyDataSetChanged();
            }
        });

//                builder.setNegativeButton("아니오", null);
//                Log.d(TAG, "onContextItemSelected: " + new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d(TAG, "onClick: " + which);
//                    }
//                });

        builder.setNegativeButton("아니오", this);

//                AlertDialog dialog = builder.create();
//                dialog.show(); // 하면 화면에 보인다.
        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\==>
        builder.setIcon(R.drawable.beach2); // 화면에 이렇게 하면 아이콘사이즈로 들어감!
        //그런데 아니오 예 방향을 바꾸고 싶어.. 이건 버전마다 위치가 다른거거든.. 그래서 바꿀려고 하면
        //머리 아픈뎅.. 그럼 분기를 타서 몇버전에선 위치 바꿔주고 어떤버전에서 그냥 하는 걸 만들어줘야해,
        //그건 이런 상황이 나오면 어떻게 하는지 알려드릴게요~

        builder.create().show();
    }

    /////////뒤로 가기 키로 저장을 해보자///////////////


    @Override
    public void onBackPressed() {
        // 뒤로 가기전에 저장!
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("weather", mWeatherEditText.getText().toString());

        // Commit the edits!  반영할때
        editor.apply();
        //커밋은 어플라이생기기 전에 쓰던거..
        // 커밋은 동기고 (싱크를 맞추면서 간다)-ex) 복사좀 해줘~ 복사할때까지 가만히...
        // 어플라이는 비동기 -복사해줭~ 하면서 나는 다른것도 하는...그런거.
        // 나중에 뒷부분 가서 자세히 다룬데

        // 뒤로 가기
        super.onBackPressed();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                break;
            case DialogInterface.BUTTON_NEGATIVE:
        }
    }
}
