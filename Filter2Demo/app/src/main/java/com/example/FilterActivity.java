package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        tv=findViewById(R.id.tv);
//        Uri url=getIntent().getData();
//        String s="Scheme: "+url.getScheme()+"\nHost: "+url.getHost();
//        int k=1;
//        for (String i: url.getPathSegments()){
//            s+="\npara"+(k++)+": "+i;
//        }
//        s+="\naction: "+getIntent().getAction();
//        tv.setText(s);
//        String s="Content: "+getIntent().getStringExtra("sms_body").toString();
//        s+="\ndata: "+getIntent().getDataString();//sms:...
//        tv.setText(s);
        String num=getIntent().getDataString().toString().substring(4);//tel:...
        tv.setText(num);

    }
}