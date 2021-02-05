package com.example.el_bazar_mobile.api_back;

import com.example.el_bazar_mobile.model.ProduitDTO;
import com.example.el_bazar_mobile.model.SlidesDTO;


import java.util.HashMap;
import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface ApiInterface {

//    long imageUrl_DTO = new Date().getTime();
    @GET("/api/slides/carousel")
     Call<List<SlidesDTO>> GetSlide ();

    @GET("/api/produits/promo")
    Call<List<ProduitDTO>> GetPromo ();

    @POST("/api/authenticate")
    Call<ProduitDTO> authenticate (@Body ProduitDTO produitDTO);

    @GET("/api/account")
    Call<ProduitDTO> Getaccount (@Header("Authorization") String autoToken);


}

