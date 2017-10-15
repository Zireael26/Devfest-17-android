package com.gdgvitvellore.devfest17;

import android.app.Application;

import saschpe.android.customtabs.CustomTabsActivityLifecycleCallbacks;


public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        registerActivityLifecycleCallbacks(new CustomTabsActivityLifecycleCallbacks());

    }
}
