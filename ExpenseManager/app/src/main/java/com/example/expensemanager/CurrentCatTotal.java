package com.example.expensemanager;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by imrokraft on 28/5/15.
 */
public class CurrentCatTotal extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentcattotal);
    }
    public void click(View v)
    {
        Dbhandler dbh=new Dbhandler(getApplicationContext());
        TextView et=(TextView)findViewById(R.id.editet);
        int a=dbh.currentcategory("Dress");
        et.setText(a+"");
    }
}
