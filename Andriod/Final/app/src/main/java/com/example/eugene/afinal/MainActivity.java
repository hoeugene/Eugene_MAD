package com.example.eugene.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get button
        final Button button = (Button) findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                genText(view);
            }
        };
        //add listener to the button
        button.setOnClickListener(onclick);

        //get button2
        final Button button2 = (Button) findViewById(R.id.button2);
        //create listener
        View.OnClickListener onclick2 = new View.OnClickListener(){
            public void onClick(View view){
                findShop(view);
            }
        };
        //add listener to the button2
        button2.setOnClickListener(onclick2);
    }

    public void genText (View view) {
        EditText treat = (EditText) findViewById(R.id.textfield);
        String treat_string = treat.getText().toString();

        String dairy_text = "";
        Switch dairy = (Switch) findViewById(R.id.switch1);
        boolean dairy_button = dairy.isChecked();
        if (dairy_button) {
            dairy_text = "dairy-free ";
        }

        Spinner flavorSpinner = (Spinner) findViewById(R.id.flavor);
        String spinnerValue = String.valueOf(flavorSpinner.getSelectedItem());

        ToggleButton toggle = (ToggleButton)findViewById(R.id.toggleButton);
        boolean check = toggle.isChecked();
        String toggleText = "";
        if(check) {
            toggleText = " cone ";
        } else {
            toggleText = " cup ";
        }


        String checkbox_text = "";
        CheckBox check1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox check2 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox check3 = (CheckBox)findViewById(R.id.checkBox3);
        if(check1.isChecked() || check2.isChecked() || check3.isChecked()){
            checkbox_text += " with";
        }
        if(check1.isChecked()){
            checkbox_text += " sprinkles";
        }
        if(check2.isChecked()){
            checkbox_text += " hot fudge";
        }
        if(check3.isChecked()){
            checkbox_text += " nuts";
        }

        String radio_text = "";
        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
        int id = rg.getCheckedRadioButtonId();
        switch (id){
            case -1:
                radio_text = "";
                break;
            case R.id.radioButton:
                radio_text = " ice cream ";
                break;
            case R.id.radioButton2:
                radio_text = " frozen yoghurt ";
                break;
            case R.id.radioButton3:
                radio_text = " gelato ";
                break;
            default:
                radio_text = "";
        }

        TextView output = (TextView) findViewById(R.id.treat_text);
        output.setText("My " + treat_string + " is a " + dairy_text + spinnerValue + radio_text + toggleText + checkbox_text);

        ImageView icecream_image = (ImageView) findViewById(R.id.imageView);
        System.out.println(spinnerValue);
        switch (spinnerValue) {
            case "death by chocolate":
                icecream_image.setImageResource(R.drawable.chocolate);
                break;
            case "salted caramel":
                icecream_image.setImageResource(R.drawable.caramel);
                break;
            case "cookies and cream":
                icecream_image.setImageResource(R.drawable.cookiescream);
                break;
            default:
                break;
        }

    }

    public void findShop (View view) {
        Spinner flavorSpinner = (Spinner) findViewById(R.id.flavor);
        String spinnerValue = String.valueOf(flavorSpinner.getSelectedItem());

        String shopName = "";
        String shopURL = "";
        switch (spinnerValue) {
            case "death by chocolate":
                shopName = "Glacier";
                shopURL = "http://www.glaciericecream.com/";
                break;
            case "salted caramel":
                shopName = "Fior di Latte";
                shopURL = "http://fiordilattegelato.com/";
                break;
            case "cookies and cream":
                shopName = "Sweet Cow";
                shopURL = "http://www.sweetcowicecream.com/";
                break;
            default:
                break;
        }
        // Create Intent
        Intent intent = new Intent(this, findShop.class);
        // Pass data
        intent.putExtra("ShopName", shopName);
        intent.putExtra("ShopURL", shopURL);
        // Start Intent
        startActivity(intent);
    }
}
