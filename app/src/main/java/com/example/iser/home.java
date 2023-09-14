package com.example.iser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

public class home extends AppCompatActivity implements new_blog.sentdatalistener{

    explore explore;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPager);
        viewPageradapter viewPageradapter =new viewPageradapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageradapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#fff387"));
        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#D6DCED")));
    }

    @Override
    public void oninputSent(String title, String description) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        explore ex=(explore) getSupportFragmentManager().findFragmentByTag(tag);
        ex.updateString(title,description);
    }
}