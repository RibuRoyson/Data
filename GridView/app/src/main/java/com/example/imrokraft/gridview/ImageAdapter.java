package com.example.imrokraft.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by imrokraft on 9/3/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public Integer[] mThumbIds={
    R.drawable.ex7,R.drawable.ex8,R.drawable.ex9

    };
    public ImageAdapter(Context c){
        mContext=c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview=new ImageView(mContext);
        imageview.setImageResource(mThumbIds[position]);
        imageview.setScaleType(ImageView.ScaleType.CENTER);
        imageview.setLayoutParams(new GridView.LayoutParams(70,70));

        return imageview;
    }
}
