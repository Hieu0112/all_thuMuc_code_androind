package com.example.slide3_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox ck1,ck2,ck3;
    private RadioButton g1,g2;
    private RatingBar rt;
    private Spinner sp1,sp2;
    private TextView kq;
    private Button btht;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item5);
        sp1 = findViewById(R.id.uni);
        String[] a = {"PTIT", "HUST", "FTU", "HUCE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, a);
        sp1.setAdapter(adapter);
        initView();
        btht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss="check box: ";
                boolean check=false;
                if(ck1.isChecked()){
                    ss+=ck1.getText()+", ";
                    check=true;
                }
                if(ck2.isChecked()){
                    ss+=ck2.getText()+", ";
                    check=true;
                }
                if(ck3.isChecked()){
                    ss+=ck3.getText();
                    check=true;
                }
                if(ss.endsWith(", ")){
                    ss=ss.substring(0,ss.length()-2)+".";
                }
                if(check)
                    ss+="\nGioi tinh: ";
                if(g1.isChecked()){
                    ss+=g1.getText()+".";
                }
                if(g2.isChecked()){
                    ss+=g2.getText()+".";
                }
                ss+="\nRating: "+rt.getRating();
                ss+="\nCountry: "+sp1.getSelectedItem().toString();
                ss+="\nUniversity: "+sp2.getSelectedItem().toString();
                kq.setText(ss);
            }
        });
    }
    private void initView() {
        ck1=findViewById(R.id.ck1);
        ck2=findViewById(R.id.ck2);
        ck3=findViewById(R.id.ck3);
        g1=findViewById(R.id.gnam);
        g2=findViewById(R.id.gnu);
        rt=findViewById(R.id.rating);
        btht=findViewById(R.id.bt);
        kq=findViewById(R.id.txtTT);
        sp1=findViewById(R.id.coutry);
        sp2=findViewById(R.id.uni);
    }
}