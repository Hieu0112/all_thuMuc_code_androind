package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent();
    }
    public void openWeb(View view){
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=ceE4T5oGGNg"));
        startActivity(intent);
    }
    public void send(View view){
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:0912029966"));
        intent.putExtra("sms_body","Ban co tham gia khoa hoc khong");
        startActivity(intent);
    }
    public void call(View view){
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0912029966"));
        startActivity(intent);
    }
}