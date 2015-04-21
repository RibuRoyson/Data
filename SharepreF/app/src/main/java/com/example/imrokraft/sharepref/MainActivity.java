package com.example.imrokraft.sharepref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;


public class MainActivity extends ActionBarActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Mypref", Context.MODE_PRIVATE);
    }

    public void register(View view) {
        EditText fname = (EditText) findViewById(R.id.editText3);
        EditText lname = (EditText) findViewById(R.id.editText4);
        EditText user = (EditText) findViewById(R.id.editText5);
        EditText pass = (EditText) findViewById(R.id.editText6);
        String name = fname.getText().toString();
        String lastname = lname.getText().toString();
        String username = user.getText().toString();
        String password = pass.getText().toString();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor ed = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        ed.putString("name", name);
        ed.putString("lname", lastname);
        ed.putString("user", username);
        ed.putString("pass", password);

        fname.setText("");
        lname.setText("");
        user.setText("");
        pass.setText("");
        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
        String currentuservalues = name + "," + lastname + "," + username + "," + password;
        if (!sp.getString("previous_registrations", "").equals("")) {
            //already some registered
            currentuservalues = sp.getString("previous_registrations", "") + "|" + currentuservalues;
        }
        ed.putString("previous_registrations", currentuservalues);
        ed.commit();
    }

    public void signin(View v) {
        EditText edit_user = (EditText) findViewById(R.id.editText);
        EditText edit_pass = (EditText) findViewById(R.id.editText2);

        String username_entered = edit_user.getText().toString();
        String password_entered = edit_pass.getText().toString();
        boolean loginStatus = false;

        String alluser = (PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).getString("previous_registrations", "");
        if (alluser.contains(username_entered)) {
            StringTokenizer stk = new StringTokenizer(alluser, "|");
            StringTokenizer stk2 = null;
            int no_of_users = stk.countTokens();
            String usename = "";
            String passw = "";
            for (int i = 0; i < no_of_users; i++) {
                stk2 = new StringTokenizer(stk.nextToken(), ",");
                usename = (stk2.nextToken());
                passw = (stk2.nextToken());
                //				name=(stk2.nextToken());
                //				mail=(stk2.nextToken());
                //				phone=(stk2.nextToken());
                //				photo=(stk2.nextToken());
                if (usename.equalsIgnoreCase(username_entered) && passw.equals(password_entered)) {
                    Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, Second.class));


//                    loginStatus = true;
//                    SharedPreferences.Editor e = (PreferenceManager.getDefaultSharedPreferences(getApplicationContext())).edit();
//                    e.putString("user", username_entered);
//                    e.putString("pass", password_entered);
//                    e.putString("name", stk2.nextToken());
//                    e.commit();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "login Failed", Toast.LENGTH_LONG).show();
                }

            }
        } else {
            Toast.makeText(getApplicationContext(), "User doesn\'t Exist  Register First.", Toast.LENGTH_LONG).show();
                }
//        if (loginStatus) {
//            Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(this, Second.class));
//        } else {
//            Toast.makeText(getApplicationContext(), "Login Failed\n Enter correct Username and Password.", Toast.LENGTH_LONG).show();
//        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
