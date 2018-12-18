package com.example.user.ch7_5_3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {
    private TextView txv1;


    public TextFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        txv1 = (TextView)view.findViewById(R.id.txv1);
        // Inflate the layout for this fragment
        return view;
    }

    public void changeBMIValue(double bmi){
        txv1.setText(Double.toString(bmi));
    }

}
