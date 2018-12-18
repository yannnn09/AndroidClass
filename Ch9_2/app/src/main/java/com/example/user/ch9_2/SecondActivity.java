package com.example.user.ch9_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn_closeSec = (Button)findViewById(R.id.btn_closeSec);
        btn_closeSec.setOnClickListener(btn_closeSec_listener);
    }

    View.OnClickListener btn_closeSec_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
