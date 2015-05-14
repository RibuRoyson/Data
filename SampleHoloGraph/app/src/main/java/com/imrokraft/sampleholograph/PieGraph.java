package com.imrokraft.sampleholograph;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.echo.holographlibrary.PieSlice;

/**
 * Created by imrokraft on 12/5/15.
 */
public class PieGraph extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piegraph);
        com.echo.holographlibrary.PieGraph pg=(com.echo.holographlibrary.PieGraph)findViewById(R.id.piegraph);
        PieSlice slice=new PieSlice();
        slice.setColor(Color.parseColor("#99CC00"));
        slice.setValue(2);
        pg.addSlice(slice);
        slice=new PieSlice();
        slice.setColor(Color.parseColor("#FFBB33"));
        slice.setValue(3);
        pg.addSlice(slice);
        slice = new PieSlice();
        slice.setColor(Color.parseColor("#AA66CC"));
        slice.setValue(8);
        pg.addSlice(slice);
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
