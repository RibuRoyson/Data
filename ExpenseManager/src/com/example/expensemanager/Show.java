package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Show extends Activitymain {
Button a,b,c;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		a=(Button)findViewById(R.id.all);
		b=(Button)findViewById(R.id.cat);
		c=(Button)findViewById(R.id.month);
		a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(getApplicationContext(),viewdb.class);
				startActivity(in);
			}
		});
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent inc=new Intent(getApplicationContext(),Bycat.class);
				startActivity(inc);
			}
		});
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent incc=new Intent(getApplicationContext(),monthwise.class);
				startActivity(incc);
			}
		});
	}

}
