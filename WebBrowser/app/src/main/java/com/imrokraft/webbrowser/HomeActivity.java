package com.imrokraft.webbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by imrokraft on 28/4/15.
 */
public class HomeActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

    }
    public void facebook(View v)
    {
        String s="facebook";
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        in.putExtra("key",s);
        startActivity(in);
    }
    public void googleplus(View v)
    {
        String s="googleplus";
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        in.putExtra("key",s);
        startActivity(in);
    }
    public void linkedin(View v)
    {
        String s="linkedin";
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        in.putExtra("key",s);
        startActivity(in);
    }
    public void twitter(View v)
    {
        String s="twitter";
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        in.putExtra("key",s);
        startActivity(in);
    }
    public void youtube(View v)
    {
        String s="youtube";
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        in.putExtra("key",s);
        startActivity(in);
    }
    public void gmail(View v)
    {
        String s="gmail";
        Intent in=new Intent(getApplicationContext(),MainActivity.class);
        in.putExtra("key",s);
        startActivity(in);
    }
    public void go(View v)
    {
        EditText address=(EditText)findViewById(R.id.editaddress);
        String s=address.getText().toString();
        Intent inc=new Intent(getApplicationContext(),MainActivity.class);
        inc.putExtra("address",s);
        startActivity(inc);
    }
    public void exit1(View v)
    {

        System.exit(0);
    }
}
