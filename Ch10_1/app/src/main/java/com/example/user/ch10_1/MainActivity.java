package com.example.user.ch10_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String PREF_AMOUNT = "AMOUNT";
    private static final String PREF_RATE = "RATE";
    private EditText edt_amount, edt_rate;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_amount = (EditText)findViewById(R.id.edt_amount);
        edt_rate = (EditText)findViewById(R.id.edt_rate);
        prefs = getPreferences(MODE_PRIVATE);

        Button btn_change = (Button)findViewById(R.id.btn_change);
        btn_change.setOnClickListener(btn_change_listener);
        Button btn_second = (Button)findViewById(R.id.btn_second);
        btn_second.setOnClickListener(btn_second_listener);
    }

    //region 暫停app的MainActivity時執行
    protected void onPause(){
        super.onPause();
        try{
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putString(PREF_AMOUNT, edt_amount.getText().toString());
            float rate = (float)Double.parseDouble(edt_rate.getText().toString());
            prefEdit.putFloat(PREF_RATE, rate);
            prefEdit.apply();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }
    //endregion

    //region 重新回到app的MainActivity時執行
    protected void onResume(){
        super.onResume();
        String amount = prefs.getString(PREF_AMOUNT, "10000");
        edt_amount.setText(amount);
        float rate = prefs.getFloat(PREF_RATE, 31.5f);
        edt_rate.setText(String.valueOf(rate));
    }
    //endregion

    //region  匯率轉換按鈕事件
    View.OnClickListener btn_change_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double amount, rate, result;
            try {
                amount = Double.parseDouble(edt_amount.getText().toString());
                rate = Double.parseDouble(edt_rate.getText().toString());
                result = amount / rate;
                TextView txv_result = (TextView) findViewById(R.id.txv_result);
                txv_result.setText("美金：" + Double.toString(result));
            }catch (Exception e){
                Toast.makeText(MainActivity.this,
                        e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
    //endregion

    View.OnClickListener btn_second_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences shareprefs = getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor prefEdit = shareprefs.edit();
            TextView txv_result = (TextView)findViewById(R.id.txv_result);
            prefEdit.putString("USD", txv_result.getText().toString());
            prefEdit.apply();

            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        }
    };
}
