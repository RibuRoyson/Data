package com.example.expensemanager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bycat extends Activitymain {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bycat);

    }
    public void food(View v)
    {
        String f="Food";
       Dbhandler dbh = new Dbhandler(getApplicationContext());
        ArrayList<details> result = dbh.category(f);
        if (result==null||result.isEmpty()) {
            Toast.makeText(Bycat.this, "No Records Found!", Toast.LENGTH_LONG).show();
        } else {
            ListView lv = (ListView) findViewById(R.id.listView21);
            lv.setAdapter(new UserAdaptercat(getApplicationContext(),dbh.category(f)));
        }
    }
    public void drinks(View v)
    {
        String d="Drinks";
        Dbhandler dbh = new Dbhandler(getApplicationContext());
        ArrayList<details> result = dbh.category(d);
        if (result==null||result.isEmpty()) {
            Toast.makeText(Bycat.this, "No Records Found!", Toast.LENGTH_LONG).show();
        } else {
            ListView lv = (ListView) findViewById(R.id.listView21);
            lv.setAdapter(new UserAdaptercat(getApplicationContext(),dbh.category(d)));
        }
    }
    public void cloth(View v)
    {
        String c="Cloth";
        Dbhandler dbh = new Dbhandler(getApplicationContext());
        ArrayList<details> result = dbh.category(c);
        if (result==null||result.isEmpty()) {
            Toast.makeText(Bycat.this, "No Records Found!", Toast.LENGTH_LONG).show();
        } else {
            ListView lv = (ListView) findViewById(R.id.listView21);
            lv.setAdapter(new UserAdaptercat(getApplicationContext(),dbh.category(c)));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
