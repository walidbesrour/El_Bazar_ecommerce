package com.example.el_bazar_mobile;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.el_bazar_mobile.api_back.ApiInterface;
import com.example.el_bazar_mobile.api_back.retrofit;
import com.example.el_bazar_mobile.model.ProduitDTO;
import com.example.el_bazar_mobile.model.SlidesDTO;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.util.Log.d;

public class SplashScreen extends AppCompatActivity {
    private String mTextViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Retrofit retrofid = retrofit.getInstance();
        ApiInterface apiInterface = retrofid.create(ApiInterface.class);
        Call<List<ProduitDTO>> call = apiInterface.GetPromo();
        call.enqueue(new Callback<List<ProduitDTO>>() {
            @Override
            public void onResponse(Call<List<ProduitDTO>> call, Response<List<ProduitDTO>> response) {

                System.out.println("/////////////////////OK //////////////////////");
//                System.out.println(response.body());



            }

            @Override
            public void onFailure(Call<List<ProduitDTO>> call, Throwable t) {
                d("***", "*********MyFriendVM***************" +call.toString());
                d("***", "*********MyFriendVM***************" +t.toString());

            }
        });



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                Intent intent = new Intent(getApplicationContext(), CommandeActivity.class);
                startActivity(intent);
                finish();



            }
        }, 1000);


    }
}