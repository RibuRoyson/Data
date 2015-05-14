package com.example.expensemanager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daywise);
        dbh = new Dbhandler(getApplicationContext());
        total=dbh.daywise();
        int x=total.size();
        Line l=new Line();
        for(int j=0;j<x;j++)
        {
            LinePoint p=new LinePoint();
            p.setX(j);
            p.setY(Float.parseFloat(String.valueOf(total.get(j))));
            l.addPoint(p);
        }
        l.setColor(Color.parseColor("#FFBB33"));
        LineGraph li=(LineGraph)findViewById(R.id.daywisegraph);
        li.addLine(l);
        li.setRangeY(0, 700);
        li.setLineToFill(0);
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
