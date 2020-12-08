package com.example.el_bazar_mobile.profile_fragment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.adapter.Adapter_Adresse;
import com.example.el_bazar_mobile.adapter.Adapter_RecylerView_Categorie;
import com.example.el_bazar_mobile.databinding.FragmentProfilCommandeBinding;
import com.example.el_bazar_mobile.databinding.FragmentProfileBinding;
import com.example.el_bazar_mobile.databinding.FragmentProfilePannierBinding;
import com.example.el_bazar_mobile.databinding.FragmentProfilePannierBindingImpl;
import com.example.el_bazar_mobile.model.Adresse;
import com.example.el_bazar_mobile.model.Categorie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Fragment_profile_Adresse extends Fragment {
    String id_ville ;
    ArrayList<Adresse> adresses ;
    String add_gouvernorat , add_ville , add_localite ;
    int position ;
    private FragmentProfilePannierBinding binding ;

    public Fragment_profile_Adresse() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfilePannierBinding.inflate(getLayoutInflater());


        binding.Ajou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoxDialogBox () ;
            }
        });


///////////////////////////////////////////////////////////////////////////////
           createExampleList() ;
        Adapter_Adresse adapter_adresse = new Adapter_Adresse(adresses);
        binding.recyAdress.setLayoutManager(new GridLayoutManager(getContext(),1));
        binding.recyAdress.setAdapter(adapter_adresse);


