package com.example.imrokraft.sampleexpensetracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 30/3/15.
 */
public class Createclass extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview=inflater.inflate(R.layout.create,container,false);
        final Spinner sp=(Spinner)rootview.findViewById(R.id.spinnercat);
        ArrayList<String> val=new ArrayList<>();
        val.add("Food");
        val.add("Clothing");
        val.add("Drinks");
        ArrayAdapter<String> adapater=new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,val);
        sp.setAdapter(adapater);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s=sp.getItemAtPosition(position).toString();
                Toast.makeText(getActivity().getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootview;
    }
}
