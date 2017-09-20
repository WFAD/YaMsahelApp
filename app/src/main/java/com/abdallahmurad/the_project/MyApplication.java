package com.abdallahmurad.the_project;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by AbdallahMurad on 8/28/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}
