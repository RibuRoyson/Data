package com.example.imrokraft.tabview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 9/3/15.
 */
public class PageThree extends Activity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagethree);
        lv=(ListView)findViewById(R.id.listView);
        ArrayList <String> list=new ArrayList<String>();
        list.add("Number 1");
        list.add("Number 2");
        list.add("Number 3");
        list.add("Number 4");
        list.add("Number 5");
        list.add("Number 6");
        list.add("Number 7");
        list.add("Number 8");
        ArrayAdapter adap=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s1=lv.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
