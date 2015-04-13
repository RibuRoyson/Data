package com.example.imrokraft.runtimedb2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by imrokraft on 10/4/15.
 */
public class Second extends ActionBarActivity {
    UserAdapter myuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        ListView list = (ListView) findViewById(R.id.listView);
        databasehandler dbh = new databasehandler(getApplicationContext());

        myuser = new UserAdapter(getApplicationContext(),dbh.resultdata());
        list.setAdapter(myuser);
//        if(result.isEmpty())
//        {
//            Toast.makeText(getApplicationContext(),"Database Empty",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result);
//            list.setAdapter(adapter);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        myuser.notifyDataSetChanged();
        myuser.notifyDataSetInvalidated();
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
        switch (item.getItemId()) {
            case R.id.edititem:
                Intent inc = new Intent(getApplication(), Third.class);
                startActivity(inc);
                break;
            case R.id.deleteitem:
                Intent incc = new Intent(getApplication(), Four.class);
                startActivity(incc);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
