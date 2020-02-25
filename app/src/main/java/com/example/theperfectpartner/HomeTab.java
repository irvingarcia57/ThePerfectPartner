package com.example.theperfectpartner;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class HomeTab extends Fragment implements View.OnClickListener {
    NavController navController = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_tab, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        view.findViewById(R.id.profile_button).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.profile_button:
                Toast.makeText(getContext(), "button was pressed", Toast.LENGTH_SHORT).show();
                break;

        }


    }



}
