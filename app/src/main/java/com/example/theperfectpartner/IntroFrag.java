package com.example.theperfectpartner;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class IntroFrag extends Fragment implements View.OnClickListener{

    NavController navController = null;
    NavController navController1 = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.intro_frag, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        navController1 = Navigation.findNavController(view);

        view.findViewById(R.id.register_button).setOnClickListener(this);
        view.findViewById(R.id.log_in_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.register_button:
                navController.navigate(R.id.action_introFrag_to_register);
                break;
            case R.id.log_in_button:
                navController.navigate(R.id.action_introFrag_to_signIn);
                break;
        }


    }
}
