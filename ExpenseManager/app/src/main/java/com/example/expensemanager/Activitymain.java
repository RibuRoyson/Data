package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Activitymain extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
    }

    public void adddatas(View v) {
        Intent aa = new Intent(getApplicationContext(), Add.class);
        startActivity(aa);

    }

    public void editdatas(View v) {
        Intent ac = new Intent(getApplicationContext(),Showresult.class);
        startActivity(ac);
    }

    public void viewdatas(View v) {
        Intent in = new Intent(getApplicationContext(), Viewdb.class);
        startActivity(in);
    }


    public void showmonth(View v)
    {
        Intent incc = new Intent(getApplicationContext(), Monthwise.class);
        startActivity(incc);
    }
    public void showcat(View v)
    {
        Intent inc = new Intent(getApplicationContext(), Bycat.class);
        startActivity(inc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

