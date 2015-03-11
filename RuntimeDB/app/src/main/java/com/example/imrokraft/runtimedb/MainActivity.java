package com.example.imrokraft.runtimedb;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.security.DomainCombiner;


public class MainActivity extends Activity {
EditText name,place;
    String name1,place1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"Not Available",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                MainActivity.this.finish();
                break;
            default:
        }

        return super.onOptionsItemSelected(item);
    }
}
