package com.example.imrokraft.gmail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by imrokraft on 26/3/15.
 */
public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_2, container, false);
        ListView mylistview = (ListView) rootview.findViewById(R.id.listView2frag);
        UserAdapter myUserAdapter = new UserAdapter(getActivity().getApplicationContext(), Dummyusermodels());
        mylistview.setAdapter(myUserAdapter);
        return rootview;
    }

    public UserModel[] Dummyusermodels() {
        String[] names = {"Regis Miller", "Peter Johnson", "Racheal Shin"};
        String[] dates = {"Sep 29", "Sep 29", "Sep 29"};
        String[] data = {"Maria i am trying to schedule a broad game night this week,when would you be... ", "What do you think about sunday?My car seats five so i could pick up Dexter", "to me"};
        UserModel[] userlist = new UserModel[names.length];
        for (int i = 0; i < dates.length; i++) {
            userlist[i] = new UserModel(names[i], dates[i], data[i]);
        }
        return userlist;
    }

    }

