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
    Dbhandler dbh;
    ArrayList<Integer> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorytotal);



    }

    public void categorytotal(View v) {
        dbh = new Dbhandler(getApplicationContext());
        data = dbh.cattotal();
        ListView listv = (ListView) findViewById(R.id.listcategory);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        dbh = new Dbhandler(getApplicationContext());
        data = dbh.daywise();
        int x = data.size();
        if (data == null) {
            System.out.print("Null");
        }
        PieGraph pg = (PieGraph) findViewById(R.id.categorygraph);
        for (int j = 0; j < x; j++) {
            PieSlice slice = new PieSlice();
            slice.setColor(Color.parseColor("#99CC00"));
            slice.setValue(data.get(j));
            pg.addSlice(slice);

        }
    }
}
