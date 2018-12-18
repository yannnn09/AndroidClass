package com.example.user.ch7_5_3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BMIFragment extends Fragment {
    private EditText edt_weight, edt_height;
    BMIListener activityCallback;

    //將MainActivity放到 activityCallBack並檢測 mainactivity是否有實作BMIlistener介面
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityCallback = (BMIListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "需實作BMIListener");
        }
    }

    public BMIFragment() {
        // Required empty public constructor
    }

    View.OnClickListener btn_calculate_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double height, weight, bmi;
            height = Double.parseDouble(edt_height.getText().toString());
            weight = Double.parseDouble(edt_weight.getText().toString());
            height = height/100.00;
            bmi = weight/(Math.pow(height,2));
            activityCallback.onButtonClick(bmi); //activityCallBack 就是 MainActivity
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_bmi, container, false);
        edt_height = (EditText)view.findViewById(R.id.edt_height);
        edt_weight = (EditText)view.findViewById(R.id.edt_weight);
        Button btn_calculate = (Button)view.findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(btn_calculate_listener);
        // Inflate the layout for this fragment
        return view;
    }

}
