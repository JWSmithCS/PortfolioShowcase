package com.example.showcaseportfolio.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.showcaseportfolio.databinding.FragmentSifiBinding;

public class SifiFragment extends Fragment {

    private FragmentSifiBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSifiBinding.inflate(inflater, container, false);
        binding.generateBTN.setOnClickListener(v -> sayHello(v));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void sayHello(View v) {
        String first = binding.firstTXT.getText().toString();
        String last = binding.lastTXT.getText().toString();
        String city = binding.cityTXT.getText().toString();
        String school = binding.schoolTXT.getText().toString();
        String pet = binding.petTXT.getText().toString();
        String sib = binding.sibTXT.getText().toString();

        String sifiFirst = first.substring(0, Math.min(2, first.length()))
                + last.substring(0, Math.min(3, last.length()));

        String sifiLast = city.substring(0, Math.min(2, city.length()))
                + school.substring(0, Math.min(3, school.length()));

        String origin = pet.substring(Math.max(0, pet.length() - 1))
                + sib.substring(Math.min(1, sib.length()));

        String welcomeMsg = "Hello " + sifiFirst + " " + sifiLast + " From " + origin;

        binding.outputLBL.setText(welcomeMsg);
    }
}
