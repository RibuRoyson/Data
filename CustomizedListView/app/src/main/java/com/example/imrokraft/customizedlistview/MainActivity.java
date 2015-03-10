package com.example.imrokraft.customizedlistview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    UserAdapter myuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mylist=(ListView)findViewById(R.id.listView1);
        myuser=new UserAdapter(getApplicationContext(),Dummyuser());
        mylist.setAdapter(myuser);
    }
    public UserModel[] Dummyuser()
    {
        ArrayList<String> names=new ArrayList<>();
        names.add("Appu");
        names.add("Achu");
        names.add("Blitson");
        names.add("Adrash");
        names.add("Sonu");
        names.add("Melvin");

       ArrayList<String> emails=new ArrayList<>();
        emails.add("appu@gmail.com");
        emails.add("achu@yahoo.co.in");
        emails.add("blinkan@gmail.com");
        emails.add("devan@hotmail.com");
        emails.add("ssm@gmail.com");
        emails.add("mellu@gmail.com");

        UserModel[] userlist=new UserModel[names.size()];
        for(int i=0;i<emails.size();i++)
        {
            userlist[i]=new UserModel(names.get(i),emails.get(i));
        }
        return userlist;
    }

    @Override
    protected void onResume() {
        myuser.notifyDataSetChanged();
        super.onResume();
    }
}
