package com.example.intent_11_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MyService.class);
    }
    public void start(View view){
        intent.putExtra("data","Day la du lieu duoc chuyen vao service");
        startService(intent);
    }
    public void stop(View view){
        stopService(intent);
    }
}