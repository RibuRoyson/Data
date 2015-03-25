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
public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment2,container,false);
        ListView mylistview=(ListView)rootview.findViewById(R.id.mylist2);
        UserAdapter myUserAdapter=new UserAdapter(getActivity().getApplicationContext(),Dummyusermodels());
        mylistview.setAdapter(myUserAdapter);

        return rootview;
    }
    public UserModel[] Dummyusermodels()
    {
        String[] names={"Check proposals on Elance","Prepare announcement for the website","BrainStorm with the team"};
        String[] dates={"1","3","1"};
        String[] data={"Personnel","Team Planning","Team Planning"};
        UserModel[] userlist=new UserModel[names.length];
        for(int i=0;i<dates.length;i++)
        {
            userlist[i]=new UserModel(names[i],dates[i],data[i]);
        }
        return userlist;
    }
}
