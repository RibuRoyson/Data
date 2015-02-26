package com.example.expensemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activitymain extends Activity {
ImageButton add;
ImageButton show;
ImageButton edit;
ImageButton et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		add=(ImageButton)findViewById(R.id.imageButton1);
		show=(ImageButton)findViewById(R.id.imageButton2);
		edit=(ImageButton)findViewById(R.id.imageButton3);
		et=(ImageButton)findViewById(R.id.imageButton4);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent aa=new Intent(getApplicationContext(),Add.class);
				startActivity(aa);
			}
		});
		show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent ab=new Intent(getApplicationContext(),Show.class);
				startActivity(ab);
				
			}
		});
		edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ac=new Intent(getApplicationContext(),edit.class);
				startActivity(ac);
						
			}
		});
		et.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openAlert();
			}
		});
	}
	public void openAlert()
	{
		AlertDialog.Builder alert=new AlertDialog.Builder(Activitymain.this);
		alert.setTitle(this.getTitle());
		alert.setMessage("Are you Sure");
		alert.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
alert.setNegativeButton("No",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				
			}
		});

		
AlertDialog alertdialog=alert.create();
alertdialog.show();
	}
	
}
