package com.example.mvp_training;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private static List<Fragment> mFragmentList = null;


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

//    private void init() {
//        mFragmentList.add (new ProductionScheduleFragment ());
//        mFragmentList.add(new DailyScheduleFragment ());
//        mFragmentList.add(new InfomationNoticeFragment ());
//    }


    public void setFragmentList(List<Fragment> fragments) {
        mFragmentList = fragments;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }
}
