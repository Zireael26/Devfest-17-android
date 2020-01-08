package com.gdgvitvellore.devfest17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME_OUT = 1200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Context context = SplashActivity.this;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                TaskStackBuilder.create(context)
                        .addNextIntentWithParentStack(new Intent(context, IntroActivity.class))
                        .startActivities();
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

}