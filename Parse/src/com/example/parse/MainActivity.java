package com.example.parse;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void click(View v)
	{
		Parse.initialize(this, "JNPQWKtYPLMWjkzZrvW2cISCCCQzVaf5F1SF7B9z", "XRvS2OQmjoVyzQXoARgs59xLtzj99QnjyU0tTkQZ");
		ParseObject gameScore = new ParseObject("GameScore");
		gameScore.put("score", 1575);
		gameScore.put("playerName", "Sean Plott");
		gameScore.put("cheatMode", false);
		gameScore.saveEventually();
		Toast.makeText(getApplicationContext(), "Hey there!", Toast.LENGTH_SHORT).show();
	}


}
