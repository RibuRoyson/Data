package com.example.expensemanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends Activity {
EditText dele;
Button a;
dbhandler dbh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete);
		dele=(EditText)findViewById(R.id.del);
		a=(Button)findViewById(R.id.deleted);
		a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String idd=dele.getText().toString();
				dbhandler dbh=new dbhandler(delete.this);
				dbh.deletedetails(idd);
				String s=dbh.deleted;
				if(s=="true")
				{
					Toast.makeText(delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(delete.this, "No data found", Toast.LENGTH_LONG).show();
				}
				dele.setText("");
			}
		});
	}
	

}
