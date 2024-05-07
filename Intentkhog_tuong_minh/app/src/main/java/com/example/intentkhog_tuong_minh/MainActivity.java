package com.example.intentkhog_tuong_minh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button web,sms,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.web);
        sms=findViewById(R.id.sms);
        phone=findViewById(R.id.phone);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.bing.com/ck/a?!&&p=82ec1d937ce2d966JmltdHM9MTcxMjEwMjQwMCZpZ3VpZD0yMGExNTc1YS03OTQ4LTY5YTctMWFjNC00MzVhNzgyZTY4ZjkmaW5zaWQ9NTIyMg&ptn=3&ver=2&hsh=3&fclid=20a1575a-7948-69a7-1ac4-435a782e68f9&psq=pikachu&u=a1aHR0cHM6Ly93d3cucGlrYWNodW9ubGluZS5jb20v&ntb=1"));
                startActivity(intent);
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,
                        Uri.parse("sms:09201929"));
                                startActivity(intent);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:09201929"));
                startActivity(intent);
            }
        });

    }
}