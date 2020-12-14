package com.example.el_bazar_mobile.sous_produit_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.el_bazar_mobile.CommandeActivity;
import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.ImageAdapter;
import com.example.el_bazar_mobile.databinding.FragmentSousProduitBinding;
import com.example.el_bazar_mobile.model.Produits;

import java.util.ArrayList;


public class Fragment_sous_Produit extends Fragment {


    public Fragment_sous_Produit() {
        // Required empty public constructor
    }

    private FragmentSousProduitBinding binding ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSousProduitBinding.inflate(getLayoutInflater());
        //return inflater.inflate(R.layout.fragment_sous__produit, container, false);
        met_gridView(binding.myGridProduit);


        return binding.getRoot();
    }

    private void met_gridView(RecyclerView gridView11 ){
        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://pic.clubic.com/v1/images/1827269/raw?fit=smartCrop&height=675&width=1200&hash=47782cb1216082049b7911ae2983237300e11dae","PS5 sony"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://www.journaldugeek.com/content/uploads/2019/12/xbox-series-x.jpg","xbox "
                ,"series x" , "6900.000","6900.000"));
        list1.add(new Produits("https://cdn.pocket-lint.com/r/s/1200x/assets/images/140007-games-review-nintendo-switch-review-image1-lp6zy9awm0.jpg","meuble interieur"
                ,"Cosa My" , "5000.000","4200"));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000","3500.000"));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://pic.clubic.com/v1/images/1827269/raw?fit=smartCrop&height=675&width=1200&hash=47782cb1216082049b7911ae2983237300e11dae","PS5 sony"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://www.journaldugeek.com/content/uploads/2019/12/xbox-series-x.jpg","xbox "
                ,"series x" , "6900.000","6900.000"));

        list1.add(new Produits("https://static.cnews.fr/sites/default/files/iphone_12_et_12_pro_-_les_differences_5f9aea758f9a2_0.jpg","iphone 12 pro"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000","3000"));
        ImageAdapter imageAdapter = new ImageAdapter(list1);
        gridView11.setAdapter(imageAdapter);
        gridView11.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        imageAdapter.setonItemClickLister_sous(new ImageAdapter.onItemClickLister() {
            @Override
            public void ItemClick_produit(int position) {
                Intent intent = new Intent(getActivity(), CommandeActivity.class);
                startActivity(intent);

            }
        });





    }
}