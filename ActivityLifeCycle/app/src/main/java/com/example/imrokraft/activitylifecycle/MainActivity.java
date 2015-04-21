package com.example.imrokraft.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
 final String act="states";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode==2) {
            Toast.makeText(getApplicationContext(),"Activity2",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(act,"MainActivity:onCreate()");
//        Toast.makeText(getApplicationContext(),"MainActivity:onCreate()",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(getApplicationContext(),"MainActivity:onRestart()",Toast.LENGTH_SHORT).show();
        Log.d(act,"MainActivity:onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(getApplicationContext(),"MainActivity:onStart()",Toast.LENGTH_SHORT).show();
        Log.d(act,"MainActivity:onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(),"MainActivity:onResume()",Toast.LENGTH_SHORT).show();
        Log.d(act,"MainActivity:onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(getApplicationContext(),"MainActivity:onPause()",Toast.LENGTH_SHORT).show();
        Log.d(act,"MainActivity:onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(getApplicationContext(),"MainActivity:onStop()",Toast.LENGTH_SHORT).show();
        Log.d(act,"MainActivity:onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(),"MainActivity:onDestroy()",Toast.LENGTH_SHORT).show();
        Log.d(act,"MainActivity:onDestroy()");
    }

    public void click(View v)
    {
        Intent i = new Intent(this, Second.class);
        startActivityForResult(i, 2);


    }

    public void click2(View v)
    {
        Intent i = new Intent(this, Third.class);
        startActivityForResult(i, 1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
