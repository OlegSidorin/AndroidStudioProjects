package com.sidorin.contactlist;

import android.app.Application;
import android.content.Context;

public class MyContacts extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyContacts.context = getApplicationContext();
    }
    public static Context getAppContext(){
        return MyContacts.context;
    }
}
