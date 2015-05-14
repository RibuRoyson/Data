package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by imrokraft on 14/5/15.
 */
public class GraphMenu extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphmain);
    }
    public void totalgraphs(View v)
    {
        Intent in=new Intent(getApplicationContext(),TotalGraph.class);
        startActivity(in);
    }
    public void days(View v)
    {
        Intent inc=new Intent(getApplicationContext(),Daywise.class);
        startActivity(inc);
    }
    public void categories(View v)
    {
        Intent incc=new Intent(getApplicationContext(),CategoryTotal.class);
        startActivity(incc);
    }

}
