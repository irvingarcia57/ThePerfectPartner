package com.example.theperfectpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class ActivityAccountCreationHobbies extends AppCompatActivity {

    ArrayList<String> selection =new ArrayList<String>();
    //    TextView final_text;
    Button bt1_hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation_hobbies);

//        final_text =(TextView) findViewById(R.id.final_result);
//        final_text.setEnabled(false);
        bt1_hobbies = findViewById(R.id.bt1_hobbies);
        bt1_hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAccountCreationHobbies.this, ActivityAccountCreationColor.class));
                finish();
            }
        });


    }

    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.reading) {
            if (checked) {
                selection.add("@string/AC_reading");
            } else {
                selection.remove("@string/AC_reading");
            }
        }


        if (view.getId() == R.id.traveling) {
            if (checked) {
                selection.add("@string/AC_traveling");
            } else {
                selection.remove("@string/AC_traveling");
            }
        }


        if (view.getId() == R.id.fishing) {
            if (checked) {
                selection.add("@string/AC_fishing");
            } else {
                selection.remove("@string/AC_fishing");
            }
        }

        if (view.getId() == R.id.crafts) {
            if (checked) {
                selection.add("@string/AC_crafts");
            } else {
                selection.remove("@string/AC_crafts");
            }
        }

        if (view.getId() == R.id.television) {
            if (checked) {
                selection.add("@string/AC_television");
            } else {
                selection.remove("@string/AC_television");
            }
        }

        if (view.getId() == R.id.bird_watching) {
            if (checked) {
                selection.add("@string/AC_bird_watching");
            } else {
                selection.remove("@string/AC_bird_watching");
            }
        }

        if (view.getId() == R.id.collecting) {
            if (checked) {
                selection.add("@string/AC_collecting");
            } else {
                selection.remove("@string/AC_collecting");
            }
        }

        if (view.getId() == R.id.music) {
            if (checked) {
                selection.add("@string/AC_music");
            } else {
                selection.remove("@string/AC_music");
            }
        }

        if (view.getId() == R.id.video_games) {
            if (checked) {
                selection.add("@string/AC_video_games");
            } else {
                selection.remove("@string/AC_video_games");
            }
        }
        if (view.getId() == R.id.gardening) {
            if (checked) {
                selection.add("@string/AC_gardening");
            } else {
                selection.remove("@string/AC_gardening");
            }
        }
        if (view.getId() == R.id.cooking) {
            if (checked) {
                selection.add("@string/AC_cooking");
            } else {
                selection.remove("@string/AC_cooking");
            }
        }
        if (view.getId() == R.id.camping) {
            if (checked) {
                selection.add("@string/AC_camping");
            } else {
                selection.remove("@string/AC_camping");
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
