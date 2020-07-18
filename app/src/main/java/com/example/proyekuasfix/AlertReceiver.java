package com.example.proyekuasfix;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;


public class AlertReceiver extends BroadcastReceiver{
    private NotificationHelper mNotificationHelper;
    private String message;
    private  String title;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper mNotificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = mNotificationHelper.getnootifNotification(title, message);
        mNotificationHelper.getManager().notify(1, nb.build());
    }
}
