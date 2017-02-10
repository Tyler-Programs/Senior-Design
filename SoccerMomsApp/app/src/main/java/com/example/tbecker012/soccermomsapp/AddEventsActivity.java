package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class AddEventsActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button asb, mmb, db;
    public EditText nf, df, tf, lf;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);
        init();
    }

    public void init() {
        asb = (Button) findViewById(R.id.addEventButton);
        mmb = (Button) findViewById(R.id.mainMenuButton);
        db = (Button) findViewById(R.id.doneButton);

        nf = (EditText) findViewById(R.id.addNameField);
        df = (EditText) findViewById(R.id.addDateField);
        tf = (EditText) findViewById(R.id.addTimeField);
        lf = (EditText) findViewById(R.id.addLocationField);

        asb.setOnClickListener(this);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEventsActivity.this, DirectoryActivity.class));
            }
        });

        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEventsActivity.this, DirectoryActivity.class));
            }
        });
    }

    String newEventString = "";
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addEventButton:
                // newEventString = nf.getText().toString() + " " + df.getText().toString() + " " + tf.getText().toString() + " " + lf.getText().toString();
                // write newEventString to "__ Events.txt
        }
    }
}
