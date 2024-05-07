package com.example.notification_14_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class TB2Kenh extends AppCompatActivity {
    private Button bt1,bt2;
    private int notificationId=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb2_kenh2);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(TB2Kenh.this,
                        MyNotification.CHANNEL_ID)
                        .setContentTitle("Thong bao 1")
                        .setContentText("Noi dung cho thong bao 1,kenh 1")
                        .setSmallIcon(R.drawable.notification)
                        .setColor(Color.RED)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(getNotificationId(),builder.build());
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(TB2Kenh.this,
                        MyNotification.CHANNEL_ID)
                        .setContentTitle("Thong bao 2")
                        .setContentText("Noi dung cho thong bao 2,kenh 2")
                        .setSmallIcon(R.drawable.tb)
                        .setColor(Color.BLUE)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(getNotificationId(),builder.build());
            }
        });
    }
    private int getNotificationId(){
        int num=(int)new Date().getTime();
        return num;
    }
}