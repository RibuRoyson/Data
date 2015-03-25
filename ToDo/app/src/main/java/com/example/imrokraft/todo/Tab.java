package com.example.imrokraft.todo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by imrokraft on 25/3/15.
 */
public class Tab extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);
        Fragment1 f=new Fragment1();
        getSupportFragmentManager().beginTransaction().replace(R.id.list1,f).commit();
        Fragment2 f2=new Fragment2();
        getSupportFragmentManager().beginTransaction().replace(R.id.list2,f2).commit();
    }
}
