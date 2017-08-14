package com.example.thunder.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Thunder on 2017-08-14.
 */

public class SharePreferenceUtil {
    public static void saveWeather(Context context, String weather) {
        // 뒤로 가기전에 저장!
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("weather", weather);

        // Commit the edits!  반영할때
        editor.apply();
        //커밋은 어플라이생기기 전에 쓰던거..
        // 커밋은 동기고 (싱크를 맞추면서 간다)-ex) 복사좀 해줘~ 복사할때까지 가만히...
        // 어플라이는 비동기 -복사해줭~ 하면서 나는 다른것도 하는...그런거.
        // 나중에 뒷부분 가서 자세히 다룬데
    }

    public static String restoreWeather(Context context) {
        // SharedPreference 데이터 복원
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        //원래 여기엔 아무것도 존재하지 않는데... 그래서 디폴드 값을 초기값을 줘서 만들어주는거래.
        return settings.getString("weather", "맑음");
    }
}
