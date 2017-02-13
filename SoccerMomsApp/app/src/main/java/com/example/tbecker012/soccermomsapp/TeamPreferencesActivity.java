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

public class TeamPreferencesActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button mmb, dpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_preferences);
        init();
    }

    public void init(){
        mmb = (Button) findViewById(R.id.mainMenuButton);
        dpb = (Button) findViewById(R.id.donePreferencesButton);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeamPreferencesActivity.this, DirectoryActivity.class));
            }
        });

        dpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeamPreferencesActivity.this, AddRosterActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
