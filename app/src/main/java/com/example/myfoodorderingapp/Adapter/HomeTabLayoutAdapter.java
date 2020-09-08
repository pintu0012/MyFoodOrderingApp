package com.example.myfoodorderingapp.Adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myfoodorderingapp.Fragment.HomeTabLayoutFirstFragment;
import com.example.myfoodorderingapp.Fragment.HomeTabLayoutFourthFragment;
import com.example.myfoodorderingapp.Fragment.HomeTabLayoutSecondFragment;
import com.example.myfoodorderingapp.Fragment.HomeTabLayoutThirdFragment;

public class HomeTabLayoutAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public HomeTabLayoutAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeTabLayoutFirstFragment homeTabLayoutFirstFragment = new HomeTabLayoutFirstFragment();
                return homeTabLayoutFirstFragment;
            case 1:
                HomeTabLayoutSecondFragment homeTabLayoutSecondFragment= new HomeTabLayoutSecondFragment();
                return homeTabLayoutSecondFragment;
            case 2:
                HomeTabLayoutThirdFragment homeTabLayoutThirdFragment= new HomeTabLayoutThirdFragment();
                return homeTabLayoutThirdFragment;
            case 3:
                HomeTabLayoutFourthFragment homeTabLayoutFourthFragment= new HomeTabLayoutFourthFragment();
                return homeTabLayoutFourthFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}