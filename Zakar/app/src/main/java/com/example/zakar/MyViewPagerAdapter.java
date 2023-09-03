package com.example.zakar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.zakar.tabfagments.AudioFragment;
import com.example.zakar.tabfagments.DzongkhaFragment;
import com.example.zakar.tabfagments.EnglishFragment;
import com.example.zakar.tabfagments.SelectDateFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){

            case 0:
                return new SelectDateFragment();
            case 1:
                return new DzongkhaFragment();
            case 2:
                return new EnglishFragment();
            default:
                return new AudioFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
