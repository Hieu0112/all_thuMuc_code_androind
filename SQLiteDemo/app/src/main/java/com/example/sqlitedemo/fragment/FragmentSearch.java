package com.example.sqlitedemo.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitedemo.AddActivity;
import com.example.sqlitedemo.R;
import com.example.sqlitedemo.adapter.RecycleViewAdapter;
import com.example.sqlitedemo.dal.SQLiteHelper;
import com.example.sqlitedemo.model.Item;

import java.util.Calendar;
import java.util.List;

public class FragmentSearch extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private TextView tvTong;
    private Button btSearch;
    private SearchView searchView;
    private EditText eFrom,eTo;
    private Spinner spCategory;
    private RecycleViewAdapter adapter;
    private SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter=new RecycleViewAdapter();
        db=new SQLiteHelper(getContext());
        List<Item>list=db.getAll();
        adapter.setList(list);
        tvTong.setText("Tong tien: "+tong(list)+"K");
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Item>list=db.searchByTitle(newText);
                tvTong.setText("Tong tien: "+tong(list)+"K");
                adapter.setList(list);
                return true;
            }
        });
        eFrom.setOnClickListener(this);
        eTo.setOnClickListener(this);
        btSearch.setOnClickListener(this);
        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cate=spCategory.getItemAtPosition(position).toString();
                List<Item>list;
                if(!cate.equalsIgnoreCase("All")){
                    list=db.searchByCategory(cate);
                }
                else {
                    list=db.getAll();
                }
                tvTong.setText("Tong tien: "+tong(list)+"K");
                adapter.setList(list);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private int tong(List<Item>list){
        int t=0;
        for (Item i:list){
            t+=Integer.parseInt(i.getPrice());
        }
        return t;
    }
    private void initView(View view) {
        recyclerView=view.findViewById(R.id.recycleView);
        tvTong=view.findViewById(R.id.tvTong);
        btSearch=view.findViewById(R.id.btSearch);
        searchView=view.findViewById(R.id.search);
        eFrom=view.findViewById(R.id.eFrom);
        eTo=view.findViewById(R.id.eTo);
        spCategory=view.findViewById(R.id.spCategory);
        String[]arr=getResources().getStringArray(R.array.category);
        String[]arr1=new String[arr.length+1];
        arr1[0]="All";
        for (int i = 0; i < arr.length; i++) {
            arr1[i+1]=arr[i];

        }
        spCategory.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.item_spinner,arr1));
    }

    @Override
    public void onClick(View v) {
        if(v==eFrom){
                final Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog =new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                        String date="";
                        if(month1>8){
                            date=dayOfMonth+"/"+(month1+1)+"/"+year1;
                        }
                        else {
                            date=dayOfMonth+"/0"+(month1+1)+"/"+year1;
                        }
                        eFrom.setText(date);
                    }
                },year,month,day);
                dialog.show();
        }
        if(v==eTo){
            final Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog =new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {
                    String date="";
                    if(month1>8){
                        date=dayOfMonth+"/"+(month1+1)+"/"+year1;
                    }
                    else {
                        date=dayOfMonth+"/0"+(month1+1)+"/"+year1;
                    }
                    eTo.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if(v==btSearch){
            String from=eFrom.getText().toString();
            String to=eTo.getText().toString();
            if(!from.isEmpty()&&!to.isEmpty()){
                List<Item>list=db.searchByDate(from,to);
                tvTong.setText("Tong tien: "+tong(list)+"K");
                adapter.setList(list);
            }
        }
    }
}
