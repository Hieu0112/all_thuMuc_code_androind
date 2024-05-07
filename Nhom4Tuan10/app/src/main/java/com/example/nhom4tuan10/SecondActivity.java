package com.example.nhom4tuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button bt;
    TextView txta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bt=findViewById(R.id.btBack);
        txta=findViewById(R.id.txts);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        int age=intent.getIntExtra("age",20);
        String[] a= getIntent().getStringArrayExtra("s");
        String res="name: "+name+", age: "+age+", sub: \n";
        for (String i:a){
            res+=i+", ";
        }
        res=res.substring(0,res.length()-2);
        txta.setText(res);
    }
}