package com.example.user.ch9_4;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startbrowser = (Button)findViewById(R.id.btn_startbrowser);
        btn_startbrowser.setOnClickListener(btn_startbrowser_listener);

        Button btn_startmap = (Button)findViewById(R.id.btn_startmap);
        btn_startmap.setOnClickListener(btn_startmap_listener);

        Button btn_phonecall = (Button)findViewById(R.id.btn_phonecall);
        btn_phonecall.setOnClickListener(btn_phonecall_listener);

        Button btn_contact = (Button)findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(btn_contact_listener);

        Button btn_websearch = (Button)findViewById(R.id.btn_websearch);
        btn_websearch.setOnClickListener(btn_websearch_listener);

        Button btn_sendmail = (Button)findViewById(R.id.btn_sendmail);
        btn_sendmail.setOnClickListener(btn_sendmail_listener);
    }

    //region   activities browser
    View.OnClickListener btn_startbrowser_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));

            startActivity(i);
        }
    };
    //endregion

    //region   activities map
    View.OnClickListener btn_startmap_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:25.04692437135412, 121.5161783959678"));

            startActivity(i);
        }
    };
    //endregion

    //region   phone call
    View.OnClickListener btn_phonecall_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:+1725647774"));

            startActivity(i);
        }
    };
    //endregion

    //region  contact
    private static final int GET_CONTACT = 1;
    View.OnClickListener btn_contact_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType(ContactsContract.Contacts.CONTENT_TYPE);
            startActivityForResult(i, GET_CONTACT);

        }
    };
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case GET_CONTACT:
                if (resultCode == RESULT_OK){
                    String uri = data.getData().toString();
                    Toast.makeText(MainActivity.this, uri, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
                    startActivity(i);
                }
                break;

        }
    }
    //endregion

    //region  WebSearch
    View.OnClickListener btn_websearch_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY, "Andriod");
            startActivity(i);
        }
    };
    //endregion

    //region  SendMail
    View.OnClickListener btn_sendmail_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:cogawu@gmail.com"));
            startActivity(i);
        }
    };
    //endregion
}
