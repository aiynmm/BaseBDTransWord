package com.sinosoft.basebdtransword.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mars on 2017/6/13.
 */

public class CollectionPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;
    private String[] titles;
    public CollectionPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragments,String[] titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
