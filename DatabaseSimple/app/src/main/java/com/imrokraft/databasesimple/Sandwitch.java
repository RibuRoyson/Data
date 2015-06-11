package com.imrokraft.databasesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.parse.ParseUser;

/**
 * Created by imrokraft on 10/6/15.
 */
public class Sandwitch extends ActionBarActivity {
    ParseUser newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent inc=getIntent();
//        String uname=inc.getExtras().getString("username");
//        String pword=inc.getExtras().getString("passwrod");
//        try {
            newUser = ParseUser.getCurrentUser();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Username:"+uname);
//        Toast.makeText(getApplicationContext(),uname,Toast.LENGTH_LONG).show();
//        System.out.println("Password:"+pword);
        if (newUser!=null)
        {
            Intent intentabc=new Intent(this,MainActivity.class);
            startActivity(intentabc);
        }
        else {
            Intent intentabcd=new Intent(this,ActivityLogin.class);
            startActivity(intentabcd);
        }
    }
}
