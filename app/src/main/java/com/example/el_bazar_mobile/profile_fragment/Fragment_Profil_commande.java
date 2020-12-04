package com.example.el_bazar_mobile.profile_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.FragmentDetailBinding;
import com.example.el_bazar_mobile.databinding.FragmentProfilCommandeBinding;


public class Fragment_Profil_commande extends Fragment {

    private FragmentProfilCommandeBinding binding ;
    public Fragment_Profil_commande() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfilCommandeBinding.inflate(getLayoutInflater());









        return binding.getRoot() ;
    }
}