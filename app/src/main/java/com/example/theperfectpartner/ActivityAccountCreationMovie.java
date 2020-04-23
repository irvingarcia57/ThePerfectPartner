package com.example.theperfectpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class ActivityAccountCreationMovie extends AppCompatActivity {

    ArrayList<String> selection =new ArrayList<String>();
    //    TextView final_text;
    Button bt1_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation_movie);

//        final_text =(TextView) findViewById(R.id.final_result);
//        final_text.setEnabled(false);
        bt1_movie = findViewById(R.id.bt1_movie);
        bt1_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAccountCreationMovie.this, ActivityAccountCreationHobbies.class));
                finish();
            }
        });


    }

    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.action) {
            if (checked) {
                selection.add("@string/AC_action");
            } else {
                selection.remove("@string/AC_action");
            }
        }


        if (view.getId() == R.id.adventure) {
            if (checked) {
                selection.add("@string/AC_adventure");
            } else {
                selection.remove("@string/AC_adventure");
            }
        }


        if (view.getId() == R.id.animation) {
            if (checked) {
                selection.add("@string/AC_animation");
            } else {
                selection.remove("@string/AC_animation");
            }
        }

        if (view.getId() == R.id.comedy) {
            if (checked) {
                selection.add("@string/AC_comedy");
            } else {
                selection.remove("@string/AC_comedy");
            }
        }

        if (view.getId() == R.id.documentary) {
            if (checked) {
                selection.add("@string/AC_documentary");
            } else {
                selection.remove("@string/AC_documentary");
            }
        }

        if (view.getId() == R.id.drama) {
            if (checked) {
                selection.add("@string/AC_drama");
            } else {
                selection.remove("@string/AC_drama");
            }
        }

        if (view.getId() == R.id.horror) {
            if (checked) {
                selection.add("@string/AC_horror");
            } else {
                selection.remove("@string/AC_horror");
            }
        }

        if (view.getId() == R.id.political) {
            if (checked) {
                selection.add("@string/AC_political");
            } else {
                selection.remove("@string/AC_political");
            }
        }

        if (view.getId() == R.id.romance) {
            if (checked) {
                selection.add("@string/AC_romance");
            } else {
                selection.remove("@string/AC_romance");
            }
        }
        if (view.getId() == R.id.science_fiction) {
            if (checked) {
                selection.add("@string/AC_science_fiction");
            } else {
                selection.remove("@string/AC_science_fiction");
            }
        }
        if (view.getId() == R.id.thriller) {
            if (checked) {
                selection.add("@string/AC_thriller");
            } else {
                selection.remove("@string/AC_thriller");
            }
        }
        if (view.getId() == R.id.western) {
            if (checked) {
                selection.add("@string/AC_western");
            } else {
                selection.remove("@string/AC_western");
            }
        }

    }

    public void finalSelection(View view){
        String final_food_selection = "";

        for(String Selections : selection){
            final_food_selection = final_food_selection + Selections + "\n";
        }

//        final_text.setText(final_food_selection);
//        final_text.setEnabled(true);


    }


}
