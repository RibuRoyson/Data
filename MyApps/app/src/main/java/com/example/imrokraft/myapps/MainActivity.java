package com.example.imrokraft.myapps;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        removePreviousFragments();
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("Register");
        arr.add("Sign in");
        arr.add("Contact Us");
        arr.add("Exit");


        final ListView lsv=(ListView)findViewById(R.id.frame1);
        ArrayAdapter<String> adap=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arr);
        lsv.setAdapter(new UserAdapter(getApplicationContext(), arr));
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String s="Register";
                String s2="Sign in";
                String s3="Contact Us";
                String s4="Exit";
                String s1=lsv.getItemAtPosition(position).toString();
                if(s1.equals(s)) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame2, new Register())
                            .commit();
                }
                else if(s1.equals(s2))
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame2,new Signin())
                            .commit();

                }
                else if(s1.equals(s3))
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame2,new Contactus())
                            .commit();
                }
                else if (s1.equals(s4))
                {
                    AlertDialog.Builder alertdia=new AlertDialog.Builder(MainActivity.this);
                    alertdia.setTitle("Exit");
                    alertdia.setMessage("Are you sure?");
                    alertdia.setPositiveButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertdia.setNegativeButton("Yes",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            finish();
                        }
                    });
                    AlertDialog alert=alertdia.create();
                    alert.show();

                }

            }
        });


    }

//    private void removePreviousFragments() {
//        ArrayList<Fragment> al =new ArrayList<Fragment>( getSupportFragmentManager().getFragments());
////        if (al == null) {
////            // code that handles no existing fragments
////        }
//        for (Fragment frag : al) {
//            getSupportFragmentManager().beginTransaction().remove(frag).commit();
//        }
//    }


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
