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
public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_1, container, false);
        ListView mylistview1 = (ListView) rootview.findViewById(R.id.listViewfrag);
        UserAdapter1 myUserAdapter1=new UserAdapter1(getActivity().getApplicationContext(),Dummyusermodels());
        mylistview1.setAdapter(myUserAdapter1);
        return rootview;
    }

    public UserModel1[] Dummyusermodels()
    {
        String[] names1={"Andy Brown","Keri Anderson","Regis,Peter,Racheal"};
        String[] dates1={"1:45PM","1:39PM","Sep 29"};
        String[] data1={"Bring your parents to workday!","Picture from last Saturday",""};
        String[] data2={"Hey what do you think about a...","Check out the new friend we made","Sunday works!!"};
        String[] data3={"Work","Fun","Family"};
        UserModel1[] userlist=new UserModel1[names1.length];
        for(int i=0;i<dates1.length;i++)
        {
            userlist[i]=new UserModel1(names1[i],dates1[i],data1[i],data2[i],data3[i]);
        }
        return userlist;
    }
}


