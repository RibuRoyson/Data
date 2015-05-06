package com.imrokraft.expensefragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by imrokraft on 14/4/15.
 */
public class UserAdapter extends ArrayAdapter<details> {
    ArrayList<details> userslist;
    Context myContext;


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
    private View getCustomView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mlayoutInflater = LayoutInflater.from(myContext);
            convertView = mlayoutInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView id=(TextView) convertView.findViewById(R.id.textid1);
        TextView expen = (TextView) convertView.findViewById(R.id.textexp2);
        TextView cat = (TextView) convertView.findViewById(R.id.textcat3);
        TextView desc = (TextView) convertView.findViewById(R.id.textdes4);
        TextView tim = (TextView) convertView.findViewById(R.id.texttime5);
        TextView dat = (TextView) convertView.findViewById(R.id.textdate6);
        expen.setText(userslist.get(position).getExpense());
        cat.setText(userslist.get(position).getCat());
        desc.setText(userslist.get(position).getDescription());
        tim.setText(userslist.get(position).getTime1());
        dat.setText(userslist.get(position).getDate1());
        id.setText(userslist.get(position).getId());

//        convertView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                new View.OnCreateContextMenuListener() {
//                    @Override
//                    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//                        onCreateContextMenu(menu, v, menuInfo);
//                        MenuInflater menuinflater=new MenuInflater(getContext());
//                        menuinflater.inflate(R.menu.editdel,menu);
//                    }
//
//                };
//                return false;
//            }
//        });



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) myContext).b=new Bundle();

                ((MainActivity) myContext).b.putString("id", userslist.get(position).getId());
                ((MainActivity) myContext).b.putString("expense", userslist.get(position).getExpense());
                ((MainActivity) myContext).b.putString("cat", userslist.get(position).getCat());
                ((MainActivity) myContext).b.putString("description", userslist.get(position).getDescription());
                ((MainActivity) myContext).b.putString("time", userslist.get(position).getTime1());
                ((MainActivity) myContext).b.putString("date", userslist.get(position).getDate1());
                ((MainActivity) myContext).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame2,new EditData())
                        .commit();
            }
        });
        return convertView;
    }


}

