package com.example.sukien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTime extends AppCompatActivity implements View.OnClickListener{

    private EditText et,ed;
    private TextView tvm;
    AutoCompleteTextView auto;
    MultiAutoCompleteTextView multi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        et=findViewById(R.id.eTime);
        ed=findViewById(R.id.eDate);
        et.setOnClickListener(this);
        ed.setOnClickListener(this);
        tvm=findViewById(R.id.mDoiMau);
        registerForContextMenu(tvm);

        auto=findViewById(R.id.aut);
        multi=findViewById(R.id.multi);
        String[] city={"Ha noi","ha giang","Hai phong","Thai Binh","Tuyen Quang","Lang Son","Long An"};
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,city);
        auto.setAdapter(adapter);
        multi.setAdapter(adapter);
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    @Override
    public void onClick(View v) {
        if(v==et){
            Calendar c= Calendar.getInstance();
            int hh=c.get(Calendar.HOUR_OF_DAY);
            int mm=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view,
                                      int hourOfDay, int minute) {
                    et.setText(hourOfDay+" : "+minute);
                }
            },hh,mm,true);
            timePickerDialog.show();
        }
        if(v==ed){
            Calendar c= Calendar.getInstance();
            int y=c.get(Calendar.YEAR);
            int m=c.get(Calendar.MONTH);
            int d=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    ed.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }, y , m , d );
            datePickerDialog.show();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.color_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.mRed) {
//            tvm.setTextColor(Color.RED);
            tvm.setBackgroundColor(Color.RED);
        } else if (itemId == R.id.mGreen) {
//            tvm.setTextColor(Color.GREEN);
            tvm.setBackgroundColor(Color.GREEN);
        } else if (itemId == R.id.mBlue) {
//            tvm.setTextColor(Color.BLUE);
            tvm.setBackgroundColor(Color.BLUE);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.mFile) {
            Toast.makeText(this, "File", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.mExit) {
            System.exit(0);
        } else if (itemId == R.id.mEmail) {
            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.mPhone) {
            Toast.makeText(this, "Phone", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}