package com.example.mvp_training;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class SalesOrderActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager2 pager;
    ViewPagerAdapter pagerAdapter;
    String ordernumber,saleordernum,itemID,customername,qty,containerDate,onlineDate,orgID,activity;
    TextView ordernum;

    //模擬APS製令介面功能
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order);

        tabs = findViewById(R.id.Tablayout_searchorder);
        pager = findViewById(R.id.viewpager_searchorder);

        pagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), getLifecycle ());
        setupViewPager();
        pager.setAdapter (pagerAdapter);
        String[] tabTitle = {"前關製令", "本階製令", "後關製令", "裝配製令", "銷售製令"};
        new TabLayoutMediator(tabs, pager, new TabLayoutMediator.TabConfigurationStrategy () {
            @Override
            public void onConfigureTab (@NonNull TabLayout.Tab tab, int position) {
                tab.setText (tabTitle[position]);
            }
        }).attach();

        pager.setCurrentItem(2);
    }

    public void setupViewPager() {
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add (new ManufactureOrderListPageFragment ());
        mFragmentList.add (new ManufactureOrderListPageFragment ());
        mFragmentList.add (new ManufactureOrderListPageFragment ());
        mFragmentList.add (new ManufactureOrderListPageFragment ());
        mFragmentList.add (new ManufactureOrderListPageFragment ());

//        mFragmentList.add (new BlankFragment1());
//        mFragmentList.add (new BlankFragment3());
//        mFragmentList.add (new BlankFragment4());
//        mFragmentList.add (new BlankFragment5());
        pagerAdapter.setFragmentList (mFragmentList);
    }
}