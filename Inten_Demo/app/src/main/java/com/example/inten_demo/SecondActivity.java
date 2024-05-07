package com.example.inten_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private Button bt;
    private TextView tvName;
    private TextView tvSub,tvST;
    private ImageView img;
    private TextView tvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bt=findViewById(R.id.bt);
        tvName=findViewById(R.id.tvName);
        tvSub=findViewById(R.id.tvSub);
        img=findViewById(R.id.img);
        tvST=findViewById(R.id.tvST);
        tvList=findViewById(R.id.tvList);
        Intent t=getIntent();
        String name=t.getStringExtra("name");
        int age=t.getIntExtra("age",0);
        tvName.setText("Ten:"+ name+",Tuoi: "+age);
        String[]sub=t.getStringArrayExtra("subject");
        tvSub.setText(Arrays.toString(sub));
        Student s=(Student) t.getSerializableExtra("student");
        img.setImageResource(s.getImgs());
        tvST.setText("Name: "+s.getName()+" - tuoi: "+s.getAge());
        List<Student>list=(List<Student>)t.getSerializableExtra("data");
        String tt="";
        for (Student i:list){
            tt+=i.getName()+" age: "+i.getAge()+"\n";
        }
        tvList.setText(tt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}