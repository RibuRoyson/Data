package com.example.seekbar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
TextView tv;
Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

	}
	public void play(View v)
	{
		Thread th=new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++)
				{
					try
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}

					final int j=i;
					runOnUiThread(new Runnable() {
						public void run() {
							Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();
							SeekBar sb=(SeekBar)findViewById(R.id.seekBar1);
							sb.setProgress(j*10);
						}
					});
					if(i==10)
					{
						
					}
				}

			}

		});
		th.start();
		tv=(TextView)findViewById(R.id.textView1);
		tv.setText("Start mode Initiated");
	}
	public void stop(View v)
	{
		
	}
}
