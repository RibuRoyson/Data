package com.example.expensemanager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Showresult extends Activity {
    TextView tv,tv1, mnth;
    int i = 0;
    String length;
    String results;
    Dbhandler dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showresult);
        Button b1=(Button)findViewById(R.id.selectmnth);
        registerForContextMenu(b1);
        tv=(TextView)findViewById(R.id.monthtotal);
  }
    public void totalclick(View v)
    {
        tv1 = (TextView) findViewById(R.id.totv);
        dbh = new Dbhandler(Showresult.this);
        int x = dbh.total();
        tv1.setText("" + x);
    }
    public void monthclick(View v)
    {
        mnth = (TextView) findViewById(R.id.monthv);
        dbh = new Dbhandler(Showresult.this);
        int y = dbh.totalmnth();
        mnth.setText("" + y);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.month, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.janu: {
                i = 1;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                Log.e("arraylist length", "" + length);
                if (results==null||results.isEmpty())
                {
                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
                }
                else {
                    tv.setText(results);
                }
                break;
            }
            case R.id.feb: {
                i = 2;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));

                Log.e("arraylist length", "" + length);
                if (length == "") {
                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    tv.setText(results);
                }
                break;
            }
            case R.id.mar: {
                i = 3;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.apr: {
                i = 4;
                Dbhandler dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.may: {
                i = 5;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.jun: {
                i = 6;
                 dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.jul: {
                i = 7;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.aug: {
                i = 8;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.sep: {
                i = 9;
                 dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.oct: {
                i = 10;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.nov: {
                i = 11;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                tv.setText(results);
//              length = results.size();
//                Log.e("arraylist length", "" + length);
//                if (length == "") {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
                break;
            }
            case R.id.dec: {
                i = 12;
                dbh = new Dbhandler(getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                try {
                    if (results != null) {
                        tv.setText(results);
                    } else {
                        Toast.makeText(getApplicationContext(), "No Entry", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
//                Log.e("arraylist length", "" + length);
//                if (length == null) {
//                    Toast.makeText(Showresult.this, "Database Empty", Toast.LENGTH_LONG).show();
//                } else {
//                    tv.setText(results);
//                }
//                break;
            }
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
