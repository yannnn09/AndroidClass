package com.example.user.ch8_2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EditNameDialogListener{
    //多選對話方塊屬性
    private String[] multi_items = {"Samsung", "HTC", "Apple", "A5U5"};
    private boolean[] multi_items_checked = new boolean[multi_items.length];

    //進度條對話方塊屬性
    private ProgessDialogFragment progressDlg;
    private int p=0;           //初始進度設定為0
    private Handler pHandler; //背景的進度處理程序


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //關於對話方塊按鈕綁定
        Button btn_about = (Button)findViewById(R.id.btn_about);
        btn_about.setOnClickListener(btn_about_listener);
        //確認對話方塊按鈕綁定
        Button btn_confirm = (Button)findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(btn_confirm_listener);
        //單選對話方塊按鈕綁定
        Button btn_single = (Button)findViewById(R.id.btn_single);
        btn_single.setOnClickListener(btn_single_listener);
        //複選對話方塊按鈕綁定
        Button btn_multi = (Button)findViewById(R.id.btn_multi);
        btn_multi.setOnClickListener(btn_multi_listener);
        //fragment建立對話方快按鈕綁定
        Button btn_fragment = (Button)findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(btn_fragment_listener);
        //fragment建立互動對話方塊綁定
        Button btn_fragment_hello = (Button)findViewById(R.id.btn_fragment_hello);
        btn_fragment_hello.setOnClickListener(btn_fragment_hello_listener);
        //進度條對話方塊按鈕綁定
        PHandler_initial();
        Button btn_progress = (Button)findViewById(R.id.btn_progess);
        btn_progress.setOnClickListener(btn_progress_listener);
        //日期選擇對話方塊按鈕綁定
        Button btn_datepicker = (Button)findViewById(R.id.btn_datepicker);
        btn_datepicker.setOnClickListener(btn_datepicker_listener);
        //時間選擇對話方塊按鈕綁定
        Button btn_timepicker = (Button)findViewById(R.id.btn_timepicker);
        btn_timepicker.setOnClickListener(btn_timepicker_listener);
    }

    //region 關於對話方塊事件
    View.OnClickListener btn_about_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("關於")
                    .setMessage("版本:7.0\n作者:陳小明")
                    .setPositiveButton("確定", null)
                    .show();
        }
    };
    //endregion

    //region 確認對話方塊事件
    //對話方塊-確定按鈕事件
    DialogInterface.OnClickListener btn_confirm_PB_listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();   //關閉程式
        }
    };

    View.OnClickListener btn_confirm_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("確認")
                    .setMessage("確認結束本程式?")
                    .setPositiveButton("確定", btn_confirm_PB_listener)
                    .setNegativeButton("取消", null)
                    .show();
        }
    };
    //endregion

    //region 單選對話方塊事件
    //對話方塊內-單選項目點擊事件
    DialogInterface.OnClickListener btn_single_choose_listener =
            new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Button btn = (Button)findViewById(R.id.btn_single);
            switch (which){
                case 0:
                    btn.setBackgroundColor(Color.RED);
                    break;
                case 1:
                    btn.setBackgroundColor(Color.YELLOW);
                    break;
                case 2:
                    btn.setBackgroundColor(Color.GREEN);
                    break;
            }
        }
    };
    View.OnClickListener btn_single_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] options = {"RED", "YELLOW", "GREEN" };
            AlertDialog.Builder builder = new
                    AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Choose a color")
                    .setItems(options, btn_single_choose_listener)
                    .setNegativeButton("cancel", null)
                    .show();
        }
    };
    //endregion

    //region複選對話方塊事件
    //對話方塊內 -多選項目點擊事件
    DialogInterface.OnMultiChoiceClickListener btn_multi_choose_listener =
            new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                    Toast.makeText(MainActivity.this,
                            multi_items[which]+(isChecked? "勾選":"沒有勾選"),
                            Toast.LENGTH_LONG).show();

                }
    };
    //對話方塊內 -確定按鈕點擊事件
    DialogInterface.OnClickListener btn_multi_PB_listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            String msg = "";
            for (int index = 0; index<multi_items.length; index++){
                if (multi_items_checked[index]){
                    msg += multi_items[index]+"\n";
                }
            }
            TextView txv_multiop = (TextView)findViewById(R.id.txv_multiop);
            txv_multiop.setText(msg);
        }
    };
    //主畫面按鈕多選對話方塊按鈕點擊事件
    View.OnClickListener btn_multi_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("please check items")
                    .setPositiveButton("confirm", btn_multi_PB_listener)
                    .setNegativeButton("cancel", null)
                    .setMultiChoiceItems(multi_items, multi_items_checked, btn_multi_choose_listener)
                    .show();
        }
    };
    //endregion

    //region Fragmemt建立對話方塊事件
    //"confirm"按鈕間接執行事件
    public void doPositiveClick(){
        Toast.makeText(MainActivity.this, "press the confirm button",
                Toast.LENGTH_LONG).show();
        finish();
    }
    //"cancel"按鈕間接執行事件
    public void doNagativeClick(){
        Toast.makeText(MainActivity.this, "press the cancel button",
                Toast.LENGTH_LONG).show();
    }

    View.OnClickListener btn_fragment_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MyDialog dlg = MyDialog.newInstance("確認對話方塊"); //生成對話方塊
                FragmentManager fm = getSupportFragmentManager(); //建立片段管理器
                dlg.show(fm, "confirmdialog"); //請片段管理器叫出對話方塊的畫面
            }
        };
    //endregion

    //region Fragment 建立互動對話方塊事件
    public void onFinishEditNameDialog(String inputText){
        Toast.makeText(MainActivity.this, "您好!"+inputText, Toast.LENGTH_LONG).show();
    }

    View.OnClickListener btn_fragment_hello_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            EditNameDialog editName = new EditNameDialog();
            editName.show(fm, "EditNameDialog");
        }
    };
    //endregion

    //region 進度條對話方塊事件
    //進度條背景程序初始化
    public void PHandler_initial(){
        pHandler = new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                if (p >= 100){    //若進度完成
                    progressDlg.dismiss();  //關掉進度條對話方塊
                    TextView txv_progress = (TextView)findViewById(R.id.txv_progress);
                    txv_progress.setText("download complete");
                }else{  //若進度未完成
                    p++;
                    progressDlg.updateProgress(); //更新進度條
                    pHandler.sendEmptyMessageDelayed(0, 50); //設定更新頻率為50ms
                }
            }
        };
    }

    //"隱藏"按鈕事件
    public void doPositiveClick_Progress(){
        Toast.makeText(MainActivity.this,
                "隱藏下載對話方塊",
                Toast.LENGTH_LONG
        ).show();
    }
    //"取消"按鈕事件
    public void doNegativeClick_Progress(){
        Toast.makeText(MainActivity.this,
                "取消下載對話方塊",
                Toast.LENGTH_LONG
        ).show();
    }
    //進度條對話方塊按鈕點擊事件
    View.OnClickListener btn_progress_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progressDlg = ProgessDialogFragment.newInstance("download file");
            FragmentManager fm = getSupportFragmentManager();
            progressDlg.show(fm, "progressdialog");
            p = 0;  //設定進度條的初始值
            pHandler.sendEmptyMessage(0);  //設定背景承旭初始延遲
        }
    };
    //endregion

    //region 日期選得對話方塊事件

    public void getDate(int year, int monthofYear, int dayofMonth){
        TextView txv_date = (TextView)findViewById(R.id.txv_date);
        txv_date.setText(
                Integer.toString(year)+"/"
                +Integer.toString(monthofYear+1)+"/"
                +Integer.toString(dayofMonth));
    }
    View.OnClickListener btn_datepicker_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatePickerDialogFragment dlg = DatePickerDialogFragment.newInstance();
            FragmentManager fm = getSupportFragmentManager();
            dlg.show(fm, "datepickerdialog");
        }
    };
    //endregion

    //region 時間選擇對話方塊事件
    public void getTime(int hourOfDay, int minute){
        TextView txv_time = (TextView)findViewById(R.id.txv_time);
        txv_time.setText(Integer.toString(hourOfDay)+":"+Integer.toString(minute));
    }
    View.OnClickListener btn_timepicker_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TimePickerDialogFragment dlg = TimePickerDialogFragment.newInstance();
            FragmentManager fm = getSupportFragmentManager();
            dlg.show(fm, "timepickerdialog");
        }
    };
    //endregion
}
