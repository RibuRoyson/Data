package com.example.imrokraft.mygalleryview;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    Integer[] pics={
            R.drawable.ex13,R.drawable.ex14,R.drawable.ex15,R.drawable.ex2,R.drawable.ex3
    };
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery ga = (Gallery) findViewById(R.id.gallery);
        ga.setAdapter(new ImageAdapter(this));
        iv = (ImageView) findViewById(R.id.imageView);
        ga.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View view, int arg2, long id) {
                                          iv.setImageResource(pics[arg2]);
                                      }
                                  }

        );


    }



    public class ImageAdapter extends BaseAdapter {

        private Context ctx;


        public ImageAdapter(Context c) {
            ctx=c;
        }

        @Override
        public int getCount() {
            return pics.length;
        }

        @Override
        public Object getItem(int arg0) {
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            ImageView  iv=new ImageView(ctx);
            iv.setImageResource(pics[arg0]);
            iv.setScaleType(ImageView.ScaleType.CENTER);
            iv.setLayoutParams(new Gallery.LayoutParams(150,220));
            return iv;
        }
    }

}

