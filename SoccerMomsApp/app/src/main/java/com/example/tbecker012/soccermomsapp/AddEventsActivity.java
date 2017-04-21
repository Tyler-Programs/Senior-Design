package com.example.tbecker012.soccermomsapp;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.provider.CalendarContract.*;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AddEventsActivity extends AppCompatActivity implements EditText.OnClickListener{
    public Button asb, mmb, db;
    public EditText nf, df, tf, lf;
    private FileManager fileManager;
    private long eventID;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);
        init();
    }

    public void init() {
        fileManager = new FileManager(getTeamName());

        asb = (Button) findViewById(R.id.addEventButton);
        mmb = (Button) findViewById(R.id.mainMenuButton);
        db = (Button) findViewById(R.id.doneButton);

        nf = (EditText) findViewById(R.id.addNameField);
        df = (EditText) findViewById(R.id.addDateField);
        tf = (EditText) findViewById(R.id.addTimeField);
        lf = (EditText) findViewById(R.id.addLocationField);

        asb.setOnClickListener(this);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEventsActivity.this, DirectoryActivity.class).putExtra("Team_Name",getTeamName()));
            }
        });

        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddEventsActivity.this, DirectoryActivity.class).putExtra("Team_Name",getTeamName()));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addEventButton:
                eventID = writeToCalendar();
                fileManager.addEvent(""+eventID+"#"+nf.getText().toString()+"#"+df.getText().toString()+"#"+tf.getText().toString()+"#"+lf.getText().toString(),getApplicationContext()); //save event to text file
                clearEditTextFields();
                // newEventString = nf.getText().toString() + " " + df.getText().toString() + " " + tf.getText().toString() + " " + lf.getText().toString();
                // write newEventString to "__ Events.txt
        }
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

    private long[] getCalendarList()
    {
        long[] list = new long[10];
        try {
            String[] projection =
                    new String[]{
                            Calendars._ID,
                            Calendars.NAME,
                            Calendars.ACCOUNT_NAME,
                            Calendars.ACCOUNT_TYPE
                    };
            Cursor calCursor = getContentResolver().query(Calendars.CONTENT_URI, projection, Calendars.VISIBLE + " = 1", null, Calendars._ID + " ASC");
            if (calCursor.moveToFirst()) {
                do {
                    long id = calCursor.getLong(0);
                    String displayName = calCursor.getString(1);
                    list[calCursor.getCount()] = id;
                    // …
                } while (calCursor.moveToNext());
            }
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
            Log.d("GET_CALENDAR***", "getCalendarList() problems");
        }
        for(int i=0;i<list.length;i++)
            Log.d("GET_CALENDAR***", "list["+i+"]: "+list[i]);

        return list;
    }

    private long writeToCalendar()
    {
        long eventID = -1;
        long calID = 8; // test phone's cal
        long startMillis = 0;
        long endMillis = 0;

        String date[] = df.getText().toString().split("/"); // mm/dd/yyyy
        String time[] = tf.getText().toString().split(":"); // hh:mm (24 base)

        Calendar beginTime = Calendar.getInstance();
        // year, month, day, hour, minute
        beginTime.set(Integer.parseInt(date[2]), Integer.parseInt(date[0]) - 1, Integer.parseInt(date[1]), Integer.parseInt(time[0]), Integer.parseInt(time[1])); // writes it one month later, so move the month back one
        startMillis = beginTime.getTimeInMillis();
        Calendar endTime = Calendar.getInstance();
        endTime.set(Integer.parseInt(date[2]), Integer.parseInt(date[0]) - 1, Integer.parseInt(date[1]), Integer.parseInt(time[0])+1, Integer.parseInt(time[1]));
        endMillis = endTime.getTimeInMillis();


        //getCalendarList();

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(Events.DTSTART, startMillis);
        values.put(Events.DTEND, endMillis);
        values.put(Events.TITLE, nf.getText().toString());
        values.put(Events.DESCRIPTION, "");
        values.put(Events.CALENDAR_ID, calID);
        values.put(Events.EVENT_TIMEZONE, "America/New York");
        try {
            Uri uri = cr.insert(Events.CONTENT_URI, values);
            eventID = Long.parseLong(uri.getLastPathSegment());
            Log.d("CALENDAR***","AddEventsActivity:  added event");
            Log.d("CALENDAR***","Cal URI: "+ uri);
            Log.d("CALENDAR***","CalID: "+Events.CALENDAR_ID);
        } catch (SecurityException e) {
            e.printStackTrace();
            Log.e("CALEDNAR***","AddEventsActivity:  Could not add event");
        }
            return eventID;

        /*
        int year, month, day, hour, minute;
        String data = df.getText().toString();
        List<String> tmp = Arrays.asList(data.split("/")); // get the data separated
        year = tmp.indexOf(2);
        month = tmp.indexOf(0);
        day = tmp.indexOf(1);
        data = tf.getText().toString();
        tmp = Arrays.asList(data.split(":"));
        hour = tmp.indexOf(0);
        minute = tmp.indexOf(1);
        try {
            long calID = 3;
            long startMillis = 0;
            long endMillis = 0;
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(year, month, day, hour, minute); // put hint in calendar line for format MM/DD/YYYY and in time line format HH:MM(:HH:MM) <- duration
            startMillis = beginTime.getTimeInMillis();
            Calendar endTime = Calendar.getInstance();
            endTime.set(year, month, day, hour+1, minute); // end one hour after the event starts
            endMillis = endTime.getTimeInMillis();

            ContentResolver cr = getContentResolver();
            ContentValues values = new ContentValues();
            values.put(CalendarContract.Events.DTSTART, startMillis);
            values.put(CalendarContract.Events.DTEND, endMillis);
            values.put(CalendarContract.Events.TITLE, "Soccer"); // default
            values.put(CalendarContract.Events.DESCRIPTION, ""); //default
            values.put(CalendarContract.Events.CALENDAR_ID, calID);
            //values.put(CalendarContract.Events.EVENT_TIMEZONE, "America/New York"); // EST timezone
            Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
            return Long.parseLong(uri.getLastPathSegment());
        }catch(SecurityException e)
        {
            Log.e("error","Permissions needed for calendars");
            e.printStackTrace();
        }
        return -1; // return as an error
        */
    }

    private void deleteFromCalendar(long evtID)
    {
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        Uri deleteUri = null;
        deleteUri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, evtID);
        int rows = getContentResolver().delete(deleteUri, null, null);
    }

    private void clearEditTextFields()
    {
        nf.setText("");
        df.setText("");
        tf.setText("");
        lf.setText("");
    }
}
