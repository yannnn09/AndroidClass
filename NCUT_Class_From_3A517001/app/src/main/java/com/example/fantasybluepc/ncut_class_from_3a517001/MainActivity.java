package com.example.fantasybluepc.ncut_class_from_3a517001;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txv_total;
    private EditText edt_adult, edt_student, edt_sale;
    private CheckBox chb_adult,chb_student,chb_sale;
    private RadioGroup radioGroup;
    private RadioButton rdb_ironman, rdb_batman;
    int adult_quantity, student_quantity, sale_quantity;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rdb_batman = (RadioButton) findViewById(R.id.rdb_batman);
        rdb_ironman = (RadioButton) findViewById(R.id.rdb_ironman);

        txv_total = (TextView) findViewById(R.id.txv_total);

        edt_adult = (EditText) findViewById(R.id.edt_adult);
        edt_student = (EditText) findViewById(R.id.edt_student);
        edt_sale = (EditText) findViewById(R.id.edt_sale);

        adult_quantity = Integer.parseInt(edt_adult.getText().toString());
        student_quantity = Integer.parseInt(edt_student.getText().toString());
        sale_quantity = Integer.parseInt(edt_sale.getText().toString());

        chb_adult = (CheckBox) findViewById(R.id.chb_adult);
        chb_student = (CheckBox) findViewById(R.id.chb_student);
        chb_sale = (CheckBox) findViewById(R.id.chb_sale);

        radioGroup.setOnCheckedChangeListener(radio_listener);

        chb_adult.setOnCheckedChangeListener(chk_listener);
        chb_student.setOnCheckedChangeListener(chk_listener);
        chb_sale.setOnCheckedChangeListener(chk_listener);

    }



   private RadioGroup.OnCheckedChangeListener radio_listener = new
            RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == rdb_ironman.getId()){
                        msg = "";
                        msg = "您購票的資訊如下:\n";
                        msg += rdb_ironman.getText() + "\n" ;
                        txv_total.setText(msg);
                    }else{
                        msg = "";
                        msg = "您購票的資訊如下:\n";
                        msg += rdb_batman.getText() + "\n" ;
                        txv_total.setText(msg);
                    }
                }
            };

    CompoundButton.OnCheckedChangeListener chk_listener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Toast.makeText(
                            MainActivity.this,
                            "已修改",
                            Toast.LENGTH_SHORT).show();
                    movie();
                }
            };



    private void movie(){

        adult_quantity = Integer.parseInt(edt_adult.getText().toString());
        student_quantity = Integer.parseInt(edt_student.getText().toString());
        sale_quantity = Integer.parseInt(edt_sale.getText().toString());

        if(chb_adult.isChecked()){
            long mon1 = Math.round(280 * adult_quantity);
            msg += "成人票共" + adult_quantity + "張";
            msg += mon1 + "\n";
        }
        if(chb_student.isChecked()){
            long mon2 = Math.round(250 * student_quantity);
            msg += "學生票共" + student_quantity + "張";
            msg += mon2 + "\n";
        }
        if(chb_sale.isChecked()){
            long mon3 = Math.round(200* sale_quantity);
            msg += "優惠票共" + sale_quantity + "張";
            msg += mon3 + "\n";
        }

        txv_total.setText(msg);
    }
}

