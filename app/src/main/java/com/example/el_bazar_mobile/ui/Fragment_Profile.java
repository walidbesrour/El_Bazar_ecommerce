package com.example.el_bazar_mobile.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.ViewPagerAdapter;
import com.example.el_bazar_mobile.databinding.FragmentProfileBinding;
import com.example.el_bazar_mobile.profile_fragment.Fragment_Detail;
import com.example.el_bazar_mobile.profile_fragment.Fragment_Profil_commande;
import com.example.el_bazar_mobile.profile_fragment.Fragment_profile_Pannier;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_four;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_one;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_three;
import com.example.el_bazar_mobile.sous_categorie.Fragment_sous_tow;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Profile  extends Fragment {


    private Fragment_Detail fragment_detail;
    private Fragment_Profil_commande fragment_profil_commande;
    private Fragment_profile_Pannier fragment_profile_pannier;


   private FragmentProfileBinding binding ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());

        fragment_detail = new Fragment_Detail();
        fragment_profil_commande = new Fragment_Profil_commande();
        fragment_profile_pannier = new Fragment_profile_Pannier();


        binding.tabLayout.setupWithViewPager(binding.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        viewPagerAdapter.addFragment(fragment_detail, "Detail");
        viewPagerAdapter.addFragment(fragment_profil_commande, "Mes Commande");
        viewPagerAdapter.addFragment(fragment_profile_pannier, "Mon Panier");

        binding.viewPager.setAdapter(viewPagerAdapter);

        binding.tabLayout.getTabAt(0);
        binding.tabLayout.getTabAt(1);
        binding.tabLayout.getTabAt(2);


        return binding.getRoot() ;
    }


}
