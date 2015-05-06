package com.imrokraft.expensefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 5/5/15.
 */
public class Bycat extends Fragment implements View.OnClickListener {
    View currentRoot = null;
    Button drinksbtn, clothbtn, foodbtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bycat, container, false);
        currentRoot = root;
        drinksbtn = (Button) root.findViewById(R.id.drinks);
        clothbtn = (Button) root.findViewById(R.id.cloth);
        foodbtn = (Button) root.findViewById(R.id.food);
        drinksbtn.setOnClickListener(this);
        clothbtn.setOnClickListener(this);
        foodbtn.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == drinksbtn) {
            String d = "Drinks";
            Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
            ArrayList<details> result = dbh.category(d);
            if (result == null || result.isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
            } else {
                ListView lv = (ListView) currentRoot.findViewById(R.id.listView21);
                lv.setAdapter(new UserAdaptercat(getActivity().getApplicationContext(), dbh.category(d)));
            }
        }
        if (v == clothbtn) {
            String c = "Cloth";
            Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
            ArrayList<details> result = dbh.category(c);
            if (result == null || result.isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
            } else {
                ListView lv = (ListView) currentRoot.findViewById(R.id.listView21);
                lv.setAdapter(new UserAdaptercat(getActivity().getApplicationContext(), dbh.category(c)));
            }
        }
        if (v == foodbtn) {
            String f = "Food";
            Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
            ArrayList<details> result = dbh.category(f);
            if (result == null || result.isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(), "No Records Found!", Toast.LENGTH_LONG).show();
            } else {
                ListView lv = (ListView) currentRoot.findViewById(R.id.listView21);
                lv.setAdapter(new UserAdaptercat(getActivity().getApplicationContext(), dbh.category(f)));
            }
        }
    }
}
