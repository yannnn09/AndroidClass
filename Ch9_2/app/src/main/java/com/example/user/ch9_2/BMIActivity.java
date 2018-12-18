package com.example.user.ch9_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        displayBMI();
        Button btn_return = (Button)findViewById(R.id.btn_return);
        btn_return.setOnClickListener(btn_return_listener);
    }

    private void displayBMI(){
        double height, weight, bmi;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null){
            TextView txv_bmi = (TextView)findViewById(R.id.txv_bmi);
            try{
                height = Double.parseDouble(bundle.getString("HEIGHT"));
                weight = Double.parseDouble(bundle.getString("WEIGHT"));
                height = height/100.00;
                bmi = weight / (height*height);
                txv_bmi.setText("BMI："+bmi);
            }catch (Exception e){
                txv_bmi.setText(e.getMessage());
            }
        }
    }

    View.OnClickListener btn_return_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
