package com.example.user.ch6_9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> selected = new ArrayList<>();//具有同時array、list的特性

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lsv_choose = (ListView)findViewById(R.id.lsv_choose);
        lsv_choose.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView cliclitem = (TextView) view;//當去選擇n項目，丟回來的資料會是view
            String item = cliclitem.getText().toString();
            if (selected.contains(item)){
                selected.remove(item);
            }else {
                selected.add(item);
            }

            String msg;
            if (selected.size()>0){
                msg = "您點了:";
                for (String str:selected){
                    msg+=","+str;
                }
            }else{
                msg = "請點餐!";
            }

            TextView txv_op = (TextView)findViewById(R.id.txv_op);
            txv_op.setText(msg);
        }
    };
}
