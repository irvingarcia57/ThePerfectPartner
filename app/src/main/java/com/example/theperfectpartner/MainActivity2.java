package com.example.theperfectpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    int id = menuItem.getItemId();

                    if(id == R.id.homeTab){
                        HomeTab fragment = new HomeTab();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,fragment);
                        fragmentTransaction.commit();
                    }
                    if(id == R.id.partnerTab){
                        PartnerTab fragment = new PartnerTab();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,fragment);
                        fragmentTransaction.commit();
                    }
                    if(id == R.id.messagesTab){
                        MessagesTab fragment = new MessagesTab();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,fragment);
                        fragmentTransaction.commit();
                    }
                    if(id == R.id.calendarTab){
                        CalendarTab fragment = new CalendarTab();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,fragment);
                        fragmentTransaction.commit();
                    }












//                    Fragment selectedFragment = null;
//                    switch(menuItem.getItemId()){
//                        case R.id.homeTab:
//                            selectedFragment = new HomeTab();
//                            break;
//                        case R.id.partnerTab:
//                            selectedFragment = new PartnerTab();
//                            break;
//                        case R.id.messagesTab:
//                            selectedFragment = new MessagesTab();
//                            break;
//                        case R.id.calendarTab:
//                            selectedFragment = new CalendarTab();
//                            break;
//                            default: selectedFragment = new HomeTab();
//                                break;
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).commit();
                    return true;


                }


            };

}
