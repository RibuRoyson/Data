package com.example.expensemanager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Viewdb extends Activity {
    ListView lv;
    Dbhandler dbh;
    ArrayList<String> data;
    UserAdapter myuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        lv = (ListView) findViewById(R.id.listView1);
        Dbhandler dbh = new Dbhandler(getApplicationContext());
        myuser = new UserAdapter(getApplicationContext(), dbh.resultdata());
        lv.setAdapter(myuser);


//        ArrayList<String> result = new ArrayList<String>();
//        result = dbh.resultdata();
//        if (result.isEmpty() == true) {
//            Toast.makeText(Viewdb.this, "Database Empty", Toast.LENGTH_LONG).show();
//        } else {
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mytextview, result);
//            lv.setAdapter(adapter);
//        }


    }


}


