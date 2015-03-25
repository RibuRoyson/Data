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
public class Fragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment1,container,false);
        ListView mylistview=(ListView)rootview.findViewById(R.id.mylist1);
        UserAdapter myUserAdapter=new UserAdapter(getActivity().getApplicationContext(),Dummyusermodels());
        mylistview.setAdapter(myUserAdapter);

        return rootview;
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
