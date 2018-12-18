package com.example.user.ch8_2;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditNameDialog extends DialogFragment {
    private EditText edt_name;


    public EditNameDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_name_dialog, container, false);
        getDialog().setTitle("幹你娘輸入姓名啦"); //設定Dialog的title
        edt_name = (EditText)view.findViewById(R.id.edt_name);
        edt_name.requestFocus();

        Button btn_submit = (Button)view.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(btn_submit_listener);
        // Inflate the layout for this fragment
        return view;
    }

    //"submit"按鈕監聽器
    View.OnClickListener btn_submit_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditNameDialogListener activity = (EditNameDialogListener)getActivity();
            activity.onFinishEditNameDialog(edt_name.getText().toString());
            EditNameDialog.this.dismiss(); //關掉dialog自己的畫面
        }
    };

}
