package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ProgressBar percentageBar;
	TextView txtStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		percentageBar=(ProgressBar)findViewById(R.id.downloadProgress); 
		txtStatus=(TextView)findViewById(R.id.txtLabel_status);
	}


	public void startDownload(View v) {
		MyAsyncTask myObj=new MyAsyncTask();
		myObj.execute("http://www.google.co.in/logo1.png","http://www.google.co.in/logo2.png","http://www.google.co.in/logo3.png");
	}

	class MyAsyncTask extends AsyncTask<String, Integer, String>{

		@Override
		protected void onPreExecute() {
			Toast.makeText(getApplicationContext(), "Starting Async", Toast.LENGTH_LONG).show();
		}

		@Override
		protected String doInBackground(String... params) {
			for (int j = 0; j < params.length; j++) {
				System.out.println("Downloading - "+params[j]);
				downlaodFile(params[j]);
			}
			return "Finished doInBackground Thread";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			Toast.makeText(getApplicationContext(), "Running onProgressUpdate", Toast.LENGTH_LONG).show();
		}

		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();

		}

		private void downlaodFile(final String fileURL){

			runOnUiThread(new Runnable() {
				public void run() {
					percentageBar.setProgress(0);
				}
			});


			try {
				for (int i = 0; i < 100; i+=10) {
					Thread.sleep(1000);
					final int k=i;
					runOnUiThread(new Runnable() {
						public void run() {
							percentageBar.setProgress(k);
							txtStatus.setText("Downloading.. \n"+k+"% complete.\n"+fileURL);
						}
					});
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
