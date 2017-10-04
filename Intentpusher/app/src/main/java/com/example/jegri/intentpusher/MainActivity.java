package com.example.jegri.intentpusher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button bttn1 = (Button) findViewById(R.id.button1);

        bttn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                sendMessage();
            }
        });

        final Button bttn2 = (Button) findViewById(R.id.button);

        bttn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                sendMessage2();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void sendMessage( ){

        /** Message
         *
         * Change Message
         */
        String message = new String("#Message!");

        /** Call the real intent
         *
         *
         *
         * Change ActionName
         *  ActionName is in the manifest.xml file of the application. Programs that can read this file are available on the internet. It has to be read.
         */
        Intent intent = new Intent("#ActionName");

        intent.putExtra("receiver","kmluns");
        intent.putExtra("content", message);
        sendBroadcast(intent);



    }


    /**
     *
     * It is the function found in the Spoof application that sends its data to the receiver that we have received our permission to create.
     *
     */

    private void sendMessage2(){

        /** Message
         *
         * Change Message
         */
        String message = new String("#Message!");



        /** Call the real intent
         *
         *
         *
         * Change ActionName
         *  It is necessary to write the intent action name in spoof application which we have our own permission.
         */
        Intent intent = new Intent("#ActionName");

        intent.putExtra("receiver","kmluns");
        intent.putExtra("content", message);
        sendBroadcast(intent);



    }



}






