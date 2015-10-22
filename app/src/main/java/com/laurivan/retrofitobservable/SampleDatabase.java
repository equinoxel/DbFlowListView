package com.laurivan.retrofitobservable;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Sample database
 * <p/>
 * Created by ivanlla on 22/10/2015.
 */
@Database(name = SampleDatabase.NAME, version = SampleDatabase.VERSION)
public class SampleDatabase {

    public static final String NAME = "Sample";

    public static final int VERSION = 1;
}
