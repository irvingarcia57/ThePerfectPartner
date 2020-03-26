package com.example.theperfectpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityIntro extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser != null){
            //there is some user logged in
            startActivity(new Intent(ActivityIntro.this, ActivityHome.class));
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            finish();
        } else{
            // not logged in
            startActivity(new Intent(ActivityIntro.this, ActivityRegister.class));
            finish();
        }

    }
}
