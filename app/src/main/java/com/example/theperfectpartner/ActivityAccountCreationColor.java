package com.example.theperfectpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class ActivityAccountCreationColor extends AppCompatActivity {

        ArrayList<String> selection = new ArrayList<String>();
        //    TextView final_text;
        Button bt1_color;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_account_creation_color);

//        final_text =(TextView) findViewById(R.id.final_result);
//        final_text.setEnabled(false);
            bt1_color = findViewById(R.id.bt1_color);
            bt1_color.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(com.example.theperfectpartner.ActivityAccountCreationColor.this, ActivityHome.class));
                    finish();
                }
            });


        }

        public void selectItem(View view) {
            boolean checked = ((CheckBox) view).isChecked();

            if (view.getId() == R.id.blue) {
                if (checked) {
                    selection.add("@string/AC_blue");
                } else {
                    selection.remove("@string/AC_blue");
                }
            }


            if (view.getId() == R.id.red) {
                if (checked) {
                    selection.add("@string/AC_red");
                } else {
                    selection.remove("@string/AC_red");
                }
            }


            if (view.getId() == R.id.green) {
                if (checked) {
                    selection.add("@string/AC_green");
                } else {
                    selection.remove("@string/AC_green");
                }
            }

            if (view.getId() == R.id.yellow) {
                if (checked) {
                    selection.add("@string/AC_yellow");
                } else {
                    selection.remove("@string/AC_yellow");
                }
            }

            if (view.getId() == R.id.orange) {
                if (checked) {
                    selection.add("@string/AC_orange");
                } else {
                    selection.remove("@string/AC_orange");
                }
            }

            if (view.getId() == R.id.black) {
                if (checked) {
                    selection.add("@string/AC_black");
                } else {
                    selection.remove("@string/AC_black");
                }
            }

            if (view.getId() == R.id.purple) {
                if (checked) {
                    selection.add("@string/AC_purple");
                } else {
                    selection.remove("@string/AC_purple");
                }
            }

            if (view.getId() == R.id.cyan) {
                if (checked) {
                    selection.add("@string/AC_cyan");
                } else {
                    selection.remove("@string/AC_cyan");
                }
            }

            if (view.getId() == R.id.pink) {
                if (checked) {
                    selection.add("@string/AC_pink");
                } else {
                    selection.remove("@string/AC_pink");
                }
            }
            if (view.getId() == R.id.magenta) {
                if (checked) {
                    selection.add("@string/AC_magenta");
                } else {
                    selection.remove("@string/AC_magenta");
                }
            }
            if (view.getId() == R.id.white) {
                if (checked) {
                    selection.add("@string/AC_white");
                } else {
                    selection.remove("@string/AC_white");
                }
            }
            if (view.getId() == R.id.gray) {
                if (checked) {
                    selection.add("@string/AC_gray");
                } else {
                    selection.remove("@string/AC_gray");
                }
            }

        }

        public void finalSelection(View view) {
            String final_food_selection = "";

            for (String Selections : selection) {
                final_food_selection = final_food_selection + Selections + "\n";
            }

//        final_text.setText(final_food_selection);
//        final_text.setEnabled(true);


        }


    }
