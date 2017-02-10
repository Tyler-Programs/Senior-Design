package com.example.tbecker012.soccermomsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class GoalActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button okb, cb;
    public Spinner gs, a1s, a2s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        init();
    }

    public void init(){
        okb = (Button) findViewById(R.id.okButton);
        cb = (Button) findViewById(R.id.cancelButton);

        gs = (Spinner) findViewById(R.id.goalSpinner);
        a1s = (Spinner) findViewById(R.id.a1Spinner);
        a2s = (Spinner) findViewById(R.id.a2Spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.team_numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        okb.setOnClickListener(this);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GoalActivity.this, ScoreboardActivity.class));
            }
        });

        gs.setAdapter(adapter);
        a1s.setAdapter(adapter);
        a2s.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.okButton:
                ScoreboardActivity sba = new ScoreboardActivity();

                sba.assister1("travis");
                sba.assister2("travis");
                finish();
                break;

            case R.id.cancelButton:
                break;
        }
    }
}
