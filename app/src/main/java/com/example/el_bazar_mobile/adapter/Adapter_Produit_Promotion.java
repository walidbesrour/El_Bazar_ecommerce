package com.example.el_bazar_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.model.Nouveau_Produit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Produit_Promotion extends PagerAdapter {

    private List<Nouveau_Produit> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter_Produit_Promotion(List<Nouveau_Produit> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);



        ImageView imageView;
        TextView marque, produit, prix;


        imageView = view.findViewById(R.id.image);
        produit = view.findViewById(R.id.nom_marque);
        marque = view.findViewById(R.id.nom_p);
        prix = view.findViewById(R.id.nom_prix);



        produit.setText(models.get(position).getProduit());
        marque.setText(models.get(position).getMarque());
        prix.setText(models.get(position).getPrix());
        Picasso.get()
                .load(models.get(position).getImage())
                .into(imageView);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


}
