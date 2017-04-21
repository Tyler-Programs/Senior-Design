package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;

public class TeamPreferencesActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button mmb, dpb;
    private EditText atf;
    public Spinner gts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_preferences);
        init();
    }

    public void init(){
        mmb = (Button) findViewById(R.id.mainMenuButton);
        dpb = (Button) findViewById(R.id.donePreferencesButton);
        atf = (EditText) findViewById(R.id.addTeamField);

        gts = (Spinner) findViewById(R.id.gameTimeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.game_time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TeamPreferencesActivity.this, DirectoryActivity.class).putExtra("Team_Name",getName())); // getTeamName -> getName
            }
        });

        dpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamName = atf.getText().toString(); // get the text from the team name field
                FileManager fileManager = new FileManager(teamName); // create a file manager with that team name
                fileManager.createDirectory(getApplicationContext()); // create the directory
                fileManager.createRosterFile(getApplicationContext()); // create the roster text file
                writePreferences();
                startActivity(new Intent(TeamPreferencesActivity.this, AddRosterActivity.class).putExtra("Team_Name",getName())); // getTeamName -> getName
            }
        });
        gts.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }

    private void writePreferences()
    {
        Log.e("TESTING","gts to string:  "+gts.getSelectedItem().toString());
        Log.e("TESTING", "cur team: "+getName());
        File t = new FileManager(getName()).createPreferencesFile(getApplicationContext(), gts.getSelectedItem().toString());
    }


    private String getName()
    {
        return atf.getText().toString();
    }
/*
    private String getTeamName() // get the string sent from the TeamPreferencesActivity
    {
        String newString;
        Bundle extras = getIntent().getExtras();
        if(extras == null) // is there any strings
            newString = null;
        else
            newString = extras.getString("Team_Name"); // retrieve the string
        return newString;
    }*/
}
