package com.example.imrokraft.frag;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by imrokraft on 24/3/15.
 */
public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment2,container,false);
        return  rootview;
    }


}
