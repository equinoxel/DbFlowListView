package com.laurivan.retrofitobservable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * A sample table with an id (autoincrementing) and a name
 * Created by ivanlla on 22/10/2015.
 */
@Table(databaseName = SampleDatabase.NAME)
public class SampleTable extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;

}
