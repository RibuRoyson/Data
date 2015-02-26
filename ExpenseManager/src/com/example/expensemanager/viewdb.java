package com.example.expensemanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class viewdb extends Activity{
ListView lv;
dbhandler dbh;
ArrayList<String> data;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view);
		
		lv=(ListView)findViewById(R.id.listView1);
		dbhandler dbh=new dbhandler(getApplicationContext());
		ArrayList<String> result=new ArrayList<String>();
		result=dbh.resultdata();
		if(result.isEmpty()==true)
		{
			Toast.makeText(viewdb.this, "Database Empty", Toast.LENGTH_LONG).show();
		}
		else
		{
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.mytextview,result);
			lv.setAdapter(adapter);
		}
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.item1:
			Intent in=new Intent(getApplicationContext(),showresult.class);
			startActivity(in);
		}
		return super.onOptionsItemSelected(item);
	}
	
	
		
	}
	

