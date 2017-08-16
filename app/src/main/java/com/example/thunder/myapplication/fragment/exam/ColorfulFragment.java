package com.example.thunder.myapplication.fragment.exam;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thunder.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorfulFragment extends Fragment {private TextView mTextView;

    public ColorfulFragment() {
        // Required empty public constructor
    }

//    public static ColorfulFragment newInstance(int color) {
//
//        Bundle args = new Bundle();
//        args.putInt("color", color);
//
//        ColorfulFragment fragment = new ColorfulFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    public static ColorfulFragment newInstance(int color,String text) {

        Bundle args = new Bundle();
        args.putInt("color", color);
        args.putString("text",text);

        ColorfulFragment fragment = new ColorfulFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_colorful, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = (TextView) view.findViewById(R.id.fragment_text);  // 이걸 안해서 힘듦..ㅠㅠ

        int color = getArguments().getInt("color");
        String text = getArguments().getString("text");

        view.setBackgroundColor(color);
//        view.findViewById()
//        view.setBackground(text);

        mTextView.setText(text);  // 흑흑 너무 어려웡...
    }

}
