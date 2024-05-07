package com.example.nhom4tuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                String name="ABC DEF";
                intent.putExtra("name",name);
                int age=18;
                intent.putExtra(name,age);
                String[] subs={"LT HDH","androind","CSDL"};
                intent.putExtra("s",subs);
                startActivity(intent);
            }
        });
    }
}