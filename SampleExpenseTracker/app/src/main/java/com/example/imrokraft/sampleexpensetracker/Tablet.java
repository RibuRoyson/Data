package com.example.imrokraft.sampleexpensetracker;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by imrokraft on 30/3/15.
 */
public class Tablet extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Create");
        arr.add("Edit");
        arr.add("View");
        arr.add("Exit");
        final ListView lsv = (ListView) findViewById(R.id.listView);
        lsv.setAdapter(new UserAdapter(getApplicationContext(), arr));
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removePreviousFragments();
                String s = "Create";
                String s2 = "Edit";
                String s3 = "View";
                String s4 = "Exit";
                String s1 = lsv.getItemAtPosition(position).toString();

                if (s1.equals(s)) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.frame1, new Createclass())
                            .commit();
                } else if (s1.equals(s2)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame1, new Editclass())
                            .commit();

                } else if (s1.equals(s3)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame1, new Viewclass())
                            .commit();
                } else if (s1.equals(s4)) {
                    new AlertDialog.Builder(Tablet.this)
                            .setTitle("Exit")
                            .setMessage("Are you sure")
                            .setPositiveButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Tablet.this.finish();
                                }
                            })
                            .setIcon(R.drawable.ic_launcher)
                            .show();
                }
            }
        });
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame1, new Createclass())
                .commit();
    }
    private void removePreviousFragments() {
        ArrayList<Fragment> al = new ArrayList<Fragment>(getSupportFragmentManager().getFragments());
        if (al == null) {
            return;
        }
        for (Fragment frag : al) {
            getSupportFragmentManager().beginTransaction().remove(frag).commit();

        }

    }
}

