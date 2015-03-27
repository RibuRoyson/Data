package com.example.imrokraft.cusdialog;

import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.customsecond);
                dialog.setTitle("Are you sure?");
                TextView text=(TextView)dialog.findViewById(R.id.textView);
                text.setText("Do you really what to exit?");
                ImageView image=(ImageView)dialog.findViewById(R.id.imageView);
                image.setImageResource(R.drawable.questionmark);
                Button diabutton=(Button)dialog.findViewById(R.id.button2);
                diabutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       MainActivity.this.finish();
                        System.exit(0);
                    }
                });
                Button b2=(Button)dialog.findViewById(R.id.button3);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }



}
