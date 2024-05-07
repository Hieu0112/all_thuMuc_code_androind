package com.example.inten_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(MainActivity.this,SecondActivity.class);
                String name="Hieu Dep Trai";
                t.putExtra("name",name);
                int age=22;
//                String age="22";
                t.putExtra("age",age);
                String[]subject={
                        "LTHDT",
                        "LT Web",
                        "LT TB DD"
                };
                t.putExtra("subject",subject);
                Student st=new Student(R.drawable.img,"Hiếu",22);
                t.putExtra("student",st);
                List<Student>list =new ArrayList<>();
                list.add(st);
                list.add(new Student(R.drawable.img,"a",22));
                list.add(new Student(R.drawable.img,"b",22));
                t.putExtra("data", (Serializable) list);
                startActivity(t);
            }
        });
    }
}