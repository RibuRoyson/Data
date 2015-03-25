package com.example.imrokraft.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by imrokraft on 23/3/15.
 */
public class UserAdapter extends ArrayAdapter<UserModel> {
    UserModel[] userlist;
    Context mycontext;
    public UserAdapter(Context context, UserModel[] userlist) {
        super(context,R.layout.list1,userlist);
        this.userlist=userlist;
        this.mycontext=context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    private View getCustomView(final int position,View convertView,ViewGroup parent)
    {
        if(convertView==null)
        {
            LayoutInflater mlayoutinflater=LayoutInflater.from(mycontext);
            convertView=mlayoutinflater.inflate(R.layout.list1,parent,false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.text1);
        TextView dates=(TextView)convertView.findViewById(R.id.text2);
        TextView data=(TextView)convertView.findViewById(R.id.text3);
        ImageView icon=(ImageView)convertView.findViewById(R.id.image);
        name.setText(userlist[position].getName());
        dates.setText(userlist[position].getDates());
        data.setText(userlist[position].getData());
        return convertView;
    }



}
