package com.example.expensemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Viewdb extends Activity {
    ArrayList<details> userslist;
    ListView lv;
    UserAdapter myuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        lv = (ListView) findViewById(R.id.listView1);
        Dbhandler dbh = new Dbhandler(getApplicationContext());
        userslist=dbh.resultdata();
        myuser = new UserAdapter(getApplicationContext(), userslist);
        lv.setAdapter(myuser);

//        registerForContextMenu(lv);
        dbh.close();
  }

    @Override
    protected void onResume() {
        super.onResume();

        myuser.notifyDataSetChanged();
        myuser.notifyDataSetInvalidated();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//      super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.editdel,menu);
        Toast.makeText(getApplicationContext(),"Menu Created",Toast.LENGTH_SHORT).show();
        System.out.println("\n\n----------------------\n"+"menu created"+"\n\n--------------------------------");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        System.out.println("\n\n----------------------\n"+"menu selected"+"\n\n--------------------------------");

        switch(item.getItemId())
        {

            case R.id.edit1:
                Toast.makeText(getApplicationContext(),"Menu edited",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),EditData.class);
                i.putExtra("id",userslist.get(lv.getSelectedItemPosition()).getId());
                i.putExtra("expense", userslist.get(lv.getSelectedItemPosition()).getExpense());
                i.putExtra("cat", userslist.get(lv.getSelectedItemPosition()).getCat());
                i.putExtra("description", userslist.get(lv.getSelectedItemPosition()).getDescription());
                i.putExtra("time",userslist.get(lv.getSelectedItemPosition()).getTime1());
                i.putExtra("date",userslist.get(lv.getSelectedItemPosition()).getDate1());
                startActivity(i);
                break;
            case R.id.dele2:
//                myuser.notifyDataSetChanged();
//                myuser.notifyDataSetInvalidated();
                Toast.makeText(getApplicationContext(),"Menu deleted",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}


