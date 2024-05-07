package com.example.tuan9_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.tuan9_navigation.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView nav;
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    FloatingActionButton bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        nav=findViewById(R.id.nav);
        bt=findViewById(R.id.fab);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Click Button add",Toast.LENGTH_SHORT).show();
            }
        });
        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        nav.getMenu().findItem(R.id.mHome).setChecked(true);
                        break;
                    case 1:
                        nav.getMenu().findItem(R.id.mNoti).setChecked(true);
                        break;
                    case 2:
                        nav.getMenu().findItem(R.id.mSearch).setChecked(true);
                        break;
                    case 3:
                        nav.getMenu().findItem(R.id.mCafe).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.mHome) {
                    viewPager.setCurrentItem(0);
                } else if (itemId == R.id.mNoti) {
                    viewPager.setCurrentItem(1);
                } else if (itemId == R.id.mSearch) {
                    viewPager.setCurrentItem(2);
                } else if (itemId == R.id.mCafe) {
                    viewPager.setCurrentItem(3);
                }
                return true;
            }
        });
    }
}