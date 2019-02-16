package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {
Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void back1(View view) {
        myintent=new Intent(this,Main3Activity.class);
        startActivity(myintent);
    }

    public void next1(View view) {
        myintent=new Intent(this,Main5Activity.class);
        startActivity(myintent);
    }
}
