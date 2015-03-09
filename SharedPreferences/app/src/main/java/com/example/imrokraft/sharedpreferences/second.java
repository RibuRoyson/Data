package com.example.imrokraft.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by imrokraft on 9/3/15.
 */
public class second extends Activity {
    public static  final String MyPreferences="MyPrefs";
    TextView tname,tphone,tstreet,temail,tplace;
    SharedPreferences sharePreferences;
    public static final String MyName="namekey";
    public static final String MyPhno="phnokey";
    public static final String MyEmail="emailkey";
    public static final String MyStreet="streetkey";
    public static final String MyPlace="placekey";
    String name,phone,street,email,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        tname=(TextView)findViewById(R.id.textView5);
        tphone=(TextView)findViewById(R.id.textView6);
        temail=(TextView)findViewById(R.id.textView7);
        tstreet=(TextView)findViewById(R.id.textView8);
        tplace=(TextView)findViewById(R.id.textView9);
        sharePreferences=getSharedPreferences(MyPreferences,MODE_PRIVATE);
        name=sharePreferences.getString(MyName,null);
        email=sharePreferences.getString(MyEmail,null);
        phone=sharePreferences.getString(MyPhno,null);
        street=sharePreferences.getString(MyStreet,null);
        place=sharePreferences.getString(MyPlace,null);
        tname.setText(name);
        tphone.setText(phone);
        temail.setText(email);
        tstreet.setText(street);
        tplace.setText(place);

    }
}
