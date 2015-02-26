package com.example.expensemanager;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class monthwise extends Activity {
ListView lvv;
dbhandler dbh;
TextView tv;
int i=0;
int length;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monthwise);
		tv=(TextView)findViewById(R.id.text1);
		registerForContextMenu(tv);
		lvv=(ListView)findViewById(R.id.list1);
		
		
		
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId())
		{
		case R.id.janu:
		{
			 i=1;
			dbhandler dbh=new dbhandler(getApplicationContext());
		ArrayList<String> results=new ArrayList<String>();
		results=dbh.monthWiseData(i);
	 length=results.size();
		Log.e("arraylist length", ""+length);
		if(length==0)
		{
			Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
		}
		else
		{
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,results);
			lvv.setAdapter(adapter);
		}
		break;
		}
		case R.id.feb:
		{
			i=2;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.mar:
		{
			i=3;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.apr:
		{
			i=4;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.may:
		{
			i=5;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.jun:
		{
			i=6;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.jul:
		{
			i=7;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.aug:
		{
			i=8;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.sep:
		{
			i=9;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.oct:
		{
			i=10;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.nov:
		{
			i=11;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		case R.id.dec:
		{
			i=12;
			dbhandler dbh=new dbhandler(getApplicationContext());
			ArrayList<String> result=new ArrayList<String>();
			result=dbh.monthWiseData(i);
			if(result.isEmpty()==true)
			{
				Toast.makeText(monthwise.this, "Database Empty", Toast.LENGTH_LONG).show();
			}
			else
			{
				ArrayAdapter<String> adapter=new ArrayAdapter<String>(monthwise.this,android.R.layout.simple_list_item_1,result);
				lvv.setAdapter(adapter);
			}
			break;
		}
		}
		return super.onContextItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.month, menu);
	}

}
