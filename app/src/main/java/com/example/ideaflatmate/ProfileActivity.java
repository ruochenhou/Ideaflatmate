package com.example.ideaflatmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmail = findViewById(R.id.tvEmail);
        tvEmail.setText(getIntent().getExtras().getString("Email"));
    }
}
