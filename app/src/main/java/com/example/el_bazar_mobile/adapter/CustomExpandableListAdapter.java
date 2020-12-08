package com.example.el_bazar_mobile.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.model.Commande;
import com.example.el_bazar_mobile.model.Produits;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Commande> listTitulo;
    private HashMap<Commande, List<Produits> > expandableListDetalles;

    public CustomExpandableListAdapter(Context context, List<Commande> listTitulo, HashMap<Commande, List<Produits>> expandableListDetalles) {
        this.context = context;
        this.listTitulo = listTitulo;
        this.expandableListDetalles = expandableListDetalles;
    }

    @Override
    public int getGroupCount() {
        return expandableListDetalles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return expandableListDetalles.get(listTitulo.get(i)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listTitulo.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return expandableListDetalles.get(listTitulo.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        Commande Facture = (Commande) getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list_group,null);

        }
        TextView item1 = view.findViewById(R.id.nom_marque1);
        item1.setText(Facture.getNum_Commande());
        TextView item2 = view.findViewById(R.id.nom_marque2);
        item2.setText( String.valueOf( Facture.getTotal()));
        TextView item3 = view.findViewById(R.id.nom_marque3);
        item3.setText(Facture.getStatus());


        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {

        final Produits produits = (Produits) getChild(groupPosition, childPosition);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_produit_commande,null);
        }

        ImageView imageView = view.findViewById(R.id.image_produit);
        Picasso.get()
                .load(produits.getImage_produit())
                .into(imageView);



        TextView nom_produit = view.findViewById(R.id.nom_p);
        nom_produit.setText(produits.getNom_produit());

        TextView marque = view.findViewById(R.id.nom_marque);
        marque.setText(produits.getMarque_produit());

        TextView prix = view.findViewById(R.id.q1);
        prix.setText(produits.getPrix_produit());


        TextView quantite = view.findViewById(R.id.p1);
        quantite.setText(String.valueOf(produits.getQuantité()));



        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
