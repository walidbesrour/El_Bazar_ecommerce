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
import com.example.el_bazar_mobile.commande.LoginFragment;
import com.example.el_bazar_mobile.databinding.ActivitySousCategorieListBinding;
import com.example.el_bazar_mobile.model.Categorie;
import com.example.el_bazar_mobile.sous_produit_fragment.Fragment_sous_List;
import com.example.el_bazar_mobile.sous_produit_fragment.Fragment_sous_Produit;

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




        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2,
                new Fragment_sous_List()).commit();



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




}