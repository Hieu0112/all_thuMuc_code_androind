package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewdemo.model.Technology;
import com.example.listviewdemo.model.TechnologyAdapter;

public class TechnologyActivity extends AppCompatActivity {

    private ListView listView;
    TechnologyAdapter adapter;
    private Technology[]list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);
        listView=findViewById(R.id.lview);
        initData();
        adapter = new TechnologyAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < listView.getAdapter().getCount(); i++) {
                    listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                listView.getChildAt(position).setBackgroundColor(Color.BLUE);
                Technology t = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),t.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        Integer[]imgs={R.drawable.img,R.drawable.img_2,R.drawable.img_3,R.drawable.img_1};
        String[]name={"Androind","IOS","Battery","Windows"};
        String[]sub={"Sub Androind","Sub IOS","Sub Battery","Sub Windows"};
        String[]des={"Describe Androind","Describe IOS","Describe Battery","Describe Windows"};
        list=new Technology[imgs.length];
        for(int i=0 ;i<list.length;i++){
            list[i]=new Technology(imgs[i],name[i],sub[i],des[i]);
        }
    }
}