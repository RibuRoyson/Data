package com.example.imrokraft.gridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by imrokraft on 9/3/15.
 */
public class FullImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Intent inc=getIntent();
        int position=inc.getExtras().getInt("id");
        ImageAdapter imageadapter=new ImageAdapter(this);
        ImageView image=(ImageView)findViewById(R.id.imageView);
        image.setImageResource(imageadapter.mThumbIds[position]);
    }
}
