package com.example.el_bazar_mobile.ui;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.Adapter_Nouveau_Produit;
import com.example.el_bazar_mobile.adapter.SliderAdapterExample;
import com.example.el_bazar_mobile.model.Nouveau_Produit;
import com.example.el_bazar_mobile.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Home  extends Fragment {

    private SliderAdapterExample adapter;
    SliderView sliderView;
    List<Nouveau_Produit> models;
    Adapter_Nouveau_Produit adapter_promo;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int page = 0;
    private int delay = 3000;
    private Handler handler = new Handler();
    ViewPager viewPager ,viewPager1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = v.findViewById(R.id.imageSlider);
        viewPager = v.findViewById(R.id.viewPager);
        viewPager1 = v.findViewById(R.id.viewPager1);
        
        pub(sliderView);
        promo(viewPager);

        return v ;
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

        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("Slider Item " + i);
            switch (i){
                case 0 :
                    sliderItem.setImageUrl("https://www.usinenouvelle.com/mediatheque/4/4/2/000843244_image_896x598/samsung-galaxy-s20.jpg");
                    break;
                case 1 :
                    sliderItem.setImageUrl("https://i1.wp.com/www.leconomistemaghrebin.com/wp-content/uploads/2019/03/image_news_get.jpg?fit=1200%2C444&ssl=1");
                    break;
                case 2 :
                    sliderItem.setImageUrl("https://i2.wp.com/tunivisions.net/wp-content/uploads/2019/08/Fruits-Rouges.jpg?resize=767%2C1024&ssl=1");
                    break;
                case 3 :
                    sliderItem.setImageUrl("https://thd.tn/wp-content/uploads/2020/03/image001.jpg");
                    break;
                case 4 :
                    sliderItem.setImageUrl("https://www.coca-cola-france.fr/content/dam/one/fr/fr/lead/le-logo-coca-cola-huit-lettres-un-trait-dunion.jpg");
                    break;

            }
            /*if (i % 2 == 0) {
                sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            } else {
                sliderItem.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }*/
            sliderItemList.add(sliderItem);
        }
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
        models.add(new Nouveau_Produit( "https://www.blanlys.ma/372-large_default/nettoyant-sol-kalyon-golden-rose-15l.jpg","Nettoyant Sol Kalyon Golden Rose 1,5L", "ROSA","100.000"));
        models.add(new Nouveau_Produit("https://lh3.googleusercontent.com/proxy/FfCmOuhHdKjIPu4EYLVdJeSc0DGp3fQKo5eboLTblsgfifZKhSdeLX2lYGxPSZwrCoiI_fKkfUmvcG9PRkpuLchGb7FhmpkoI6Y","Essuie tout Lilas ", "LILAS", "50.000"));
        models.add(new Nouveau_Produit("https://www.mega.tn/assets/uploads/img/pr_televiseurs/1021_1.jpg","samsung 43 pouce", "SAMSUNG", "300.000"));
        models.add(new Nouveau_Produit( "https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg","Lampe à poser Blanc", "titou","50.000"));
        models.add(new Nouveau_Produit( "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/social/macos-mojave-bootcamp-social-card.jpg","mac ios","pc Appel", "6000.000"));
        models.add(new Nouveau_Produit("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg","tv UHD samsung", "molotove","3100.000" ));


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
    private void promo2(ViewPager viewPager){

        models = new ArrayList<>();
        models.add(new Nouveau_Produit( "https://www.blanlys.ma/372-large_default/nettoyant-sol-kalyon-golden-rose-15l.jpg","Nettoyant Sol Kalyon Golden Rose 1,5L", "ROSA","100.000"));
        models.add(new Nouveau_Produit("https://lh3.googleusercontent.com/proxy/FfCmOuhHdKjIPu4EYLVdJeSc0DGp3fQKo5eboLTblsgfifZKhSdeLX2lYGxPSZwrCoiI_fKkfUmvcG9PRkpuLchGb7FhmpkoI6Y","Essuie tout Lilas ", "LILAS", "50.000"));
        models.add(new Nouveau_Produit("https://www.mega.tn/assets/uploads/img/pr_televiseurs/1021_1.jpg","samsung 43 pouce", "SAMSUNG", "300.000"));
        models.add(new Nouveau_Produit( "https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg","Lampe à poser Blanc", "titou","50.000"));
        models.add(new Nouveau_Produit( "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/social/macos-mojave-bootcamp-social-card.jpg","mac ios","pc Appel", "6000.000"));
        models.add(new Nouveau_Produit("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg","tv UHD samsung", "molotove","3100.000" ));


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
    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(slideRunnable_promo, delay);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(slideRunnable_promo);
    }
}
