package com.laurivan.retrofitobservable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.runtime.FlowContentObserver;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.Model;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity implements FlowContentObserver.OnModelStateChangedListener {

    FlowContentObserver observer;
    ItemAdapter itemAdapter;
    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlowManager.init(getApplicationContext());

        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MAIN", "Add Button Clicked");
                SampleTable st = new SampleTable();
                st.name = nextSessionId();
                st.save();
            }
        });
        button = (Button) findViewById(R.id.removeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MAIN", "Remove Button Clicked");
                SampleTable item = new Select().from(SampleTable.class).querySingle();
                if (item != null)
                    item.delete();
            }
        });

        // Add listeners to the model
        observer = new FlowContentObserver();
        observer.registerForContentChanges(this, SampleTable.class);

        itemAdapter = new ItemAdapter(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemAdapter);

        observer.addModelChangeListener(this);

    }

    @Override
    protected void onDestroy() {
        observer.removeModelChangeListener(this);
        observer.unregisterForContentChanges(this);

        super.onDestroy();
    }

    @Override
    public void onModelStateChanged(Class<? extends Model> table, BaseModel.Action action) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("MAIN", "Trigger a notification to the view...");
                itemAdapter.notifyDataSetChanged();
            }
        });
        //itemAdapter.notifyDataSetChanged();

    }
}
