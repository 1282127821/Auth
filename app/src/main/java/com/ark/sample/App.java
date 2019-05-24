package com.ark.sample;

import android.app.Application;

public class App extends Application {

    private static App _instance;

    public static App get() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (_instance == null) {
            _instance = this;
        }
        initialize();
    }

    public void initialize() {

    }
}
