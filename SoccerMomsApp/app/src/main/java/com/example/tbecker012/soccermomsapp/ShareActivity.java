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
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ShareActivity extends AppCompatActivity implements EditText.OnClickListener {
    public Button rb, mmb;
    public EditText ef, sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        init();
    }

    public void init(){
        rb = (Button) findViewById(R.id.rosterButton);
        mmb = (Button) findViewById(R.id.homeButton);
        ef = (EditText) findViewById(R.id.emailField);
        sm = (EditText) findViewById(R.id.editText);

        sm.setEnabled(false);

        mmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareActivity.this, DirectoryActivity.class));
            }
        });

        rb.setOnClickListener(this);
    }

    String toAddress;
    @Override
    public void onClick(View v) {
        toAddress = ef.getText().toString();

        switch(v.getId()) {
            case R.id.rosterButton:
                try {
                    String filename = teamName + "Roster.txt"; // need the path here. GET TEAMNAME FROM BUNDLE FROM INTENT
                    File fileLocation = new File(getFilesDir(), filename);
                    fileLocation.createNewFile();
                    writeToExternal(getApplicationContext(), filename);

                    fileLocation = new File(getApplicationContext().getExternalFilesDir(null), filename);
                    fileLocation.createNewFile();
                    Uri path = Uri.fromFile(fileLocation);
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    // set the type to 'email'
                    emailIntent.setType("vnd.android.cursor.dir/email");
                    String to[] = {toAddress};
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, to);

                    // the attachment
                    emailIntent.putExtra(Intent.EXTRA_STREAM, path);

                    // the mail subject
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "A SoccerMom'sApp roster has been shared with you!");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    emailIntent.setData(path);
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

    public void writeToExternal(Context context, String filename){
        try {
            File file = new File(context.getExternalFilesDir(null), filename); //Get file location from external source
            InputStream is = new FileInputStream(context.getFilesDir() + File.separator + filename); //get file location from internal
            OutputStream os = new FileOutputStream(file); //Open your OutputStream and pass in the file you want to write to
            byte[] toWrite = new byte[is.available()]; //Init a byte array for handing data transfer
            Log.i("Available ", is.available() + "");
            int result = is.read(toWrite); //Read the data from the byte array
            Log.i("Result", result + "");
            os.write(toWrite); //Write it to the output stream
            is.close(); //Close it
            os.close(); //Close it
            Log.i("Copying to", "" + context.getExternalFilesDir(null) + File.separator + filename);
            Log.i("Copying from", context.getFilesDir() + File.separator + filename + "");
        } catch (Exception e) {
            Toast.makeText(context, "File write failed: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show(); //if there's an error, make a piece of toast and serve it up
        }
    }
}
