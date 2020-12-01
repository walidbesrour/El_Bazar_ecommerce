package com.example.el_bazar_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.model.Nouveau_Produit;
import com.example.el_bazar_mobile.model.Produits;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    List<Produits> image ;
    Context context ;
    LayoutInflater layoutInflater ;

    public ImageAdapter(List<Produits> image, Context context) {
        this.image = image;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Produits getItem(int position) {
        return image.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



            convertView = layoutInflater.inflate(R.layout.item_produit_vente,null);
        Produits produits = getItem(position);
        String image_item = produits.getImage_produit();

        String nom_produit = produits.getNom_produit();
        String nom_marque = produits.getMarque_produit();
        String prix = produits.getPrix_produit();
        String Prix_bare = produits.getPrix_bare_produit();



        ImageView imageView = convertView.findViewById(R.id.image);
        Picasso.get()
                .load(image_item)
                .into(imageView);


        TextView title_produit = convertView.findViewById(R.id.nom_p);
        title_produit.setText(nom_produit);

        TextView title_marque = convertView.findViewById(R.id.nom_marque);
        title_marque.setText(nom_marque);

        TextView title_prix = convertView.findViewById(R.id.nom_prix1);
        title_prix.setText(prix);
        TextView title_prix_bare = convertView.findViewById(R.id.nom_prix);
        title_prix_bare.setText(Prix_bare);



        return convertView;

    }
}
