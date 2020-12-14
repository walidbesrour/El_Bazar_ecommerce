package com.example.el_bazar_mobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.el_bazar_mobile.Produit_Activity;
import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.ItemProduitVente0Binding;
import com.example.el_bazar_mobile.model.Nouveau_Produit;
import com.example.el_bazar_mobile.model.Produits;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.PropertyPermission;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.products_promotion> {
    List<Produits> image;
    Context context;
    LayoutInflater layoutInflater;

    public  onItemClickLister mlistener ;
    public interface onItemClickLister{ void ItemClick_produit(int position) ; }

    public void setonItemClickLister_sous( onItemClickLister lister){
        mlistener = lister;
    }


    public ImageAdapter(List<Produits> image) {
        this.image = image;
    }

    @NonNull
    @Override
    public ImageAdapter.products_promotion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemProduitVente0Binding binding = DataBindingUtil.inflate(inflater,R.layout.item_produit_vente0,parent,false);
        return new products_promotion(binding , mlistener);
        /*
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemProduitVenteBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_produit_vente,parent,false);
         */
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.products_promotion holder, int position) {


        holder.binding.nomP.setText(image.get(position).getNom_produit());
        holder.binding.nomMarque.setText(image.get(position).getMarque_produit());
        holder.binding.nomPrix1.setText(image.get(position).getPrix_produit());
        holder.binding.nomPrix.setText(image.get(position).getPrix_bare_produit());
        Picasso.get()
                .load(image.get(position).getImage_produit())
                .into(holder.binding.image);



    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class products_promotion extends RecyclerView.ViewHolder {
        ItemProduitVente0Binding binding ;
        public products_promotion(@NonNull  ItemProduitVente0Binding binding , onItemClickLister listener) {
            super(binding.getRoot());
            this.binding = binding ;
            binding.btnAchat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.ItemClick_produit(position);
                        }

                    }
                }
            });
        }
    }
}


