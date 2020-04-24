package com.example.theperfectpartner;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class CalendarTab extends Fragment{

    ProgressDialog TempDialog;
    CountDownTimer mCountDownTimer;
    int i=0;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    // private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference ref;
    public String userID;
    public String event_name1, event_name2, event_name3, event_name4, event_name5, event_name6, event_name7, event_name8, event_name9, event_name10, dob;
    public String defualt_date = "1990/01/01 12:00:00",event_date1, event_date2, event_date3, event_date4, event_date5, event_date6, event_date7, event_date8, event_date9, event_date10;
    // public String event_number1, event_number2, event_number3, event_number4, event_number5, event_number6, event_number7, event_number8, event_number9, event_number10;
    CompactCalendarView compactCalendar;
    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    private SimpleDateFormat dateFormatmonth = new SimpleDateFormat("MMMM - yyyy", Locale.getDefault());



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calendar_tab, container, false);

        TempDialog = new ProgressDialog(getActivity());
        TempDialog.setMessage("Please wait...");
        TempDialog.setCancelable(false);
        TempDialog.setProgress(i);
        TempDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        TempDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference().child("User Info").child(userID);
        ref.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dob = year + "/" + dataSnapshot.child("Birthday").getValue().toString() + " 00:00:00";
                if(dataSnapshot.hasChild("Events")) {
                    if(dataSnapshot.hasChild("Events/Event 1")) {
                        event_name1 = dataSnapshot.child("Events/Event 1/event_name").getValue().toString();
                        event_date1 = dataSnapshot.child("Events/Event 1/event_date").getValue().toString();
                    }
                    else {
                        event_date1 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 2")){
                        event_name2 = dataSnapshot.child("Events/Event 2/event_name").getValue().toString();
                        event_date2 = dataSnapshot.child("Events/Event 2/event_date").getValue().toString();
                    }
                    else{
                        event_date2 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 3")) {
                        event_name3 = dataSnapshot.child("Events/Event 3/event_name").getValue().toString();
                        event_date3 = dataSnapshot.child("Events/Event 3/event_date").getValue().toString();
                    }
                    else{
                        event_date3 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 4")) {
                        event_name4 = dataSnapshot.child("Events/Event 4/event_name").getValue().toString();
                        event_date4 = dataSnapshot.child("Events/Event 4/event_date").getValue().toString();
                    }
                    else {
                        event_date4 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 5")) {
                        event_name5 = dataSnapshot.child("Events/Event 5/event_name").getValue().toString();
                        event_date5 = dataSnapshot.child("Events/Event 5/event_date").getValue().toString();
                    }
                    else {
                        event_date5 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 6")) {
                        event_name6 = dataSnapshot.child("Events/Event 6/event_name").getValue().toString();
                        event_date6 = dataSnapshot.child("Events/Event 6/event_date").getValue().toString();
                    }
                    else {
                        event_date6 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 7")) {
                        event_name7 = dataSnapshot.child("Events/Event 7/event_name").getValue().toString();
                        event_date7 = dataSnapshot.child("Events/Event 7/event_date").getValue().toString();
                    }
                    else {
                        event_date7 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 8")) {
                        event_name8 = dataSnapshot.child("Events/Event 8/event_name").getValue().toString();
                        event_date8 = dataSnapshot.child("Events/Event 8/event_date").getValue().toString();
                    }
                    else {
                        event_date8 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 9")) {
                        event_name9 = dataSnapshot.child("Events/Event 9/event_name").getValue().toString();
                        event_date9 = dataSnapshot.child("Events/Event 9/event_date").getValue().toString();
                    }
                    else {
                        event_date9 = defualt_date;
                    }

                    if(dataSnapshot.hasChild("Events/Event 10")) {
                        event_name10 = dataSnapshot.child("Events/Event 10/event_name").getValue().toString();
                        event_date10 = dataSnapshot.child("Events/Event 10/event_date").getValue().toString();
                    }
                    else {
                        event_date10 = defualt_date;
                    }
                }
                else {

                    event_date1 = defualt_date;
                    event_date2 = defualt_date;
                    event_date3 = defualt_date;
                    event_date4 = defualt_date;
                    event_date5 = defualt_date;
                    event_date6 = defualt_date;
                    event_date7 = defualt_date;
                    event_date8 = defualt_date;
                    event_date9 = defualt_date;
                    event_date10 = defualt_date;
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

       // public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sa)

      Button btn_event = rootView.findViewById(R.id.btn_event);
        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Add_Event.class));
            }
        });
        TempDialog.show();
        mCountDownTimer = new CountDownTimer(2000, 10000)
        {
            public void onTick(long millisUntilFinished)
            {
                TempDialog.setMessage("Please wait..");
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onFinish()
            {
                TempDialog.dismiss();
                Event ev_birthday = new Event(Color.RED, timestamp(dob), "Birthday");
                // Event ev_anivetsy = new Event(Color.RED, timestamp(dob), userID);
                Event ev1 = new Event(Color.RED, timestamp(event_date1), event_name1);
                Event ev2 = new Event(Color.RED, timestamp(event_date2), event_name2);
                Event ev3 = new Event(Color.RED, timestamp(event_date3), event_name3);
                Event ev4 = new Event(Color.RED, timestamp(event_date4), event_name4);
                Event ev5 = new Event(Color.RED, timestamp(event_date5), event_name5);
                Event ev6 = new Event(Color.RED, timestamp(event_date6), event_name6);
                Event ev7 = new Event(Color.RED, timestamp(event_date7), event_name7);
                Event ev8 = new Event(Color.RED, timestamp(event_date8), event_name8);
                Event ev9 = new Event(Color.RED, timestamp(event_date9), event_name9);
                Event ev10 = new Event(Color.RED, timestamp(event_date10), event_name10);
                compactCalendar = getView().findViewById(R.id.compactcalendar_view);
                compactCalendar.setUseThreeLetterAbbreviation(true);
                compactCalendar.addEvent(ev_birthday);
                //compactCalendar.addEvent(ev_anivetsy);
                compactCalendar.addEvent(ev1);
                compactCalendar.addEvent(ev2);
                compactCalendar.addEvent(ev3);
                compactCalendar.addEvent(ev4);
                compactCalendar.addEvent(ev5);
                compactCalendar.addEvent(ev6);
                compactCalendar.addEvent(ev7);
                compactCalendar.addEvent(ev8);
                compactCalendar.addEvent(ev9);
                compactCalendar.addEvent(ev10);

                final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(false);
                actionBar.setTitle(null);
                compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDayClick(Date dateClicked) {
                        Context context = getActivity().getApplicationContext();

                        if(dateClicked.getTime() == timestamp(dob)) {
                            Toast.makeText(context, "Happy Birthday", Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date1)) {
                            Toast.makeText(context,"" + event_name1,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date2)) {
                            Toast.makeText(context,"" + event_name2,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date3)) {
                            Toast.makeText(context,"" + event_name3,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date4)) {
                            Toast.makeText(context,"" + event_name4,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date5)) {
                            Toast.makeText(context,"" + event_name5,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date6)) {
                            Toast.makeText(context,"" + event_name6,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date7)) {
                            Toast.makeText(context,"" + event_name7,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date8)) {
                            Toast.makeText(context,"" + event_name8,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date9)) {
                            Toast.makeText(context,"" + event_name9,Toast.LENGTH_SHORT).show();
                        }
                        else if(dateClicked.getTime() == timestamp(event_date10)) {
                            Toast.makeText(context,"" + event_name10,Toast.LENGTH_SHORT).show();
                        }
                        else  {
                            Toast.makeText(context, "No Event" , Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onMonthScroll(Date firstDayOfNewMonth) {

                        actionBar.setTitle(dateFormatmonth.format(firstDayOfNewMonth));

                    }
                });

            }
        }.start();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.calendar_tab, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static long timestamp(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        long millis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return millis;
    }
   /* public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStop(){
        super.onStop();
        if(mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener) ;
        }
    }*/

    private class onClick {
    }

}
