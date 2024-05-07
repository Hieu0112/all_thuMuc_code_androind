package com.example.nhom4tuan10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom4tuan10.model.Account;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUser,tvPass;
    private Button btRegister,btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        btRegister.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    private void initView() {
        tvUser=findViewById(R.id.txtUsername);
        tvPass=findViewById(R.id.txtPassword);
        btRegister=findViewById(R.id.btnRegister);
        btCancel=findViewById(R.id.btnCancel);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnRegister) {
            Account account = new Account(tvUser.getText().toString(), tvPass.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("data",account);
            setResult(RESULT_OK,intent);
            finish();
        } else if (id == R.id.btnCancel) {
            setResult(RESULT_CANCELED,null);
            finish();
        }
    }

}