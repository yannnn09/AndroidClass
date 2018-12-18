package com.example.user.ch6_3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn_1);
        btn1.setOnClickListener(btn1Listener);
        Button btn2 = (Button)findViewById(R.id.btn_2);
        btn2.setOnClickListener(btn2Listener);
    }

    View.OnClickListener btn1Listener = new View.OnClickListener(){
        public void onClick(View v) {
            num1 = (int)(Math.random()*12)+1;
            Toast.makeText(
                     MainActivity.this,
                    Integer.toString(num1),
                    Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener btn2Listener = new View.OnClickListener(){
        public void onClick(View v) {
            num2 = (int)(Math.random()*12)+1;
            Toast.makeText(
                     MainActivity.this,
                    Integer.toString(num2),
                    Toast.LENGTH_SHORT).show();

        }
    };
}


