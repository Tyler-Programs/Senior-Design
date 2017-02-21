package com.example.tbecker012.soccermomsapp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

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

    public File createEventsFile(Context context)
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
                    return newFile;
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
        return null;
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

    public boolean rewriteEvents(List<String> data, Context context){
        /*
        data in format: eventID#name#date#time#address
         */
        try {
            File oldFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + teamName), teamName + "Events.txt"); // get the current events file
            oldFile.renameTo(new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + teamName), teamName + "Events-old.txt")); // rename the file to  "...-old.txt"
            createEventsFile(context); // create the new file

            File newFile = createEventsFile(context); // create the new events file
            FileOutputStream out = new FileOutputStream(newFile, true); // create the write stream
            for(int i=0;i<data.size();i++) // loop the size of the list
            {
                out.write(data.indexOf(i)); // write each new event
                out.write("\n".getBytes()); // write a new line after the event
            }
            out.close(); // close the file when done writing
            return true; // successfully written
        }catch(Exception e){
            Log.e("error","Error rewriting events file");
            e.printStackTrace();
        }

        return false; // could not write properly
    }

    public void addEvent(String data, Context context)
    {
        /*
        data in format: eventID#address/n
         */
        try{
            File newFile = new File("" + context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS + "/" + teamName), teamName + "Events.txt"); // get the file
            FileOutputStream out = new FileOutputStream(newFile, true); //open file with appending option
            out.write(data.getBytes());
            out.write("\n".getBytes()); // add the newline character
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
            Log.e("error", "FILE NOT FOUND");
        }
    }

    public void removeEvent(long evtID, Context context)
    {
        // find the evtID in the Events.txt file and remove that line
    }

}



