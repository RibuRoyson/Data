package com.imrokraft.multifragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Anoop CH on 25-03-2015.
 */
public class ListFragment extends Fragment {

    public ListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("John");
        arr.add("Jerry");
        arr.add("Jeny");
        arr.add("Jack");
        arr.add("Juniver");

        ListView lsv=(ListView)rootView.findViewById(R.id.mylistview);
        lsv.setAdapter(new UserAdapter(getActivity().getApplicationContext(), arr));

        return rootView;
    }

}
