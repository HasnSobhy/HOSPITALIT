package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {
Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void back2(View view) {
        myintent=new Intent(this,Main4Activity.class);
        startActivity(myintent);
    }

    public void start(View view) {
        myintent=new Intent(this,Main6Activity.class);
        startActivity(myintent);
    }
}
