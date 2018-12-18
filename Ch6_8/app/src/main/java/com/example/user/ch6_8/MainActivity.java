package com.example.user.ch6_8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double[] energyRate = {3.1, 4.4, 13.2, 9.7, 5.1, 3.7};//6個元素的索引值
    EditText edt_weight, edt_time;
    TextView txv_rate, txv_op;
    Spinner spn_sports;
    Button btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_weight = (EditText)findViewById(R.id.edt_weight);
        edt_time = (EditText)findViewById(R.id.edt_time);
        txv_rate = (TextView)findViewById(R.id.txv_rate);
        txv_op = (TextView)findViewById(R.id.txv_op);
        spn_sports = (Spinner)findViewById(R.id.spn_sports);
        btn_calculate = (Button)findViewById(R.id.btn_calculate);

        spn_sports.setOnItemSelectedListener(selectedListener);
        btn_calculate.setOnClickListener(clickListener);
    }

    AdapterView.OnItemSelectedListener selectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            txv_rate.setText(String.valueOf(energyRate[position]));//會把選到的項目回丟(0~5,共6個)
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) { }
    };

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double w = Double.parseDouble(edt_weight.getText().toString());
            double h = Double.parseDouble(edt_time.getText().toString());
            int selected = spn_sports.getSelectedItemPosition();
            long consuedEnergy = Math.round(energyRate[selected]*w*h);
            txv_op.setText(String.format("消耗熱量\n %d仟卡",consuedEnergy));
        }
    };
}
