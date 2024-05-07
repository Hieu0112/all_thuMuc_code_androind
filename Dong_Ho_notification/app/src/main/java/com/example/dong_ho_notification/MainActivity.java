package com.example.dong_ho_notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private Button btDat,btDung;
    private TextView tv;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker=findViewById(R.id.time);
        btDat=findViewById(R.id.btDat);
        btDung=findViewById(R.id.btDung);
        tv=findViewById(R.id.tv);
        btDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Đã dừng đặt giờ");
                pendingIntent.cancel();
            }
        });
        btDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                int gio=timePicker.getCurrentHour();
                int phut=timePicker.getCurrentMinute();
                String sgio=String.valueOf(gio);
                String sphut=String.valueOf(phut);
                if(gio>12){
                    sgio=String.valueOf(gio-12);
                }
                if(phut<10){
                    sphut="0"+sphut;
                }
                tv.setText("Thời gian hẹn giờ: "+sgio+":"+sphut);
                Intent intent=new Intent(MainActivity.this, AlarmReceiver.class);
                intent.setAction("MyAction");
                intent.putExtra("time",sgio+":"+sphut);
                alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
            }
        });
    }
}