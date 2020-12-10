package com.example.el_bazar_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.el_bazar_mobile.commande.LoginFragment;
import com.example.el_bazar_mobile.databinding.ActivityCommandeBinding;


public class CommandeActivity extends AppCompatActivity {


    private ActivityCommandeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_commande);
        setSupportActionBar(binding.mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"eeeeeeeeee",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CommandeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,
                new LoginFragment()).commit();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true ;
    }
}