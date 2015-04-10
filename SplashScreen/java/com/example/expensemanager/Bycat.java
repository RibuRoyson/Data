package com.example.expensemanager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bycat extends Activitymain {
    ListView lv;
    Dbhandler dbh;
    Button a1, b1, c1;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bycat);
        a1 = (Button) findViewById(R.id.food);
        b1 = (Button) findViewById(R.id.drinks);
        c1 = (Button) findViewById(R.id.cloth);
        a1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                lv = (ListView) findViewById(R.id.listView1);
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.food();
                if (result.isEmpty() == true) {
                    Toast.makeText(Bycat.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Bycat.this, android.R.layout.simple_list_item_1, result);
                    lv.setAdapter(adapter);
                }

            }
        });
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                lv = (ListView) findViewById(R.id.listView1);
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.Drinks();
                if (result.isEmpty() == true) {
                    Toast.makeText(Bycat.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Bycat.this, android.R.layout.simple_list_item_1, result);
                    lv.setAdapter(adapter);
                }
            }
        });
        c1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                lv = (ListView) findViewById(R.id.listView1);
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<String> result = new ArrayList<String>();
                result = dbh.Cloth();
                if (result.isEmpty() == true) {
                    Toast.makeText(Bycat.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Bycat.this, android.R.layout.simple_list_item_1, result);
                    lv.setAdapter(adapter);
                }
            }
        });
    }

}
