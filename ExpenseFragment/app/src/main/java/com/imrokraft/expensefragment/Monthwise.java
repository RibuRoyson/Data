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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 6/5/15.
 */
public class Monthwise extends Fragment {
    ListView lvv;
    Dbhandler dbh;
    TextView tv;
    int i = 0;
    int length;
    UserAdapter myuser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.monthwise, container, false);
        tv = (TextView) root.findViewById(R.id.text1);
        registerForContextMenu(tv);
        lvv = (ListView) root.findViewById(R.id.list1);

        return root;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = this.getActivity().getMenuInflater();
        inflater.inflate(R.menu.month, menu);
        super.onCreateContextMenu(menu, v, menuInfo);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.janu: {
                i = 1;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> results = new ArrayList<details>();
                results = dbh.monthWiseData(i);
                length = results.size();
                Log.e("arraylist length", "" + length);
                if (length == 0) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(1));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.feb: {
                i = 2;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(2));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.mar: {
                i = 3;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(3));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.apr: {
                i = 4;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(4));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.may: {
                i = 5;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(5));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.jun: {
                i = 6;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(6));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.jul: {
                i = 7;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(7));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.aug: {
                i = 8;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(8));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.sep: {
                i = 9;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(9));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.oct: {
                i = 10;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(10));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.nov: {
                i = 11;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(11));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.dec: {
                i = 12;
                Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthWiseData(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    myuser = new UserAdapter(getActivity().getApplicationContext(), dbh.monthWiseData(12));
                    lvv.setAdapter(myuser);
                }
                break;
            }


        }
        return super.onContextItemSelected(item);
    }
}
