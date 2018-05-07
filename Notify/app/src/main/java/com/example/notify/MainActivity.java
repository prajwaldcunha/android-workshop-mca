package com.example.notify;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendDialog(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setMessage("This is a dialog box!!")
                .setCancelable(true)
                .setTitle("This is the dialog title");

        builder1.show();
    }

    public void sendToast(View view) {
        Toast.makeText(this, "This is a toast", Toast.LENGTH_LONG).show();
    }

    public void sendNotification(View view) {
        Log.i("Test", "Test");
        String idChannel = "my_channel_01";
        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel = null;
        // The id of the channel.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, null);
        builder.setContentTitle("Test notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("Notification content");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(idChannel, "Test notification", NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(mChannel);
        }
        builder.setChannelId(idChannel);
        mNotificationManager.notify(1, builder.build());
    }
}

