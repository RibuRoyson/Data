package com.imrokraft.databasesimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imrokraft on 4/6/15.
 */
public class Second extends ActionBarActivity {
    UserAdapter myuser;
    final ParseObject database=new ParseObject("SimpleDB");
    ParseQuery<ParseObject> query = ParseQuery.getQuery("SimpleDB");
    final ArrayList<String> object=new ArrayList<String>();
    final ArrayList<String> notes=new ArrayList<String>();
    final ArrayList<String> notes2=new ArrayList<String>();
    ListView list;
    SharedPreferences share;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        list = (ListView) findViewById(R.id.listView);
        databasehandler dbh = new databasehandler(getApplicationContext());
        myuser = new UserAdapter(getApplicationContext(), dbh.resultdata());

        list.setAdapter(myuser);
        if (isNetworkAvailable(this)==true)
        {
//            String obj=database.getObjectId();
//            ParseQuery<ParseObject> query=ParseQuery.getQuery("SimpleDB");
//            query.findInBackground(new FindCallback<ParseObject>() {
//                @Override
//                public void done(List<ParseObject> list, ParseException e) {
//                    if (e == null) {
//                        for (ParseObject post : list) {
//                            System.out.println(post.getObjectId());
//                            System.out.println(post.getString("Name"));
//                            System.out.println(post.getString("Qualification"));
//                            notes.add(post.getString("Name"));
//                            object.add(post.getObjectId());
//                        }
//                        for (int i = 0; i < notes.size(); i++) {
//                            String ss = notes.get(i);
//                            notes2.add(ss);
//                        }
//                    }
//                }
//            });

            share=getSharedPreferences("MyPrefs", MODE_PRIVATE);
            email=share.getString("email",null);
            ParseQuery<ParseObject> query1 = ParseQuery.getQuery("SimpleDB");
            query1.whereEqualTo("Email",email);
            query1.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> list, ParseException e) {
                    if (e == null) {
                        for (ParseObject post : list) {
                            System.out.println(post.getObjectId());
                            System.out.println(post.getString("Name"));
                            System.out.println(post.getString("Qualification"));
                            notes.add(post.getString("Name"));
                            object.add(post.getObjectId());
                        }
                        for (int i = 0; i < notes.size(); i++) {
                            String ss = notes.get(i);
                            notes2.add(ss);
                        }
                    }
                }
            });

            System.out.println(notes);
//            query.getInBackground("jQpNxpdctK", new GetCallback<ParseObject>() {
//                @Override
//                public void done(ParseObject parseObject, ParseException e) {
//                    if (e==null)
//                    {
////                        int id=database.getInt("Id");
//                        String name=database.getString("Name");
//                        String qual=database.getString("Qualification");
////                        System.out.println("id:"+id);
//                        System.out.println("name:"+name);
//                        System.out.println("qual:"+qual);
//                    }
//                    else {
//                        System.out.println("Something Wrong!!"+e.getMessage());
//                    }
//                }
//            });
        }
        else
        {
            String obj1=database.getObjectId();
            query.fromLocalDatastore();
            query.getInBackground("jQpNxpdctK", new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject parseObject, ParseException e) {
                    if (e==null)
                    {
//                        int id=database.getInt("Id");
                        String name=database.getString("Name");
                        String qual=database.getString("Qualification");
//                        System.out.println("id:"+id);
                        System.out.println("name:"+name);
                        System.out.println("qual:"+qual);

                    }
                    else {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(Second.this,"list",Toast.LENGTH_LONG).show();
            }
        });
//        if(result.isEmpty())
//        {
//            Toast.makeText(getApplicationContext(),"Database Empty",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result);
//            list.setAdapter(adapter);
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
    protected void onResume() {
        super.onResume();
        myuser.notifyDataSetChanged();
        myuser.notifyDataSetInvalidated();
    }

}
