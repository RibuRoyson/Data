package com.example.expensemanager;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Showresult extends Activity {
    TextView tv, mnth;
    Button b1, b2;
    Cursor exp;
    Dbhandler dbh;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showresult);
        tv = (TextView) findViewById(R.id.totv);
        mnth = (TextView) findViewById(R.id.monthv);
        b1 = (Button) findViewById(R.id.total);
        b2 = (Button) findViewById(R.id.totalmn);
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dbh = new Dbhandler(Showresult.this);
                int x = dbh.total();
                tv.setText("" + x);
            }
        });
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dbh = new Dbhandler(Showresult.this);
                int y = dbh.totalmnth();
                mnth.setText("" + y);

            }
        });

    }


}
