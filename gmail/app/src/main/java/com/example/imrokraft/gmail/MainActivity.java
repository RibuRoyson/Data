package com.example.imrokraft.gmail;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#DA4336"));
        ab.setBackgroundDrawable(colorDrawable);
        ListView mylistview=(ListView)findViewById(R.id.listview);
        UserAdapter myUserAdapter=new UserAdapter(getApplicationContext(),Dummyusermodels());
        mylistview.setAdapter(myUserAdapter);
    }
    public UserModel[] Dummyusermodels()
    {
        String[] names={"Regis Miller","Peter Johnson","Racheal Shin"};
        String[] dates={"Sep 29","Sep 29","Sep 29"};
        String[] data={"Maria i am trying to schedule a broad game night this week,when would you be... ","What do you think about sunday?My car seats five so i could pick up Dexter","to me"};
        UserModel[] userlist=new UserModel[names.length];
        for(int i=0;i<dates.length;i++)
        {
            userlist[i]=new UserModel(names[i],dates[i],data[i]);
        }
return userlist;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.next:
                Intent inc=new Intent(getApplicationContext(),Secondgmail.class);
                startActivity(inc);
        }
        return super.onOptionsItemSelected(item);
    }
}
