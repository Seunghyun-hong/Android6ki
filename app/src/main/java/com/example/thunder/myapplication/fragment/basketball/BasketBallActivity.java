package com.example.thunder.myapplication.fragment.basketball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.thunder.myapplication.R;

public class BasketBallActivity extends AppCompatActivity implements BasketScoreFragment.OnWarningListener {

    private BasketScoreFragment mATeamFragment;
    private BasketScoreFragment mBTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_ball);

        mATeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_a);
        mBTeamFragment = (BasketScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_b);

        mBTeamFragment.setTeamName("Team B");
    }


    public void resetButtonClicked(View view) {
        mATeamFragment.reset();
        mBTeamFragment.reset();
    }

    // 우선 여기서 온워닝을 알 수 있게 되었어!!!
    @Override
    public void onWarning(String teamName) {
        Toast.makeText(this, "경고" + teamName, Toast.LENGTH_SHORT).show();
        if(teamName.equals("Team A")) {
            mBTeamFragment.warning();
        } else {
            mATeamFragment.warning();
        }
    }
}
