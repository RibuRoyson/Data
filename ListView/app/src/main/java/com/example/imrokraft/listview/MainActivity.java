package com.example.imrokraft.listview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    EditText name,email;
    ListView list;

    String name1,email1;
    Button add,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText);

        add=(Button)findViewById(R.id.button);
        show=(Button)findViewById(R.id.button1);
        list=(ListView)findViewById(R.id.listView);
        final ArrayList<String> names=new ArrayList<String>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names.add(name.getText().toString());

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setAdapter(adapter);
            }
        });
    }





}
