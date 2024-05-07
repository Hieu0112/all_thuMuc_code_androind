package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.login.model.Account;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txtInfor);
        Intent intent=getIntent();
        if(intent.getSerializableExtra("account")!=null&&intent.getSerializableExtra("user")!=null){
            Account log=(Account) intent.getSerializableExtra("account");
            Account user=(Account) intent.getSerializableExtra("user");
            if(log.getUsername().equalsIgnoreCase(user.getUsername())&&log.getPassword().equalsIgnoreCase(user.getPassword())){
                txt.setText("Dang Nhap Thanh Cong!!!");
            }
            else{
                txt.setText("Tai Khoan Khong Ton Tai");
            }
        }
    }
}