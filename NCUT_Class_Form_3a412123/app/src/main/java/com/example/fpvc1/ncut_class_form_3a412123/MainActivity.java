package com.example.fpvc1.ncut_class_form_3a412123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener{
    private RadioButton rb1,rb2;
    RadioGroup rg;
    TextView tv1,tv2,tv3,tv4;
    CheckBox cb1,cb2,cb3;
    EditText ed1,ed2,ed3;
    String text1,text2,text3;
    int sum1,sum2,sum3;
    String MovieSelectString = "請購票" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rg = findViewById(R.id.rg);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);

        rg.setOnCheckedChangeListener(this);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                MovieSelectString = "鋼鐵人大戰超人";
                break;
            case R.id.rb2:
                MovieSelectString = "隊長大戰扁富俠";
                break;
        }ShowMoney();
    }
    void ShowMoney(){
        String S = MovieSelectString+"\n";
        if(cb1.isChecked()){
            int sum = Integer.parseInt(ed1.getText().toString()) * 280;
            S += "成人票" + ed1.getText().toString() + "張共" + sum + "元" +"\n";
        }
        if(cb2.isChecked()){
            int sum = Integer.parseInt(ed2.getText().toString()) * 230;
            S += "學生票" + ed2.getText().toString() + "張共" + sum + "元" +"\n";
        }
        if(cb3.isChecked()){
            int sum = Integer.parseInt(ed3.getText().toString()) * 180;
            S += "促銷票" + ed3.getText().toString() + "張共" + sum + "元" +"\n";
        }
        tv4.setText("您的購票資訊如下：\n" + S);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        ShowMoney();
    }
}
