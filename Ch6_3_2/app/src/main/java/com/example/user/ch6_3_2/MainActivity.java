package com.example.user.ch6_3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton imgBtn1, imgBtn2, imgBtn3;
    private int[] pp = new int[4];
    private int  num1,num2,num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pp[0] = R.drawable.d13;
        pp[1] = R.drawable.d8;
        pp[2] = R.drawable.h7;
        pp[3] = R.drawable.h11;

        imgBtn1 = (ImageButton)findViewById(R.id.imgbtn_1);
        imgBtn1.setOnClickListener(imgbtn1Listener);

        imgBtn2 = (ImageButton)findViewById(R.id.imgbtn_2);
        imgBtn2.setOnClickListener(imgbtn2Listener);

        imgBtn3 = (ImageButton)findViewById(R.id.imgbtn_3);
        imgBtn3.setOnClickListener(imgbtn3Listener);
    }

    View.OnClickListener imgbtn1Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            num1 = (int)(Math.random()*4);
            imgBtn1.setImageResource(pp[num1]);
        }
    };

    View.OnClickListener imgbtn2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num2 = (int)(Math.random()*3);
            imgBtn2.setImageResource(R.drawable.d8);
        }
    };

    View.OnClickListener imgbtn3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num3 = (int)(Math.random()*3);
            imgBtn3.setImageResource(R.drawable.h7);
        }
    };
}
