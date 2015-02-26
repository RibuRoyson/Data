package com.example.expensemanager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends Activity {
EditText et1,et2,et3,et4,et5,et6;
SQLiteDatabase db;
String dat,tim,id,ex,cat,des;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);
		et1=(EditText)findViewById(R.id.expet);
		et2=(EditText)findViewById(R.id.catet);
		et3=(EditText)findViewById(R.id.deset);
		et4=(EditText)findViewById(R.id.timeet);
		et5=(EditText)findViewById(R.id.dateet);
		et6=(EditText)findViewById(R.id.id);
	}
	public void editdetails(View v)
	{
		String id1=et6.getText().toString();
		dbhandler dbh=new dbhandler(this);
		Cursor c=null;
		c=dbh.update(id1);
		if(c!=null)
		{
			if(c.moveToFirst())
			{
				String e=c.getString(c.getColumnIndex("expense"));
				String ca=c.getString(c.getColumnIndex("cat"));
				String d=c.getString(c.getColumnIndex("description"));
				String t=c.getString(c.getColumnIndex("time"));
				String da=c.getString(c.getColumnIndex("date"));
				et1.setText(e);
				et2.setText(ca);
				et3.setText(d);
				et4.setText(t);
				et5.setText(da);
				c.close();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "No data",Toast.LENGTH_LONG).show();
			}
		}
		else
		{
			Toast.makeText(getApplicationContext(), "No data",Toast.LENGTH_LONG).show();
		}
	

}
	public void updatedata(View v)
	{
		dbhandler dbh=new dbhandler(this);
		ex=et1.getText().toString();
		cat=et2.getText().toString();
		des=et3.getText().toString();
		tim=et4.getText().toString();
		dat=et5.getText().toString();
		id=et6.getText().toString();
		dbh.updateDetails(ex,cat,des, tim, dat, id);
		Toast.makeText(getApplicationContext(), "Updated",Toast.LENGTH_LONG).show();
		et1.setText("");
		et2.setText("");
		et3.setText("");
		et4.setText("");
		et5.setText("");
		et6.setText("");
	}
	public void viewdata(View v)
	{
		Intent incr=new Intent(getApplicationContext(),viewdb.class);
		startActivity(incr);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.del:
			Intent inc=new Intent(getApplicationContext(),delete.class);
			startActivity(inc);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
