package com.example.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(savedInstanceState==null){
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new MyFragment1()).
			commit();	
		}
	}



	public void onButton1Click(View v) {
		Toast.makeText(getApplicationContext(), "Button1 clicked", Toast.LENGTH_SHORT).show();	
		removePreviousFragments();
		getSupportFragmentManager().beginTransaction()
		.add(R.id.container, new MyFragment1()).
		commit();
	}

	public void onButton2Click(View v) {
		Toast.makeText(getApplicationContext(), "Button2 clicked", Toast.LENGTH_SHORT).show();	
		removePreviousFragments();
		getSupportFragmentManager().beginTransaction()
		.add(R.id.container, new MyFragment2()).
		commit();
	}


	public void onButton3Click(View v) {
		Toast.makeText(getApplicationContext(), "Button3 clicked", Toast.LENGTH_SHORT).show();
		removePreviousFragments();
		getSupportFragmentManager().beginTransaction()
		.add(R.id.container, new MyFragment3()).
		commit();
	}

	private void removePreviousFragments() {
		ArrayList<Fragment> al=new ArrayList<Fragment>(getSupportFragmentManager().getFragments());
		if(al==null || al.size()<1){
			return;
		}
		for(Fragment frag:al)
			getSupportFragmentManager().beginTransaction().remove(frag).commit();
	}
}
