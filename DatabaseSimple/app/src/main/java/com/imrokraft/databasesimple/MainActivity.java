package com.imrokraft.databasesimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends ActionBarActivity {

    databasehandler dbh;
    EditText name, qual;
    String name1, qual1,uname,email;
    int id ;
    final ParseObject database=new ParseObject("SimpleDB");
    ParseUser newUser;
    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
//        ActionBar ab=getSupportActionBar();
//        ab.setLogo(R.drawable.messenger_bubble_small_blue);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.messenger_bubble_small_blue);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        share=getSharedPreferences("MyPrefs", MODE_PRIVATE);
        uname=share.getString("username", null);
        System.out.println("Username:"+uname);
        Toast.makeText(getApplicationContext(),"Logged In:"+uname,Toast.LENGTH_LONG).show();
//        ParseUser currentUser=ParseUser.getCurrentUser();
//        if (currentUser==null)
//        {
//            loadloginView();
//        }

    }
    public void loadloginView()
    {
        Intent intent=new Intent(this,ActivityLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void submitclick(View v) {
        databasehandler dbh=new databasehandler(getApplicationContext());
        int s=dbh.resultid();
        name = (EditText) findViewById(R.id.editname);
        qual = (EditText) findViewById(R.id.editqua);
        name1 = name.getText().toString();
        qual1 = qual.getText().toString();
        details d = new details(id, name1, qual1);
        d.setName(name1);
        d.setQual(qual1);

        dbh.insert(d);
        Toast.makeText(getApplicationContext(), "Details Submitted", Toast.LENGTH_SHORT).show();
        name.setText("");
        qual.setText("");
        share=getSharedPreferences("MyPrefs", MODE_PRIVATE);
        uname=share.getString("username", null);
        email=share.getString("email",null);
//        database.put("Id",s);
        database.put("Name",name1);
        database.put("Qualification", qual1);
        database.put("UserName",uname);
        database.put("Email",email);
        if (isNetworkAvailable(this)==true)
        {
            database.saveInBackground();
            Toast.makeText(getApplicationContext(), "Stored in cloud", Toast.LENGTH_SHORT).show();
        }else {
            database.pinInBackground();
            Toast.makeText(getApplicationContext(), "Stored in local", Toast.LENGTH_SHORT).show();
        }
        database.saveEventually(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not Done!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent inc=new Intent(MainActivity.this,MainActivity.class);
        startActivity(inc);
    }

    public void viewclick(View v) {
        Intent in = new Intent(getApplicationContext(), Second.class);
        startActivity(in);
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
        switch (item.getItemId()) {
            case R.id.edititem:
                Intent inc = new Intent(getApplication(), Third.class);
                startActivity(inc);
                break;
            case R.id.deleteitem:
                Intent incc = new Intent(getApplication(),Four.class);
                startActivity(incc);
                break;
            case R.id.action_settings:
                Intent inccc = new Intent(getApplication(),FaceBookLogin.class);
                startActivity(inccc);
                break;
            case R.id.cloud:
                Intent inc1=new Intent(getApplication(),ListSecond.class);
                startActivity(inc1);
                break;
            case R.id.action_logout:
                ParseUser.logOut();
                ParseUser newUser = ParseUser.getCurrentUser();
                loadloginView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    Log.w("INTERNET:", String.valueOf(i));

                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Log.w("INTERNET:", "connected!");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent obj=new Intent(Intent.ACTION_MAIN);
        obj.addCategory(Intent.CATEGORY_HOME);
        obj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(obj);
    }
}
