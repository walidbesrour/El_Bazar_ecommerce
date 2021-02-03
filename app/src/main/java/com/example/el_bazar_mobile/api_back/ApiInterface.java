package com.example.el_bazar_mobile.api_back;

import com.example.el_bazar_mobile.model.ProduitDTO;
import com.example.el_bazar_mobile.model.SlidesDTO;


import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {

//    long imageUrl_DTO = new Date().getTime();
    @GET("/api/slides/carousel")
     Call<List<SlidesDTO>> GetSlide ();

    @GET("/api/produits/promo")
    Call<List<ProduitDTO>> GetPromo ();

    @POST("/api/authenticate")
    Call<List<ProduitDTO>> authenticate (@Body HashMap<Object, Object> map);

    /*
     @POST("contacts")
    public  Call<user> SetUser(@Body HashMap<Object, Object> map);

        public void SetRetrofit (String A ,String B ,String C)
    {
        Retrofit retrofi = retrofit.getInstance();


        ApiInterface apiInterface = retrofi.create(ApiInterface.class);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("username", A);
        map.put("email", B);
        map.put("password",C);

        Call<user> call = apiInterface.SetUser(map);

        call.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {

            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {

            }
        });


    }
     */
}

