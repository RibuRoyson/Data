package com.example.expensemanager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieSlice;

import java.util.ArrayList;

/**
 * Created by imrokraft on 14/5/15.
 */
public class CategoryTotal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorytotal);
    }

    public void categorytotal(View v) {
        ArrayList<Integer> data=new ArrayList<Integer>();
        String[] colr={"#f60606","#d4f606","#06f658","#06f6ef","#062ff6","#f40dfb"};
        data = (new Dbhandler(this)).cattotal();
        ListView listv = (ListView) findViewById(R.id.listcategory);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
//        dbh = new Dbhandler(getApplicationContext());
//        data = dbh.daywise();
        int y=colr.length;
        int x = data.size();
        if (data == null) {
            System.out.print("Null");
        }
        PieGraph pg = (PieGraph) findViewById(R.id.categorygraph);
        pg.removeSlices();
        PieSlice slice;
        for (int j = 0; j < x; j++) {
            slice= new PieSlice();
            slice.setColor(Color.parseColor(colr[j]));
            slice.setValue(data.get(j));
            pg.addSlice(slice);
        }
    }
}
