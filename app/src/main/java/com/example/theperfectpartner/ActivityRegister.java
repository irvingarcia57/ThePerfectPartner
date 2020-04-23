package com.example.theperfectpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityRegister extends AppCompatActivity {

    private EditText register_email, register_name, register_password;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mFirebaseAuth = FirebaseAuth.getInstance();

        register_email = findViewById(R.id.register_email);
        register_name = findViewById(R.id.register_name);
        register_password = findViewById(R.id.register_password);
        Button register_button = findViewById(R.id.register_button);
        TextView login_direct = findViewById(R.id.login_direct);



        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = register_email.getText().toString();
                String name = register_name.getText().toString();
                String password = register_password.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    if(password.length()>6){

                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(ActivityRegister.this, ActivityAccountCreationBirthday.class));
                                finish();
                            }else {
                                //Something went wrong
                                Toast.makeText(ActivityRegister.this, "Something went wrong ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ActivityRegister.this, "Error:"+ e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnCanceledListener(new OnCanceledListener() {
                        @Override
                        public void onCanceled() {
                            Toast.makeText(ActivityRegister.this, "Cancelled, Try Again", Toast.LENGTH_SHORT).show();
                        }
                    });




                    }else{
                        Toast.makeText(ActivityRegister.this, "Password must be 6 characters long", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ActivityRegister.this, "Fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login_direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
            }
        });


    }


}
