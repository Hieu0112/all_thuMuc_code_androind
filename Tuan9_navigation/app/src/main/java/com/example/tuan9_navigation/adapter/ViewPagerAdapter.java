package com.example.tuan9_navigation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tuan9_navigation.fragment.fragmentCafe;
import com.example.tuan9_navigation.fragment.fragmentHome;
import com.example.tuan9_navigation.fragment.fragmentNoti;
import com.example.tuan9_navigation.fragment.fragmentSearch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragmentHome();
            case 1:
                return new fragmentNoti();
            case 2:
                return new fragmentSearch();
            case 3:
                return new fragmentCafe();
            default:
                return new fragmentHome();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
