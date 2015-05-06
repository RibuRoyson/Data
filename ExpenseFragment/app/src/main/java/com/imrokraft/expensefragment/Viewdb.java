package com.imrokraft.expensefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 5/5/15.
 */
public class Viewdb extends Fragment {
    ArrayList<details> userslist;
    ListView lv;
    UserAdapter myuser;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.view, container, false);
        lv = (ListView)root.findViewById(R.id.listView1);
        Dbhandler dbh = new Dbhandler(getActivity().getApplicationContext());
        userslist=dbh.resultdata();
        myuser = new UserAdapter(getActivity(), userslist);
        if (myuser.isEmpty() == true) {
            Toast.makeText(getActivity().getApplicationContext(), "Sorry No Entry!!", Toast.LENGTH_LONG).show();
        }else {

            lv.setAdapter(myuser);
        }
//        registerForContextMenu(lv);
        dbh.close();
        return  root;
    }


    @Override
    public void onResume() {
        super.onResume();

        myuser.notifyDataSetChanged();
        myuser.notifyDataSetInvalidated();

    }
}
