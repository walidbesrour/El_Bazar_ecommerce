package com.example.el_bazar_mobile.sous_categorie;

import android.content.Intent;
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.el_bazar_mobile.CommandeActivity;
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

public class Fragment_sous_three extends Fragment {
    RecyclerView gridView , gridView2 ;

    SliderView sliderView;
    private SliderAdapterExample adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sous_three, container, false);

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
                    sliderItem.setImageUrl("https://www.danstapub.com/wp-content/uploads/2020/05/VISU2.png");
                    break;
                case 1 :
                    sliderItem.setImageUrl("https://www.miliboo.com/images/v5/bannieres/home/fr/home_noel_2020_mobile.jpg");
                    break;
                case 2 :
                    sliderItem.setImageUrl("https://www.danstapub.com/wp-content/uploads/2020/05/VISU4-1160x508.png");
                    break;
                case 3 :
                    sliderItem.setImageUrl("https://i.ytimg.com/vi/AZ_8yO40mIg/maxresdefault.jpg");
                    break;
                case 4 :
                    sliderItem.setImageUrl("https://www.maxitendance.com/wp-content/uploads/2013/07/1-Pub-IKEA-Assembly-Service-Montage-Surrealiste.jpg");
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
    private void met_gridView(RecyclerView gridView ){
        ArrayList<Produits> list12 = new ArrayList <>();
        list12.add(new Produits("https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg","Robe bleu"
                ,"Cosa My" , "500.000","420.000"));
        list12.add(new Produits("https://media3.newlookassets.com/i/newlook/646876301D3/femme/vetements/robes/robe-en-jean-noire-a-col-carre-et-manches-bouffantes.jpg?strip=true&qlt=80&w=720","robe noir"
                ,"lo My" , "400.000","350.000"));
        list12.add(new Produits("https://ba-sh.com/dw/image/v2/BBTP_PRD/on/demandware.static/-/Sites-master-bash/default/dw1b6d7d74/allImages/H18NEW/1H20AZUR_BRIQUE_1.jpg?sw=870&sh=1389&sm=fit","roge fleur"
                ,"apple" , "290.000","250.000"));
        list12.add(new Produits("https://www.caroll.com/dw/image/v2/BCMJ_PRD/on/demandware.static/-/Sites-caroll-master/default/dw60c33ed1/images/RF04007U-01-robe-femme-clarisse.jpg?sw=522&sh=783&sm=fit&q=80","noir Serie"
                ,"SONY bb" , "590.000","550.000"));
        list12.add(new Produits("https://www.maison123.com/dw/image/v2/AAWW_PRD/on/demandware.static/-/Sites-UPAP-master/default/dw185e477e/652451007_x.jpg?sw=1000","jupe coute"
                ,"SON moi" , "590.000","550.000"));
        list12.add(new Produits("https://media.cyrillus.be/Pictures/cyrillus/77081/robe-longue-brodee-femme.jpg?width=542","jupe jaune "
                ,"series x" , "690.000","690.000"));


        ImageAdapter imageAdapter = new ImageAdapter(list12);
        gridView.setAdapter(imageAdapter);
        gridView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        imageAdapter.setonItemClickLister_sous(new ImageAdapter.onItemClickLister() {
            @Override
            public void ItemClick_produit(int position) {
                Intent intent = new Intent(getActivity(), CommandeActivity.class);
                startActivity(intent);
            }
        });


    }
    private void met_gridView2(RecyclerView gridView ){
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



        ImageAdapter imageAdapter = new ImageAdapter(list1);
        gridView.setAdapter(imageAdapter);
        gridView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        imageAdapter.setonItemClickLister_sous(new ImageAdapter.onItemClickLister() {
            @Override
            public void ItemClick_produit(int position) {
                Intent intent = new Intent(getActivity(), CommandeActivity.class);
                startActivity(intent);
            }
        });
    }

}
