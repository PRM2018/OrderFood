package com.prm.orderfood.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.prm.orderfood.Fragment.ManageEmployee;
import com.prm.orderfood.Fragment.ManageFood;

public class AdminPageAdapter extends FragmentPagerAdapter {
    public AdminPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ManageEmployee();
            default:
                return new ManageFood();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Employee";
            default:
                return "Food";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
