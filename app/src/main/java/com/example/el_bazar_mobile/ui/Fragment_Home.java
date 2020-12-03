package com.example.el_bazar_mobile.ui;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import com.example.el_bazar_mobile.R;

import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_four;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_one;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_three;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_tow;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

public class Fragment_Home  extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Fragment_sous_one fragment_sous_one;
    private Fragment_sous_tow fragment_sous_tow;
    private Fragment_sous_three fragment_sous_three;
    private Fragment_sous_four fragment_sous_four;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = v.findViewById(R.id.view_pager);
        tabLayout = v.findViewById(R.id.tab_layout);

        fragment_sous_one = new Fragment_sous_one();
        fragment_sous_tow = new Fragment_sous_tow();
        fragment_sous_three = new Fragment_sous_three();
        fragment_sous_four = new Fragment_sous_four();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        viewPagerAdapter.addFragment(fragment_sous_one, "Home");
        viewPagerAdapter.addFragment(fragment_sous_tow, "Vetement");
        viewPagerAdapter.addFragment(fragment_sous_three, "meuble");
        viewPagerAdapter.addFragment(fragment_sous_four, "electronique");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);
        tabLayout.getTabAt(2);
        tabLayout.getTabAt(3);

       // BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
    //    badgeDrawable.setVisible(true);
    //    badgeDrawable.setNumber(12);



        return v ;
    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}
