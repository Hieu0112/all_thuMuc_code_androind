package com.example.fragment_tuan8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment_tuan8.fragment.FragmentA;
import com.example.fragment_tuan8.fragment.FragmentB;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btA,btB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btA=findViewById(R.id.btA);
        btB=findViewById(R.id.btB);
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        Fragment fg;
        int id = v.getId();
        if (id == R.id.btA) {
            fg = new FragmentA();
            transaction.add(R.id.frag, fg);
        } else if (id == R.id.btB) {
            fg = new FragmentB();
            transaction.add(R.id.frag, fg);
        }
        transaction.commit();
    }
}