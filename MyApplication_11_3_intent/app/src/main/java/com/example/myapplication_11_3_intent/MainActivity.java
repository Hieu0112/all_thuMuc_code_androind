package com.example.myapplication_11_3_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iWeb,iSms,iPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iWeb=findViewById(R.id.web);
        iSms=findViewById(R.id.sms);
        iPhone=findViewById(R.id.phone);
        iWeb.setOnClickListener(this);
        iSms.setOnClickListener(this);
        iPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.web) {
            Intent w = new Intent();
            w.setAction(Intent.ACTION_VIEW);
            w.setData(Uri.parse("https://www.youtube.com/watch?v=0EFn2XjTAjM"));
            startActivity(w);
        } else if (id == R.id.sms) {
            Intent s = new Intent();
            s.setAction(Intent.ACTION_VIEW);
            s.setData(Uri.parse("sms:" + "0988289071"));
            s.putExtra("sms_body", "hieu dep trai muon nam");
            startActivity(s);
        } else if (id == R.id.phone) {
            Intent p = new Intent();
            p.setAction(Intent.ACTION_DIAL);
            p.setData(Uri.parse("tel:0988289071"));
            startActivity(p);
        }
    }
}