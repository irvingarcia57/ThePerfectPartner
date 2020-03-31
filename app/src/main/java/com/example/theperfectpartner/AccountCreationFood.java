package com.example.theperfectpartner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.ArrayList;


public class AccountCreationFood extends Fragment implements View.OnClickListener {
    private ArrayList<String> selection =new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.account_creation_food, container, false);


    }




    @Override
    public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();

            if (view.getId() == R.id.burgers) {
                if (checked) {
                    selection.add("Burgers");
                } else {
                    selection.remove("Burgers");
                }
            }
            if (view.getId() == R.id.italian) {
                if (checked) {
                    selection.add("Italian");
                } else {
                    selection.remove("Italian");
                }
            }
            if (view.getId() == R.id.asian) {
                if (checked) {
                    selection.add("Asian");
                } else {
                    selection.remove("Asian");
                }
            }
            if (view.getId() == R.id.mexican) {
                if (checked) {
                    selection.add("Mexican");
                } else {
                    selection.remove("Mexican");
                }
            }
            if (view.getId() == R.id.tacos) {
                if (checked) {
                    selection.add("Tacos");
                } else {
                    selection.remove("Tacos");
                }
            }
            if (view.getId() == R.id.indian) {
                if (checked) {
                    selection.add("Indian");
                } else {
                    selection.remove("Indian");
                }
            }
            if (view.getId() == R.id.cajun) {
                if (checked) {
                    selection.add("Cajun");
                } else {
                    selection.remove("Cajun");
                }
            }
            if (view.getId() == R.id.mediter) {
                if (checked) {
                    selection.add("Mediterranean");
                } else {
                    selection.remove("Mediterranean");
                }
            }
            if (view.getId() == R.id.german) {
                if (checked) {
                    selection.add("German");
                } else {
                    selection.remove("German");
                }
            }

    }
}
