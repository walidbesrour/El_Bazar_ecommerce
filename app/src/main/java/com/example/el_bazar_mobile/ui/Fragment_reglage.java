package com.example.el_bazar_mobile.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.FragmentReglageBinding;

public class Fragment_reglage extends Fragment {

    private FragmentReglageBinding binding ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      binding = FragmentReglageBinding.inflate(getLayoutInflater());
//        View v = inflater.inflate(R.layout.fragment_reglage, container, false);

        binding.btnAvantage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoxDialogBox3 ();
            }
        });

        binding.btnDroit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoxDialogBox();
            }
        });
        binding.btnMarche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoxDialogBox2 ();
            }
        });


        return binding.getRoot() ;
    }


    public  void ShoxDialogBox ()
    {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.droits_et_garantis);

        dialog.show();

    }
    public  void ShoxDialogBox2 ()
    {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.les_avantage);

        dialog.show();

    }
    public  void ShoxDialogBox3 ()
    {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.avantage_fidelite);

        dialog.show();

    }
}
