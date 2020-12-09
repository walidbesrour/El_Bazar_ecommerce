package com.example.el_bazar_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.el_bazar_mobile.adapter.Adapter_other_products;
import com.example.el_bazar_mobile.databinding.ActivityProduitBinding;
import com.example.el_bazar_mobile.model.Produits;

import java.util.ArrayList;

public class Produit_Activity extends AppCompatActivity {

    private ActivityProduitBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     binding = DataBindingUtil.setContentView(this,R.layout.activity_produit_);



        binding.ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.detailbbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(binding.detail, new AutoTransition());
                    binding.expandableView.setVisibility(View.VISIBLE);
                    binding.detailbbb.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                } else {
                    TransitionManager.beginDelayedTransition(binding.detail, new AutoTransition());
                    binding.expandableView.setVisibility(View.GONE);
                    binding.detailbbb.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                }
            }
        });




        setSupportActionBar(binding.mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"eeeeeeeeee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Produit_Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //////////// Recycle View //////////////
        Adapter_other_products adapter_other_products = new Adapter_other_products(mylist());
        binding.OtherProducts.setAdapter(adapter_other_products);
        binding.OtherProducts.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        ///////////////////////////////////
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true ;
    }

    public ArrayList<Produits> mylist(){
        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://www.artofbrilliance.co.uk/wp-content/uploads/2019/02/happy-tshirt-1.jpg","t shirt"
                ,"titou My" , "35.000","35.000"));
        list1.add(new Produits("https://ufpro.com/storage/app/media/Product%20Images/Shirts-Sweaters/Urban%20T-Shirt/Black/Urban-Tshirt-black-hero-2019-493.jpg","t shirt noir"
                ,"titou My" , "40.000","45.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/51lJrXMOmQL._AC_UX679_.jpg","shirt 12"
                ,"apple shirt" , "20.000","25.000"));
        list1.add(new Produits("https://ae01.alicdn.com/kf/HTB1RXXQSVXXXXXFaXXXq6xXFXXXO/La-conception-des-hommes-d-t-de-caf-amer-n-ont-aucune-crainte-l-ing-nieur.jpg_640x640.jpg","t shirt design"
                ,"T shirt design NY" , "590.000","600.000"));
        list1.add(new Produits("https://lartdaccoucher.com/wp-content/uploads/2018/11/F_French-navy.jpg","t shirt femme"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://cdn.monsieurtshirt.com/images/13895/product_large/t-shirt-femme-je-prefere-etre-en-retard.jpg?1547550942986","femme t shirt"
                ,"series t shirt" , "6900.000","6900.000"));
        list1.add(new Produits("https://lh3.googleusercontent.com/proxy/DgYZU2qMb50DNgCxh-Mscj3OpOgGaXOoyG-SkDua9thrKJXXq4IxvZIuXJRg93vvlDr_IXPkvnhltrIp","meuble interieur"
                ,"Cosa My" , "5000.000","4200"));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000","3500.000"));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://pic.clubic.com/v1/images/1827269/raw?fit=smartCrop&height=675&width=1200&hash=47782cb1216082049b7911ae2983237300e11dae","PS5 sony"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://www.journaldugeek.com/content/uploads/2019/12/xbox-series-x.jpg","xbox "
                ,"series x" , "6900.000","6900.000"));

        list1.add(new Produits("https://static.cnews.fr/sites/default/files/iphone_12_et_12_pro_-_les_differences_5f9aea758f9a2_0.jpg","iphone 12 pro"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000","3000"));

        return list1 ;
    }
}