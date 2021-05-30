package com.example.e_voting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {

    TextInputEditText e_mail;
    TextInputEditText pass_word;
    Button login_btn;
    Button go_to_signUp;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_user_login);

        e_mail = findViewById(R.id.email);
        pass_word = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);
        go_to_signUp = findViewById(R.id.go_to_Register);

        fAuth = FirebaseAuth.getInstance();


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e_mail.getText().toString().trim();
                String password = pass_word.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    e_mail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    pass_word.setError("Email is required");
                    return;
                }

                if(password.length() < 6){
                    pass_word.setError("Password is too short");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UserLogin.this, "Loged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), UserDashBoard.class));
                        }
                        else {
                            Toast.makeText(UserLogin.this, "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        go_to_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, User_SignUp.class);
                startActivity(intent);
            }
        });

    }




}