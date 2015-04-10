package com.example.imrokraft.runtimedb2;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    EditText name,qual;
    String name1,qual1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void submitclick(View v)
{
    name=(EditText)findViewById(R.id.editname);
    qual=(EditText)findViewById(R.id.editqua);
    name1=name.getText().toString();
    qual1=qual.getText().toString();
    details d=new details();
    d.setName(name1);
    d.setQual(qual1);
    databasehandler dbh=new databasehandler(this);
    dbh.insert(d);
    Toast.makeText(getApplicationContext(),"Details Submitted",Toast.LENGTH_SHORT).show();
}
public void viewclick(View v)
{
    Intent in=new Intent(getApplicationContext(),Second.class);
    startActivity(in);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.edititem:
                Intent inc=new Intent(getApplication(),Third.class);
                startActivity(inc);
                break;
            case R.id.deleteitem:
                Intent incc=new Intent(getApplication(),Four.class);
                startActivity(incc);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
