package com.imrokraft.expensefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by imrokraft on 6/5/15.
 */
public class Showresult extends Fragment implements View.OnClickListener {
    TextView tv,tv1, mnth;
    int i = 0;
    String length;
    String results;
    Dbhandler dbh;
    View currentRoot=null;
    Button toexp,curto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.showresult, container, false);
        Button b1=(Button)root.findViewById(R.id.selectmnth);
        registerForContextMenu(b1);
        tv=(TextView)root.findViewById(R.id.monthtotal);
        currentRoot=root;
        toexp=(Button)root.findViewById(R.id.totalbut);
        curto=(Button)root.findViewById(R.id.curtotal);
        toexp.setOnClickListener(this);
        curto.setOnClickListener(this);
        return root;
    }
    @Override
    public void onClick(View v) {
        if(v == toexp)
        {
            tv1 = (TextView)currentRoot.findViewById(R.id.totv);
            dbh = new Dbhandler(getActivity().getApplicationContext());
            int x = dbh.total();
            tv1.setText("" + x);
        }
        if (v == curto)
        {
            mnth = (TextView)currentRoot.findViewById(R.id.monthv);
            dbh = new Dbhandler(getActivity().getApplicationContext());
            int y = dbh.totalmnth();
            mnth.setText("" + y);
        }
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = this.getActivity().getMenuInflater();
        inflater.inflate(R.menu.month, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.janu: {
                i = 1;
                dbh = new Dbhandler(getActivity().getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                Log.e("arraylist length", "" + length);
                if (results==null||results.isEmpty())
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Database Empty", Toast.LENGTH_LONG).show();
                }
                else {
                    tv.setText(results);
                }
                break;
            }
            case R.id.feb: {
                i = 2;
                dbh = new Dbhandler(getActivity().getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));

                Log.e("arraylist length", "" + length);
                if (length == "") {
                    Toast.makeText(getActivity().getApplicationContext(), "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    tv.setText(results);
                }
                break;
            }
            case R.id.mar: {
                i = 3;
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
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
                dbh = new Dbhandler(getActivity().getApplicationContext());
                results = String.valueOf(dbh.monthtotal(i));
                try {
                    if (results != null) {
                        tv.setText(results);
                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "No Entry", Toast.LENGTH_SHORT).show();
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


}
