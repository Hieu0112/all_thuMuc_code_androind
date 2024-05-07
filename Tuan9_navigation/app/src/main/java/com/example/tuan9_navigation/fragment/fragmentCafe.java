package com.example.tuan9_navigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tuan9_navigation.R;
import com.example.tuan9_navigation.cafe.CafeViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class fragmentCafe extends Fragment {
    TabLayout tab;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cafe,container,false);
        tab=view.findViewById(R.id.tabLayout);
        viewPager=view.findViewById(R.id.viewPager);
        CafeViewPagerAdapter adapter=new CafeViewPagerAdapter(getChildFragmentManager(),3);
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
        return view;
    }
}
