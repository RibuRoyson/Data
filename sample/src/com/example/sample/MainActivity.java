package com.example.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


	Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}
	public void forloop(View v)
	{
		for(;;)
		{
			Toast.makeText(getApplicationContext(), "for loop running", Toast.LENGTH_SHORT).show();
		}

	}
	public void threadrun(View v)
	{
		Thread th=new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++)
				{
					try
					{
						Thread.sleep(3000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}

					final int j=i;
					runOnUiThread(new Runnable() {
						public void run() {
							Toast.makeText(getApplicationContext(), "for loop running", Toast.LENGTH_SHORT).show();
							ProgressBar pb=(ProgressBar)findViewById(R.id.progressBar1);
							pb.setProgress(j*10);
						}
					});
				}

			}

		});
		th.start();
	}

}