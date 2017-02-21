package com.example.tbecker012.soccermomsapp;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RosterPageActivity extends AppCompatActivity implements EditText.OnClickListener{

    public Button hb, ub, cb1, ab;
    public EditText nf1, nf2, nf3, nf4, nf5; // name fields
    public EditText af1, af2, af3, af4, af5; // age fields
    public EditText numf1, numf2, numf3, numf4, numf5; // num field
    public EditText gf1, gf2, gf3, gf4, gf5; // grade field

    //public Button hb, ub, ab, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20, cb21, cb22, cb23, cb24, cb25, cb26, cb27, cb28, cb29, cb30, cb31, cb32, cb33, cb34, cb35, cb36, cb37, cb38, cb39, cb40;
    //public EditText nf1, nf2, nf3, nf4, nf5, nf6, nf7, nf8, nf9, nf10, nf11, nf12, nf13, nf14, nf15, nf16, nf17, nf18, nf19, nf20, nf21, nf22, nf23, nf24, nf25, nf26, nf27, nf28, nf29, nf30, nf31, nf32, nf33, nf34, nf35, nf36, nf37, nf38, nf39, nf40;
    //public EditText af1, af2, af3, af4, af5, af6, af7, af8, af9, af10, af11, af12, af13, af14, af15, af16, af17, af18, af19, af20, af21, af22, af23, af24, af25, af26, af27, af28, af29, af30, af31, af32, af33, af34, af35, af36, af37, af38, af39, af40;
    //public EditText nuf1, nuf2, nuf3, nuf4, nuf5, nuf6, nuf7, nuf8, nuf9, nuf10, nuf11, nuf12, nuf13, nuf14, nuf15, nuf16, nuf17, nuf18, nuf19, nuf20, nuf21, nuf22, nuf23, nuf24, nuf25, nuf26, nuf27, nuf28, nuf29, nuf30, nuf31, nuf32, nuf33, nuf34, nuf35, nuf36, nuf37, nuf38, nuf39, nuf40;
    //public EditText gf1, gf2, gf3, gf4, gf5, gf6, gf7, gf8, gf9, gf10, gf11, gf12, gf13, gf14, gf15, gf16, gf17, gf18, gf19, gf20, gf21, gf22, gf23, gf24, gf25, gf26, gf27, gf28, gf29, gf30, gf31, gf32, gf33, gf34, gf35, gf36, gf37, gf38, gf39, gf40;

    public Spinner ps1, ps2, ps3, ps4, ps5, ps6, ps7, ps8, ps9, ps10, ps11, ps12, ps13, ps14, ps15, ps16, ps17, ps18, ps19, ps20, ps21, ps22, ps23, ps24, ps25, ps26, ps27, ps28, ps29, ps30, ps31, ps32, ps33, ps34, ps35, ps36, ps37, ps38, ps39, ps40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_page);
        init();
    }

    public void init(){
        /*
        Delete below once dynamic
         */
        nf1 = (EditText) findViewById(R.id.nameField1);
        nf2 = (EditText) findViewById(R.id.nameField2);
        nf3 = (EditText) findViewById(R.id.nameField3);
        nf4 = (EditText) findViewById(R.id.nameField4);
        nf5 = (EditText) findViewById(R.id.nameField5);
        af1 = (EditText) findViewById(R.id.ageField1);
        af2 = (EditText) findViewById(R.id.ageField2);
        af3 = (EditText) findViewById(R.id.ageField3);
        af4 = (EditText) findViewById(R.id.ageField4);
        af5 = (EditText) findViewById(R.id.ageField5);
        numf1 = (EditText) findViewById(R.id.numField1);
        numf2 = (EditText) findViewById(R.id.numField2);
        numf3 = (EditText) findViewById(R.id.numField3);
        numf4 = (EditText) findViewById(R.id.numField4);
        numf5 = (EditText) findViewById(R.id.numField5);
        gf1 = (EditText) findViewById(R.id.gradeField1);
        gf2 = (EditText) findViewById(R.id.gradeField2);
        gf3 = (EditText) findViewById(R.id.gradeField3);
        gf4 = (EditText) findViewById(R.id.gradeField4);
        gf5 = (EditText) findViewById(R.id.gradeField5);
        /*
        Delete above once dynamic
         */
        hb = (Button) findViewById(R.id.homeButton);
        ub = (Button) findViewById(R.id.updateButton);
        ub = (Button) findViewById(R.id.addButton);
        cb1 = (Button) findViewById(R.id.clearButton1);
        ab = (Button) findViewById(R.id.addButton);

        ps1 = (Spinner) findViewById(R.id.posSpinner1);
        ps2 = (Spinner) findViewById(R.id.posSpinner2);
        ps3 = (Spinner) findViewById(R.id.posSpinner3);
        ps4 = (Spinner) findViewById(R.id.posSpinner4);
        ps5 = (Spinner) findViewById(R.id.posSpinner5);
        ps6 = (Spinner) findViewById(R.id.posSpinner6);
        ps7 = (Spinner) findViewById(R.id.posSpinner7);
        ps8 = (Spinner) findViewById(R.id.posSpinner8);
        ps9 = (Spinner) findViewById(R.id.posSpinner9);
        ps10 = (Spinner) findViewById(R.id.posSpinner10);
        ps11 = (Spinner) findViewById(R.id.posSpinner11);
        ps12 = (Spinner) findViewById(R.id.posSpinner12);
        ps13 = (Spinner) findViewById(R.id.posSpinner13);
        ps14 = (Spinner) findViewById(R.id.posSpinner14);
        ps15 = (Spinner) findViewById(R.id.posSpinner15);
        ps16 = (Spinner) findViewById(R.id.posSpinner16);
        ps17 = (Spinner) findViewById(R.id.posSpinner17);
        ps18 = (Spinner) findViewById(R.id.posSpinner18);
        ps19 = (Spinner) findViewById(R.id.posSpinner19);
        ps20 = (Spinner) findViewById(R.id.posSpinner20);
        ps21 = (Spinner) findViewById(R.id.posSpinner21);
        ps22 = (Spinner) findViewById(R.id.posSpinner22);
        ps23 = (Spinner) findViewById(R.id.posSpinner23);
        ps24 = (Spinner) findViewById(R.id.posSpinner24);
        ps25 = (Spinner) findViewById(R.id.posSpinner25);
        ps26 = (Spinner) findViewById(R.id.posSpinner26);
        ps27 = (Spinner) findViewById(R.id.posSpinner27);
        ps28 = (Spinner) findViewById(R.id.posSpinner28);
        ps29 = (Spinner) findViewById(R.id.posSpinner29);
        ps30 = (Spinner) findViewById(R.id.posSpinner30);
        ps31 = (Spinner) findViewById(R.id.posSpinner31);
        ps32 = (Spinner) findViewById(R.id.posSpinner32);
        ps33 = (Spinner) findViewById(R.id.posSpinner33);
        ps34 = (Spinner) findViewById(R.id.posSpinner34);
        ps35 = (Spinner) findViewById(R.id.posSpinner35);
        ps36 = (Spinner) findViewById(R.id.posSpinner36);
        ps37 = (Spinner) findViewById(R.id.posSpinner37);
        ps38 = (Spinner) findViewById(R.id.posSpinner38);
        ps39 = (Spinner) findViewById(R.id.posSpinner39);
        ps40 = (Spinner) findViewById(R.id.posSpinner40);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.soccer_positions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nf2.setText(FileHelper.ReadFile(RosterPageActivity.this));
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RosterPageActivity.this, AddRosterActivity.class));
            }
        });

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FileHelper.saveToFile( nf1.getText().toString())){
                    Toast.makeText(RosterPageActivity.this,"Saved to file",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RosterPageActivity.this,"Error save file!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        hb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RosterPageActivity.this, DirectoryActivity.class));
            }
        });

        ps1.setAdapter(adapter);
        ps2.setAdapter(adapter);
        ps3.setAdapter(adapter);
        ps4.setAdapter(adapter);
        ps5.setAdapter(adapter);
        ps6.setAdapter(adapter);
        ps7.setAdapter(adapter);
        ps8.setAdapter(adapter);
        ps9.setAdapter(adapter);
        ps10.setAdapter(adapter);
        ps11.setAdapter(adapter);
        ps12.setAdapter(adapter);
        ps13.setAdapter(adapter);
        ps14.setAdapter(adapter);
        ps15.setAdapter(adapter);
        ps16.setAdapter(adapter);
        ps17.setAdapter(adapter);
        ps18.setAdapter(adapter);
        ps19.setAdapter(adapter);
        ps20.setAdapter(adapter);
        ps21.setAdapter(adapter);
        ps22.setAdapter(adapter);
        ps23.setAdapter(adapter);
        ps24.setAdapter(adapter);
        ps25.setAdapter(adapter);
        ps26.setAdapter(adapter);
        ps27.setAdapter(adapter);
        ps28.setAdapter(adapter);
        ps29.setAdapter(adapter);
        ps30.setAdapter(adapter);
        ps31.setAdapter(adapter);
        ps32.setAdapter(adapter);
        ps33.setAdapter(adapter);
        ps34.setAdapter(adapter);
        ps35.setAdapter(adapter);
        ps36.setAdapter(adapter);
        ps37.setAdapter(adapter);
        ps38.setAdapter(adapter);
        ps39.setAdapter(adapter);
        ps40.setAdapter(adapter);


        readFromFile(getApplicationContext()); // DELETE THIS LINE ONCE DYNAMIC
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.homeButton:
                break;

            case R.id.updateButton:
                break;
        }
    }

    private void readFromFile(Context context) {

        String ret = "";

        try {
            File myFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + "Team1"), "Team1" + "Roster.txt"); // replace 'Team1' with teamName once dynamic
            FileInputStream in = new FileInputStream(myFile);
            String[] data = new String[6];

            if (in != null) { // Name#Age#Player Number#Position#Grade
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                /*
                Loop once dynamic
                 */
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf1.setText(data[0]); // first and last name
                af1.setText(data[1]);
                numf1.setText(data[2]);
                ps1.setSelection(1);
                gf1.setText(data[4]);
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf2.setText(data[0]); // first and last name
                af2.setText(data[1]);
                numf2.setText(data[2]);
                ps2.setSelection(1);
                gf2.setText(data[4]);
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf3.setText(data[0]); // first and last name
                ps3.setSelection(1);
                af3.setText(data[1]);
                numf3.setText(data[2]);
                gf3.setText(data[4]);
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf4.setText(data[0]); // first and last name
                ps4.setSelection(1);
                af4.setText(data[1]);
                numf4.setText(data[2]);
                gf4.setText(data[4]);
                ret = bufferedReader.readLine();
                data = ret.split("#");
                nf5.setText(data[0]); // first and last name
                af5.setText(data[1]);
                numf5.setText(data[2]);
                ps5.setSelection(1);
                gf5.setText(data[4]);
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
