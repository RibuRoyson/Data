package com.example.imrokraft.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
    TextView name,phno,email,street,place;
    public static final String MyPreferences="MyPrefs";
    public static final String MyName="namekey";
    public static final String MyPhno="phnokey";
    public static final String MyEmail="emailkey";
    public static final String MyStreet="streetkey";
    public static final String MyPlace="placekey";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText);
        phno=(EditText)findViewById(R.id.editText1);
        email=(EditText)findViewById(R.id.editText2);
        street=(EditText)findViewById(R.id.editText3);
        place=(EditText)findViewById(R.id.editText4);
        sharedPreferences=getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
    }
    public void save(View v)
    {
        String n=name.getText().toString();
        String ph=phno.getText().toString();
        String e=email.getText().toString();
        String s=street.getText().toString();
        String p=place.getText().toString();
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(MyName,n);
        editor.putString(MyPhno,ph);
        editor.putString(MyEmail,e);
        editor.putString(MyStreet,s);
        editor.putString(MyPlace,p);
        editor.commit();
        Intent in=new Intent(this,second.class);
        startActivity(in);
    }
}
