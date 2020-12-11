package com.example.el_bazar_mobile.commande;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.el_bazar_mobile.R;
import com.example.el_bazar_mobile.databinding.FragmentCommandeOneBinding;
import com.example.el_bazar_mobile.util.DatePickerFragment;
import com.example.el_bazar_mobile.util.DateValidatorWeekdays;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class Fragment_Commande_One extends Fragment  implements DatePickerDialog.OnDateSetListener{

    private FragmentCommandeOneBinding binding ;
    public Fragment_Commande_One() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCommandeOneBinding.inflate(getLayoutInflater());

/////////////////////////////////////////////    button ADD  ///////////////////////////////////////////////////////////////////////////

        binding.ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment F_Commande_two = new Fragment_Commande_Tow();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container1,F_Commande_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

/////////////////////////////////////////////    date   ///////////////////////////////////////////////////////////////////////////

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

        long today = MaterialDatePicker.todayInUtcMilliseconds();

        calendar.setTimeInMillis(today);

        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        long january = calendar.getTimeInMillis();

        calendar.set(Calendar.MONTH, Calendar.MARCH);
        long march = calendar.getTimeInMillis();

        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        long december = calendar.getTimeInMillis();

        //CalendarConstraints
        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setValidator(new DateValidatorWeekdays());

        //MaterialDatePicker
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("SELECT A DATE");
        builder.setSelection(today);
        builder.setCalendarConstraints(constraintBuilder.build());
        final MaterialDatePicker materialDatePicker = builder.build();



        binding.DateProfile1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             //   DialogFragment datePicker = new DatePickerFragment();
            //    datePicker.show( getChildFragmentManager(), "date picker");
                materialDatePicker.show(getChildFragmentManager(), "DATE_PICKER");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
////////////////////////////////////////////////////////////////////
        return binding.getRoot();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        binding.DateProfile1.setText(currentDateString);
    }
}