package com.example.el_bazar_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.ItemPannierBinding;
import com.example.el_bazar_mobile.model.Produits;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Adapter_Commande_panier extends RecyclerView.Adapter<Adapter_Commande_panier.Commande_panier> {

    ArrayList<Produits> produits;
    Context context ;

    public Adapter_Commande_panier(ArrayList<Produits> produits, Context context) {
        this.produits = produits;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_Commande_panier.Commande_panier onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPannierBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_pannier,parent,false);
        return new Commande_panier(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Commande_panier.Commande_panier holder, int position) {


        holder.binding.nomP.setText(produits.get(position).getNom_produit());
        holder.binding.nomMarque.setText(produits.get(position).getMarque_produit());
        Picasso.get()
                .load(produits.get(position).getImage_produit())
                .into(holder.binding.imageProduit);
        holder.binding.Total1.setText(produits.get(position).getPrix_produit());
        holder.binding.numberPickerCustom.setValue(produits.get(position).getQuantité());

    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class Commande_panier extends RecyclerView.ViewHolder {
        private ItemPannierBinding binding ;
        public Commande_panier(@NonNull ItemPannierBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;
        }
    }
}
