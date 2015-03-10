package com.example.imrokraft.customizedlistview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by imrokraft on 10/3/15.
 */
public class UserAdapter extends ArrayAdapter<UserModel> {
UserModel[] userslist;
    Context myContext;


    public UserAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public UserAdapter(Context context, UserModel[] userlist) {
        super(context,R.layout.list_item,userlist);
        this.userslist=userlist;
        this.myContext=context;

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
        name.setText(userslist[position].getName());
        email.setText(userslist[position].getEmail());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               AddData.currentuser=userslist[position];

                Intent i = new Intent(getContext(),AddData.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myContext.startActivity(i);
            }
        });
        return convertView;
    }
}
