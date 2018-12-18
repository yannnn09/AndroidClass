package com.example.user.ch7_5_2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private  static final String MESSAGE = "MESSAGE" ;  //建立常數，final是指變數不能被修改
    private  String msg;

    public  static SecondFragment newInstance(String msg) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(MESSAGE, msg);
        fragment.setArguments(args);
        return fragment;
    }


    public SecondFragment() {
        // Required empty public constructor
    }

    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() !=null){
            msg = getArguments().getString(MESSAGE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second
                , container, false);  //主畫面生成片段
        TextView txv_op = (TextView)view.findViewById(R.id.txv_op);  //用片段的view來找ID
        txv_op.setText(msg);
        // Inflate the layout for this fragment
        return view;
    }

}
