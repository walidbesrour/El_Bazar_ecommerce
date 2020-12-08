package com.example.el_bazar_mobile.ui;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.el_bazar_mobile.adapter.ViewPagerAdapter;
import com.example.el_bazar_mobile.databinding.FragmentProfileBinding;
import com.example.el_bazar_mobile.profile_fragment.Fragment_Detail;
import com.example.el_bazar_mobile.profile_fragment.Fragment_Profil_commande;
import com.example.el_bazar_mobile.profile_fragment.Fragment_profile_Adresse;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;


public class Fragment_Profile  extends Fragment {


    private Fragment_Detail fragment_detail;
    private Fragment_Profil_commande fragment_profil_commande;
    private Fragment_profile_Adresse fragment_profile_adresse;

            // image pick
    private static final int GALLER_ACTION_PICK_CODE = 100 ;
    Uri imageUri ;





   private FragmentProfileBinding binding ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());

        fragment_detail = new Fragment_Detail();
        fragment_profil_commande = new Fragment_Profil_commande();
        fragment_profile_adresse = new Fragment_profile_Adresse();


        binding.tabLayout.setupWithViewPager(binding.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        viewPagerAdapter.addFragment(fragment_detail, "Detail");
        viewPagerAdapter.addFragment(fragment_profile_adresse, "Mes Adresse");
        viewPagerAdapter.addFragment(fragment_profil_commande, "Mes Commande");


        binding.viewPager.setAdapter(viewPagerAdapter);

        binding.tabLayout.getTabAt(0);
        binding.tabLayout.getTabAt(1);
        binding.tabLayout.getTabAt(2);


        binding.downloadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runTimePermission();




            }
        });

        return binding.getRoot() ;
    }

        private void runTimePermission(){
            Dexter.withContext(getContext())
                    .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                galleryIntent();
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken token) {
                                token.continuePermissionRequest();
                        }
                    }).check();
        }

    private void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLER_ACTION_PICK_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if(requestCode == GALLER_ACTION_PICK_CODE){
                imageUri = data.getData();
                binding.profileImage.setImageURI(imageUri);

            }

        }

    }


}
