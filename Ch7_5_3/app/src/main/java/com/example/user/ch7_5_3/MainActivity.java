package com.example.user.ch7_5_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BMIListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(double bmi){
        TextFragment tf = (TextFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frg_text);
        tf.changeBMIValue(bmi);
    }
}
