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
 * Created by imrokraft on 13/5/15.
 */
public class Sampletotalmonth extends ActionBarActivity {
Dbhandler dbh;
    ArrayList<String> data;
    ArrayList<Integer> total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sampletotalmonth);

    }
    public void getit(View v)
    {
        int i=5;
        dbh = new Dbhandler(getApplicationContext());
        data = dbh.monthgraph(i);
        for(int j=0;j<=12;j++) {
            total = dbh.monthwise(j);
        }
        if(total==null)
        {
            System.out.print("Null");
        }
        ListView lv11=(ListView)findViewById(R.id.listViewgraph);
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,total);
        lv11.setAdapter(adapter);
        int x=data.size();
        Line l=new Line();
        for(int j=0;j<x;j++)
        {
            LinePoint p=new LinePoint();
            p.setX(j);
            p.setY(Float.parseFloat(data.get(j)));
            l.addPoint(p);
        }
        l.setColor(Color.parseColor("#FFBB33"));
        LineGraph li=(LineGraph)findViewById(R.id.graph);
        li.addLine(l);
        li.setRangeY(0, 700);
        li.setLineToFill(0);
    }
}
