package com.imrokraft.multifragments;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity {

    boolean twoPaneLayoutLoaded=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            if(findViewById(R.id.container)==null){
                twoPaneLayoutLoaded=true;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.listdetail_container, new ListDetailFragment())
                        .commit();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.listview_container, new ListFragment())
                        .commit();

            }else{
                twoPaneLayoutLoaded=false;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ListFragment())
                        .commit();
            }
        }
    }

}
