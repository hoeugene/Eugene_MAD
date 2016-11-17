package com.example.eugene.lab8coffee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class FindCoffeeActivity extends AppCompatActivity {

    private CoffeeShop myCoffeeShop = new CoffeeShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_coffee);

        //get button
        final Button button = (Button) findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findCoffee(view);
            }
        };
        //add listener to the button
        button.setOnClickListener(onclick);
    }

    public void findCoffee(View view) {
        Spinner shop = (Spinner)findViewById(R.id.spinner);
        Integer crowd = shop.getSelectedItemPosition();
        myCoffeeShop.setCoffeeShop(crowd);
        String shopName = myCoffeeShop.getShopName();
        String shopURL = myCoffeeShop.getShopURL();

        // Create Intent
        Intent intent = new Intent(this, ReceiveCoffeeActivity.class);
        // Pass data
        intent.putExtra("coffeeShopName", shopName);
        intent.putExtra("coffeeShopURL", shopURL);
        // Start Intent
        startActivity(intent);

    }
}
