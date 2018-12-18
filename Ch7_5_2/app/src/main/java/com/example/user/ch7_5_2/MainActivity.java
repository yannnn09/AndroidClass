package com.example.user.ch7_5_2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SecondFragment sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        FirstFragment ff = new FirstFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.add(R.id.flyt_flame, ff);
        trans.commit();
*/
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flyt_flame, ff)
                .commit();

        sf = SecondFragment.newInstance("這是第2個fragment片段");

        Button btn_replace = (Button)findViewById(R.id.btn_replace);
        btn_replace.setOnClickListener(btn_replace_listener);
        Button btn_delete = (Button)findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(btn_delete_listener);

    }

    View.OnClickListener btn_replace_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getSupportFragmentManager()             //取得fragment管理器
                    .beginTransaction()             //啟動交易
                    .replace(R.id.flyt_flame, sf)   //取代fragment片段
                    .commit();                      //確認交易
        }
    };

    View.OnClickListener btn_delete_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(sf)
                    .commit();
        }
    };
}
