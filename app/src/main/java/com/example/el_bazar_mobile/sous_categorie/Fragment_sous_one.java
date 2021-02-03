package com.example.el_bazar_mobile.sous_categorie;

import android.animation.ArgbEvaluator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import com.example.el_bazar_mobile.CommandeActivity;
import com.example.el_bazar_mobile.Produit_Activity;
import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.Adapter_Nouveau_Produit;
import com.example.el_bazar_mobile.adapter.Adapter_Produit_Promotion;
import com.example.el_bazar_mobile.adapter.ImageAdapter;
import com.example.el_bazar_mobile.adapter.SliderAdapterExample;
import com.example.el_bazar_mobile.adapter.Slider_Adapter_Promo;
import com.example.el_bazar_mobile.api_back.ApiInterface;
import com.example.el_bazar_mobile.api_back.Url;
import com.example.el_bazar_mobile.api_back.retrofit;
import com.example.el_bazar_mobile.model.Nouveau_Produit;
import com.example.el_bazar_mobile.model.Produits;
import com.example.el_bazar_mobile.model.SliderItem;
import com.example.el_bazar_mobile.model.SlidesDTO;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.util.Log.d;

public class Fragment_sous_one extends Fragment {

    private SliderAdapterExample adapter;
    SliderView sliderView;
    List<Nouveau_Produit> models;
    Adapter_Nouveau_Produit adapter_promo;
    Adapter_Produit_Promotion adapter_produit_promotion ;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int page = 0 , page2 = 0;
    private int delay = 3000;
    private int delay2 = 3000;
    private Handler handler = new Handler();
    ViewPager viewPager ,viewPager1;
    RecyclerView gridView  ;
    ViewPager2 viewPager2 ;
    private Handler sliderHandler = new Handler();
    String url = Url.MonURL() ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sous_one, container, false);

        sliderView = v.findViewById(R.id.imageSlider);
        viewPager = v.findViewById(R.id.viewPager);
        viewPager1 = v.findViewById(R.id.viewPager1);
        gridView = v.findViewById(R.id.myGrid);
        viewPager2 = v.findViewById(R.id.ViewPageImage);


        pub(sliderView);
        promo(viewPager);
        promo1(viewPager1);
        met_gridView(gridView);
        pub2(viewPager2);

        return v ;
    }


    private void met_gridView(RecyclerView gridView11 ){
        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://cdn.pocket-lint.com/r/s/1200x/assets/images/140007-games-review-nintendo-switch-review-image1-lp6zy9awm0.jpg","meuble interieur"
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
            ImageAdapter imageAdapter = new ImageAdapter(list1);
        gridView11.setAdapter(imageAdapter);
        gridView11.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        imageAdapter.setonItemClickLister_sous(new ImageAdapter.onItemClickLister() {
            @Override
            public void ItemClick_produit(int position) {
                Intent intent = new Intent(getActivity(), CommandeActivity.class);
                startActivity(intent);
            }
        });





    }

    private void pub(SliderView sliderView){

        adapter = new SliderAdapterExample(getContext());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);



        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });


        Retrofit retrofid = retrofit.getInstance();
        ApiInterface apiInterface = retrofid.create(ApiInterface.class);
        Call<List<SlidesDTO>> call = apiInterface.GetSlide();
        call.enqueue(new Callback<List<SlidesDTO>>() {
            @Override
            public void onResponse(Call<List<SlidesDTO>> call, Response<List<SlidesDTO>> response) {

                System.out.println("///////////////////////////////////////////");

                System.out.println(response.body().get(0).getImageUrl_DTO());
                System.out.println(response.body().get(1).getImageUrl_DTO());
                System.out.println(response.body().get(2).getImageUrl_DTO());
                System.out.println(response.body().get(3).getImageUrl_DTO());
                System.out.println(response.body().get(4).getImageUrl_DTO());



                List<SliderItem> sliderItemList = new ArrayList<>();
                //dummy data
                for (int i = 0; i < 5; i++) {
                    SliderItem sliderItem = new SliderItem();
                    sliderItem.setDescription("Slider Item " + i);
                    switch (i){
                        case 0 :
                            sliderItem.setImageUrl(url+"/image/"+response.body().get(0).getImageUrl_DTO());
                            break;
                        case 1 :
                            sliderItem.setImageUrl(url+"/image/"+response.body().get(1).getImageUrl_DTO());
                            break;
                        case 2 :
                            sliderItem.setImageUrl(url+"/image/"+response.body().get(2).getImageUrl_DTO());
                            break;
                        case 3 :
                            sliderItem.setImageUrl(url+"/image/"+response.body().get(3).getImageUrl_DTO());
                            break;
                        case 4 :
                            sliderItem.setImageUrl(url+"/image/"+response.body().get(4).getImageUrl_DTO());
                            break;

                    }
            /*
            if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            */
                    sliderItemList.add(sliderItem);
                }


                adapter.renewItems(sliderItemList);

            }

            @Override
            public void onFailure(Call<List<SlidesDTO>> call, Throwable t) {
                d("***", "*********MyFriendVM***************" +call.toString());
                d("***", "*********MyFriendVM***************" +t.toString());

            }
        });


        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
