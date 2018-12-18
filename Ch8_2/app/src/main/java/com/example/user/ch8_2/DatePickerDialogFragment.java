package com.example.user.ch8_2;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerDialogFragment extends DialogFragment {
    Calendar dt = Calendar.getInstance();

    static DatePickerDialogFragment newInstance(){
        DatePickerDialogFragment dlg =new DatePickerDialogFragment();
        return dlg;
    }
    //當點及日期時觸發的監聽器
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ((MainActivity)getActivity()).getDate(year, month, dayOfMonth);
        }
    };
    //生成dialog畫面
    public Dialog onCreateDialog(Bundle saveInstanceState){
        DatePickerDialog dDialog = new DatePickerDialog(
                getActivity(),                      //在那個畫面出現
                listener,                           //日期被選擇的事件
                dt.get(Calendar.YEAR),              //目前的年
                dt.get(Calendar.MONTH),             //目前的月
                dt.get(Calendar.DAY_OF_MONTH)       //目前的日
        );
        return dDialog;
    }
}
