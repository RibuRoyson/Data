package com.example.imrokraft.runtimedb2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 10/4/15.
 */
public class Second extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        ListView list=(ListView)findViewById(R.id.listView);
        databasehandler dbh=new databasehandler(getApplicationContext());
        ArrayList<String > result=new ArrayList<>();
        result=dbh.resultdata();
        if(result.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Database Empty",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result);
            list.setAdapter(adapter);
        }
    }
}
