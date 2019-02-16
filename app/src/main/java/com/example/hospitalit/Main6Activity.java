package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main6Activity extends AppCompatActivity {
Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    public void nearby(View view) {
      myintent=new Intent(this,Main7Activity.class);
      startActivity(myintent);
    }
}
