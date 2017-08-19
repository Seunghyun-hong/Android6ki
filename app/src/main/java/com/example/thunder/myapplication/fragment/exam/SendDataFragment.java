package com.example.thunder.myapplication.fragment.exam;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thunder.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendDataFragment extends Fragment {


    private String mData;

    public interface SendData {
        void onSandData(String text);
    }

    private EditText mDataEditText;
    private TextView mColorTextView;

    // 요놈이 이제 액티비티가 되는거지!
    private SendData mSendDataListener;

    public SendDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SendData) {
            mSendDataListener = (SendData) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "SendData 를 구현해 주세요");
        }
    }

    // 뷰를 만드는 곳
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_data, container, false);
    }

    // 뷰가 다 만들어 진 다음 호출되는 곳
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDataEditText = (EditText) view.findViewById(R.id.send_Activity_edit_text);
        mColorTextView = (TextView) view.findViewById(R.id.color_text);
        mData = mDataEditText.getText().toString();

        // ★★★★★★ 버튼을 누르면 데이터를 액티비티로 보내고 싶어.
        getView().findViewById(R.id.send_data_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSendDataListener.onSandData(mDataEditText.getText().toString());
            }
        });
        //★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    }

    // 이건 결국 안씀 ㅋㅋㅋㅋ
//    void sendData(String data) {
//        getView().setBackgroundColor(Color.GREEN);
//    }

    // 텍스트 뷰어를 가져오는 메소드를 만들자
    void getTextview(String data) {
        mColorTextView.setText(data);
    }
}
