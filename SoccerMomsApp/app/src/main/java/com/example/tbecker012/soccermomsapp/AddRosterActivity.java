package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;

public class AddRosterActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button mmb, drb, apb;
    private FileManager fileManager;
    private EditText addnamef, addagef, addnumf, addgradef;
    public Spinner posSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_roster);
        init();
    }

    public void init(){
        fileManager = new FileManager(getTeamName());
        mmb = (Button) findViewById(R.id.mainMenuButton);
        drb = (Button) findViewById(R.id.doneRosterButton);
        apb = (Button) findViewById(R.id.addPlayerButton);
        addnamef = (EditText) findViewById(R.id.addNameField);
        addagef = (EditText) findViewById(R.id.addAgeField);
        addnumf = (EditText) findViewById(R.id.addNumberField); // NOTE: THIS IS NAMED WRONG, ID IS HOOKED UP TO RIGHT COMPONENT THOUGH
        addgradef = (EditText) findViewById(R.id.addGradeField);

        posSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.soccer_positions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddRosterActivity.this, DirectoryActivity.class).putExtra("Team_Name",getTeamName()));
            }
        });

        drb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //fileManager.createEventsFile(getApplicationContext());
                    startActivity(new Intent(AddRosterActivity.this, AddEventsActivity.class).putExtra("Team_Name", getTeamName()));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        apb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ //Add a player to the existing roster file
                //data in format: Name#Age#Player Number#Position#Grade
                if(!addnamef.getText().toString().isEmpty() && !addnumf.getText().toString().isEmpty())
                {
                    Toast t = new Toast(getApplicationContext()).makeText(getApplicationContext(),"Please enter a player name or number.", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    String teamName = getTeamName(); // Get the team from the last activity
                    fileManager = new FileManager(teamName); // create the file manager with that team name
                    fileManager.addPlayer(getPlayerInfo(), getApplicationContext()); // write the player's data to the file
                    clearEditTextFields(); // reset the edit text fields for the next player
                }
            }
        });

        posSpinner.setAdapter(adapter);
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

        if(addnamef.getText().toString() != null || addnamef.getText().toString() != "") {
            //String[] tmp = new String[2];
            //tmp = addnamef.getText().toString().split(" ");
            //res += tmp[0] + "#" + tmp[1] + "#";
            res += addnamef.getText().toString()+"#";
        }
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
