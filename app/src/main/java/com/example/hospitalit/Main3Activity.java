package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void next(View view) {
        myintent=new Intent(this,Main4Activity.class);
        startActivity(myintent);
    }

    public void skip(View view) {
        myintent=new Intent(this,Main6Activity.class);
        startActivity(myintent);
    }
}
