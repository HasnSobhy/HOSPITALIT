package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void signup(View view) {
        myintent=new Intent(this,Main2Activity.class);
        startActivity(myintent);
    }

    public void signinsubmit(View view) {
        myintent=new Intent(this,Main3Activity.class);
        startActivity(myintent);
    }
}
