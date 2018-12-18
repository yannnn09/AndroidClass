package com.example.user.ch10_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences prefs = getSharedPreferences("Mypref", MODE_PRIVATE);
        String str = prefs.getString("USD", "1000");

        TextView txv_USD = (TextView)findViewById(R.id.txv_USD);
        txv_USD.setText(str);

    }
}
