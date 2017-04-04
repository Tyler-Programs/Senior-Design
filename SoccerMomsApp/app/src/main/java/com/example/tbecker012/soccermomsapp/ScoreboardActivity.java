package com.example.tbecker012.soccermomsapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.CountDownTimer;

public class ScoreboardActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button gcstb, gcspb, gcrb, pcstb, pcspb, pcrb, usib, usdb, osib, osdb, hb;
    public EditText userSF, oppSF, gcMinutes, gcSeconds, pcMinutes, pcSeconds, summArea;
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        init();
    }

    private void init() {
        // initialize all components

        gcstb = (Button) findViewById(R.id.startGCButton);
        gcspb = (Button) findViewById(R.id.stopGCButton);
        gcrb = (Button) findViewById(R.id.resetGCButton);
        pcstb = (Button) findViewById(R.id.startPCButton);
        pcspb = (Button) findViewById(R.id.stopPCButton);
        pcrb = (Button) findViewById(R.id.resetPCButton);
        usib = (Button) findViewById(R.id.userScoreIncButton);
        usdb = (Button) findViewById(R.id.userScoreDecButton);
        osib = (Button) findViewById(R.id.oppScoreIncButton);
        osdb = (Button) findViewById(R.id.oppScoreDecButton);
        hb = (Button) findViewById(R.id.homeButton);

        userSF = (EditText) findViewById(R.id.userScoreField);
        oppSF = (EditText) findViewById(R.id.oppScoreField);

        userSF.setEnabled(false);
        oppSF.setEnabled(false);

        gcMinutes = (EditText) findViewById(R.id.gcMinField);
        gcSeconds = (EditText) findViewById(R.id.gcSecField);
        pcMinutes = (EditText) findViewById(R.id.pcMinField);
        pcSeconds = (EditText) findViewById(R.id.pcSecField);
        summArea = (EditText) findViewById(R.id.summaryArea);

        summArea.setEnabled(false);

        usib.setOnClickListener(this);
        usdb.setOnClickListener(this);
        osib.setOnClickListener(this);
        osdb.setOnClickListener(this);
        gcstb.setOnClickListener(this);
        gcspb.setOnClickListener(this);
        gcrb.setOnClickListener(this);
        pcstb.setOnClickListener(this);
        pcspb.setOnClickListener(this);
        pcrb.setOnClickListener(this);
        hb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreboardActivity.this, DirectoryActivity.class));
            }
        });
    }

    public Activity a;
    @Override
    public void onClick(View v) {
        String usString = userSF.getText().toString();
        String osString = oppSF.getText().toString();
        int userScore = Integer.parseInt(usString);
        int oppScore = Integer.parseInt(osString);

        switch(v.getId()){
            case R.id.startGCButton:
                startGC();
                break;

            case R.id.stopGCButton:
                stopGC();
                break;

            case R.id.resetGCButton:
                int m = getInitGCMinutes();
                int s = getInitGCSeconds();
                if(m >= 10)
                    gcMinutes.setText(String.valueOf(getInitGCMinutes()));
                else
                    gcMinutes.setText("0" + String.valueOf(getInitGCMinutes()));

                if(s >= 10)
                    gcSeconds.setText(String.valueOf(getInitGCSeconds()));
                else
                    gcSeconds.setText("0" + String.valueOf(getInitGCSeconds()));

                break;

            case R.id.startPCButton:
                startPC();
                break;

            case R.id.stopPCButton:
                stopPC();
                break;

            case R.id.resetPCButton:
                int m2 = getInitPCMinutes();
                int s2 = getInitPCSeconds();
                if(m2 >= 10)
                    pcMinutes.setText(String.valueOf(getInitPCMinutes()));
                else
                    pcMinutes.setText("0" + String.valueOf(getInitPCMinutes()));

                if(s2 >= 10)
                    pcSeconds.setText(String.valueOf(getInitPCSeconds()));
                else
                    pcSeconds.setText("0" + String.valueOf(getInitPCSeconds()));

                break;

            case R.id.userScoreIncButton:
                userScore++;
                userSF.setText(String.valueOf(userScore));
                String timeOfEvent = getGCMinutes() + " : " + gcSeconds.getText().toString();
                String st = summArea.getText().toString();
                summArea.setText(st + "\n\nTime: " + timeOfEvent + ". Goal scored by home team. Score is: " + userScore + "-" + oppScore);

                break;

            case R.id.userScoreDecButton:
                if(userScore > 0){
                    userScore--;
                    userSF.setText(String.valueOf(userScore));
                    String st3 = summArea.getText().toString();
                    summArea.setText(st3 + "\nPrevious goal cancelled.  Score is: " + userScore + "-" + oppScore);

                    break;
                }
                else {
                    break;
                }

            case R.id.oppScoreIncButton:
                oppScore++;
                oppSF.setText(String.valueOf(oppScore));
                String timeOfEvent2 = getGCMinutes() + " : " + gcSeconds.getText().toString();
                String st2 = summArea.getText().toString();
                summArea.setText(st2 + "\n\nTime: " + timeOfEvent2 + ". Goal scored by away team. Score is: " + userScore + "-" + oppScore);

                break;

            case R.id.oppScoreDecButton:
                if(oppScore > 0){
                    oppScore--;
                    oppSF.setText(String.valueOf(oppScore));
                    String st4 = summArea.getText().toString();
                    summArea.setText(st4 + "\nPrevious goal cancelled.  Score is: " + userScore + "-" + oppScore);

                    break;
                }
                else {
                    break;
                }

            case R.id.homeButton:
                break;
        }
    }

    String gc_mins;
    String gc_secs;
    int gc_minute;
    int gc_second;
    int gc_initMinute;
    int gc_initSecond;
    int gc_count = 0;
    CountDownTimer gcdt;

    String pc_mins;
    String pc_secs;
    int pc_minute;
    int pc_second;
    int pc_initMinute;
    int pc_initSecond;
    int pc_count = 0;

    String scorer;
    String assister1;
    String assister2;

    CountDownTimer pcdt;

    private void startGC(){
        gc_count++;
        gcstb.setEnabled(false);
        gcrb.setEnabled(false);
        gc_secs = gcSeconds.getText().toString();
        gc_mins = gcMinutes.getText().toString();
        gc_second = Integer.parseInt(gc_secs);
        gc_minute = Integer.parseInt(gc_mins);

        if(gc_minute < 10)
            gcMinutes.setText("0" + gc_minute);

        if(gc_count == 1){
            gc_initMinute = gc_minute;
            gc_initSecond = gc_second;
            setInitGCMinutes(gc_initMinute);
            setInitGCSeconds(gc_initSecond);
        }

        gc_second = getGCSeconds();
        gc_minute = Integer.parseInt(gc_mins);
        setGCMinutes(gc_minute);
        gcdt = new CountDownTimer(gc_second * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished >= 10000)
                    gcSeconds.setText("" + millisUntilFinished / 1000);
                else
                    gcSeconds.setText("0" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                gcSeconds.setText("00");
                if(getGCMinutes() == 0) {
                    stopGC();
                }
                else{
                    setGCMinutes(getGCMinutes() - 1);
                    if(getGCMinutes() >= 10)
                        gcMinutes.setText(String.valueOf(getGCMinutes()));
                    else
                        gcMinutes.setText("0" + String.valueOf(getGCMinutes()));

                    gcSeconds.setText("60");
                    setGCSeconds(60);
                    startGC();
                }
            }
        };
        gcdt.start();
    }

    private void stopGC(){
        gcstb.setEnabled(true);
        gcrb.setEnabled(true);
        if(gcdt != null){
            gcdt.cancel();
            gcdt = null;
        }
    }

    private void startPC(){
        pc_count++;
        pcstb.setEnabled(false);
        pcrb.setEnabled(false);
        pc_secs = pcSeconds.getText().toString();
        pc_mins = pcMinutes.getText().toString();
        pc_second = Integer.parseInt(pc_secs);
        pc_minute = Integer.parseInt(pc_mins);
        if(pc_minute < 10)
            pcMinutes.setText("0" + pc_minute);

        if(pc_count == 1){
            pc_initMinute = pc_minute;
            pc_initSecond = pc_second;
            setInitPCMinutes(pc_initMinute);
            setInitPCSeconds(pc_initSecond);
        }

        pc_second = getPCSeconds();
        pc_minute = Integer.parseInt(pc_mins);
        setPCMinutes(pc_minute);
        pcdt = new CountDownTimer(pc_second * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished >= 10000)
                    pcSeconds.setText("" + millisUntilFinished / 1000);
                else
                    pcSeconds.setText("0" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                pcSeconds.setText("00");
                if(getPCMinutes() == 0) {
                    stopPC();
                }
                else{
                    setPCMinutes(getPCMinutes() - 1);
                    if(getPCMinutes() >= 10)
                        pcMinutes.setText(String.valueOf(getPCMinutes()));
                    else
                        pcMinutes.setText("0" + String.valueOf(getPCMinutes()));

                    pcSeconds.setText("60");
                    setPCSeconds(60);
                    startPC();
                }
            }
        };
        pcdt.start();
    }

    private void stopPC(){
        pcstb.setEnabled(true);
        pcrb.setEnabled(true);
        if(pcdt != null){
            pcdt.cancel();
            pcdt = null;
        }
    }

    public void updateGoalScorer(){
        summArea.setText("this sucks");
    }

    public void assister1(String str){
        summArea.setText(summArea.getText().toString() + "this sucks");
    }

    public void assister2(String str){
        summArea.setText(summArea.getText().toString() + "this sucks");
    }

    public void updateText(String str){
        summArea.setText(str);
    }

    public int getGCMinutes(){
        return gc_minute;
    }

    public void setGCMinutes(int min){
        this.gc_minute = min;
    }

    public int getGCSeconds(){
        return gc_second;
    }

    public void setGCSeconds(int sec){
        this.gc_second = sec;
    }

    public int getInitGCMinutes(){
        return gc_initMinute;
    }

    public void setInitGCMinutes(int min){
        this.gc_initMinute = min;
    }

    public int getInitGCSeconds(){
        return gc_initSecond;
    }

    public void setInitGCSeconds(int sec){
        this.gc_initSecond = sec;
    }

    public int getPCMinutes(){
        return pc_minute;
    }

    public void setPCMinutes(int min){
        this.pc_minute = min;
    }

    public int getPCSeconds(){
        return pc_second;
    }

    public void setPCSeconds(int sec){
        this.pc_second = sec;
    }

    public int getInitPCMinutes(){
        return pc_initMinute;
    }

    public void setInitPCMinutes(int min){
        this.pc_initMinute = min;
    }

    public int getInitPCSeconds(){
        return pc_initSecond;
    }

    public void setInitPCSeconds(int sec){
        this.pc_initSecond = sec;
    }

    public String getGoalScorer(){ return scorer; }

    public void setGoalScorer(String scorer){ this.scorer = scorer; }

    public String getAssister1(){ return assister1; }

    public void setAssister1(String assister1){ this.assister1 = assister1; }

    public String getAssister2(){ return assister2; }

    public void setAssister2(String assister2){ this.assister2 = assister2; }
}
