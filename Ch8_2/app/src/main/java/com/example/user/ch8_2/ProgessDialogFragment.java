package com.example.user.ch8_2;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgessDialogFragment extends DialogFragment {
    private ProgressDialog pDialog; //Android內建進度條對話方塊類別
    //建立進度條對話方塊的靜態方法
    static ProgessDialogFragment newInstance(String title){
        ProgessDialogFragment dlg = new ProgessDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        dlg.setArguments(args);
        return dlg;
    }
    //"隱藏"按鈕點擊事件
    DialogInterface.OnClickListener PB_listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            ((MainActivity)getActivity()).doPositiveClick_Progress();
        }
    };
    //"取消"按鈕點擊事件
    DialogInterface.OnClickListener NB_listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            ((MainActivity)getActivity()).doNegativeClick_Progress();
        }
    };
    //Dialog建立方法
    public Dialog onCreateDialog(Bundle savedInstanceState){
        String title = getArguments().getString("title");
        pDialog = new ProgressDialog(getActivity());
        pDialog.setTitle(title);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //進度條的類型
        pDialog.setProgress(0); //進度條的初始值
        pDialog.setButton(DialogInterface.BUTTON_POSITIVE, "隱藏", PB_listener);
        pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", NB_listener);
        return pDialog;
    }

    public void updateProgress(){
        pDialog.incrementProgressBy(1); //進度條每次增加的數量
    }
}
