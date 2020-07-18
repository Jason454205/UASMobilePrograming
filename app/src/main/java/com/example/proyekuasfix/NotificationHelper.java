package com.example.proyekuasfix;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String notif = "AlarmID";
    public static final String notifName = "Alarm On";
    private NotificationManager mManager;
    private String title;
    private String message;


    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createChannels();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel nootif = new NotificationChannel(notif, notifName, NotificationManager.IMPORTANCE_DEFAULT);
        nootif.enableLights(true);
        nootif.enableVibration(true);
        nootif.setLightColor(R.color.colorPrimary);
        nootif.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(nootif);
    }
    public NotificationManager getManager(){
        if(mManager==null){
            mManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }return mManager;
    }
    public NotificationCompat.Builder getnootifNotification(String title, String message){
        this.title = title;
        this.message = message;
        return new NotificationCompat.Builder(getApplicationContext(),notif)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_one);

    }


}
