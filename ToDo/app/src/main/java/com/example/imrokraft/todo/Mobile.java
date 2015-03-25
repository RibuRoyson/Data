package com.example.imrokraft.todo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by imrokraft on 25/3/15.
 */
public class Mobile extends Fragment {

    public Mobile()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_mobile, container, false);
        ListView mylist=(ListView)rootView.findViewById(R.id.listView3);
        UserAdapter myUserAdapter=new UserAdapter(getActivity().getApplicationContext(),Dummyusermodels());
        mylist.setAdapter(myUserAdapter);
        return rootView;
    }
    public UserModel[] Dummyusermodels()
    {
        String[] names={"Edit the draft for the flyer","Renew Subway Subscription","Edit the draft for the flyer","Send final version of our flyer to journeylists","Prepare announcement for the website","Planning Session","Doist Development meeting","Call Nancy"};
        String[] dates={"1","","1","1","3","","1","1"};
        String[] data={"Press","Team Planning","Team Planning","Press","Personal","Personal","IT Expo","IT Expo"};
        UserModel[] userlist=new UserModel[names.length];
        for(int i=0;i<dates.length;i++)
        {
            userlist[i]=new UserModel(names[i],dates[i],data[i]);
        }
        return userlist;
    }
}
