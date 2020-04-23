package com.example.theperfectpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


public class ActivityAccountCreationFood extends AppCompatActivity {

    ArrayList<String> selection =new ArrayList<String>();
//    TextView final_text;
    Button bt1_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation_food);

//        final_text =(TextView) findViewById(R.id.final_result);
//        final_text.setEnabled(false);
        bt1_food = findViewById(R.id.bt1_food);
        bt1_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityAccountCreationFood.this, ActivityAccountCreationMovie.class));
                finish();
            }
        });


    }

    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.japanese) {
            if (checked) {
                selection.add("@string/AC_japanese");
            } else {
                selection.remove("@string/AC_japanese");
            }
        }


        if (view.getId() == R.id.cajun) {
            if (checked) {
                selection.add("Cajun");
            } else {
                selection.remove("Cajun");
            }
        }


        if (view.getId() == R.id.german) {
            if (checked) {
                selection.add("German");
            } else {
                selection.remove("German");
            }
        }

        if (view.getId() == R.id.indian) {
            if (checked) {
                selection.add("Indian");
            } else {
                selection.remove("Indian");
            }
        }

        if (view.getId() == R.id.italian) {
            if (checked) {
                selection.add("Italian");
            } else {
                selection.remove("Italian");
            }
        }

        if (view.getId() == R.id.mediter) {
            if (checked) {
                selection.add("Mediterranean");
            } else {
                selection.remove("Mediterranean");
            }
        }

        if (view.getId() == R.id.mexican) {
            if (checked) {
                selection.add("Mexican");
            } else {
                selection.remove("Mexican");
            }
        }

        if (view.getId() == R.id.burgers) {
            if (checked) {
                selection.add("Burgers");
            } else {
                selection.remove("Burgers");
            }
        }

        if (view.getId() == R.id.tacos) {
            if (checked) {
                selection.add("Tacos");
            } else {
                selection.remove("Tacos");
            }
        }
        if (view.getId() == R.id.chinese) {
            if (checked) {
                selection.add("Tacos");
            } else {
                selection.remove("Tacos");
            }
        }
        if (view.getId() == R.id.greek) {
            if (checked) {
                selection.add("Tacos");
            } else {
                selection.remove("Tacos");
            }
        }
        if (view.getId() == R.id.thai) {
            if (checked) {
                selection.add("Tacos");
            } else {
                selection.remove("Tacos");
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
