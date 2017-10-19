package com.gdgvitvellore.devfest17;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import saschpe.android.customtabs.CustomTabsActivityLifecycleCallbacks;


public class App extends Application {

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
