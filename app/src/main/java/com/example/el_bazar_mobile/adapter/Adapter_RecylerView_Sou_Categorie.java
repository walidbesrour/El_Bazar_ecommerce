package com.example.el_bazar_mobile.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.ItemSousCategorieBinding;
import com.example.el_bazar_mobile.model.Categorie;

import java.util.ArrayList;

public class Adapter_RecylerView_Sou_Categorie extends RecyclerView.Adapter<Adapter_RecylerView_Sou_Categorie.List_Categorie> {


    private ArrayList<Categorie> categories = new ArrayList<>();


    public  onItemClickLister mlistener ;
    // interface to click
    public interface onItemClickLister{ void ItemClick_sous(int position) ; }

    public void setonItemClickLister_sous( onItemClickLister lister){
        mlistener = lister;
    }

    public Adapter_RecylerView_Sou_Categorie(ArrayList<Categorie> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public Adapter_RecylerView_Sou_Categorie.List_Categorie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSousCategorieBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_sous_categorie,parent,false);
        return  new List_Categorie(binding, mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_RecylerView_Sou_Categorie.List_Categorie holder, int position) {
        holder.binding.textCategorie.setText(categories.get(position).getCategorie_principale());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class List_Categorie extends RecyclerView.ViewHolder {
        private ItemSousCategorieBinding binding ;
        public List_Categorie(@NonNull ItemSousCategorieBinding binding , onItemClickLister listener) {
            super(binding.getRoot());
            this.binding = binding ;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.ItemClick_sous(position);
                        }

                    }
                }
            });
        }
    }
}
