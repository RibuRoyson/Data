package com.example.imrokraft.myapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by imrokraft on 26/3/15.
 */
public class UserAdapter extends ArrayAdapter<String> {
    Context myContext;
    ArrayList<String> myList;

    public UserAdapter(Context myContext, ArrayList<String> myList) {
        super(myContext, R.layout.list_item, myList);
        this.myContext = myContext;
        this.myList = myList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(myContext);
            convertView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.textcontent)).setText(myList.get(position));
        return convertView;
    }
}