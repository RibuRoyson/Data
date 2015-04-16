package com.example.expensemanager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Monthwise extends Activity {
    ListView lvv;
    Dbhandler dbh;
    TextView tv;
    int i = 0;
    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthwise);
        tv = (TextView) findViewById(R.id.text1);
        registerForContextMenu(tv);
        lvv = (ListView) findViewById(R.id.list1);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()) {
            case R.id.janu: {
                i = 1;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> results = new ArrayList<String>();
                results = dbh.monthWiseData(i);
                length = results.size();
                Log.e("arraylist length", "" + length);
                if (length == 0) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, results);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.feb: {
                i = 2;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.mar: {
                i = 3;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.apr: {
                i = 4;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.may: {
                i = 5;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.jun: {
                i = 6;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.jul: {
                i = 7;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.aug: {
                i = 8;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.sep: {
                i = 9;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.oct: {
                i = 10;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.nov: {
                i = 11;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
            case R.id.dec: {
                i = 12;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(Monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Monthwise.this, android.R.layout.simple_list_item_1, result);
                    lvv.setAdapter(adapter);
                }
                break;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.month, menu);
    }

}
