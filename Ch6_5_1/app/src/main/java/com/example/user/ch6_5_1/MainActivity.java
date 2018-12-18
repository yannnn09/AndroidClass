package com.example.user.ch6_5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chk_original,chk_seafood,chk_beef;
    private void c(){
        int amount = 0;
        int quantity = 0;
        EditText edt_num = (EditText)findViewById(R.id.edt_num);//綁定輸入框
        quantity = Integer.parseInt(edt_num.getText().toString());//取得數量(確保取得的都是字串，再轉成數字)
        if (chk_original.isChecked()){
            amount += 250*quantity;
        }
        if (chk_beef.isChecked()) {
            amount += 275 * quantity;
        }
        if (chk_seafood.isChecked()){
            amount += 350*quantity;
        }
        TextView txv_output = (TextView)findViewById(R.id.txv_Output);
        txv_output.setText(Integer.toString(amount));//數字先轉成字串再給setText
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //設定事件綁定
        Button btn_calculate = (Button)findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(btn_listener);

        CheckBox chk_original = (CheckBox)findViewById(R.id.chk_original);
        chk_original.setOnCheckedChangeListener(chk_changelistener);
    }

    View.OnClickListener btn_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            c();
        }

    };
    CompoundButton.OnCheckedChangeListener chk_changelistener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Toast.makeText(
                            MainActivity.this,
                            "checkedChange",
                            Toast.LENGTH_SHORT).show();
                }
            };

}
