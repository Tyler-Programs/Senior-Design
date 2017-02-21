package com.example.tbecker012.soccermomsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EventsPageActivity extends AppCompatActivity {
    public Button neb, scb, mmb;
    public EditText if1, if2, if3, if4, if5, if6, if7, if8, if9, if10, if11, if12, if13, if14, if15, if16, if17, if18, if19, if20, if21, if22, if23, if24, if25, if26, if27, if28, if29, if30, if31, if32, if33, if34, if35, if36, if37, if38, if39, if40, if41, if42, if43, if44, if45, if46, if47, if48, if49, if50;
    public EditText df1, df2, df3, df4, df5, df6, df7, df8, df9, df10, df11, df12, df13, df14, df15, df16, df17, df18, df19, df20, df21, df22, df23, df24, df25, df26, df27, df28, df29, df30, df31, df32, df33, df34, df35, df36, df37, df38, df39, df40, df41, df42, df43, df44, df45, df46, df47, df48, df49, df50;
    public EditText tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25, tf26, tf27, tf28, tf29, tf30, tf31, tf32, tf33, tf34, tf35, tf36, tf37, tf38, tf39, tf40, tf41, tf42, tf43, tf44, tf45, tf46, tf47, tf48, tf49, tf50;
    public EditText lf1, lf2, lf3, lf4, lf5, lf6, lf7, lf8, lf9, lf10, lf11, lf12, lf13, lf14, lf15, lf16, lf17, lf18, lf19, lf20, lf21, lf22, lf23, lf24, lf25, lf26, lf27, lf28, lf29, lf30, lf31, lf32, lf33, lf34, lf35, lf36, lf37, lf38, lf39, lf40, lf41, lf42, lf43, lf44, lf45, lf46, lf47, lf48, lf49, lf50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

    public void init(){
        neb = (Button) findViewById(R.id.newEventButton);
        scb = (Button) findViewById(R.id.saveChangesButton);
        mmb = (Button) findViewById(R.id.mainMenuButton);

        neb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsPageActivity.this, AddEventsActivity.class));
            }
        });

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventsPageActivity.this, DirectoryActivity.class));
            }
        });

        if1 = (EditText) findViewById(R.id.idField1);
        if2 = (EditText) findViewById(R.id.idField2);
        if3 = (EditText) findViewById(R.id.idField3);
        if4 = (EditText) findViewById(R.id.idField4);
        if5 = (EditText) findViewById(R.id.idField5);
        if6 = (EditText) findViewById(R.id.idField6);
        if7 = (EditText) findViewById(R.id.idField7);
        if8 = (EditText) findViewById(R.id.idField8);
        if9 = (EditText) findViewById(R.id.idField9);
        if10 = (EditText) findViewById(R.id.idField10);
        if11 = (EditText) findViewById(R.id.idField11);
        if12 = (EditText) findViewById(R.id.idField12);
        if13 = (EditText) findViewById(R.id.idField13);
        if14 = (EditText) findViewById(R.id.idField14);
        if15 = (EditText) findViewById(R.id.idField15);
        if16 = (EditText) findViewById(R.id.idField16);
        if17 = (EditText) findViewById(R.id.idField17);
        if18 = (EditText) findViewById(R.id.idField18);
        if19 = (EditText) findViewById(R.id.idField19);
        if20 = (EditText) findViewById(R.id.idField20);
        if21 = (EditText) findViewById(R.id.idField21);
        if22 = (EditText) findViewById(R.id.idField22);
        if23 = (EditText) findViewById(R.id.idField23);
        if24 = (EditText) findViewById(R.id.idField24);
        if25 = (EditText) findViewById(R.id.idField25);
        if26 = (EditText) findViewById(R.id.idField26);
        if27 = (EditText) findViewById(R.id.idField27);
        if28 = (EditText) findViewById(R.id.idField28);
        if29 = (EditText) findViewById(R.id.idField29);
        if30 = (EditText) findViewById(R.id.idField30);
        if31 = (EditText) findViewById(R.id.idField31);
        if32 = (EditText) findViewById(R.id.idField32);
        if33 = (EditText) findViewById(R.id.idField33);
        if34 = (EditText) findViewById(R.id.idField34);
        if35 = (EditText) findViewById(R.id.idField35);
        if36 = (EditText) findViewById(R.id.idField36);
        if37 = (EditText) findViewById(R.id.idField37);
        if38 = (EditText) findViewById(R.id.idField38);
        if39 = (EditText) findViewById(R.id.idField39);
        if40 = (EditText) findViewById(R.id.idField40);
        if41 = (EditText) findViewById(R.id.idField41);
        if42 = (EditText) findViewById(R.id.idField42);
        if43 = (EditText) findViewById(R.id.idField43);
        if44 = (EditText) findViewById(R.id.idField44);
        if45 = (EditText) findViewById(R.id.idField45);
        if46 = (EditText) findViewById(R.id.idField46);
        if47 = (EditText) findViewById(R.id.idField47);
        if48 = (EditText) findViewById(R.id.idField48);
        if49 = (EditText) findViewById(R.id.idField49);
        if50 = (EditText) findViewById(R.id.idField50);

        df1 = (EditText) findViewById(R.id.dateField1);
        df2 = (EditText) findViewById(R.id.dateField2);
        df3 = (EditText) findViewById(R.id.dateField3);
        df4 = (EditText) findViewById(R.id.dateField4);
        df5 = (EditText) findViewById(R.id.dateField5);
        df6 = (EditText) findViewById(R.id.dateField6);
        df7 = (EditText) findViewById(R.id.dateField7);
        df8 = (EditText) findViewById(R.id.dateField8);
        df9 = (EditText) findViewById(R.id.dateField9);
        df10 = (EditText) findViewById(R.id.dateField10);
        df11 = (EditText) findViewById(R.id.dateField11);
        df12 = (EditText) findViewById(R.id.dateField12);
        df13 = (EditText) findViewById(R.id.dateField13);
        df14 = (EditText) findViewById(R.id.dateField14);
        df15 = (EditText) findViewById(R.id.dateField15);
        df16 = (EditText) findViewById(R.id.dateField16);
        df17 = (EditText) findViewById(R.id.dateField17);
        df18 = (EditText) findViewById(R.id.dateField18);
        df19 = (EditText) findViewById(R.id.dateField19);
        df20 = (EditText) findViewById(R.id.dateField20);
        df21 = (EditText) findViewById(R.id.dateField21);
        df22 = (EditText) findViewById(R.id.dateField22);
        df23 = (EditText) findViewById(R.id.dateField23);
        df24 = (EditText) findViewById(R.id.dateField24);
        df25 = (EditText) findViewById(R.id.dateField25);
        df26 = (EditText) findViewById(R.id.dateField26);
        df27 = (EditText) findViewById(R.id.dateField27);
        df28 = (EditText) findViewById(R.id.dateField28);
        df29 = (EditText) findViewById(R.id.dateField29);
        df30 = (EditText) findViewById(R.id.dateField30);
        df31 = (EditText) findViewById(R.id.dateField31);
        df32 = (EditText) findViewById(R.id.dateField32);
        df33 = (EditText) findViewById(R.id.dateField33);
        df34 = (EditText) findViewById(R.id.dateField34);
        df35 = (EditText) findViewById(R.id.dateField35);
        df36 = (EditText) findViewById(R.id.dateField36);
        df37 = (EditText) findViewById(R.id.dateField37);
        df38 = (EditText) findViewById(R.id.dateField38);
        df39 = (EditText) findViewById(R.id.dateField39);
        df40 = (EditText) findViewById(R.id.dateField40);
        df41 = (EditText) findViewById(R.id.dateField41);
        df42 = (EditText) findViewById(R.id.dateField42);
        df43 = (EditText) findViewById(R.id.dateField43);
        df44 = (EditText) findViewById(R.id.dateField44);
        df45 = (EditText) findViewById(R.id.dateField45);
        df46 = (EditText) findViewById(R.id.dateField46);
        df47 = (EditText) findViewById(R.id.dateField47);
        df48 = (EditText) findViewById(R.id.dateField48);
        df49 = (EditText) findViewById(R.id.dateField49);
        df50 = (EditText) findViewById(R.id.dateField50);

        tf1 = (EditText) findViewById(R.id.timeField1);
        tf2 = (EditText) findViewById(R.id.timeField2);
        tf3 = (EditText) findViewById(R.id.timeField3);
        tf4 = (EditText) findViewById(R.id.timeField4);
        tf5 = (EditText) findViewById(R.id.timeField5);
        tf6 = (EditText) findViewById(R.id.timeField6);
        tf7 = (EditText) findViewById(R.id.timeField7);
        tf8 = (EditText) findViewById(R.id.timeField8);
        tf9 = (EditText) findViewById(R.id.timeField9);
        tf10 = (EditText) findViewById(R.id.timeField10);
        tf11 = (EditText) findViewById(R.id.timeField11);
        tf12 = (EditText) findViewById(R.id.timeField12);
        tf13 = (EditText) findViewById(R.id.timeField13);
        tf14 = (EditText) findViewById(R.id.timeField14);
        tf15 = (EditText) findViewById(R.id.timeField15);
        tf16 = (EditText) findViewById(R.id.timeField16);
        tf17 = (EditText) findViewById(R.id.timeField17);
        tf18 = (EditText) findViewById(R.id.timeField18);
        tf19 = (EditText) findViewById(R.id.timeField19);
        tf20 = (EditText) findViewById(R.id.timeField20);
        tf21 = (EditText) findViewById(R.id.timeField21);
        tf22 = (EditText) findViewById(R.id.timeField22);
        tf23 = (EditText) findViewById(R.id.timeField23);
        tf24 = (EditText) findViewById(R.id.timeField24);
        tf25 = (EditText) findViewById(R.id.timeField25);
        tf26 = (EditText) findViewById(R.id.timeField26);
        tf27 = (EditText) findViewById(R.id.timeField27);
        tf28 = (EditText) findViewById(R.id.timeField28);
        tf29 = (EditText) findViewById(R.id.timeField29);
        tf30 = (EditText) findViewById(R.id.timeField30);
        tf31 = (EditText) findViewById(R.id.timeField31);
        tf32 = (EditText) findViewById(R.id.timeField32);
        tf33 = (EditText) findViewById(R.id.timeField33);
        tf34 = (EditText) findViewById(R.id.timeField34);
        tf35 = (EditText) findViewById(R.id.timeField35);
        tf36 = (EditText) findViewById(R.id.timeField36);
        tf37 = (EditText) findViewById(R.id.timeField37);
        tf38 = (EditText) findViewById(R.id.timeField38);
        tf39 = (EditText) findViewById(R.id.timeField39);
        tf40 = (EditText) findViewById(R.id.timeField40);
        tf41 = (EditText) findViewById(R.id.timeField41);
        tf42 = (EditText) findViewById(R.id.timeField42);
        tf43 = (EditText) findViewById(R.id.timeField43);
        tf44 = (EditText) findViewById(R.id.timeField44);
        tf45 = (EditText) findViewById(R.id.timeField45);
        tf46 = (EditText) findViewById(R.id.timeField46);
        tf47 = (EditText) findViewById(R.id.timeField47);
        tf48 = (EditText) findViewById(R.id.timeField48);
        tf49 = (EditText) findViewById(R.id.timeField49);
        tf50 = (EditText) findViewById(R.id.timeField50);

        lf1 = (EditText) findViewById(R.id.addressField1);
        lf2 = (EditText) findViewById(R.id.addressField2);
        lf3 = (EditText) findViewById(R.id.addressField3);
        lf4 = (EditText) findViewById(R.id.addressField4);
        lf5 = (EditText) findViewById(R.id.addressField5);
        lf6 = (EditText) findViewById(R.id.addressField6);
        lf7 = (EditText) findViewById(R.id.addressField7);
        lf8 = (EditText) findViewById(R.id.addressField8);
        lf9 = (EditText) findViewById(R.id.addressField9);
        lf10 = (EditText) findViewById(R.id.addressField10);
        lf11 = (EditText) findViewById(R.id.addressField11);
        lf12 = (EditText) findViewById(R.id.addressField12);
        lf13 = (EditText) findViewById(R.id.addressField13);
        lf14 = (EditText) findViewById(R.id.addressField14);
        lf15 = (EditText) findViewById(R.id.addressField15);
        lf16 = (EditText) findViewById(R.id.addressField16);
        lf17 = (EditText) findViewById(R.id.addressField17);
        lf18 = (EditText) findViewById(R.id.addressField18);
        lf19 = (EditText) findViewById(R.id.addressField19);
        lf20 = (EditText) findViewById(R.id.addressField20);
        lf21 = (EditText) findViewById(R.id.addressField21);
        lf22 = (EditText) findViewById(R.id.addressField22);
        lf23 = (EditText) findViewById(R.id.addressField23);
        lf24 = (EditText) findViewById(R.id.addressField24);
        lf25 = (EditText) findViewById(R.id.addressField25);
        lf26 = (EditText) findViewById(R.id.addressField26);
        lf27 = (EditText) findViewById(R.id.addressField27);
        lf28 = (EditText) findViewById(R.id.addressField28);
        lf29 = (EditText) findViewById(R.id.addressField29);
        lf30 = (EditText) findViewById(R.id.addressField30);
        lf31 = (EditText) findViewById(R.id.addressField32);
        lf33 = (EditText) findViewById(R.id.addressField33);
        lf34 = (EditText) findViewById(R.id.addressField34);
        lf35 = (EditText) findViewById(R.id.addressField35);
        lf36 = (EditText) findViewById(R.id.addressField36);
        lf27 = (EditText) findViewById(R.id.addressField37);
        lf38 = (EditText) findViewById(R.id.addressField38);
        lf39 = (EditText) findViewById(R.id.addressField39);
        lf40 = (EditText) findViewById(R.id.addressField40);
        lf41 = (EditText) findViewById(R.id.addressField41);
        lf42 = (EditText) findViewById(R.id.addressField42);
        lf43 = (EditText) findViewById(R.id.addressField43);
        lf44 = (EditText) findViewById(R.id.addressField44);
        lf45 = (EditText) findViewById(R.id.addressField45);
        lf46 = (EditText) findViewById(R.id.addressField46);
        lf47 = (EditText) findViewById(R.id.addressField47);
        lf48 = (EditText) findViewById(R.id.addressField48);
        lf49 = (EditText) findViewById(R.id.addressField49);
        lf50 = (EditText) findViewById(R.id.addressField50);
    }

    public void launchMaps(View view)
    {
        /* Attempt to write to a file and then read from that same file. */
       writeToFile("9875+Hilltop+Drive+Bangor+PA", getApplicationContext()); //uncomment
       String tmpString = readFromFile(getApplicationContext()); //uncomment
       //String tmpString = "9875+Hilltop+Drive+Bangor+PA"; //remove
        /*Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);*/

        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("google.navigation:q="+Uri.encode("9875+Hilltop+Drive+Bangor+PA")); //substitute encode string for tmpString

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

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("address.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
