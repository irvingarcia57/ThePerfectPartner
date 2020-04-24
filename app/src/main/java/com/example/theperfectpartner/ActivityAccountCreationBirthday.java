package com.example.theperfectpartner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;


public class ActivityAccountCreationBirthday extends AppCompatActivity {

    Button bt1_birthday;
    DatePicker date_picker;
    int day, month, year;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private FirebaseAuth mFirebaseAuth;
    String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation_birthday);
        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("User Info/" + user_id);

        bt1_birthday = findViewById(R.id.bt1_birthday);
        date_picker = findViewById(R.id.date_picker);

        bt1_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = date_picker.getDayOfMonth();
                month = date_picker.getMonth() + 1;
                year = date_picker.getYear();
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ref.child("Birthday").setValue(String.format("%02d",month) + "/" + String.format("%02d",day));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                startActivity(new Intent(ActivityAccountCreationBirthday.this, ActivityAccountCreationFood.class));
                finish();
            }
        });

    }



}
