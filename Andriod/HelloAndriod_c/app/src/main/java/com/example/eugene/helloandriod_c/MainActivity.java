package com.example.eugene.helloandriod_c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayBoo(View view){
        TextView bootext = (TextView)findViewById(R.id.message);
        EditText username = (EditText)findViewById(R.id.editText);
        String nameVal = username.getText().toString();
        bootext.setText("Happy Halloween " + nameVal + "!");
        ImageView donut = (ImageView)findViewById(R.id.imageView);
        donut.setImageResource(R.drawable.donut);
    }
}
