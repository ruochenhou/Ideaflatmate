package com.example.ideaflatmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText txtEmailSignup;
    private EditText txtPasswordSignup;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtEmailSignup = findViewById(R.id.txtEmailSignup);
        txtPasswordSignup = findViewById(R.id.txtPasswordSignup);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void btnUserSignup_Click(View v){

        final ProgressDialog progressDialog = ProgressDialog.show(SignupActivity.this, "Please waiting...", "Processing...",true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailSignup.getText().toString(),txtPasswordSignup.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent (SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                }
                else
                {
                    Log.e("ERROR",task.getException().toString());
                    Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
