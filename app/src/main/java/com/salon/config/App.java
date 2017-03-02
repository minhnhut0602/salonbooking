package com.salon.config;

import android.app.Application;
import android.content.Context;

/**
 * Created by cis on 30/11/16.
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Context getContext() {
        return mContext;
    }
}
