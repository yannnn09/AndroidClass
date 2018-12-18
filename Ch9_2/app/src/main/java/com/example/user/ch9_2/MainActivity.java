package com.example.user.ch9_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startSec = (Button)findViewById(R.id.btn_startSec);
        btn_startSec.setOnClickListener(btn_startSec_listener);

        Button btn_calculate = (Button)findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(btn_calculate_listener);

        Button btn_query = (Button)findViewById(R.id.btn_query);
        btn_query.setOnClickListener(btn_query_listener);

        Button btn_startThird = (Button)findViewById(R.id.btn_startThird);
        btn_startThird.setOnClickListener(btn_startThird_listener);
    }

    //region 啟動第二個活動
    View.OnClickListener btn_startSec_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    };
    //endregion

    //region 傳參數代入身高體重至第二個活動計算BMI
    View.OnClickListener btn_calculate_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText edt_height = (EditText)findViewById(R.id.edt_height);
            EditText edt_weight = (EditText)findViewById(R.id.edt_weight);
            Intent myIntent = new Intent();
            myIntent.setClass(MainActivity.this, BMIActivity.class);
            Bundle bundle = new Bundle();                                   //生成參數裝箱物件
            bundle.putString("HEIGHT", edt_height.getText().toString());    //放入身高
            bundle.putString("WEIGHT", edt_weight.getText().toString());    //放入體重
            myIntent.putExtras(bundle);                                     //將參數箱放到intent上
            startActivity(myIntent);                                        //啟動BMI活動
        }
    };
    //endregion

    //region 傳參數代入生日至第二個活動查詢星座並帶回查詢結果
    private static final int SET_HOROSCOPE = 1; //定義查詢星座的事件編號
    private EditText edt_month, edt_day;


    View.OnClickListener btn_query_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                int month, day;
                edt_month = (EditText)findViewById(R.id.edt_month);
                edt_day = (EditText)findViewById(R.id.edt_day);
                month = Integer.parseInt(edt_month.getText().toString());
                day = Integer.parseInt(edt_day.getText().toString());
                if (month < 1 || month > 12 || day < 1 || day > 31) {
                    Toast.makeText(MainActivity.this
                            , "資料範圍錯誤"
                            , Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                Intent myIntent = new Intent(MainActivity.this
                        , HoroscopeActivity.class);
                myIntent.putExtra("MONTH", month);
                myIntent.putExtra("DAY", day);
                startActivityForResult(myIntent, SET_HOROSCOPE);
            }catch (Exception e){
                Toast.makeText(MainActivity.this,
                        e.getMessage(),
                        Toast.LENGTH_LONG)
                        .show();
            }


        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);  //讓父類別的方法先執行
        switch (requestCode){
            case SET_HOROSCOPE:
                if (resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    TextView txv_queryoutput = (TextView)findViewById(R.id.txv_queryoutput);
                    txv_queryoutput.setText("生日"
                            +edt_month.getText()
                            +"月"
                            +edt_day.getText()
                            +"日\n星座:"
                            +bundle.getString("HOROSCOPE"));
                }
                break;
        }
    }
    //endregion

    //region 使用別名呼叫第三個活動頁
    View.OnClickListener btn_startThird_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent("ch09.ch9_2.ThirdActivity"));
        }
    };
    //endregion
}
