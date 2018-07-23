package com.prm.orderfood;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.prm.orderfood.Adapter.AdminPageAdapter;

public class AdminActivity extends AppCompatActivity {
    TabLayout admin_tabLayout;
    ViewPager admin_viewPager;
    AdminPageAdapter adminPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Intent intent=getIntent();

        admin_tabLayout=findViewById(R.id.admin_tabLayout);
        admin_viewPager=findViewById(R.id.admin_viewPager);
        adminPageAdapter=new AdminPageAdapter(getSupportFragmentManager());

        //Setup
        admin_viewPager.setAdapter(adminPageAdapter);
        admin_tabLayout.setupWithViewPager(admin_viewPager);
        admin_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
