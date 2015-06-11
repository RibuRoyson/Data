package com.imrokraft.databasesimple;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by imrokraft on 4/6/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this,"YRg6LkthSFL3sXBdc99VqQmUwoOi4fgBKoYnalXC","3ZPB7eUviJ8DEyVbasJgWakLGMd6UqLGcYIjb0k8");
    }
}
