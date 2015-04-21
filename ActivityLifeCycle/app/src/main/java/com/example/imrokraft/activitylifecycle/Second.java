package com.example.imrokraft.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by imrokraft on 21/4/15.
 */
public class Second extends ActionBarActivity {
final String act="states";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Toast.makeText(getApplicationContext(), "Second:onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(act, "Second:onCreate()");


    }
    public void second(View v)
    {
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(getApplicationContext(),"Second:onRestart()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Second:onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(getApplicationContext(),"Second:onStart()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Second:onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(),"Second:onResume()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Second:onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(getApplicationContext(),"Second:onPause()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Second:onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(getApplicationContext(),"Second:onStop()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Second:onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(),"Second:onDestroy()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Second:onDestroy()");
    }
}
