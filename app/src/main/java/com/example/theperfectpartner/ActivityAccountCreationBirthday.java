package com.example.theperfectpartner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class ActivityAccountCreationBirthday extends AppCompatActivity {

    Button bt1_birthday;
    DatePicker date_picker;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation_birthday);


        bt1_birthday = findViewById(R.id.bt1_birthday);
        bt1_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAccountCreationBirthday.this, ActivityAccountCreationFood.class));
                finish();
            }
        });

    }



}
