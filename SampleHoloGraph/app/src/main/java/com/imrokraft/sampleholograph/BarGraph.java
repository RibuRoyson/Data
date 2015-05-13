package com.imrokraft.sampleholograph;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.echo.holographlibrary.Bar;

import java.util.ArrayList;

/**
 * Created by imrokraft on 12/5/15.
 */
public class BarGraph extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Bar> points = new ArrayList<Bar>();
        Bar d = new Bar();
        d.setColor(Color.parseColor("#99CC00"));
        d.setName("Test1");
        d.setValue(10);
        Bar d2 = new Bar();
        d2.setColor(Color.parseColor("#FFBB33"));
        d2.setName("Test2");
        d2.setValue(20);
        points.add(d);
        points.add(d2);
        com.echo.holographlibrary.BarGraph g=(com.echo.holographlibrary.BarGraph)findViewById(R.id.bargraph);
        g.setBars(points);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bargraph:
                Intent in=new Intent(getApplicationContext(),BarGraph.class);
                startActivity(in);
                break;
            case R.id.piegraph:
                Intent inc=new Intent(getApplicationContext(),PieGraph.class);
                startActivity(inc);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
