package com.example.el_bazar_mobile.profile_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.CustomExpandableListAdapter;
import com.example.el_bazar_mobile.databinding.FragmentDetailBinding;
import com.example.el_bazar_mobile.databinding.FragmentProfilCommandeBinding;
import com.example.el_bazar_mobile.model.Commande;
import com.example.el_bazar_mobile.model.Nouveau_Produit;
import com.example.el_bazar_mobile.model.Produits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Fragment_Profil_commande extends Fragment {


    private ExpandableListAdapter expandableListAdapter;
    private List<Commande> groupList;
    private HashMap<Commande, List<Produits>> listaContactos;
    private int lastExpandedPosition = -1;



    private FragmentProfilCommandeBinding binding ;
    public Fragment_Profil_commande() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfilCommandeBinding.inflate(getLayoutInflater());

        groupList = new ArrayList<>();





        init();

        binding.listExtensible.setAdapter(expandableListAdapter);

        binding.listExtensible.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    binding.listExtensible.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });



        return binding.getRoot() ;
    }




    private void init() {
//        this.expandableListView = findViewById(R.id.list_extensible);
        this.listaContactos = getContactos();
        this.groupList = new ArrayList<>(listaContactos.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(getContext(),
                groupList, listaContactos);

    }

    private HashMap<Commande, List<Produits>> getContactos() {
        HashMap<Commande, List<Produits>> listaC = new HashMap<>();

        groupList = new ArrayList<>();
        groupList.add(new Commande("1500586",1500 , "livré"));
        groupList.add(new Commande("1500586",250000 , "livré"));
        groupList.add(new Commande("1500586",15890 , "livré"));
        groupList.add(new Commande("1500586",18950 , "livré"));
        groupList.add(new Commande("1500586",26900 , "livré"));


        ArrayList<Produits> list1 = new ArrayList <>();
        list1.add(new Produits("https://lh3.googleusercontent.com/proxy/DgYZU2qMb50DNgCxh-Mscj3OpOgGaXOoyG-SkDua9thrKJXXq4IxvZIuXJRg93vvlDr_IXPkvnhltrIp","meuble interieur"
                ,"Cosa My" , "5000.000","10"));
        list1.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000","5"));
        list1.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000","3"));
        list1.add(new Produits("https://images-na.ssl-images-amazon.com/images/I/91J0vrjGY3L._AC_SX466_.jpg","Sony's MASTER Serie"
                ,"SONY" , "5900.000","1"));

        ArrayList<Produits> list2 = new ArrayList<>();
        list2.add(new Produits("https://static.cnews.fr/sites/default/files/iphone_12_et_12_pro_-_les_differences_5f9aea758f9a2_0.jpg","iphone 12 pro","apple" ,
                "2900.000","2"));
        list2.add(new Produits("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000","1"));
        list2.add(new Produits("https://i.vimeocdn.com/video/667401754_1280.jpg"
                ,"danao ","delice" , "690.000","1"));

        ArrayList<Produits> list3 = new ArrayList <>();
        list3.add(new Produits("https://img.bfmtv.com/c/0/0/808a1/7098de2fb514f1244d1da671297.jpg","iphone 12"
                ,"apple" , "2900.000","3")) ;
        list3.add(new Produits("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR__5v5R66BFREzVt7-4u9FkS9zC_FDl4G30Q&usqp=CAU","meuble interieur"
                ,"Cosa My" , "4000.000","5"));
        ArrayList<Produits> list4 = new ArrayList <>();
        list4.add(new Produits( "https://www.blanlys.ma/372-large_default/nettoyant-sol-kalyon-golden-rose-15l.jpg","Nettoyant Sol Kalyon Golden Rose 1,5L", "ROSA","100.000","2"));
        list4.add(new Produits("https://tn.jumia.is/unsafe/fit-in/300x300/filters:fill(white)/product/71/9742/1.jpg?7306","Essuie tout Lilas ", "LILAS", "50.000","2"));
        list4.add(new Produits( "https://www.cdiscount.com/pdt2/4/7/1/1/700x700/ina6957599321471/rw/lampe-de-chevet-2pcs-lampe-de-table-en-bois-et-tis.jpg","Lampe à poser Blanc", "titou","50.000","1"));
        list4.add(new Produits( "https://support.apple.com/library/content/dam/edam/applecare/images/en_US/social/macos-mojave-bootcamp-social-card.jpg","mac ios","pc Appel", "6000.000","5"));

        ArrayList<Produits> list5 = new ArrayList <>();
        list5.add(new Produits("https://www.samsungshop.tn/15270-thickbox_default/49-ru7300-curved-smart-4k-uhd-tv-samsung-tunisie-prix.jpg"
                ,"tv UHD samsung", "molotove","3100.000","1"));
        list5.add(new Produits("https://i.vimeocdn.com/video/667401754_1280.jpg"
                ,"danao ","delice" , "690.000","1"));




            listaC.put(groupList.get(0),list1);
            listaC.put(groupList.get(1),list2);
            listaC.put(groupList.get(2),list3);
            listaC.put(groupList.get(3),list4);
            listaC.put(groupList.get(4),list5);




        return listaC;
    }































}