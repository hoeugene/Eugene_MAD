package com.example.eugene.lab8coffee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReceiveCoffeeActivity extends AppCompatActivity {

    private String shopName;
    private String shopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_coffee);

        Intent intent = getIntent();
        shopName = intent.getStringExtra("coffeeShopName");
        shopURL = intent.getStringExtra("coffeeShopURL");

        TextView messageView = (TextView) findViewById(R.id.coffeeShopTextView);
        messageView.setText("Check out " + shopName);

        final ImageButton ImgButton = (ImageButton) findViewById(R.id.imageButton);
        View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                loadWebsite(view);
            }
        };
        ImgButton.setOnClickListener(onclick);
    }

    private void loadWebsite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(shopURL));
        startActivity(intent);
    }
}
