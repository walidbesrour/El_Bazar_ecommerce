package com.example.el_bazar_mobile.commande;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.Adapter_Commande_panier;
import com.example.el_bazar_mobile.adapter.Adapter_commande_facture;
import com.example.el_bazar_mobile.databinding.FragmentCommandeTowBinding;
import com.example.el_bazar_mobile.model.Produits;

import java.util.ArrayList;


public class Fragment_Commande_Tow extends Fragment {


    private FragmentCommandeTowBinding binding ;
    public Fragment_Commande_Tow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCommandeTowBinding.inflate(getLayoutInflater());

        binding.contunier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment F_Commande_three = new Fragment_Commande_Three();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container1,F_Commande_three);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        // Inflate the layout for this fragment
        Adapter_Commande_panier adapter_commande_panier = new Adapter_Commande_panier(remplirList(),getActivity());
        binding.recycleId.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        binding.recycleId.setAdapter(adapter_commande_panier);












        return binding.getRoot() ;
    }


    public ArrayList<Produits> remplirList(){

        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://i.pinimg.com/236x/75/ab/d2/75abd28624939282a296094ff77830ae.jpg","souris gamer"
                ,"Gamer ROG" , "5000.000",10));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000",5));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000",3));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000",1));
        return list1 ;
    }
}