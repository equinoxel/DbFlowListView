package com.laurivan.retrofitobservable;

import android.app.Application;

/**
 * App container
 * <p/>
 * Created by ivanlla on 22/10/2015.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //FlowManager.init(this);
    }
}
