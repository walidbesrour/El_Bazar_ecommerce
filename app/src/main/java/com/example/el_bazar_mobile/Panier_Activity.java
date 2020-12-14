package com.example.el_bazar_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.el_bazar_mobile.adapter.Adapter_Commande_panier;
import com.example.el_bazar_mobile.databinding.ActivityPanierBinding;
import com.example.el_bazar_mobile.model.Produits;

import java.util.ArrayList;

public class Panier_Activity extends AppCompatActivity {

    private ActivityPanierBinding binding ;
    ArrayList<Produits> list1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_panier_);

        Adapter_Commande_panier adapter_commande_panier = new Adapter_Commande_panier(remplirList(),Panier_Activity.this);
        binding.recycleId.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        binding.recycleId.setAdapter(adapter_commande_panier);
        adapter_commande_panier.setonItemClickLister_sous(new Adapter_Commande_panier.onItemClickLister() {
            @Override
            public void ItemClick_Remove(int position) {
                list1.remove(position);
                adapter_commande_panier.notifyItemRemoved(position);
            }
        });
    }

    public ArrayList<Produits> remplirList(){

       list1 = new ArrayList <>();
        list1.add(new Produits("https://i.pinimg.com/236x/75/ab/d2/75abd28624939282a296094ff77830ae.jpg","souris gamer"
                ,"Gamer ROG" , "5000.000",10));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000",5));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000",3));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000",1));
        return list1 ;
    }

}