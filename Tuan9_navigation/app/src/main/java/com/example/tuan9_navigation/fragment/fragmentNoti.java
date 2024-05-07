package com.example.tuan9_navigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuan9_navigation.R;
import com.example.tuan9_navigation.adapter.MessageAdapter;
import com.example.tuan9_navigation.model.Message;

import java.util.ArrayList;
import java.util.List;

public class fragmentNoti extends Fragment {
    MessageAdapter messageAdapter;
    RecyclerView recyclerView;
    List<Message> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_noti,container,false);
        list=new ArrayList<>();
        list.add(new Message(R.drawable.image,"God chu","Em an com chua?","16:20"));
        list.add(new Message(R.drawable.image,"B chu","Ban an com chua?","14:20"));
        list.add(new Message(R.drawable.image,"Doraemon","Banh ran?","12:20"));
        list.add(new Message(R.drawable.image," 7 vien ngoc rong","Do an","8:20"));
        list.add(new Message(R.drawable.image,"Cat","Meowwwwwwwwwwwwwwww?","6:20"));
        recyclerView=view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        messageAdapter= new MessageAdapter(view.getContext(),list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(messageAdapter);
        return view;
    }
}
