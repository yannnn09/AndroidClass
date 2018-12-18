package com.example.user.ch8_2;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerDialogFragment extends DialogFragment {
    Calendar dt =Calendar.getInstance();

    static TimePickerDialogFragment newInstance(){
        TimePickerDialogFragment dlg = new TimePickerDialogFragment();
        return dlg;
    }
    //當時間被選擇時被執行的監聽器事件
    TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            ((MainActivity)getActivity()).getTime(hourOfDay, minute);
        }
    };
    //生成time dialog畫面
    public Dialog onCreateDialog(Bundle savedInstanceState){
        TimePickerDialog tDialog = new TimePickerDialog(
                getActivity(),
                listener,
                dt.get(Calendar.HOUR),
                dt.get(Calendar.MINUTE),
                true
        );
        return tDialog;
    }

}
