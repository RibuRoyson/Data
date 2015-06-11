package com.imrokraft.databasesimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imrokraft on 4/6/15.
 */
public class UserAdapter extends ArrayAdapter<details> {
    ArrayList<details> userslist;
    Context myContext;
    final ArrayList<String> notes=new ArrayList<String>();
    final ArrayList<String> object=new ArrayList<String>();
    final ArrayList<String> notes2=new ArrayList<String>();
    String s1,email;
    SharedPreferences share;

    public UserAdapter(Context context, ArrayList<details> userlist) {
        super(context, R.layout.list_item, userlist);
        this.userslist = userlist;
        this.myContext = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }



    private View getCustomView(final int position, View convertView, ViewGroup parent) {

        share=myContext.getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
        email=share.getString("email",null);
        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("SimpleDB");
        query1.whereEqualTo("Email",email);
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
                }
            }
        });




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
//                    for (int i = 0; i < notes.size(); i++) {
//                        String ss = notes.get(i);
//                        notes2.add(ss);
//                    }
////                    System.out.println(notes2);
//                }
//            }
//        });
        if (convertView == null) {
            LayoutInflater mlayoutInflater = LayoutInflater.from(myContext);
            convertView = mlayoutInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.text2);
        TextView email = (TextView) convertView.findViewById(R.id.text3);
        TextView id=(TextView)convertView.findViewById(R.id.text1);
        name.setText(userslist.get(position).getName());
        email.setText(userslist.get(position).getQual());
        id.setText(String.valueOf(userslist.get(position).getId()));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getContext(), EditData.class);
                i.putExtra("id", userslist.get(position).getId());
                i.putExtra("name", userslist.get(position).getName());
                i.putExtra("qual", userslist.get(position).getQual());

                String dd =object.get(position).trim();
               /* for (int j = 0; j < object.size(); j++) {
                    s1 = object.get(j);

                }*/
                Toast.makeText(myContext, dd, Toast.LENGTH_SHORT).show();
                String ss=dd.toString().trim();
                i.putExtra("objectid",ss);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myContext.startActivity(i);

            }
        });


        return convertView;

    }
}

