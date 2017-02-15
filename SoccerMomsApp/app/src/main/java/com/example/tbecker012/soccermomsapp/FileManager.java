package com.example.tbecker012.soccermomsapp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Tyler on 2/14/2017.
 */

public class FileManager {

    private String teamName;
    /*
    1) Create object of this class
    2) Call makeRosterFile(String teamName, this.getApplicationContext)

    File is created under the team's folder in documents
     */
    public FileManager()
    {
        //default constructor
    }

    public FileManager(String team)
    {
        teamName = team;
    }

    public void createDirectory(Context context)
    {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            File newDir = new File(""+context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), teamName);
            try{
                newDir.mkdir();
                Log.e("error","Dir created successfully");
            }catch(Exception e)
            {
                Log.e("error","Problem creating directory: "+newDir);
                e.printStackTrace();
            }
        } // end SD Card exists check
        else
        {
            Log.e("error", "SD Card not found");
        }
    }

    public void createRosterFile(Context context)
    {
        // check if sd card exists
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            File newFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + teamName), teamName + "Roster.txt");
            if (!newFile.exists()) { // if the team has not been created already
                try {
                    newFile.createNewFile(); // create it as a file
                    Log.e("error", "File created successfully");
                    FileOutputStream out = new FileOutputStream(newFile); // open the file for writing
                    out.write("".getBytes()); // write nothing to the file
                    out.close(); // close the file when done writing
                } catch (Exception e) {
                    Log.e("error", "Problem creating file");
                    e.printStackTrace();
                }
            } else if (newFile.exists()) { // the team has already been created
                Log.e("error", "Team already created: " + teamName);
                Toast t = Toast.makeText(context, "That team already exists.", Toast.LENGTH_LONG);
                t.show();
            }
        }
        else{
            Log.e("error", "SD Card not found");
        }
    }

    public void createEventsFile(Context context)
    {
        // check if sd card exists
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            File newFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + teamName), teamName + "Events.txt");
            if (!newFile.exists()) { // if the team has not been created already
                try {
                    newFile.createNewFile(); // create it as a file
                    Log.e("error", "File created successfully");
                    FileOutputStream out = new FileOutputStream(newFile); // open the file for writing
                    out.write("".getBytes()); // write nothing to the file
                    out.close(); // close the file when done writing
                } catch (Exception e) {
                    Log.e("error", "Problem creating file");
                    e.printStackTrace();
                }
            } else if (newFile.exists()) { // the team has already been created
                Log.e("error", "Event file already created for: " + teamName);
                Toast t = Toast.makeText(context, "That file already exists.", Toast.LENGTH_LONG);
                t.show();
            }
        }
        else{
            Log.e("error", "SD Card not found");
        }
    }


    public void addPlayer(String data, Context context)
    {
        /*
        data in format: First Name#Last Name#Age#Player Number#Position#Grade
        Delimit on #
        */
            try{
                File newFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + teamName), teamName + "Roster.txt"); // get the file
                FileOutputStream out = new FileOutputStream(newFile, true); //open file with appending option
                //FileInputStream in = new FileInputStream(file);
                // append contents to file
                out.write(data.getBytes());
                // close the file
                out.close();
                //in.close();
            } catch (Exception e){
                e.printStackTrace();
                Log.e("error","FILE NOT FOUND");
            }
        }



}



