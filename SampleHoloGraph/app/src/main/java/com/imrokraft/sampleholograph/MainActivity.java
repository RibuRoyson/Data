package com.imrokraft.sampleholograph;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linegraph2);
        Line l=new Line();
        LinePoint p=new LinePoint();
        p.setX(0);
        p.setY(5);
        l.addPoint(p);
        p=new LinePoint();
        p.setX(8);
        p.setY(8);
        l.addPoint(p);
        p=new LinePoint();
        p.setX(10);
        p.setY(4);
        l.addPoint(p);
        l.setColor(Color.parseColor("#FFBB33"));
        LineGraph li=(LineGraph)findViewById(R.id.linegraph);
        li.addLine(l);
        li.setRangeY(0, 10);
        li.setLineToFill(0);
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


        //noinspection SimplifiableIfStatement
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
