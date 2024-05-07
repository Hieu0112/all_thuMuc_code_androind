package com.example.dong_ho_notification;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import java.util.Date;

public class AlarmReceiver extends BroadcastReceiver {
    final String CHANNEL_ID="201";

    @Override
    public void onReceive(Context context, Intent intent) {
        String time=intent.getStringExtra("time");

        if(intent.getAction().equals("MyAction")){
            NotificationManager notificationManager=(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(
                        CHANNEL_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_HIGH
                );
                channel.setDescription("Mieu ta cho kenh 1");
                notificationManager.createNotificationChannel(channel);
            }
            NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setContentTitle("Báo thức: "+time)
                    .setContentText("Dậy đi đến giờ "+time+" rồi")
                    .setSmallIcon(R.drawable.icon_notification)
                    .setColor(Color.RED)
                    .setCategory(NotificationCompat.CATEGORY_ALARM);
            notificationManager.notify(getNotificationId(),builder.build());
        }
    }
    private int getNotificationId(){
        return (int)(new Date().getTime());
    }
}
