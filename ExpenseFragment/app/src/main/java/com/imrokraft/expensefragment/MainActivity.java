package com.imrokraft.expensefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
Integer[] pics={R.drawable.addnew,
        R.drawable.sum,
        R.drawable.editdel,
        R.drawable.calender,
        R.drawable.category,
        R.drawable.settings,



};
    public Bundle b=null;
    String[] names={
            "Add","Sum","Edit/Delete","Show by Month","Show by Category","Settings"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayList<String> arr=new ArrayList<String>();
//        arr.add("Add");
//        arr.add("Sum");
//        arr.add("Edit/Delete");
//        arr.add("Show by Month");
//        arr.add("Show by Category");
//        arr.add("Settings");
        final ListView lsv=(ListView)findViewById(R.id.listfirst);
//        lsv.setAdapter(new UserAdapterlist(getApplicationContext(), arr));
        CustomListAdapter adapter=new CustomListAdapter(this,names,pics);

        lsv.setAdapter(adapter);
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removePreviousFragments();
                String s = "Add";
                String s2 = "Sum";
                String s3 = "Edit/Delete";
                String s4 = "Show by Month";
                String s5 = "Show by Category";
                String s6 = "Settings";
                String s1 = lsv.getItemAtPosition(position).toString();

                if (s1.equals(s)) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame2, new Addnew())
                            .commit();
                } else if (s1.equals(s2)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame2, new Showresult())
                            .commit();

                } else if (s1.equals(s3)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame2, new Viewdb())
                            .commit();
                } else if (s1.equals(s4)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame2, new Monthwise())
                            .commit();

                } else if (s1.equals(s5)) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame2, new Bycat())
                            .commit();

                }
            }
        });
            getSupportFragmentManager().beginTransaction()
            .add(R.id.frame2, new IdleClass())
                    .commit();




    }

    private void removePreviousFragments() {
        ArrayList<Fragment> al =new ArrayList<Fragment>( getSupportFragmentManager().getFragments());
        if (al==null) {
            return;
        }
        for (Fragment frag : al) {
            getSupportFragmentManager().beginTransaction().remove(frag).commit();
        }
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
