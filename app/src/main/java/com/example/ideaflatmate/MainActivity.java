package com.example.ideaflatmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Login = (Button) findViewById(R.id.LoginButton);

//login button go to next page
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLoginPage = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(toLoginPage);
            }
        });

//sign-up button go to next page
        Button SignUp = (Button) findViewById(R.id.SignupButton);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignUp = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(toSignUp);
            }
        });


    }
}
