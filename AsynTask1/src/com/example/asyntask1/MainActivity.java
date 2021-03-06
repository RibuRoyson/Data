package com.example.asyntask1;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	ProgressDialog pb;
	TextView tv;
	ImageView im;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void download(View v)
	{	
		//	pb=(ProgressBar)findViewById(R.id.progress1);
		tv=(TextView)findViewById(R.id.textView1);
		im=(ImageView)findViewById(R.id.imageView1);
		
		
		MyAsyntask myObj1=new MyAsyntask();
		myObj1.execute(((EditText)findViewById(R.id.editText1)).getText().toString());	
		
	}
	public void exit(View v)
	{
		finish();
	}

	class MyAsyntask extends AsyncTask<String, Void, String>
	{

		Bitmap bmp;
		@Override
		protected String doInBackground(String... params) {
			InputStream is=null;
			try
			{
				URL ulrn=new URL(params[0]);
				HttpURLConnection con=(HttpURLConnection)ulrn.openConnection();
				is=con.getInputStream();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			bmp=BitmapFactory.decodeStream(is);
			return null;
		}



		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pb=ProgressDialog.show(MainActivity.this,"Asyansample","Loading...");
			Toast.makeText(getApplicationContext(), "Started!!", Toast.LENGTH_SHORT).show();
		}

		@Override
		protected void onPostExecute(String result) {
			pb.dismiss();		
			im.setImageBitmap(bmp);
			Toast.makeText(getApplicationContext(), "Completed!!", Toast.LENGTH_SHORT).show();
			super.onPostExecute(result);
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}


	}
}
