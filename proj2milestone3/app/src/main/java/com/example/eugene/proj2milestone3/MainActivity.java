package com.example.eugene.proj2milestone3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findClassInfo(View view){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("This is an alert with no consequence");
        dlgAlert.setTitle("App Title");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);


        switch (view.getId()) {

            case R.id.Mon8am:
            case R.id.Tue8am:
            case R.id.Wed8am:
            case R.id.Thu8am:
            case R.id.Fri8am:
                dlgAlert.setMessage("Prof. X blah blah blah");
                dlgAlert.setTitle("Physics");
                break;
            default:
                break;
        }
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
