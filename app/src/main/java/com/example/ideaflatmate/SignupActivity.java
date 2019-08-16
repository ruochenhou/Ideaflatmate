package com.example.ideaflatmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText UEmail, Upassword, ConfirmPassword, UserName;
    private Button SignUpButton;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private String name, email, password, confrimPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();



        UserName = findViewById(R.id.UserNameEditTextSignPage);
        UEmail = findViewById(R.id.EmailEditTextLoginSignPage);
        Upassword = findViewById(R.id.PasswordEditTextSignPage);
        ConfirmPassword = findViewById(R.id.Conpassword);
        SignUpButton = findViewById(R.id.SignUpButtonSignPage);


        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = UserName.getText().toString();
                email = UEmail.getText().toString();
                password = Upassword.getText().toString();
                confrimPassword = ConfirmPassword.getText().toString();
                if (name.isEmpty()|| email.isEmpty()||password.isEmpty())
                {
                    Toast.makeText(SignupActivity.this,"Please fill up all the entries"
                    , Toast.LENGTH_SHORT).show();
                }else
                    if (password.equals(confrimPassword))
                    {
                        mAuth.createUserWithEmailAndPassword(email,password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful())
                                        {
                                            //send data to database
                                            mReference = mDatabase.getReference(mAuth.getUid());
                                            UserProfile userProfile = new UserProfile(name,email);
                                            mReference.setValue(userProfile);
                                            Toast.makeText(SignupActivity.this,"sign up successful"
                                                    , Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });


                    }else {

                        Toast.makeText(SignupActivity.this,"Both password should be same"
                                , Toast.LENGTH_SHORT).show();
                    }








            }
        });




    }
}
