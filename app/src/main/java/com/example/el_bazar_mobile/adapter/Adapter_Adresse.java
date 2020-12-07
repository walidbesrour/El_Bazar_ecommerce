package com.example.el_bazar_mobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.ItemAdresseBinding;
import com.example.el_bazar_mobile.model.Adresse;
import com.example.el_bazar_mobile.model.Categorie;

import java.util.ArrayList;

public class Adapter_Adresse extends RecyclerView.Adapter<Adapter_Adresse.List_Categorie> {

    private ArrayList<Adresse> adresses = new ArrayList<>();

    public Adapter_Adresse(ArrayList<Adresse> adresses) {
        this.adresses = adresses;
    }

    @NonNull
    @Override
    public Adapter_Adresse.List_Categorie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemAdresseBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_adresse,parent,false);
        return new List_Categorie(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Adresse.List_Categorie holder, int position) {
            //   holder.binding.textCategorie.setText(categories.get(position).getCategorie_principale());
        holder.binding.nomMarque1.setText(adresses.get(position).getGouvernorat_user());
        holder.binding.nomMarque2.setText(adresses.get(position).getVille_user());
        holder.binding.nomMarque3.setText(adresses.get(position).getLocalite_user());
    }

    @Override
    public int getItemCount() {
        return adresses.size();
    }

    public class List_Categorie extends RecyclerView.ViewHolder {
        ItemAdresseBinding binding ;
        public List_Categorie(@NonNull ItemAdresseBinding binding) {
            super(binding.getRoot());
            this.binding = binding ;
        }
    }
}
