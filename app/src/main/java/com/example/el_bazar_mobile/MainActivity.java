package com.example.el_bazar_mobile;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.el_bazar_mobile.ui.Fragment_Home;

import com.example.el_bazar_mobile.ui.Fragment_Profile;
import com.example.el_bazar_mobile.ui.Fragment_notification;
import com.example.el_bazar_mobile.ui.Fragment_reglage;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;



    Context context ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);




       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"eeeeeeeeee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Sous_Categorie_List.class);
                startActivity(intent);
                finish();
            }
        });



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Fragment_Home()).commit();


        nav_bar();





    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true ;
    }

    public void nav_bar(){
        chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home, true);
        //   getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {

            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.home:
                        fragment = new Fragment_Home();
                        break;
                    case R.id.cart:
                        fragment = new Fragment_notification();
                        break;
                    case R.id.profile:
                       fragment = new Fragment_Profile();
                        break;
                    case R.id.reglage:
                        fragment = new Fragment_reglage();
                        break;

                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            }
        });
    }




}