//////////////////////////////////////////////////////////////////////////////

        return binding.getRoot() ;
    }



    public void createExampleList() {
        adresses = new ArrayList<>();
        adresses.add(new Adresse("Ariana","gazela","Ariana","tunis rue 12"));
        adresses.add(new Adresse("Beja","nefza","touz","mounastie rue 120"));
        adresses.add(new Adresse("Ariana","tadhamen","Ariana","nasr rue 12"));
        adresses.add(new Adresse("Ariana","nebel","Electronique","sousa rue 12"));
        adresses.add(new Adresse("mednin","mido","djerba","beb jdid rue 12"));
        adresses.add(new Adresse("sousa","saousa","sos","menzah rue 12"));
        adresses.add(new Adresse("mestir","Electronique","djerba","djerba rue 12"));
    }
    public  void ShoxDialogBox ()
    {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.add_new_adress);


        Spinner spinner_gouvernorat = dialog.findViewById(R.id.gouvernorat);
        Spinner spinner_ville = dialog.findViewById(R.id.ville);
        Spinner spinner_localite = dialog.findViewById(R.id.localite);
        try{
            JSONObject obj=new JSONObject(LoadJsonFromAsset());

            JSONArray array=obj.getJSONArray("Gouvernorats");
            ArrayList<String> list = null;


            list= new ArrayList<>();
            for( int i=0;i<array.length();i++){

                JSONObject o = array.getJSONObject(i);

                String label_v =o.getString("label");

                list.add(label_v);


            }

            Log.d("*******", String.valueOf(list));


            ArrayAdapter<String> adapter_gouvernorat = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);

            adapter_gouvernorat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_gouvernorat.setAdapter(adapter_gouvernorat);

            spinner_gouvernorat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    add_gouvernorat = spinner_gouvernorat.getItemAtPosition(position).toString();


             //     Toast.makeText(parent.getContext(), z, Toast.LENGTH_SHORT).show();

                    try {

                        JSONObject obj_ville =new JSONObject(LoadJsonFromAsset_ville());

                        JSONArray array2=obj_ville.getJSONArray("Villes");
                        ArrayList<String> list_ville = null;
                        list_ville= new ArrayList<>();
                        for( int i=0;i<array2.length();i++){

                            JSONObject o = array2.getJSONObject(i);
                            String label_ville =o.getString("Ville");
                            String labell_IDGouvernorat = o.getString("IDGouvernorat");


                            if(position == 0 && labell_IDGouvernorat.equals("1") )
                            {

                                list_ville.add(label_ville);
                            }
                            if(position == 1 && labell_IDGouvernorat.equals("2") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 2 && labell_IDGouvernorat.equals("3") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 3 && labell_IDGouvernorat.equals("4") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 4 && labell_IDGouvernorat.equals("5") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 5 && labell_IDGouvernorat.equals("6") )
                            {
                                list_ville.add(label_ville);
                            }if(position == 6 && labell_IDGouvernorat.equals("7") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 7 && labell_IDGouvernorat.equals("8") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 8 && labell_IDGouvernorat.equals("9") )
                            {
                                list_ville.add(label_ville);
                            }if(position == 9 && labell_IDGouvernorat.equals("10") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 10 && labell_IDGouvernorat.equals("11") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 11 && labell_IDGouvernorat.equals("12") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 12 && labell_IDGouvernorat.equals("13") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 13 && labell_IDGouvernorat.equals("14") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 14 && labell_IDGouvernorat.equals("15") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 15 && labell_IDGouvernorat.equals("16") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 16 && labell_IDGouvernorat.equals("17") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 17 && labell_IDGouvernorat.equals("18") )
                            {
                                list_ville.add(label_ville);
                            }
                            if(position == 18 && labell_IDGouvernorat.equals("19") )
                            {
                                list_ville.add(label_ville);
                            }  if(position == 19 && labell_IDGouvernorat.equals("20") )
                            {
                                list_ville.add(label_ville);
                            }  if(position == 20 && labell_IDGouvernorat.equals("21") )
                            {
                                list_ville.add(label_ville);
                            }  if(position == 21 && labell_IDGouvernorat.equals("22") )
                            {
                                list_ville.add(label_ville);
                            }  if(position == 22 && labell_IDGouvernorat.equals("23") )
                            {
                                list_ville.add(label_ville);
                            }  if(position == 23 && labell_IDGouvernorat.equals("24") )
                            {
                                list_ville.add(label_ville);
                            }




                        }

                        ArrayAdapter<String> adapter_ville = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list_ville);
                        spinner_ville.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list_ville));




                        spinner_ville.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                // Log.d("==> position ", String.valueOf(position));

                                try {
                                    String Ville_sp = parent.getSelectedItem().toString() ;

                                    JSONObject obj_ville2 =new JSONObject(LoadJsonFromAsset_ville());

                                    JSONArray array22=obj_ville2.getJSONArray("Villes");
                                    ArrayList<String> list_ville2 = null;
                                    list_ville2= new ArrayList<>();
                                    for( int i=0;i<array22.length();i++) {

                                        JSONObject o = array22.getJSONObject(i);
                                        String label_ville2 = o.getString("Ville");
                                        String ID = o.getString("ID");
                                        if (label_ville2.equals(Ville_sp))
                                        {
                                            id_ville = ID ;
                                            add_ville = label_ville2 ;
                                        }

                                    }

                              //    Toast.makeText(parent.getContext(), add_ville, Toast.LENGTH_SHORT).show();



                                    JSONObject obj_Localite = new JSONObject(LoadJsonFromAsset_localite());
                                    JSONArray array3 = obj_Localite.getJSONArray("Localites");



                                    ArrayList<String> list_Localites = null;
                                    list_Localites= new ArrayList<>();



                                    for( int i=0;i<array3.length();i++){
                                        JSONObject o = array3.getJSONObject(i);
                                        String label_localites =o.getString("Localite");
                                        String labell_IDVille = o.getString("IDVille");

                                        if(id_ville.equals(labell_IDVille)){
                                            list_Localites.add(label_localites);
                                            add_localite = label_localites ;
                                        }




                                    }

                                    spinner_localite.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list_Localites));



                                }catch (Exception exe){exe.printStackTrace(); }


                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        ////////////////
                        /*

                         */
//////////

                    }catch (Exception ex){ ex.printStackTrace(); }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }catch (JSONException e){
            e.printStackTrace();
        }

        Button ajouter = dialog.findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adresses.add(new Adresse(add_gouvernorat,add_ville,add_localite));
                Adapter_Adresse adapter_adresse = new Adapter_Adresse(adresses);
                binding.recyAdress.setAdapter(adapter_adresse);

                dialog.dismiss();
            }
        });





        dialog.show();

    }

    ///////////// spinner //////////:
    public String LoadJsonFromAsset(){
        String json=null;
        try{
            InputStream in= getContext().getAssets().open("gouvernorat.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String LoadJsonFromAsset_ville(){
        String json=null;
        try{
            InputStream in=getContext().getAssets().open("villes.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public String LoadJsonFromAsset_localite(){
        String json=null;
        try{
            InputStream in=getContext().getAssets().open("localite.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}