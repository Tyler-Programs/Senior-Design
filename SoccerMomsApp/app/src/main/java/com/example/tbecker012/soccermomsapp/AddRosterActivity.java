package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRosterActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button mmb, drb, apb;
    private FileManager fileManager;
    private EditText addnamef, addagef, addnumf, addgradef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_roster);
        init();
    }

    public void init(){
        mmb = (Button) findViewById(R.id.mainMenuButton);
        drb = (Button) findViewById(R.id.doneRosterButton);
        apb = (Button) findViewById(R.id.addPlayerButton);
        addnamef = (EditText) findViewById(R.id.addNameField);
        addagef = (EditText) findViewById(R.id.addAgeField);
        addnumf = (EditText) findViewById(R.id.addTimeField); // NOTE: THIS IS NAMED WRONG, ID IS HOOKED UP TO RIGHT COMPONENT THOUGH
        addgradef = (EditText) findViewById(R.id.addGradeField);

        anf = (EditText) findViewById(R.id.addNameField);
        aaf = (EditText) findViewById(R.id.addAgeField);
        anuf = (EditText) findViewById(R.id.addNumberField);
        agf = (EditText) findViewById(R.id.addGradeField);

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

        apb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ //Add a player to the existing roster file
                //data in format: Name#Age#Player Number#Position#Grade
                String teamName = getTeamName(); // Get the team from the last activity
                fileManager = new FileManager(teamName); // create the file manager with that team name
                fileManager.addPlayer(getPlayerInfo(), getApplicationContext()); // write the player's data to the file
                clearEditTextFields(); // reset the edit text fields for the next player
            }
        });
    }

    @Override
    public void onClick(View v) {


    }

    private String getTeamName() // get the string sent from the TeamPreferencesActivity
    {
        String newString;
        Bundle extras = getIntent().getExtras();
        if(extras == null) // is there any strings
            newString = null;
        else
            newString = extras.getString("Team_Name"); // retrieve the string
        return newString;
    }

    private String getPlayerInfo(){
        String res="";

        if(addnamef.getText().toString() != null || addnamef.getText().toString() != "")
            res += addnamef.getText().toString()+"#";
        else
            res += "#";
        if(addagef.getText().toString() != null || addagef.getText().toString() != "")
            res += addagef.getText().toString() + "#";
        else
            res += "#";
        if(addnumf.getText().toString() != null || addnumf.getText().toString() != "")
            res += addnumf.getText().toString() + "#";
        else
            res += "#";
        if(true) // position not yet implemented
            res += "Striker" + "#";
        else
            res += "#";
        if(addgradef.getText().toString() != null || addgradef.getText().toString() != "")
            res += addgradef.getText().toString() + "#";
        else
            res += "#";

        return res+"\n";
    }

    private void clearEditTextFields()
    {
        addnamef.setText("");
        addagef.setText("");
        addnumf.setText("");
        addgradef.setText("");
    }

}