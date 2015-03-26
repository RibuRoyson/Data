package com.example.imrokraft.myapps;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by imrokraft on 26/3/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ListFragment extends Fragment {
    public ListFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("Register");
        arr.add("Sign in");
        arr.add("Contact Us");
        arr.add("Exit");


        final ListView lsv=(ListView)rootView.findViewById(R.id.listViewfrag);
       ArrayAdapter<String> adap=new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,arr);
        lsv.setAdapter(adap);
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });

        return rootView;
    }
}
