package com.example.el_bazar_mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.ItemProduitVenteBinding;
import com.example.el_bazar_mobile.model.Produits;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_other_products extends RecyclerView.Adapter<Adapter_other_products.List_other_products> {

    List<Produits> produits ;

    public Adapter_other_products(List<Produits> produits) {
        this.produits = produits;
    }

    @NonNull
    @Override
    public Adapter_other_products.List_other_products onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemProduitVenteBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_produit_vente,parent,false);


        return new List_other_products(binding) ;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_other_products.List_other_products holder, int position) {

        holder.binding.nomP.setText(produits.get(position).getNom_produit());
        holder.binding.nomMarque.setText(produits.get(position).getMarque_produit());
        holder.binding.nomPrix.setText(produits.get(position).getPrix_bare_produit());
        holder.binding.nomPrix1.setText(produits.get(position).getPrix_produit());


        Picasso.get()
                .load(produits.get(position).getImage_produit())
                .into(holder.binding.image);

    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class List_other_products extends RecyclerView.ViewHolder {
        private ItemProduitVenteBinding binding ;
        public List_other_products(@NonNull ItemProduitVenteBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;
        }
    }
}
