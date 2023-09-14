package com.example.iser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPageradapter extends FragmentPagerAdapter {
    public viewPageradapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new blog();
        }
        else if(position==1){
            return new explore();
        }
        else{
            return new setting();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Blog";
        }
        else if(position==1){
            return "Explore";
        }
        else{
            return "Settings";
        }
    }
}