//        for (int i = 0; i < 5; i++) {
//            SliderItem sliderItem = new SliderItem();
//            sliderItem.setDescription("Slider Item " + i);
//            switch (i){
//                case 0 :
//                    sliderItem.setImageUrl("https://www.usinenouvelle.com/mediatheque/4/4/2/000843244_image_896x598/samsung-galaxy-s20.jpg");
//                    break;
//                case 1 :
//                    sliderItem.setImageUrl("https://i1.wp.com/www.leconomistemaghrebin.com/wp-content/uploads/2019/03/image_news_get.jpg?fit=1200%2C444&ssl=1");
//                    break;
//                case 2 :
//                    sliderItem.setImageUrl("https://i2.wp.com/tunivisions.net/wp-content/uploads/2019/08/Fruits-Rouges.jpg?resize=767%2C1024&ssl=1");
//                    break;
//                case 3 :
//                    sliderItem.setImageUrl("https://thd.tn/wp-content/uploads/2020/03/image001.jpg");
//                    break;
//                case 4 :
//                    sliderItem.setImageUrl("https://www.coca-cola-france.fr/content/dam/one/fr/fr/lead/le-logo-coca-cola-huit-lettres-un-trait-dunion.jpg");
//                    break;
//
//            }
//            /*if (i % 2 == 0) {
//                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
//            } else {
//                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
//            }*/
//            sliderItemList.add(sliderItem);
//        }
        adapter.renewItems(sliderItemList);
    }

    private Runnable slideRunnable_promo = new Runnable() {
        @Override
        public void run() {
            if (adapter_promo.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }

    };
    private void promo(ViewPager viewPager){

        models = new ArrayList<>();
        models.add(new Nouveau_Produit("https://static.cnews.fr/sites/default/files/iphone_12_et_12_pro_-_les_differences_5f9aea758f9a2_0.jpg","iphone 12 pro","apple" ,
                "2900.000"));
        models.add(new Nouveau_Produit("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000"));
        models.add(new Nouveau_Produit("https://i.vimeocdn.com/video/667401754_1280.jpg"
                ,"danao ","delice" , "690.000"));
        models.add(new Nouveau_Produit( "https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg","Lampe à poser Blanc", "titou","50.000"));
        models.add(new Nouveau_Produit( "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/social/macos-mojave-bootcamp-social-card.jpg","mac ios","pc Appel", "6000.000"));
        models.add(new Nouveau_Produit("https://www.journaldugeek.com/content/uploads/2019/12/xbox-series-x.jpg","xbox "
                ,"series x" , "6900.000" ));


        adapter_promo = new Adapter_Nouveau_Produit(models, getContext());


        viewPager.setAdapter(adapter_promo);
        viewPager.setPadding(120, 0, 120, 0);


        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter_promo.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private Runnable slideRunnable_promo2 = new Runnable() {
        @Override
        public void run() {
            if (adapter_produit_promotion.getCount() == page2) {
                page2 = 0;
            } else {
                page2++;
            }
            viewPager1.setCurrentItem(page2, true);
            handler.postDelayed(this, delay);
        }

    };
    private void promo1(ViewPager viewPager){

        models = new ArrayList<>();
        models.add(new Nouveau_Produit("https://www.mega.tn/assets/uploads/img/pr_televiseurs/1021_1.jpg","samsung 43 pouce", "SAMSUNG", "300.000"));
        models.add(new Nouveau_Produit("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg","tv UHD samsung", "molotove","3100.000" ));
        models.add(new Nouveau_Produit( "https://www.blanlys.ma/372-large_default/nettoyant-sol-kalyon-golden-rose-15l.jpg","Nettoyant Sol Kalyon Golden Rose 1,5L", "ROSA","100.000"));
        models.add(new Nouveau_Produit("https://tn.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/71/9742/1.jpg?7306","Essuie tout Lilas ", "LILAS", "50.000"));
        models.add(new Nouveau_Produit( "https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg","Lampe à poser Blanc", "titou","50.000"));
        models.add(new Nouveau_Produit( "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/social/macos-mojave-bootcamp-social-card.jpg","mac ios","pc Appel", "6000.000"));



        adapter_produit_promotion = new Adapter_Produit_Promotion(models, getContext());


        viewPager.setAdapter(adapter_produit_promotion);
        viewPager.setPadding(10, 0, 10, 0);


        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter_produit_promotion.getCount() -1) && position < (colors.length - 1)) {
                    viewPager1.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager1.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                page2 = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(slideRunnable_promo, delay);
        handler.postDelayed(slideRunnable_promo2, delay);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(slideRunnable_promo);
        handler.removeCallbacks(slideRunnable_promo2);
    }

    private void pub2(ViewPager2 viewPager2){
        List<SliderItem> slider = new ArrayList<>();

        //dummy data
        slider.add(new SliderItem("https://www.marketing-etudiant.fr/wp-content/uploads/2016/01/taste-the-feeling.jpg"));
        slider.add(new SliderItem("https://i.pinimg.com/originals/4d/68/bd/4d68bd92f0293d1e5b48a09e8bc0efea.jpg"));
        slider.add(new SliderItem("https://www.journaldugeek.com/content/uploads/2016/03/Screenshot-40.png"));
        slider.add(new SliderItem("https://mediacomeulalie.weebly.com/uploads/3/8/8/4/38842785/2885011_orig.jpg"));
        slider.add(new SliderItem("https://www.sportbuzzbusiness.fr/wp-content/uploads/2016/05/pub-Volvo-Zlatan-Ibrahimovic-euro-2016-V90.jpg"));
        viewPager2.setAdapter(new Slider_Adapter_Promo(slider,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r =1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(slideRunnable);
                sliderHandler.postDelayed(slideRunnable,3000);
            }
        });

    }
    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+ 1);
        }
    };
}

