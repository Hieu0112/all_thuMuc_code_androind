package com.example.nhom4tuan10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom4tuan10.model.Account;

public class MainLogin extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);
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