package com.example.expensemanager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;

import java.util.ArrayList;

/**
 * Created by imrokraft on 14/5/15.
 */
public class Daywise extends ActionBarActivity {
    Dbhandler dbh;
    ArrayList<Integer> total;
    String[] actions = new String[] {
            "Bookmark",
            "Subscribe",
            "Share"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daywise);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, actions);

        ActionBar.OnNavigationListener navigationListener=new ActionBar.OnNavigationListener() {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "You selected : " + actions[itemPosition]  , Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        getSupportActionBar().setListNavigationCallbacks(adapter, navigationListener);
        dbh = new Dbhandler(getApplicationContext());
        total=dbh.daywise();

        if (total==null||total.isEmpty()) {
            Toast.makeText(Daywise.this, "No Records Found!", Toast.LENGTH_LONG).show();
        }
        else
        {
            int x=total.size();
            Line l = new Line();
            for (int j = 0; j < x; j++) {
                LinePoint p = new LinePoint();
                p.setX(j);

                p.setY(Float.parseFloat(String.valueOf(total.get(j))));
                l.addPoint(p);

            }
            l.setColor(Color.parseColor("#FFBB33"));
            LineGraph li = (LineGraph) findViewById(R.id.daywisegraph);
            li.addLine(l);

            li.setLineToFill(0);
        }
    }
    public void get(View v)
    {
        dbh = new Dbhandler(getApplicationContext());
        total=dbh.daywise();
        if(total==null)
        {
            System.out.print("Null");
        }
        ListView list=(ListView)findViewById(R.id.listday);
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,total);
        list.setAdapter(adapter);
    }
}
