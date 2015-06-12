package com.imrokraft.databasesimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imrokraft on 8/6/15.
 */
public class ListSecond extends ActionBarActivity {
    String email,emailfb;
    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listsecond);
        final ArrayList<String> notes=new ArrayList<String>();
        final ArrayList<String> object=new ArrayList<String>();
        final ArrayList<String> notes2=new ArrayList<String>();
        final ListView lv=(ListView)findViewById(R.id.list);

        share=getSharedPreferences("UsernamePrefs", Context.MODE_PRIVATE);
        int ab=share.getInt("loginfb",0);
        if (ab==1)
        {
            emailfb=share.getString("emailfb",null);
            ParseQuery<ParseObject> query1 = ParseQuery.getQuery("SimpleDB");
            query1.whereEqualTo("Email",emailfb);
            query1.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {
                        for (ParseObject post : list) {
//                        System.out.println(post.getObjectId());
//                        System.out.println(post.getString("Name"));
//                        System.out.println(post.getString("Qualification"));
                            notes.add(post.getString("Name"));
                            object.add(post.getObjectId());
                        }
                        for (int i = 0; i < notes.size(); i++) {
                            String ss = notes.get(i);
                            notes2.add(ss);
                        }
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListSecond.this,android.R.layout.simple_list_item_1,notes2);
                        lv.setAdapter(adapter);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                object.get(position);
                                Toast.makeText(getApplication(), object.get(position).toString(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            });

        }else {
            email = share.getString("email", null);
            ParseQuery<ParseObject> query1 = ParseQuery.getQuery("SimpleDB");
            query1.whereEqualTo("Email", email);
            query1.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {
                        for (ParseObject post : list) {
//                        System.out.println(post.getObjectId());
//                        System.out.println(post.getString("Name"));
//                        System.out.println(post.getString("Qualification"));
                            notes.add(post.getString("Name"));
                            object.add(post.getObjectId());
                        }
                        for (int i = 0; i < notes.size(); i++) {
                            String ss = notes.get(i);
                            notes2.add(ss);
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListSecond.this, android.R.layout.simple_list_item_1, notes2);
                        lv.setAdapter(adapter);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                object.get(position);
                                Toast.makeText(getApplication(), object.get(position).toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            });
        }


//        ParseQuery<ParseObject> query=ParseQuery.getQuery("SimpleDB");
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> list, ParseException e) {
//                if (e == null) {
//                    for (ParseObject post : list) {
////                        System.out.println.(post.getObjectId());
////                        System.out.println(post.getString("Name"));
////                        System.out.println(post.getString("Qualification"));
//
//
//                        notes.add(post.getString("Name"));
//                        object.add(post.getObjectId());
//                        //System.out.println(notes);
//                    }
//
//                    for (int i = 0; i < notes.size(); i++)
//                    {
//                    String ss= notes.get(i);
//                        notes2.add(ss);
//                    }
//                    System.out.println(notes2);
//                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListSecond.this,android.R.layout.simple_list_item_1,notes2);
//                    lv.setAdapter(adapter);
//                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            object.get(position);
//                            Toast.makeText(getApplication(), object.get(position).toString(),Toast.LENGTH_LONG).show();
//                        }
//                    });
//            }
//        }
//    });
        System.out.println(notes);

    }

}
