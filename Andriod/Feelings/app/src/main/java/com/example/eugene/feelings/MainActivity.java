package com.example.eugene.feelings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findMood(View view) {
        // Get name
        EditText name = (EditText)findViewById(R.id.nameEditText);
        String nameValue = name.getText().toString();
        TextView feeling = (TextView)findViewById(R.id.feelingTextView);

        // Spinner
        Spinner moodSpinner = (Spinner)findViewById(R.id.spinner);
        String spinnerValue = String.valueOf(moodSpinner.getSelectedItem());
        // Toggle Button
        ToggleButton toggle = (ToggleButton)findViewById(R.id.toggleButton);
        boolean energy = toggle.isChecked();
        String energyText = "empty";
        if(energy) {
            energyText = " positive ";
        } else {
            energyText = " negative ";
        }
        // Switch button
        String meditate_text = "";
        Switch meditate = (Switch)findViewById(R.id.switch1);
        boolean meditate_button = meditate.isChecked();
        if(meditate_button){
            meditate_text = " meditates ";
        }
        // Radio button
        String radio_text = "";
        RadioGroup yoga = (RadioGroup)findViewById(R.id.radioGroup);
        int yoga_id = yoga.getCheckedRadioButtonId();
        switch (yoga_id){
            case -1:
                radio_text = "";
                break;
            case R.id.radioButton:
                radio_text = " Yin ";
                break;
            case R.id.radioButton2:
                radio_text = " Bikram ";
                break;
            case R.id.radioButton3:
                radio_text = " Hatha ";
                break;
            default:
                radio_text = "";
        }
        // Checkboxes
        String checkbox_text = "";
        CheckBox check1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox check3 = (CheckBox)findViewById(R.id.checkBox3);
        if(check1.isChecked()){
            checkbox_text += " sarcastic";
        }
        if(check3.isChecked()){
            checkbox_text += " conservative";
        }

        // Images
        ImageView moodImage = (ImageView)findViewById(R.id.imageView);
        moodImage.setImageResource(R.drawable.donut);

        // Rating bar
        RatingBar rate = (RatingBar)findViewById(R.id.ratingBar);
        int rateStar = rate.getNumStars();
        String rate_text = " " + String.valueOf(rateStar) + " star ";
        // Show Text
        feeling.setText(nameValue + " is a" + energyText + spinnerValue + rate_text + "person " + "that " + meditate_text + radio_text + checkbox_text);
    }
}
