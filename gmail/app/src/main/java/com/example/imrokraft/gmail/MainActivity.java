package com.example.imrokraft.gmail;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
boolean twopanel=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#DA4336"));
        ab.setBackgroundDrawable(colorDrawable);
        if(savedInstanceState==null)
        {
            if(findViewById(R.id.container)==null)
            {
                twopanel=true;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.list2,new Fragment1())
                        .commit();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.list3,new Fragment2())
                        .commit();
            }
            else
            {
                twopanel=false;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.listview,new Mobilegmail())
                        .commit();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.next:
                Intent inc=new Intent(getApplicationContext(),Secondgmail.class);
                startActivity(inc);
        }
        return super.onOptionsItemSelected(item);
    }
}
