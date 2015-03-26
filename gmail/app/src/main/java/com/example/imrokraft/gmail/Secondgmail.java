package com.example.imrokraft.gmail;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by imrokraft on 19/3/15.
 */
public class Secondgmail extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        ListView mylistview1=(ListView)findViewById(R.id.list2);
        UserAdapter1 myUserAdapter1=new UserAdapter1(getApplicationContext(),Dummyusermodels());
        mylistview1.setAdapter(myUserAdapter1);
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

