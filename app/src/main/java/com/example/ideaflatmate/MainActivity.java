package com.example.ideaflatmate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btnLogin_Click(View v){
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
    public void btnSignup_Click(View v){
        Intent i = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(i);
    }




}
