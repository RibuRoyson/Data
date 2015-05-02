package com.example.expensemanager;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showresult extends Activity {
    TextView tv, mnth;

    Cursor exp;
    Dbhandler dbh;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showresult);
        Button b1=(Button)findViewById(R.id.selectmnth);
        registerForContextMenu(b1);
  }
    public void totalclick(View v)
    {
        tv = (TextView) findViewById(R.id.totv);
        dbh = new Dbhandler(Showresult.this);
        int x = dbh.total();
        tv.setText("" + x);
    }
    public void monthclick(View v)
    {
        mnth = (TextView) findViewById(R.id.monthv);
        dbh = new Dbhandler(Showresult.this);
        int y = dbh.totalmnth();
        mnth.setText("" + y);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
