package com.example.user.ch7_2;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements PopupMenu.OnMenuItemClickListener{
    private TextView txv_op;
    private ConstraintLayout layout_main;
    private FrameLayout layout_frame;

    private Button btn_contextmenu, btn_popupMenu;
    ActionMode.Callback mCallback;
    ActionMode mMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv_op = findViewById(R.id.txv_op);
        layout_main = findViewById(R.id.layout_main);
        layout_frame = findViewById(R.id.layout_frame);

        registerForContextMenu(layout_frame);

        mCallback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.setTitle("選擇背景色彩");
                getMenuInflater().inflate(R.menu.menu_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.cmenu_red:
                        layout_main.setBackgroundColor(Color.RED);
                        break;
                    case R.id.cmenu_green:
                        layout_main.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.cmenu_blue:
                        layout_main.setBackgroundColor(Color.BLUE);
                        break;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        };

        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mMode!=null){
                    return false;
                }else{
                    mMode = startActionMode(mCallback);
                    v.setSelected(true);
                }
                return false;
            }
        };

        btn_contextmenu = findViewById(R.id.btn_contextmenu);
        btn_contextmenu.setOnLongClickListener(longClickListener);

        btn_popupMenu = findViewById(R.id.btn_popupMenu);
        btn_popupMenu.setOnClickListener(btnClickListener);
    }


    //(複寫)建立右上角選單方法
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }

    //使用者點擊menu項目處發事件
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            int temp;
            double result;
            EditText edt_temp = findViewById(R.id.edt_temp);

            switch (item.getItemId()) {
                case R.id.toF:
                    temp = Integer.parseInt(edt_temp.getText().toString());
                    result = (9.0 * temp) / 5.0 + 32.0;
                    txv_op.setText("華氏溫度:" + result);
                    break;
                case R.id.toC:
                    temp = Integer.parseInt(edt_temp.getText().toString());
                    result = (5.0 / 9.0) * (temp - 32.0);
                    txv_op.setText("攝氏溫度:" + result);
                    break;
                case R.id.submenu:
                    txv_op.setText(item.getTitle());
                    break;
                case R.id.submenuitem1:
                    txv_op.setText(item.getTitle());
                    break;
                case R.id.submenuitem2:
                    txv_op.setText(item.getTitle());
                    break;
                case R.id.menu_red:
                    if(item.isChecked())item.setChecked(false);
                    else item.setChecked(true);
                    layout_main.setBackgroundColor(Color.RED);
                    break;
                case R.id.menu_green:
                    if(item.isChecked())item.setChecked(false);
                    else item.setChecked(true);
                    layout_main.setBackgroundColor(Color.GREEN);
                    break;
                case R.id.menu_blue:
                    if(item.isChecked())item.setChecked(false);
                    else item.setChecked(true);
                    layout_main.setBackgroundColor(Color.BLUE);
                    break;
            }

        }catch (Exception e){
            txv_op.setText(e.getMessage());
        }return super.onOptionsItemSelected(item);
    }

    //(複寫)點及畫面建立內容選單方法
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("選擇背景色彩");
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    //(複寫)內如選單項目被點擊觸發的方法
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.cmenu_red:
                layout_main.setBackgroundColor(Color.RED);
                break;
            case R.id.cmenu_green:
                layout_main.setBackgroundColor(Color.GREEN);
                break;
            case R.id.cmenu_blue:
                layout_main.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.cmenu_red:
                layout_main.setBackgroundColor(Color.RED);
                break;
            case R.id.cmenu_green:
                layout_main.setBackgroundColor(Color.GREEN);
                break;
            case R.id.cmenu_blue:
                layout_main.setBackgroundColor(Color.BLUE);
                break;
        }
        return false;
    }

    PopupMenu.OnMenuItemClickListener PopupMenuListener = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.cmenu_red:
                    layout_main.setBackgroundColor(Color.RED);
                    break;
                case R.id.cmenu_green:
                    layout_main.setBackgroundColor(Color.GREEN);
                    break;
                case R.id.cmenu_blue:
                    layout_main.setBackgroundColor(Color.BLUE);
                    break;
            }
            return false;
        }
    };

    View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PopupMenu popup = new PopupMenu(MainActivity.this, v);
            popup.setOnMenuItemClickListener(PopupMenuListener);
            popup.inflate(R.menu.menu_context);
            popup.show();
        }
    };
}
