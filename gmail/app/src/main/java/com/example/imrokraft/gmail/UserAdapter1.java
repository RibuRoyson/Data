package com.example.imrokraft.gmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by imrokraft on 19/3/15.
 */
public class UserAdapter1 extends ArrayAdapter<UserModel1> {
    UserModel1[] userlist;
    Context mycontext;
    public UserAdapter1(Context context, UserModel1[] userlist) {
        super(context,R.layout.secondlist,userlist);
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
            convertView=mlayoutinflater.inflate(R.layout.secondlist,parent,false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.namesec);
        TextView dates=(TextView)convertView.findViewById(R.id.datesec);
        TextView data=(TextView)convertView.findViewById(R.id.data1);
        TextView data1=(TextView)convertView.findViewById(R.id.datathird);
        TextView data2=(TextView)convertView.findViewById(R.id.datafour);
        ImageView icon=(ImageView)convertView.findViewById(R.id.image);
        name.setText(userlist[position].getName());
        dates.setText(userlist[position].getDates());
        data.setText(userlist[position].getData());
        data1.setText(userlist[position].getData2());
        data2.setText(userlist[position].getData3());
        return convertView;
    }
}
