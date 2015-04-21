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
public class Third extends ActionBarActivity {
    final String act="states";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        Toast.makeText(getApplicationContext(), "Third:onCreate()", Toast.LENGTH_SHORT).show();
        Log.d(act, "Third:onCreate()");

    }
    public void third(View v)
    {
        setResult(RESULT_OK);
        finish();
    }
    public void thirdtwo(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(getApplicationContext(),"Third:onRestart()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Third:onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(getApplicationContext(),"Third:onStart()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Third:onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(),"Third:onResume()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Third:onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(getApplicationContext(),"Third:onPause()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Third:onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(getApplicationContext(),"Third:onStop()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Third:onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(),"Third:onDestroy()",Toast.LENGTH_SHORT).show();
        Log.d(act,"Third:onDestroy()");
    }
}

