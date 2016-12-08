package com.example.eugene.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class findShop extends AppCompatActivity {

    private String shopName;
    private String shopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_shop);


        Intent intent = getIntent();
        shopName = intent.getStringExtra("ShopName");
        shopURL = intent.getStringExtra("ShopURL");

        TextView messageView = (TextView) findViewById(R.id.textView2);
        messageView.setText("You should check out " + shopName);
    }
}
