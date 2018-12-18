package com.example.user.ch8_2;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends DialogFragment {
    //產生動態title的mydialog物件
    static MyDialog newInstance(String title){
        MyDialog dlg = new MyDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        dlg.setArguments(args);
        return dlg;
    }

    //Dialog內"confirm"按鈕監聽器
    DialogInterface.OnClickListener PB_listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //執行主畫面的doPositiveClick()方法
            ((MainActivity)getActivity()).doPositiveClick();
        }
    };
    //Dialog內"cancel"按鈕監聽器
    DialogInterface.OnClickListener NB_listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //執行主畫面的doNegativeClick()方法
            ((MainActivity)getActivity()).doNagativeClick();
        }
    };
    //onCreateDialog
    public Dialog onCreateDialog(Bundle savedInstanceState){
        String title = getArguments().getString("title");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage("確定結束本程式")
                .setPositiveButton("confirm", PB_listener)
                .setNegativeButton("cancel", NB_listener);
        return builder.create();
    }


/*
    public MyDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog, container, false);
    }

*/
}
