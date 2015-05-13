package com.imrokraft.sampleproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by imrokraft on 8/5/15.
 */
public class MobileJava extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.mobile,container,false);
        return rootview;
    }
}
