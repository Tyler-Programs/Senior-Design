package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRosterActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button mmb, drb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_roster);
        init();
    }

    public void init(){
        mmb = (Button) findViewById(R.id.mainMenuButton);
        drb = (Button) findViewById(R.id.doneRosterButton);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddRosterActivity.this, DirectoryActivity.class));
            }
        });

        drb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddRosterActivity.this, AddEventsActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
