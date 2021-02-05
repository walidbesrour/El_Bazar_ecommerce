package com.example.el_bazar_mobile;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.el_bazar_mobile.api_back.ApiInterface;
import com.example.el_bazar_mobile.api_back.retrofit;
import com.example.el_bazar_mobile.model.ProduitDTO;
import com.example.el_bazar_mobile.ui.Fragment_Home;

import com.example.el_bazar_mobile.ui.Fragment_Profile;
import com.example.el_bazar_mobile.ui.Fragment_notification;
import com.example.el_bazar_mobile.ui.Fragment_reglage;
import com.google.android.material.textfield.TextInputEditText;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;

    MenuItem menuItem;
        int x = 0 , y =0 ;

       String auto_tocken ;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.shop) {
            Intent intent_panier = new Intent(this , Panier_Activity.class);
            startActivity(intent_panier);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);


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
                        if(x != 0 )
                        {
                        System.out.println("test");
                        fragment = new Fragment_Profile();
                    }
                        else
                        {
                            System.out.println("nnnnn");
                            Dialog dialog = new Dialog(context);
                            dialog.setContentView(R.layout.identification);
                            dialog.show();


                            Button login2 = dialog.findViewById(R.id.walid);
                            TextInputEditText name = dialog.findViewById(R.id.name_profile1);
                            TextInputEditText password = dialog.findViewById(R.id.email_profile1);

                            login2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String A = name.getText().toString() ;
                                    String B = password.getText().toString() ;

                                    Retrofit retrofi = retrofit.getInstance();


                                    ApiInterface apiInterface = retrofi.create(ApiInterface.class);

                                    ProduitDTO produitDTO = new ProduitDTO(A,B);

                                    Call<ProduitDTO> call = apiInterface.authenticate(produitDTO);
                                    call.enqueue(new Callback<ProduitDTO>() {
                                        @Override
                                        public void onResponse(Call<ProduitDTO> call, Response<ProduitDTO> response) {
                                            System.out.println("******************ok*****************");
                                            System.out.println(response.body().getId_token());
                                            auto_tocken = response.body().getId_token() ;


                                            Retrofit retrofi = retrofit.getInstance();

                                            ApiInterface apiInterface = retrofi.create(ApiInterface.class);


                                            Call<ProduitDTO> call1 = apiInterface.Getaccount(auto_tocken);

                                            call1.enqueue(new Callback<ProduitDTO>() {
                                                @Override
                                                public void onResponse(Call<ProduitDTO> call, Response<ProduitDTO> response) {
                                                    System.out.println("************ the tocken is good ***********");
                                                    dialog.dismiss();
                                                    y = 1 ;

                                                }

                                                @Override
                                                public void onFailure(Call<ProduitDTO> call, Throwable t) {
                                                    System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnneeeeeeeeeeeeeeeeeeeee***********");
                                                }
                                            });

                                        }

                                        @Override
                                        public void onFailure(Call<ProduitDTO> call, Throwable t) {
                                            System.out.println("no my lover " );
                                            System.out.println(t);
                                            System.out.println(call);
                                        }
                                    });
                                }
                            });


            ////////////////////////////////////////////////////////////////
                            if (y == 1 ){
                                fragment = new Fragment_Profile();
                            }





                        }

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