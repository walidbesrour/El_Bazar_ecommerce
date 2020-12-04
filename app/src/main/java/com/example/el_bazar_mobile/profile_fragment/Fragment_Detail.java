package com.example.el_bazar_mobile.profile_fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.el_bazar_mobile.databinding.FragmentDetailBinding;



public class Fragment_Detail extends Fragment {

    private FragmentDetailBinding binding ;
    public Fragment_Detail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(getLayoutInflater());








        return binding.getRoot() ;
    }
}