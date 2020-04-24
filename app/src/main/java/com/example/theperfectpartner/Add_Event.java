package com.example.theperfectpartner;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Event extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference databaseReference;
    DatePicker event_date;
    Spinner event_number;
    Button btn_add_ev, btn_delete;
    EditText event_name;
    String user_id;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null) {
            finish();
        }
        user_id = firebaseAuth.getCurrentUser().getUid();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = mFirebaseDatabase.getReference("User Info/" + user_id);
        DisplayMetrics dm = new DisplayMetrics();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width * 0.8),(int)(height * 0.8));
        event_number = findViewById(R.id.event_num);
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(Add_Event.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Event_List));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        event_number.setAdapter(myadapter);
        event_name = findViewById(R.id.event_name);
        btn_add_ev = findViewById(R.id.btn_add_event);
        btn_delete = findViewById(R.id.btn_delete);
        event_date = findViewById(R.id.event_date);
        btn_add_ev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Events();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Del_events();
            }
        });

    }
    public void Events() {
        if(event_number.getSelectedItemPosition() != 0){
            String number_event = event_number.getSelectedItem().toString().trim();
            String name_event = event_name.getText().toString().trim();
            String date_event =  event_date.getYear() + "/" + String.format("%02d", event_date.getMonth() + 1) + "/" + String.format("%02d",event_date.getDayOfMonth()) + " 00:00:00";
          //  events events = new events(number_event, name_event, date_event);
          //  databaseReference.child("Events").child(event_number.getSelectedItem().toString()).setValue(events);
            databaseReference.child("Events").child(event_number.getSelectedItem().toString()).child("Event Name").setValue(name_event);
            databaseReference.child("Events").child(event_number.getSelectedItem().toString()).child("Event Date").setValue(date_event);
            Toast.makeText(getApplicationContext(), "Events Created", Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(getApplicationContext(), "Please select an Event number to schduel a date", Toast.LENGTH_LONG).show();
    }

    public void Del_events(){
        if(event_number.getSelectedItemPosition() != 0) {
            databaseReference.child("Events").child(event_number.getSelectedItem().toString()).removeValue();
        }
    }



}
