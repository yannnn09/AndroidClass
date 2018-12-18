package com.example.user.ch6_5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txv_op;
    private RadioGroup rdg;
    private RadioButton rdb3, rdb5, rdb7, rdb10;
    //
    private ImageView img_picture;
    private RadioGroup rdg_animal;
    private RadioButton rdb_dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv_op = (TextView)findViewById(R.id.txv_op);
        rdg = (RadioGroup)findViewById(R.id.rdg);
        rdb3 = (RadioButton)findViewById(R.id.rdb3);
        rdb5 = (RadioButton)findViewById(R.id.rdb5);
        rdb7 = (RadioButton)findViewById(R.id.rdb7);
        rdb10 = (RadioButton)findViewById(R.id.rdb10);
        rdg.setOnCheckedChangeListener(rdglistener);
        //
        img_picture = (ImageView)findViewById(R.id.img_picture);
        rdg_animal = (RadioGroup)findViewById(R.id.rdg_animal);
        rdb_dog = (RadioButton)findViewById(R.id.rdb_dog);
        rdg_animal.setOnCheckedChangeListener(rdganilistener);
    }
   RadioGroup.OnCheckedChangeListener rdglistener = new RadioGroup.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(RadioGroup group, int checkedId) {
           if (checkedId ==rdb3.getId()){
               txv_op.setText(rdb3.getText());
           }else if (checkedId == rdb5.getId()){
               txv_op.setText(rdb5.getText());
           }else if (checkedId == rdb7.getId()){
               txv_op.setText(rdb7.getText());
           }else{
               txv_op.setText(rdb10.getText());
           }
       }
   };

   RadioGroup.OnCheckedChangeListener rdganilistener = new RadioGroup.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(RadioGroup group, int checkedId) {
           if (checkedId == rdb_dog.getId())
               img_picture.setImageResource(R.drawable.dog);
           else
               img_picture.setImageResource(R.drawable.elephant);
       }
   };
}
