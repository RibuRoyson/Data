package com.example.imrokraft.runtimedb2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by imrokraft on 13/4/15.
 */
public class UserAdapter extends ArrayAdapter<details> {
    ArrayList<details> userslist;
    Context myContext;


    public UserAdapter(Context context, ArrayList<details> userlist) {
        super(context,R.layout.list_item,userlist);
        this.userslist=userlist;
        this.myContext=context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    private View getCustomView(final int position,View convertView,ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater mlayoutInflater=LayoutInflater.from(myContext);
            convertView=mlayoutInflater.inflate(R.layout.list_item,parent,false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.text1);
        TextView email=(TextView)convertView.findViewById(R.id.text2);
//        TextView id=(TextView)convertView.findViewById(R.id.text3);
        name.setText(userslist.get(position).getName());
        email.setText(userslist.get(position).getQual());
//        id.setText(userslist.get(position).getId());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i = new Intent(getContext(),AddData.class);
i.putExtra("id",userslist.get(position).getId());
                i.putExtra("name",userslist.get(position).getName());
                i.putExtra("qual",userslist.get(position).getQual());

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myContext.startActivity(i);
            }
        });
     return convertView;
    }
}

