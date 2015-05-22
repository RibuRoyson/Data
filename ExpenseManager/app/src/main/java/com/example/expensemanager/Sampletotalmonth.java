package com.example.expensemanager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.echo.holographlibrary.Bar;

import java.util.ArrayList;

/**
 * Created by imrokraft on 13/5/15.
 */
public class Sampletotalmonth extends ActionBarActivity {
Dbhandler dbh;

    ArrayList<Integer> total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sampletotalmonth);
        dbh = new Dbhandler(getApplicationContext());
        total = dbh.monthwise();
        if(total==null||total.isEmpty())
        {
            System.out.print("Null");
        }
        else {

            ArrayList<Bar> points = new ArrayList<Bar>();
            Bar d = new Bar();
            d.setColor(Color.parseColor("#99CC00"));
            d.setName("January");
            d.setValue(total.get(0));
            Bar d2 = new Bar();
            d2.setColor(Color.parseColor("#FFBB33"));
            d2.setName("February");
            d2.setValue(total.get(1));
            Bar d3 = new Bar();
            d3.setColor(Color.parseColor("#99CC00"));
            d3.setName("March");
            d3.setValue(total.get(2));
            Bar d4 = new Bar();
            d4.setColor(Color.parseColor("#99CC00"));
            d4.setName("April");
            d4.setValue(total.get(3));
            Bar d5 = new Bar();
            d5.setColor(Color.parseColor("#99CC00"));
            d5.setName("May");
            d5.setValue(total.get(4));
            Bar d6 = new Bar();
            d6.setColor(Color.parseColor("#99CC00"));
            d6.setName("June");
            d6.setValue(total.get(5));
            Bar d7 = new Bar();
            d7.setColor(Color.parseColor("#99CC00"));
            d7.setName("July");
            d7.setValue(total.get(6));
            Bar d8 = new Bar();
            d8.setColor(Color.parseColor("#99CC00"));
            d8.setName("August");
            d8.setValue(total.get(7));
            Bar d9 = new Bar();
            d9.setColor(Color.parseColor("#99CC00"));
            d9.setName("September");
            d9.setValue(total.get(8));
            Bar d10 = new Bar();
            d10.setColor(Color.parseColor("#99CC00"));
            d10.setName("October");
            d10.setValue(total.get(9));
            Bar d11 = new Bar();
            d11.setColor(Color.parseColor("#99CC00"));
            d11.setName("November");
            d11.setValue(total.get(10));
            Bar d12 = new Bar();
            d12.setColor(Color.parseColor("#99CC00"));
            d12.setName("December");
            d12.setValue(total.get(11));
            points.add(d);
            points.add(d2);
            points.add(d3);
            points.add(d4);
            points.add(d5);
            points.add(d6);
            points.add(d7);
            points.add(d8);
            points.add(d9);
            points.add(d10);
            points.add(d11);
            points.add(d12);
            com.echo.holographlibrary.BarGraph g = (com.echo.holographlibrary.BarGraph) findViewById(R.id.graph);
            g.setBars(points);
        }
    }
    public void getit(View v)
    {
        String[] names={"January","February","March","April","May","June","July","August","September","October","November","December"};
        dbh = new Dbhandler(getApplicationContext());
        total = dbh.monthwise();
               if(total==null||total.isEmpty())
        {
            System.out.print("Null");
        }
        ListView lv11=(ListView)findViewById(R.id.listViewgraph);
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,total);
        lv11.setAdapter(adapter);
        int x=total.size();


    }
}
