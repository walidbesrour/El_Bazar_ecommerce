package com.example.el_bazar_mobile.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.SliderAdapterExample;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = v.findViewById(R.id.imageSlider);
        pub(sliderView);


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
}
