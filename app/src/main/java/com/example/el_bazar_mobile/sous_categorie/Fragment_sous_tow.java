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

public class Fragment_sous_tow extends Fragment {
    GridView gridView , gridView2 ,gridView3 ;

    SliderView sliderView;
    private SliderAdapterExample adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sous_tow, container, false);

        sliderView = v.findViewById(R.id.imageSlider);
        gridView = v.findViewById(R.id.myGrid);
        gridView2 = v.findViewById(R.id.myGrid2);
        gridView3 = v.findViewById(R.id.myGrid3);


        pub(sliderView);
        met_gridView(gridView);
        met_gridView2(gridView2);
        met_gridView3(gridView3);

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
                    sliderItem.setImageUrl("https://img-4.linternaute.com/Sdf7sX8UPmJu5S0Y3V-oxHKAj6Y=/1240x/smart/d6af652ac22a4e2eb275921ea5611b22/ccmcms-linternaute/10175492.jpg");
                    break;
                case 1 :
                    sliderItem.setImageUrl("https://www.prime-beaute.com/wp-content/uploads/2019/09/hugo-boss-the-scent-absolute.jpg");
                    break;
                case 2 :
                    sliderItem.setImageUrl("https://p8.storage.canalblog.com/89/55/1323261/103441294_o.jpg");
                    break;
                case 3 :
                    sliderItem.setImageUrl("https://www.beautydecoder.com/wp-content/uploads/2016/05/armani-si-eau-de-toilette.jpg");
                    break;
                case 4 :
                    sliderItem.setImageUrl("https://www.maxitendance.com/wp-content/uploads/2017/07/campagne-zara-femme-hiver-2017-2018-1.jpg");
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
        list1.add(new Produits("https://a.1stdibscdn.com/custom-counter-bar-pub-table-with-attached-swing-out-seats-built-to-spec-for-sale/1121189/f_154282121563006102694/15428212_master.jpg?width=768","Robe bleu"
                ,"Cosa My" , "500.000","420.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/71W0bb6MhYL._AC_SX522_.jpg","robe noir"
                ,"lo My" , "400.000","350.000"));
        list1.add(new Produits("https://i5.walmartimages.com/asr/ad080de9-fe5a-4389-b026-624bb8be0561_1.526053a94fdf23ec2255e202c063883a.jpeg","roge fleur"
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
    private void met_gridView3(GridView gridView ){
        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://www.artofbrilliance.co.uk/wp-content/uploads/2019/02/happy-tshirt-1.jpg","t shirt"
                ,"titou My" , "35.000","35.000"));
        list1.add(new Produits("https://ufpro.com/storage/app/media/Product%20Images/Shirts-Sweaters/Urban%20T-Shirt/Black/Urban-Tshirt-black-hero-2019-493.jpg","t shirt noir"
                ,"titou My" , "40.000","45.000"));
        list1.add(new Produits("https://ae01.alicdn.com/kf/HTB1RXXQSVXXXXXFaXXXq6xXFXXXO/La-conception-des-hommes-d-t-de-caf-amer-n-ont-aucune-crainte-l-ing-nieur.jpg_640x640.jpg","t shirt design"
                ,"T shirt design NY" , "590.000","600.000"));
        list1.add(new Produits("https://lartdaccoucher.com/wp-content/uploads/2018/11/F_French-navy.jpg","t shirt femme"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://cdn.monsieurtshirt.com/images/13895/product_large/t-shirt-femme-je-prefere-etre-en-retard.jpg?1547550942986","femme t shirt"
                ,"series t shirt" , "6900.000","6900.000"));

        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/51lJrXMOmQL._AC_UX679_.jpg","shirt 12"
                ,"apple shirt" , "20.000","25.000"));
        list1.add(new Produits("https://www.cdiscount.com/pdt2/6/2/5/1/700x700/mp10536625/rw/robe-de-soiree-mi-longue-a-col-bateau-avec-petites.jpg","Robe bleu"
                ,"Cosa My" , "500.000","420.000"));
        list1.add(new Produits("https://media3.newlookassets.com/i/newlook/646876301D3/femme/vetements/robes/robe-en-jean-noire-a-col-carre-et-manches-bouffantes.jpg?strip=true&qlt=80&w=720","robe noir"
                ,"lo My" , "400.000","350.000"));
        list1.add(new Produits("https://ba-sh.com/dw/image/v2/BBTP_PRD/on/demandware.static/-/Sites-master-bash/default/dw1b6d7d74/allImages/H18NEW/1H20AZUR_BRIQUE_1.jpg?sw=870&sh=1389&sm=fit","roge fleur"
                ,"apple" , "290.000","250.000"));
        list1.add(new Produits("https://lh3.googleusercontent.com/proxy/DgYZU2qMb50DNgCxh-Mscj3OpOgGaXOoyG-SkDua9thrKJXXq4IxvZIuXJRg93vvlDr_IXPkvnhltrIp","meuble interieur"
                ,"Cosa My" , "5000.000","4200"));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000","3500.000"));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://www.caroll.com/dw/image/v2/BCMJ_PRD/on/demandware.static/-/Sites-caroll-master/default/dw60c33ed1/images/RF04007U-01-robe-femme-clarisse.jpg?sw=522&sh=783&sm=fit&q=80","noir Serie"
                ,"SONY bb" , "590.000","550.000"));
        list1.add(new Produits("https://www.maison123.com/dw/image/v2/AAWW_PRD/on/demandware.static/-/Sites-UPAP-master/default/dw185e477e/652451007_x.jpg?sw=1000","jupe coute"
                ,"SON moi" , "590.000","550.000"));
        list1.add(new Produits("https://media.cyrillus.be/Pictures/cyrillus/77081/robe-longue-brodee-femme.jpg?width=542","jupe jaune "
                ,"series x" , "690.000","690.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://pic.clubic.com/v1/images/1827269/raw?fit=smartCrop&height=675&width=1200&hash=47782cb1216082049b7911ae2983237300e11dae","PS5 sony"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://media.cyrillus.fr/Pictures/cyrillus/62971/t-shirt-femme-en-lyocell.jpg?width=542","xbox "
                ,"series x" , "6900.000","6900.000"));

        list1.add(new Produits("https://cdn.monsieurtshirt.com/images/4541/product_large/t-shirt-femme-courir.jpg?1543829293236","iphone 12 pro"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000","3000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/51lJrXMOmQL._AC_UX679_.jpg","shirt 12"
                ,"apple shirt" , "20.000","25.000"));
        list1.add(new Produits("https://www.cdiscount.com/pdt2/6/2/5/1/700x700/mp10536625/rw/robe-de-soiree-mi-longue-a-col-bateau-avec-petites.jpg","Robe bleu"
                ,"Cosa My" , "500.000","420.000"));
        list1.add(new Produits("https://media3.newlookassets.com/i/newlook/646876301D3/femme/vetements/robes/robe-en-jean-noire-a-col-carre-et-manches-bouffantes.jpg?strip=true&qlt=80&w=720","robe noir"
                ,"lo My" , "400.000","350.000"));
        list1.add(new Produits("https://ba-sh.com/dw/image/v2/BBTP_PRD/on/demandware.static/-/Sites-master-bash/default/dw1b6d7d74/allImages/H18NEW/1H20AZUR_BRIQUE_1.jpg?sw=870&sh=1389&sm=fit","roge fleur"
                ,"apple" , "290.000","250.000"));
        list1.add(new Produits("https://lh3.googleusercontent.com/proxy/DgYZU2qMb50DNgCxh-Mscj3OpOgGaXOoyG-SkDua9thrKJXXq4IxvZIuXJRg93vvlDr_IXPkvnhltrIp","meuble interieur"
                ,"Cosa My" , "5000.000","4200"));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000","3500.000"));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://www.caroll.com/dw/image/v2/BCMJ_PRD/on/demandware.static/-/Sites-caroll-master/default/dw60c33ed1/images/RF04007U-01-robe-femme-clarisse.jpg?sw=522&sh=783&sm=fit&q=80","noir Serie"
                ,"SONY bb" , "590.000","550.000"));
        list1.add(new Produits("https://www.maison123.com/dw/image/v2/AAWW_PRD/on/demandware.static/-/Sites-UPAP-master/default/dw185e477e/652451007_x.jpg?sw=1000","jupe coute"
                ,"SON moi" , "590.000","550.000"));
        list1.add(new Produits("https://media.cyrillus.be/Pictures/cyrillus/77081/robe-longue-brodee-femme.jpg?width=542","jupe jaune "
                ,"series x" , "690.000","690.000"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://pic.clubic.com/v1/images/1827269/raw?fit=smartCrop&height=675&width=1200&hash=47782cb1216082049b7911ae2983237300e11dae","PS5 sony"
                ,"SONY" , "5900.000","5500.000"));
        list1.add(new Produits("https://media.cyrillus.fr/Pictures/cyrillus/62971/t-shirt-femme-en-lyocell.jpg?width=542","xbox "
                ,"series x" , "6900.000","6900.000"));

        list1.add(new Produits("https://cdn.monsieurtshirt.com/images/4541/product_large/t-shirt-femme-courir.jpg?1543829293236","iphone 12 pro"
                ,"apple" , "2900.000","2500.000"));
        list1.add(new Produits("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000","3000"));




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

