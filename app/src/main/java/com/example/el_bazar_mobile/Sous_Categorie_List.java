package com.example.el_bazar_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.el_bazar_mobile.adapter.Adapter_RecylerView_Categorie;
import com.example.el_bazar_mobile.adapter.Adapter_RecylerView_Sou_Categorie;
import com.example.el_bazar_mobile.databinding.ActivitySousCategorieListBinding;
import com.example.el_bazar_mobile.model.Categorie;

import java.util.ArrayList;
import java.util.List;

public class Sous_Categorie_List extends AppCompatActivity {
    Context context ;

    private ActivitySousCategorieListBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sous__categorie__list);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sous__categorie__list);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        context = Sous_Categorie_List.this;
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Electronique"));
        categories.add(new Categorie("Meuble"));
        categories.add(new Categorie("nouriture"));
        categories.add(new Categorie("Smartphone"));
        categories.add(new Categorie("voiture"));
        categories.add(new Categorie("Moto"));
        categories.add(new Categorie("nouriture"));
        categories.add(new Categorie("Smartphone"));

        Adapter_RecylerView_Categorie adapter_recylerView_categorie = new Adapter_RecylerView_Categorie(categories);
        binding.list1.setLayoutManager(new GridLayoutManager(this,1));
        binding.list1.setAdapter(adapter_recylerView_categorie);



        adapter_recylerView_categorie.setonItemClickLister(new Adapter_RecylerView_Categorie.onItemClickLister() {
            @Override
            public void ItemClick(int position) {
               // String post = categories.get(position).getCategorie_principale() ;
                String aa = String.valueOf(position);
                Log.d("zzzzzzzz","   "+ position);


                 if(position == 0){

                     remplir_list(list_remplir0());
                }else if (position == 1){
                     remplir_list(list_remplir1());
                }
                else if (position == 2){
                     remplir_list(list_remplir2());
                }
                else if (position == 3){
                     remplir_list(list_remplir3());
                }
                else if (position == 4){
                     remplir_list(list_remplir4());
                }
                else if (position == 5){
                     remplir_list(list_remplir5());
                }
                else if (position == 6){
                     remplir_list(list_remplir6());
                }
                else if (position == 7){
              ;
                     remplir_list(list_remplir7());
                }else{
                     remplir_list(list_remplir0());
                }



            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"eeeeeeeeee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true ;
    }


    public ArrayList<Categorie> list_remplir(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Electronique"));
        categories.add(new Categorie("Meuble"));
        categories.add(new Categorie("nouriture"));
        categories.add(new Categorie("Smartphone"));
        categories.add(new Categorie("voiture"));
        categories.add(new Categorie("Moto"));
        categories.add(new Categorie("TV"));
        categories.add(new Categorie("cosmétiques"));

        return categories ;
    }
    public ArrayList<Categorie> list_remplir0(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Pc"));
        categories.add(new Categorie("Machine a laver"));
        categories.add(new Categorie("robot maison"));
        categories.add(new Categorie("frigidaire"));
        categories.add(new Categorie("aspirateur"));
        categories.add(new Categorie("lave vaiselle"));
        categories.add(new Categorie("robot cuisin"));
        categories.add(new Categorie("Smartphone"));

        return categories ;
    }
    public ArrayList<Categorie> list_remplir1(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("table"));
        categories.add(new Categorie("chaise"));
        categories.add(new Categorie("table + 4 chaise"));
        categories.add(new Categorie("meuble chambre à coucher"));
        categories.add(new Categorie("meuble cuisine"));
        categories.add(new Categorie("meuble d'entrée"));
        categories.add(new Categorie("armoir"));
        categories.add(new Categorie("armoir de maison"));

        return categories ;
    }
    public ArrayList<Categorie> list_remplir2(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("patte"));
        categories.add(new Categorie("couscous"));
        categories.add(new Categorie("delice"));
        categories.add(new Categorie("tomate"));
        categories.add(new Categorie("hrisa"));
        categories.add(new Categorie("pomme de tair"));
        categories.add(new Categorie("ships"));
        categories.add(new Categorie("couca"));

        return categories ;
    }
    public ArrayList<Categorie> list_remplir3(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Apple"));
        categories.add(new Categorie("Huawei"));
        categories.add(new Categorie("Oppo"));
        categories.add(new Categorie("Samsung"));
        categories.add(new Categorie("Tecno"));
        categories.add(new Categorie("XIAOMI"));
        categories.add(new Categorie("ipro"));
        categories.add(new Categorie("Xpansia"));

        return categories ;
    }    public ArrayList<Categorie> list_remplir4(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Citroën"));
        categories.add(new Categorie("Opel"));
        categories.add(new Categorie("Renault"));
        categories.add(new Categorie("Peugeo"));
        categories.add(new Categorie("Volkswagen"));
        categories.add(new Categorie("Mercedes"));
        categories.add(new Categorie("Fiat"));
        categories.add(new Categorie("Nissan"));

        return categories ;
    }    public ArrayList<Categorie> list_remplir5(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Yamaha"));
        categories.add(new Categorie("Honda"));
        categories.add(new Categorie("Kawasaki"));
        categories.add(new Categorie("Suzuki"));
        categories.add(new Categorie("BMW"));
        categories.add(new Categorie("Triumph"));
        categories.add(new Categorie("Piaggio"));
        categories.add(new Categorie("KTM"));

        return categories ;
    }
    public ArrayList<Categorie> list_remplir6(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Electronique"));
        categories.add(new Categorie("Meuble"));
        categories.add(new Categorie("nouriture"));
        categories.add(new Categorie("Smartphone"));
        categories.add(new Categorie("voiture"));
        categories.add(new Categorie("Moto"));
        categories.add(new Categorie("nouriture"));
        categories.add(new Categorie("Grundig"));

        return categories ;
    }
    public ArrayList<Categorie> list_remplir7(){
        ArrayList<Categorie> categories = new ArrayList<>();
        categories.add(new Categorie("Nars"));
        categories.add(new Categorie("Lancôme "));
        categories.add(new Categorie("Dior beauty"));
        categories.add(new Categorie("Laura Mercier"));
        categories.add(new Categorie("Charlotte Tilbury"));
        categories.add(new Categorie("Estée Lauder"));
        categories.add(new Categorie("Chanel Beauty"));
        categories.add(new Categorie("Tatcha "));

        return categories ;
    }


    public void remplir_list( ArrayList<Categorie> list ){
        Adapter_RecylerView_Sou_Categorie adapter_recylerView_categorie = new Adapter_RecylerView_Sou_Categorie(list);
        binding.list2.setLayoutManager(new GridLayoutManager(context,1));
        binding.list2.setAdapter(adapter_recylerView_categorie);
        adapter_recylerView_categorie.setonItemClickLister_sous(new Adapter_RecylerView_Sou_Categorie.onItemClickLister() {
            @Override
            public void ItemClick_sous(int position) {
                Intent intent = new Intent(context, Produit_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}