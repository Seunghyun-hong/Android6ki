package com.example.thunder.myapplication.adapterView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thunder.myapplication.R;

import java.util.List;

/**
 * Created by Thunder on 2017-07-26.
 */

public class PeopleAdapter extends BaseAdapter {

    private final String TAG = PeopleAdapter.class.getSimpleName();

    private final List<People> mData;  //실제 데이터를 받아온다
    private final Context mContext;

//    데이터를 받는 방법이 없어서 생성자를 만들어서 데이터를 받자!


    public PeopleAdapter(Context context, List<People> data) {
        mContext = context;
        mData = data;
    }

    // 데이터 갯수 // 그래서 엠데이터가 받아오면 우리는 사이즈로 배열의 크기를 알 수 있지.
    @Override
    public int getCount() {
        return mData.size();  // 그러면 데이터가 잘 나옴.. 이거 0 으로 해버리면 아예 안나옴
    }

    // position(위치 0,1,2,3,,,,) 번째에 어떤 데이터가 있는지 알려줘야 함.
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // 데이터베이스 id
    @Override
    public long getItemId(int position) {
        return position; // 우린 아직 데이터베이스를 안배웠으니까 그냥 포지션 리턴해주면 된데.
    }

    // 실제 폰에서 표시될 레이아웃을 정해주는거래!!
    // 포지션 0번째 부터~ n번째 까지 말이지!!!
    // 내가 정해주면 그것대로 만든다고 하네.. (참 귀찮은 자식이구만.ㅋㅋㅋㅋ 알아서 만들것이지!!!!)


    // 화면에 레이아웃이 6개가 보인다 하면 우리가 만든 getview 가 6번 일한거~
    // 지워지는거=새로생기는거 레퍼런스(주소)를 교환하면서?! 난지워진다~ 넌 새로 적어~ 이렇게 해줄 수 있게 하는게
    //convertview 이거래!!!
    //(내가 이해 한게 맞네... 책 1011 페이지에 그림 있음)
    // 원장님은
    // convertView - position번째의 레이아웃의 레퍼런스
    // 이렇게 설명 붙이심..
    // 그런데 내가 이해하는게 맞는지는 모르겠네만.....
    // ViewGroup parent 가 뭐냐면
    // 실제로 이 어탭터는 잘 만들어두면 어디서든 붙어서 쓸 수 있는거얌.
    // 우리는 리스트뷰에 붙일껀데 다른 그레드(?)뷰에 붙일 수 도 있는거고!!
    // 하튼 그러니까 알려주는거지! 누구한테 붙을껀지!!!
    //만약 부모의 속성을 쓸 게 뭔가 있다 하면 이 parent 를 이용해서 캐스팅해서 쓸 수도 있징.
    // 원장님설명은
    // parent - 이 어댑터가 붙을 부모의 레퍼런스 (ListView나 GridView 등등등...)
    // 이라고 적어주심.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //여기서부터는 기계적으로 외워서 치면 된데...ㅎㅎ
//        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_exam, parent, false);
//        //layoutinflater 는 리소스를 가지고 올때 인플리터를 통해 가지고 올 수 있는데
//        // 레이아웃을 가지고 오게 해주는 객체에요.
//        // 그러고 .from 해서 컨텍스트를 가지고 오게 하면
//        // 알아서 가지고 올끄에요
//        // 임플레이터가 붙일끄에요.
//        // 아까 내가 만든 레이아웃을 말이죠!(item_exam)
//        // parent 부모에게 말이죠!!
//        // 이 View convertView 가 루트에 붙냐?(attachToRoot)[루트는 최상위 레이아웃이냐 아니냐 라는 뜻이래]
//        // 그런데 이 어탭트 안에서는 다 차일드야. position을 가지고 있는 차일드!!
//        // 그래서 최상위가 아니니까! 항상 false 인거지!!
//
//        // 이렇게 가지고 왔으니.. 그럼 이미지랑 텍뷰랑 다 가져와야 겠지 파인트뷰아이디 해서...
//        // 그러면 아이템이그잼에 가서 모두에게 아이디를 주고
//        // 나는 가지고 온다.
////        ImageView imageView = fin
//                // 그런데 파인드 뷰아이디가 안나옴.. 뭐징?
//        // 레이아웃 가지고 오기
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
//        TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text);
//        TextView phoneTextView = (TextView) convertView.findViewById(R.id.phone_text);
//
//        // 이젠 불러왔으니까 위에 있는 애들한데 데이터를 넣어주면 됨..(mData 에 있다!데이터는 메소드 getItem에도 있공)
//        // data
//        People people = mData.get(position); // 난 이렇게 해야지 원장님은
////        People people = (People) getItem(position); 이렇게 쓰는걸 선호한데.
//        // 이미지 텍뷰 다 넣어주자!
//        // 이미지 src 대시 셋이미지리소스로 해준다.
//        // 뿌리기
//        imageView.setImageResource(people.getPicture());
//        nameTextView.setText(people.getName());
//        phoneTextView.setText(people.getPhone());

        // 이제 분기 타서 나눠주자!! (내폰이 죽어버림...왜 그런지 모르클..ㅠㅠㅠ 리턴이 null 이라 죽음..ㅋㅋㅋㅋ covertView로 바꿔줌)

        ViewHolder holder = null;
        if (convertView == null) {
            Log.d(TAG, "getView 최초 : " + position);
            // 최초
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_exam, parent, false);
            holder = new ViewHolder();  // 홀더는 이미지 이름 폰넘버를 가지고 있는 에
            // 레이아웃 가지고 오기
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
            TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text);
            TextView phoneTextView = (TextView) convertView.findViewById(R.id.phone_text);
            holder.image = imageView;
            holder.name = nameTextView;
            holder.phone = phoneTextView;

            convertView.setTag(holder); //이 태그는 별다른 기능없이 약간에 꼬리표 붙여주는 개념? 저장개념이라고 생각하면 되려나?
            // 그래서 이걸 써줌으로써 태그 들렁오니까 재활용 할때도 이용할 수 있지.
            // 레퍼런스를 들고 있는거래....
        } else {
            Log.d(TAG, "getView 재사용 : " + position);
            //재사용
            holder = (ViewHolder) convertView.getTag();
        }

        // data  (데이터는 뭐 건들지 않았음.)
        People people = mData.get(position); // 난 이렇게 해야지 원장님은
//        People people = (People) getItem(position); 이렇게 쓰는걸 선호한데.

        // 뿌리기  (뿌릴땐 holder가 들고 있으니까 홀더로 바꿔주면 됨.
        holder.image.setImageResource(people.getPicture());
        holder.name.setText(people.getName());
        holder.phone.setText(people.getPhone());

        return convertView;
    }

     private static class ViewHolder {  //레퍼런스를 물고 있을려고 만든거래
         ImageView image;
         TextView name;
         TextView phone;
     }

}
