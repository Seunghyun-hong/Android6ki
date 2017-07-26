package com.example.thunder.myapplication.adapterviewexam;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thunder.myapplication.R;

import java.util.List;

/**
 * Created by Thunder on 2017-07-26.
 */

public class PositionAdapter extends BaseAdapter {
    private final List<Position> mData;  //실제 데이터를 받아온다
    private final Context mContext;

//    데이터를 받는 방법이 없어서 생성자를 만들어서 데이터를 받자!


    public PositionAdapter(Context context, List<Position> data) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            // 최초
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_colorful_exam, parent, false);
            holder = new ViewHolder();
            // 레이아웃 가지고 오기
            TextView positionTextView = (TextView) convertView.findViewById(R.id.position_text);
            holder.position = positionTextView;

            convertView.setTag(holder); //이 태그는 별다른 기능없이 약간에 꼬리표 붙여주는 개념? 저장개념이라고 생각하면 되려나?
            // 그래서 이걸 써줌으로써 태그 들렁오니까 재활용 할때도 이용할 수 있지.
        } else {
            //재사용
            holder = (ViewHolder) convertView.getTag();
        }

        // data  (데이터는 뭐 건들지 않았음.)
        Position position1 = mData.get(position); // 난 이렇게 해야지 원장님은
//        People people = (People) getItem(position); 이렇게 쓰는걸 선호한데.

        // 뿌리기  (뿌릴땐 holder가 들고 있으니까 홀더로 바꿔주면 됨.

        if (position == 0) {
            convertView.setBackgroundColor(Color.BLACK);
        } else if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.BLUE);
        } else {
            convertView.setBackgroundColor(Color.RED);
        }

//        convertView.setBackgroundColor(Color.BLACK);
        holder.position.setText(position1.getPosition());

        return convertView;
    }

    private static class ViewHolder {
        TextView position;

    }

}
