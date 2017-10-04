package com.example.jegri.IntentSpoof;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


/**
 * Created by kmluns on 22.06.2017.
 */

public class Main2Activity extends AppCompatActivity {


    public TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        Intent i1 = getIntent();

        textview = (TextView) findViewById(R.id.textView);
        textview.setText(textview.getText() + "\r\n" + i1.getStringExtra("content"));

        if(i1.getExtras().get("attachment_path") != null || i1.getExtras().get("attachment_path") != ""){
            Intent i = new Intent();
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setAction(android.content.Intent.ACTION_VIEW);
            i.setDataAndType((Uri)i1.getExtras().get("attachment_path") , "image/*");
            this.startActivity(i);
        }

    }

}
