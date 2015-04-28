package com.imrokraft.webbrowser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {
    WebView webview;
    ProgressBar progress;
    String s1="facebook";
    String s2="googleplus";
    String s3="linkedin";
    String s4="twitter";
    String s5="youtube";
    String s6="gmail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webView);

        Intent in=getIntent();
        String s=in.getExtras().getString("key");
        if(s1.equals(s))
        {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.facebook.com");
        }
        else if(s2.equals(s))
        {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.plus.google.com");
        }
        else if(s3.equals(s))
        {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.linkedin.com");
        }
        else if(s4.equals(s))
        {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.twitter.com");
        }
        else if(s5.equals(s))
        {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.youtube.com");
        }
        else if(s6.equals(s))
        {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://www.gmail.com");
        }
        else {
            Intent inc = getIntent();
            String add = inc.getExtras().getString("address");
            String name = "https://www.google.com/search?q=";
            StringBuffer sb = new StringBuffer(50);
            String address1 = sb.append(name).append(add).toString();
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(address1);
        }
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                MainActivity.this.setValue(newProgress);
                super.onProgressChanged(view, newProgress);
            }

        });
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                // Handle the error
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;
            }
        });

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);
        Button go = (Button) findViewById(R.id.gobutton);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "https://www.google.com/search?q=";
                EditText address = (EditText) findViewById(R.id.edittext);
                String url = address.getText().toString();
                StringBuffer sb = new StringBuffer(50);
                String address1 = sb.append(name).append(url).toString();

                    if (validateUrl(address1)) {
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.loadUrl(address1);

                        MainActivity.this.progress.setProgress(0);
                    }


            }



        });
    }

    public void setValue(int progress) {
        this.progress.setProgress(progress);
    }

//    public void go(View v) {
//        EditText address = (EditText) findViewById(R.id.edittext);
//        String url = address.getText().toString();
//        if (validateUrl(url)) {
//            webview.getSettings().setJavaScriptEnabled(true);
//            webview.loadUrl(url);
//
//            MainActivity.this.progress.setProgress(0);
//        }
//
//    }
//    private boolean validateUrl(String url) {
//        return true;
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void back(View v) {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void forward(View v) {
        if (webview.canGoForward()) {
            webview.goForward();
        } else {

        }
    }

    public void exit(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                })
                .show();

    }
    private boolean validateUrl(String url) {
        return true;
    }

    public void home(View v) {
        Intent inc=new Intent(getApplication(),HomeActivity.class);
        startActivity(inc);

        }


    }

