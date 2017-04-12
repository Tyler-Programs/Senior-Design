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
import android.widget.Spinner;

import java.io.File;
import java.io.FileFilter;

public class HomeActivity extends AppCompatActivity {
    public Button vtb, atb;
    public String selectedTeam; // for multiple team support
    public Spinner teamSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }


    public void init() {
        vtb = (Button) findViewById(R.id.viewTeamButton);
        atb = (Button) findViewById(R.id.addTeamButton);
        teamSelector = (Spinner) findViewById(R.id.teamSelector);

        teamSelector.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getTeamNames())); // set the dynamic list to the spinner

        vtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("test", "homeactivity:  cur team: "+ getSelectedTeam());
                startActivity(new Intent(HomeActivity.this, DirectoryActivity.class).putExtra("Team_Name",getSelectedTeam()));
            }
        });

        atb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TeamPreferencesActivity.class)); // selected from the spinner
            }
        });

        getTeamNames(); // returning string array. use array to create adapter for a spinner.
    }


    private String[] getTeamNames() // try to get multiple team recognition.
    {
        String filepath = ""+getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);

        File dir = new File(filepath);
        FileFilter list = new FileFilter(){
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] files = dir.listFiles(list);
        String[] res = new String[files.length];
        for(int i=0; i<files.length; i++)
        {
            //Log.e("TEST",files[i].getName());
            res[i] = files[i].getName(); // get the name of the team and assign it to the array
        }

        return res;
    }

    private String getSelectedTeam()
    {
        // get the selected team from the spinner
        return teamSelector.getSelectedItem().toString();
    }
}
