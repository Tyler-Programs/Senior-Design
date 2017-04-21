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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class EventsPageActivity extends AppCompatActivity implements Button.OnClickListener {

    private Button seb, neb; // save event button
    public Button menu; // main menu button

    //String evtName, evtDate, evtTime, evtLoc;
    public EditText nf1, nf2, nf3, nf4, nf5, nf6, nf7, nf8, nf9, nf10; // name fields
    public EditText df1, df2, df3, df4, df5, df6, df7, df8, df9, df10; // date field
    public EditText tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10; // time field
    public EditText af1, af2, af3, af4, af5, af6, af7, af8, af9, af10; //address field
    public Button sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9, sb10; // search buttons


    //public Button neb, scb, mmb;
    //public EditText if1, if2, if3, if4, if5, if6, if7, if8, if9, if10, if11, if12, if13, if14, if15, if16, if17, if18, if19, if20, if21, if22, if23, if24, if25, if26, if27, if28, if29, if30, if31, if32, if33, if34, if35, if36, if37, if38, if39, if40, if41, if42, if43, if44, if45, if46, if47, if48, if49, if50;
    //public EditText df1, df2, df3, df4, df5, df6, df7, df8, df9, df10, df11, df12, df13, df14, df15, df16, df17, df18, df19, df20, df21, df22, df23, df24, df25, df26, df27, df28, df29, df30, df31, df32, df33, df34, df35, df36, df37, df38, df39, df40, df41, df42, df43, df44, df45, df46, df47, df48, df49, df50;
    //public EditText tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20, tf21, tf22, tf23, tf24, tf25, tf26, tf27, tf28, tf29, tf30, tf31, tf32, tf33, tf34, tf35, tf36, tf37, tf38, tf39, tf40, tf41, tf42, tf43, tf44, tf45, tf46, tf47, tf48, tf49, tf50;
    //public EditText lf1, lf2, lf3, lf4, lf5, lf6, lf7, lf8, lf9, lf10, lf11, lf12, lf13, lf14, lf15, lf16, lf17, lf18, lf19, lf20, lf21, lf22, lf23, lf24, lf25, lf26, lf27, lf28, lf29, lf30, lf31, lf32, lf33, lf34, lf35, lf36, lf37, lf38, lf39, lf40, lf41, lf42, lf43, lf44, lf45, lf46, lf47, lf48, lf49, lf50;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_events_page);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            init();

            readFromFile(getApplicationContext());
        }

        public void init() {
            neb = (Button) findViewById(R.id.newEventButton);
            seb = (Button) findViewById(R.id.saveButton);
            menu = (Button) findViewById(R.id.mainMenuButton);

            nf1 = (EditText) findViewById(R.id.idField1);
            nf2 = (EditText) findViewById(R.id.idField2);
            nf3 = (EditText) findViewById(R.id.idField3);
            nf4 = (EditText) findViewById(R.id.idField4);
            nf5 = (EditText) findViewById(R.id.idField5);
            nf6 = (EditText) findViewById(R.id.idField6);
            nf7 = (EditText) findViewById(R.id.idField7);
            nf8 = (EditText) findViewById(R.id.idField8);
            nf9 = (EditText) findViewById(R.id.idField9);
            nf10 = (EditText) findViewById(R.id.idField10);

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

            tf1 = (EditText) findViewById(R.id.timeField1);
            tf2 = (EditText) findViewById(R.id.timeField2);
            tf3 = (EditText) findViewById(R.id.timeField3);
            tf4 = (EditText) findViewById(R.id.timeField4);
            tf5 = (EditText) findViewById(R.id.timeField5);
            tf6 = (EditText) findViewById(R.id.timeField6);
            tf7 = (EditText) findViewById(R.id.timeField7);
            tf8 = (EditText) findViewById(R.id.timeField8);
            tf9 = (EditText) findViewById(R.id.timeField9);
            tf10 = (EditText) findViewById(R.id.timeField1);

            af1 = (EditText) findViewById(R.id.addressField1);
            af2 = (EditText) findViewById(R.id.addressField2);
            af3 = (EditText) findViewById(R.id.addressField3);
            af4 = (EditText) findViewById(R.id.addressField4);
            af5 = (EditText) findViewById(R.id.addressField5);
            af6 = (EditText) findViewById(R.id.addressField6);
            af7 = (EditText) findViewById(R.id.addressField7);
            af8 = (EditText) findViewById(R.id.addressField8);
            af9 = (EditText) findViewById(R.id.addressField9);
            af10 = (EditText) findViewById(R.id.addressField10);

            sb1 = (Button) findViewById(R.id.searchButton1);
            sb2 = (Button) findViewById(R.id.searchButton2);
            sb3 = (Button) findViewById(R.id.searchButton3);
            sb4 = (Button) findViewById(R.id.searchButton4);
            sb5 = (Button) findViewById(R.id.searchButton5);
            sb6 = (Button) findViewById(R.id.searchButton6);
            sb7 = (Button) findViewById(R.id.searchButton7);
            sb8 = (Button) findViewById(R.id.searchButton8);
            sb9 = (Button) findViewById(R.id.searchButton9);
            sb10 = (Button) findViewById(R.id.searchButton10);

            sb1.setOnClickListener(this);
            sb2.setOnClickListener(this);
            sb3.setOnClickListener(this);
            sb4.setOnClickListener(this);
            sb5.setOnClickListener(this);
            sb6.setOnClickListener(this);
            sb7.setOnClickListener(this);
            sb8.setOnClickListener(this);
            sb9.setOnClickListener(this);
            sb10.setOnClickListener(this);
            seb.setOnClickListener(this);
            menu.setOnClickListener(this);
            neb.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.saveButton:
                    // get all the string data and put into list
                    // loop through each row
                    break;
                case R.id.newEventButton:
                    startActivity(new Intent(EventsPageActivity.this, AddEventsActivity.class).putExtra("Team_Name",getTeamName()));
                    break;
                case R.id.mainMenuButton:
                    startActivity(new Intent(EventsPageActivity.this, DirectoryActivity.class).putExtra("Team_Name",getTeamName()));
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
                case R.id.searchButton4:
                    launchMaps(v, af4.getText().toString());
                    break;
                case R.id.searchButton5:
                    launchMaps(v, af5.getText().toString());
                    break;
                case R.id.searchButton6:
                    launchMaps(v, af6.getText().toString());
                    break;
                case R.id.searchButton7:
                    launchMaps(v, af7.getText().toString());
                    break;
                case R.id.searchButton8:
                    launchMaps(v, af8.getText().toString());
                    break;
                case R.id.searchButton9:
                    launchMaps(v, af9.getText().toString());
                    break;
                case R.id.searchButton10:
                    launchMaps(v, af10.getText().toString());
                    break;
                default:
            }

        }

        public void launchMaps(View view, String addr) {
            //String tmpString = readFromFile(getApplicationContext()); //uncomment

        /*Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);*/

            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("google.navigation:q=" + Uri.encode(addr)); //substitute encode string for tmpString

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");

            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }

        private void writeToFile(String data, Context context) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("address.txt", context.MODE_PRIVATE));
                outputStreamWriter.write(data);
                outputStreamWriter.close();
            } catch (IOException e) {
                Log.e("Exception", "File write failed: " + e.toString());
            }
        }

        private void readFromFile(Context context) {

            String ret;

            try {
                File myFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + getTeamName()), getTeamName() + "Events.txt");
                FileInputStream in = new FileInputStream(myFile);
                String[] data = new String[5];

                if (in != null) { // evtID#name#date#time#addr
                    InputStreamReader inputStreamReader = new InputStreamReader(in);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    try {
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
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf4.setText(data[1]); //name field
                        df4.setText(data[2]); // date field
                        tf4.setText(data[3]); // time field
                        af4.setText(data[4]); // address field
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf5.setText(data[1]); //name field
                        df5.setText(data[2]); // date field
                        tf5.setText(data[3]); // time field
                        af5.setText(data[4]); // address field
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf6.setText(data[1]); //name field
                        df6.setText(data[2]); // date field
                        tf6.setText(data[3]); // time field
                        af6.setText(data[4]); // address field
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf7.setText(data[1]); //name field
                        df7.setText(data[2]); // date field
                        tf7.setText(data[3]); // time field
                        af7.setText(data[4]); // address field
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf8.setText(data[1]); //name field
                        df8.setText(data[2]); // date field
                        tf8.setText(data[3]); // time field
                        af8.setText(data[4]); // address field
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf9.setText(data[1]); //name field
                        df9.setText(data[2]); // date field
                        tf9.setText(data[3]); // time field
                        af9.setText(data[4]); // address field
                        ret = bufferedReader.readLine();
                        data = ret.split("#");
                        nf10.setText(data[1]); //name field
                        df10.setText(data[2]); // date field
                        tf10.setText(data[3]); // time field
                        af10.setText(data[4]); // address field

                /*
                ^^^^^^^^^^^^^^^^^^^^^^^^^
                 */
                    } catch (Exception e)
                    {
                        Log.e("test","EventsPageActivity:  could not write all events to view");
                        e.printStackTrace();
                    }

                    in.close();
                }
            } catch (FileNotFoundException e) {
                Log.e("login activity", "File not found: " + e.toString());
            } catch (IOException e) {
                Log.e("login activity", "Can not read file: " + e.toString());
            }

            // return ret; // return used to be String
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
}
