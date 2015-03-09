package com.example.imrokraft.tabview;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends TabActivity {
TabHost tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=(TabHost)findViewById(android.R.id.tabhost);
        TabHost.TabSpec tab1=tab.newTabSpec("taba");
        TabHost.TabSpec tab2=tab.newTabSpec("tabb");
        TabHost.TabSpec tab3=tab.newTabSpec("tabc");
        tab1.setIndicator("Gallery");
        tab1.setContent(new Intent(this,PageOne.class));
        tab2.setIndicator("Details");
        tab2.setContent(new Intent(this,PageTwo.class));
        tab3.setIndicator("Contacts");
        tab3.setContent(new Intent(this,PageThree.class));
        tab.addTab(tab1);
        tab.addTab(tab2);
        tab.addTab(tab3);
    }



}
