package com.example.user.ch7_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    private TextView op, touchop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op = findViewById(R.id.txv_op);
        Button btn_lc = findViewById(R.id.btn_lc);
        btn_lc.setOnClickListener(this); //自己(類別本身)，監聽器綁在自己身上就好
        btn_lc.setOnLongClickListener(this);


        touchop = findViewById(R.id.txv_touchop);
        FrameLayout frm_1 = findViewById(R.id.frm_1);
        frm_1.setOnTouchListener(this);
        frm_1.setOnClickListener(this);

        Button btn_touch = findViewById(R.id.btn_touch);
        btn_touch.setOnClickListener(this);
    }

    public boolean onLongClick(View v){
        op.setText("觸發LongClick事件");
        return true;
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_lc:
                op.setText("觸發click事件");
                break;
            case R.id.btn_touch:
                touchop.setText("Touch Button Click");
                touchop.setTextColor(Color.BLACK);
                break;
            case R.id.frm_1:
                touchop.setTextColor(Color.BLUE);
                break;
        }
    }

    public boolean onKeyDown(int KeyCode, KeyEvent event){
        if (KeyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this,"按下KeyCode_BACK鍵...",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    };

    public boolean onKeyUp(int KeyCode, KeyEvent event){
        op.setText("按下KeyCode按鍵碼:"+ KeyCode);
        return super.onKeyUp(KeyCode, event);
    }

    public boolean onTouch(View v, MotionEvent event){
        if (v.getId() != R.id.frm_1) return false;
        int act = event.getAction();
        switch(act){
            case MotionEvent.ACTION_DOWN:
                touchop.setText("ACTION_DOWN");
                touchop.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_UP:
                touchop.setText("ACTION_UP");
                touchop.setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_MOVE:
                float evt_x = event.getX();
                float evt_y = event.getY();
                int v_w = v.getWidth();
                int v_h = v.getHeight();
                touchop.setText("evt_x="+evt_x+"\nevt_y="+evt_y+"\nw="+v_w+"\nh="+v_h);
                if (evt_x>=0 && evt_x<=v_w && evt_y>=0 && evt_y<=v_h){
                    touchop.setTextColor(Color.RED);
                }else{
                    touchop.setTextColor(Color.GREEN);
                }
                break;
        }
        return false;
    }
}
