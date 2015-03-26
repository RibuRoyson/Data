package com.example.imrokraft.todo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
boolean twoPanel=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null)
        {
            if(findViewById(R.id.container)==null)
            {
                twoPanel=true;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.list1,new Fragment1())
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.list2,new Fragment2())
                        .commit();
            }
            else
            {
                twoPanel=false;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,new Mobile())
                        .commit();
            }
        }


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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
