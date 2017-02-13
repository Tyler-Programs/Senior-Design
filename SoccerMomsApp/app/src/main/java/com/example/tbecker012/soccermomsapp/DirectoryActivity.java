package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button hb, ngb, rb, sb, eb;
    public EditText summArea, et5;
    String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        init();
    }

    public void init(){
        hb = (Button) findViewById(R.id.homeButton);
        ngb = (Button) findViewById(R.id.newGameButton);
        rb = (Button) findViewById(R.id.rosterButton);
        sb = (Button) findViewById(R.id.statsButton);
        eb = (Button) findViewById(R.id.eventsButton);

        hb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DirectoryActivity.this, HomeActivity.class));
            }
        });

        ngb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DirectoryActivity.this, ScoreboardActivity.class));
            }
        });

        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DirectoryActivity.this, RosterPageActivity.class));
            }
        });

        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    h = DateFormat.format("MM-dd-yyyyy-h-mmssaa", System.currentTimeMillis()).toString();
                    // this will create a new name everytime and unique
                    File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                    // if external memory exists and folder with name Notes
                    if (!root.exists()) {
                        root.mkdirs(); // this will create folder.
                    }
                    File filepath = new File(root, h + ".txt");  // file path to save
                    FileWriter writer = new FileWriter(filepath);
                    writer.append("Hi");
                    writer.flush();
                    writer.close();
                    String m = "File generated with name " + h + ".txt";
                    et5.setText(m);

                } catch (IOException e) {
                    et5.setText(e.getMessage().toString());
                    e.printStackTrace();
                }            }
        });

        eb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DirectoryActivity.this, EventsPageActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homeButton:
                updateText("a");
                break;

            case R.id.newGameButton:
                break;

            case R.id.rosterButton:
                break;

            case R.id.statsButton:
                break;

            case R.id.eventsButton:
                break;
        }
    }
    ScoreboardActivity sba = new ScoreboardActivity();
    public void updateText(String str){
        sba.updateText("theeeee");

    }

}
