package com.example.el_bazar_mobile.profile_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.el_bazar_mobile.R;


public class Fragment_profile_Pannier extends Fragment {

    public Fragment_profile_Pannier() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile__pannier, container, false);
    }
}