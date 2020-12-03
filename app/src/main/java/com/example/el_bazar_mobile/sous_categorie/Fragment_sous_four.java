package com.example.el_bazar_mobile.sous_categorie;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.ImageAdapter;
import com.example.el_bazar_mobile.adapter.SliderAdapterExample;
import com.example.el_bazar_mobile.model.Produits;
import com.example.el_bazar_mobile.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_sous_four extends Fragment {

    GridView gridView , gridView2 ;

    SliderView sliderView;
    private SliderAdapterExample adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sous_four, container, false);


        sliderView = v.findViewById(R.id.imageSlider);
        gridView = v.findViewById(R.id.myGrid);
        gridView2 = v.findViewById(R.id.myGrid2);



        pub(sliderView);
        met_gridView(gridView);
        met_gridView2(gridView2);
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
                    sliderItem.setImageUrl("");
                    break;
                case 1 :
                    sliderItem.setImageUrl("https://www.cdiscount.com/pdt2/1/0/3/1/700x700/meg4260568821103/rw/megaport-high-end-pc-gamer-amd-ryzen-7-1700x-8x3-8.jpg");
                    break;
                case 2 :
                    sliderItem.setImageUrl("https://images.frandroid.com/wp-content/uploads/2020/03/laptop-gamer.jpg");
                    break;
                case 3 :
                    sliderItem.setImageUrl("https://consomac.fr/images/news/annonce-macbookair-2018-header.jpg");
                    break;
                case 4 :
                    sliderItem.setImageUrl("https://images.frandroid.com/wp-content/uploads/2019/02/samsung-galaxy-s10.jpg");
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
    private void met_gridView(GridView gridView ){
        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://infomaxparis.com/3133-medium_default/pc-gamer-configuration-fixes-pc-gamer-aeroman.jpg","Robe bleu"
                ,"Cosa My" , "500.000","420.000"));
        list1.add(new Produits("https://www.tunisianet.com.tn/128358-large/pc-de-bureau-asus-rog-strix-gl12cx-i9-9e-gen-16-go.jpg","robe noir"
                ,"lo My" , "400.000","350.000"));
        list1.add(new Produits("https://www.techadvisor.fr/cmsdata/slideshow/3684835/gaming_meilleur_pc_portable_gamer_thumb800.jpg","roge fleur"
                ,"apple" , "290.000","250.000"));
        list1.add(new Produits("https://www.caroll.com/dw/image/v2/BCMJ_PRD/on/demandware.static/-/Sites-caroll-master/default/dw60c33ed1/images/RF04007U-01-robe-femme-clarisse.jpg?sw=522&sh=783&sm=fit&q=80","noir Serie"
                ,"SONY bb" , "590.000","550.000"));
        list1.add(new Produits("https://www.maison123.com/dw/image/v2/AAWW_PRD/on/demandware.static/-/Sites-UPAP-master/default/dw185e477e/652451007_x.jpg?sw=1000","jupe coute"
                ,"SON moi" , "590.000","550.000"));
        list1.add(new Produits("https://media.cyrillus.be/Pictures/cyrillus/77081/robe-longue-brodee-femme.jpg?width=542","jupe jaune "
                ,"series x" , "690.000","690.000"));





        gridView.setAdapter(new ImageAdapter(list1, getActivity()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Intent A = new Intent(getActivity(), Produit.class);
//                startActivity(A);
            }
        });
    }
    private void met_gridView2(GridView gridView ){
        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://www.artofbrilliance.co.uk/wp-content/uploads/2019/02/happy-tshirt-1.jpg","t shirt"
                ,"titou My" , "35.000","35.000"));
        list1.add(new Produits("https://ufpro.com/storage/app/media/Product%20Images/Shirts-Sweaters/Urban%20T-Shirt/Black/Urban-Tshirt-black-hero-2019-493.jpg","t shirt noir"
                ,"titou My" , "40.000","45.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/51lJrXMOmQL._AC_UX679_.jpg","shirt 12"
                ,"apple shirt" , "20.000","25.000"));
        list1.add(new Produits("https://ae01.alicdn.com/kf/HTB1RXXQSVXXXXXFaXXXq6xXFXXXO/La-conception-des-hommes-d-t-de-caf-amer-n-ont-aucune-crainte-l-ing-nieur.jpg_640x640.jpg","t shirt design"
                ,"T shirt design NY" , "590.000","600.000"));
        list1.add(new Produits("https://lartdaccoucher.com/wp-content/uploads/2018/11/F_French-navy.jpg","t shirt femme"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://cdn.monsieurtshirt.com/images/13895/product_large/t-shirt-femme-je-prefere-etre-en-retard.jpg?1547550942986","femme t shirt"
                ,"series t shirt" , "6900.000","6900.000"));




        gridView.setAdapter(new ImageAdapter(list1, getActivity()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Intent A = new Intent(getActivity(), Produit.class);
//                startActivity(A);
            }
        });
    }
}
