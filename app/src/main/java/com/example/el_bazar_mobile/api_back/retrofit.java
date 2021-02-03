package com.example.el_bazar_mobile.api_back;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
    String url = Url.MonURL() ;
        System.out.println(url);
         retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit ;

    }
}
