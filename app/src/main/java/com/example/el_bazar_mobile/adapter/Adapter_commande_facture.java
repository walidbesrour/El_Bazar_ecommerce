package com.example.el_bazar_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.ItemPannierFinalBinding;
import com.example.el_bazar_mobile.model.Produits;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_commande_facture extends RecyclerView.Adapter<Adapter_commande_facture.Commande_facture> {

    ArrayList<Produits> produits;
    Context context ;

    public Adapter_commande_facture(ArrayList<Produits> produits, Context context) {
        this.produits = produits;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_commande_facture.Commande_facture onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPannierFinalBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_pannier_final,parent,false);
        return new Commande_facture(binding) ;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_commande_facture.Commande_facture holder, int position) {

        holder.binding.nomP.setText(produits.get(position).getNom_produit());
        holder.binding.nomMarque.setText(produits.get(position).getMarque_produit());
        Picasso.get()
                .load(produits.get(position).getImage_produit())
                .into(holder.binding.imageProduit);
        holder.binding.Total1.setText(produits.get(position).getPrix_produit());
        holder.binding.numberPickerCustom.setText(String.valueOf(produits.get(position).getQuantité()));

    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class Commande_facture extends RecyclerView.ViewHolder {
        private ItemPannierFinalBinding binding ;
        public Commande_facture(@NonNull ItemPannierFinalBinding binding ) {
            super(binding.getRoot());
            this.binding = binding ;
        }
    }
}
