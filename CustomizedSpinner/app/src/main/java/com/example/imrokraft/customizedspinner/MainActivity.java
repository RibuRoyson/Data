package com.example.imrokraft.customizedspinner;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {
public ArrayList<SpinnerModel> Customlist=new ArrayList<SpinnerModel>();
    TextView output;
    CustomAdapter adapter;
    CustomSpinner activity=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



}
