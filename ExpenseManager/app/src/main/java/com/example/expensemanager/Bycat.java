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
    Button a1, b1, c1;
    UserAdaptercat myuser;


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
                lv = (ListView) findViewById(R.id.listView21);
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.food();
                if (result.isEmpty() == true) {
                    Toast.makeText(Bycat.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdaptercat(getApplicationContext(),dbh.food());
                    lv.setAdapter(myuser);
                }

            }
        });
        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                lv = (ListView) findViewById(R.id.listView21);
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.Drinks();
                if (result.isEmpty() == true) {
                    Toast.makeText(Bycat.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdaptercat(getApplicationContext(),dbh.Drinks());
                    lv.setAdapter(myuser);
                }
            }
        });
        c1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                lv = (ListView) findViewById(R.id.listView21);
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.Cloth();
                if (result.isEmpty() == true) {
                    Toast.makeText(Bycat.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdaptercat(getApplicationContext(),dbh.Cloth());
                    lv.setAdapter(myuser);
                }
            }
        });
    }

}
