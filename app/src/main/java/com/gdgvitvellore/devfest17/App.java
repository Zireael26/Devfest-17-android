package com.gdgvitvellore.devfest17;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import saschpe.android.customtabs.CustomTabsActivityLifecycleCallbacks;


public class App extends Application {

    private static final String TWITTER_KEY = "r8AmjQZ8hA9uyTdq2yNTL0pVa";
    private static final String TWITTER_SECRET = "orvzvJOadXsPKseaRNzuIHGmul2v7JKB3nsJIS7hcIdMgDptTG";
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());

        instance = this;
        registerActivityLifecycleCallbacks(new CustomTabsActivityLifecycleCallbacks());

    }
}
