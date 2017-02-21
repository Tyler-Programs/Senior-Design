package com.example.tbecker012.soccermomsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EventsPageActivity extends AppCompatActivity implements Button.OnClickListener{

    private Button seb; // save event button
    private Button menu; // main menu button

    String evtName, evtDate, evtTime, evtLoc;
    public EditText nf1, nf2, nf3; // name fields
    public EditText df1, df2, df3; // date field
    public EditText tf1, tf2, tf3; // time field
    public EditText af1, af2, af3; //address field
    public Button sb1, sb2, sb3; // search buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        readFromFile(getApplicationContext());
    }

    public void init()
    {
        seb = (Button) findViewById(R.id.saveButton);
        seb.setOnClickListener(this);

        menu = (Button) findViewById(R.id.mainMenuButton);
        menu.setOnClickListener(this);

        nf1 = (EditText) findViewById(R.id.idField1);
        nf2 = (EditText) findViewById(R.id.idField2);
        nf3 = (EditText) findViewById(R.id.idField3);
        df1 = (EditText) findViewById(R.id.dateField1);
        df2 = (EditText) findViewById(R.id.dateField2);
        df3 = (EditText) findViewById(R.id.dateField3);
        tf1 = (EditText) findViewById(R.id.timeField1);
        tf2 = (EditText) findViewById(R.id.timeField2);
        tf3 = (EditText) findViewById(R.id.timeField3);
        af1 = (EditText) findViewById(R.id.addressField1);
        af2 = (EditText) findViewById(R.id.addressField2);
        af3 = (EditText) findViewById(R.id.addressField3);

        sb1 = (Button) findViewById(R.id.searchButton1);
        sb2 = (Button) findViewById(R.id.searchButton2);
        sb3 = (Button) findViewById(R.id.searchButton3);

        sb1.setOnClickListener(this);
        sb2.setOnClickListener(this);
        sb3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.saveButton:
                // get all the string data and put into list
                // loop through each row
                break;
            case R.id.mainMenuButton:
                startActivity(new Intent(EventsPageActivity.this, DirectoryActivity.class));
                break;
            case R.id.searchButton1:
                launchMaps(v, af1.getText().toString());
                break;
            case R.id.searchButton2:
                launchMaps(v, af2.getText().toString());
                break;
            case R.id.searchButton3:
                launchMaps(v, af3.getText().toString());
                break;

        }
    }

    public void launchMaps(View view, String addr)
    {
       //String tmpString = readFromFile(getApplicationContext()); //uncomment

        /*Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);*/

        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("google.navigation:q="+Uri.encode(addr)); //substitute encode string for tmpString

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("address.txt", context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private void readFromFile(Context context) {

        String ret;

        try {
            File myFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + "Team1"), "Team1" + "Events.txt"); // replace 'Team1' with teamName once dynamic
            FileInputStream in = new FileInputStream(myFile);
            String[] data = new String[5];

            if (in != null) { // evtID#name#date#time#addr
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                /*
                Loop once dynamic
                 */
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf1.setText(data[1]); //name field
                df1.setText(data[2]); // date field
                tf1.setText(data[3]); // time field
                af1.setText(data[4]); // address field
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf2.setText(data[1]); //name field
                df2.setText(data[2]); // date field
                tf2.setText(data[3]); // time field
                af2.setText(data[4]); // address field
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf3.setText(data[1]); //name field
                df3.setText(data[2]); // date field
                tf3.setText(data[3]); // time field
                af3.setText(data[4]); // address field

                /*
                ^^^^^^^^^^^^^^^^^^^^^^^^^
                 */

                in.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        // return ret; // return used to be String
    }
}
