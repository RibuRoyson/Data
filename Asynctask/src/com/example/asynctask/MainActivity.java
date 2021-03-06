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
		String currentURL="";

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
			percentageBar.setProgress(values[0]);
			txtStatus.setText("Downloading.. \n"+values[0]+"% complete.\n"+currentURL);
		}

		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();

		}

		private void downlaodFile(final String fileURL){
			currentURL=fileURL;
			publishProgress(0);

			try {
				for (int i = 0; i < 101; i+=10) {
					Thread.sleep(1000);
					publishProgress(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
