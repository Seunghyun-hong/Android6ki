package com.example.thunder.myapplication.fragment.basketball;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thunder.myapplication.R;

/**
 * Created by Thunder on 2017-08-15.
 */

public class BasketScoreFragment extends Fragment implements View.OnClickListener {

    public interface OnWarningListener {
        void onWarning(String teamName);
    }

    @Override
    public void onAttach(Context context) {
                        //이 컨텍스트(레퍼런스)는 이 프래그먼트와 실제로 붙는 액티비티의 컨텍스트
        //어찌보면 이 컨텍스트가 액티비티라고 할 수 있지.
        super.onAttach(context);

        // 액티비티와 연결 됨!
        mListener = (OnWarningListener) context;
    }

    private TextView mScoreTextView;
    private TextView mTeamNameTextView;
    private int mScore;

    private OnWarningListener mListener;

    //뷰를 만드는 곳
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basket_score, container, false);
    }

    // 뷰가 다 만들어 진 다음 호출되는 곳
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScoreTextView = (TextView) view.findViewById(R.id.point_text);
        mTeamNameTextView = (TextView) view.findViewById(R.id.team_name_text);
        view.findViewById(R.id.plus3_button).setOnClickListener(this);
        view.findViewById(R.id.plus2_button).setOnClickListener(this);
        view.findViewById(R.id.plus1_button).setOnClickListener(this);

        //복원
        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("score");
            mTeamNameTextView.setText("" + mScore);
        }
    }

    // 회전할때 저장
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("score", mScore);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus3_button:
                mScore += 3;
                break;
            case R.id.plus2_button:
                mScore += 2;
                break;
            case R.id.plus1_button:
                mScore++;
                break;
        }
        if(mScore > 20) {
            mListener.onWarning(mTeamNameTextView.getText().toString());
        }
        mScoreTextView.setText("" + mScore);
    }

    // 리셋기능추가
    public void reset() {
        mScore = 0;
        mScoreTextView.setText("" + mScore);
    }

    // 팀이름 변경기능 추가
    public void setTeamName(String name) {
        mTeamNameTextView.setText(name);
    }

    // 빨갛게 되는 거 추가
    public void warning() {
        getView().setBackgroundColor(Color.RED);
    }

}
