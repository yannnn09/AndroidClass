package com.example.user.ch10_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private static final int READ_BLOCK_SIZE = 100;
    private String fname = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_save = (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(btn_save_listener);

        Button btn_read = (Button)findViewById(R.id.btn_read);
        btn_read.setOnClickListener(btn_read_listener);

        Button btn_readrawdata = (Button)findViewById(R.id.btn_readrawdata);
        btn_readrawdata.setOnClickListener(btn_readraw_listener);
    }

    //region 存取檔案
    View.OnClickListener btn_save_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText edt_input = (EditText)findViewById(R.id.edt_input);
            String str = edt_input.getText().toString();
            try{
                FileOutputStream out = openFileOutput(fname, MODE_PRIVATE);
                OutputStreamWriter sw = new OutputStreamWriter(out);
                sw.write(str);
                sw.flush();
                sw.close();
                Toast.makeText(MainActivity.this,
                        "成功寫入檔案...",
                        Toast.LENGTH_SHORT).show();
                edt_input.setText("");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    View.OnClickListener btn_read_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                FileInputStream in = openFileInput(fname);
                InputStreamReader sr = new InputStreamReader(in);
                char[] buffer = new char[READ_BLOCK_SIZE];
                String str = "";
                int count;
                while ((count = sr.read(buffer))>0){
                    String s = String.copyValueOf(buffer, 0, count);
                    str += s;
                    buffer = new char[READ_BLOCK_SIZE];
                }
                sr.close();
                Toast.makeText(MainActivity.this,
                        "檔案讀取成功...",
                        Toast.LENGTH_SHORT).show();
                TextView txv_readdata = (TextView)findViewById(R.id.txv_readdata);
                txv_readdata.setText(str);
            }catch (Exception e){

            }
        }
    };
    //endregion

    //region 讀取raw檔案
    View.OnClickListener btn_readraw_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                InputStream in = MainActivity.this.getResources().openRawResource(R.raw.note);
                InputStreamReader sr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(sr);
                String s = null, str = "";
                while ((s = br.readLine())!= null){
                    str += s + "\n";
                }
                br.close();
                sr.close();
                Toast.makeText(MainActivity.this, "成功讀取raw的檔案...", Toast.LENGTH_SHORT).show();
                TextView txv_rawdata = (TextView)findViewById(R.id.txv_rawdata);
                txv_rawdata.setText("讀取內容\n"+str);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
    //endregion
}
