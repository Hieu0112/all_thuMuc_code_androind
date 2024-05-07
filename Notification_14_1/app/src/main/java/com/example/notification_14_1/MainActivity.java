package com.example.notification_14_1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private int notificationId = 1;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a notification channel for Android 8.0 and above
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(
                            "channel_id",
                            "Channel Name",
                            NotificationManager.IMPORTANCE_DEFAULT
                    );
                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);
                }

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "channel_id")
                        .setSmallIcon(R.drawable.notification)
                        .setContentTitle("Thông báo")
                        .setContentText("Nội dung thông báo")
                        .setDefaults(NotificationCompat.DEFAULT_SOUND)
                        .setColor(Color.RED);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(getNotificationId(), builder.build());
            }
        });
    }
    private int getNotificationId(){
        int num=(int)new Date().getTime();
        return num;
    }
}
