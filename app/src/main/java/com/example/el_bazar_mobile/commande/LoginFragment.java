package com.example.el_bazar_mobile.commande;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding ;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());

        binding.walid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment F_Commande_One = new Fragment_Commande_One();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container1,F_Commande_One);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        return binding.getRoot();

    }
}