package com.example.thunder.myapplication.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.thunder.myapplication.R;

/**
 * Created by Thunder on 2017-08-14.
 */

public class DialogUtil {
    public static AlertDialog createAlertdialog(Context context, DialogInterface.OnClickListener listener) {
        // 물어보자 AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("삭제");
        builder.setMessage("정말로 삭제하시겠습니까?");
//                builder.setAdapter(); 셋어뎁터가 된다는 것은 리스트뷰를 사용할 수 있다는 거겠지?
        // 바깥 부분 클릭 했을 때 닫기
        builder.setCancelable(false); //해버리면 밖에 클릭해도 대화상자 사라지지 않음!

        //\\\\\\\\\\\\\\\\\\\\\\\\\\\\==>
        builder.setIcon(R.drawable.beach2); // 화면에 이렇게 하면 아이콘사이즈로 들어감!
        //그런데 아니오 예 방향을 바꾸고 싶어.. 이건 버전마다 위치가 다른거거든.. 그래서 바꿀려고 하면
        //머리 아픈뎅.. 그럼 분기를 타서 몇버전에선 위치 바꿔주고 어떤버전에서 그냥 하는 걸 만들어줘야해,
        //그건 이런 상황이 나오면 어떻게 하는지 알려드릴게요~
        builder.setPositiveButton("예", listener);
        builder.setNegativeButton("아니오", listener);

        return builder.create();
    }
}
