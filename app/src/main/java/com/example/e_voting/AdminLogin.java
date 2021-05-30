package com.example.e_voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AdminLogin extends AppCompatActivity {

    TextInputEditText e_Mail;
    TextInputEditText pass_Word;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the status bar text color and icon is dark
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_admin_login);

        e_Mail = findViewById(R.id.eMail);
        pass_Word = findViewById(R.id.passWord);
        login_btn = findViewById(R.id.go);

        login_btn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                String admin_email = e_Mail.getText().toString();
                String admin_password = pass_Word.getText().toString();
                String mail = "vote";
                String pass = "firebase";

                if(TextUtils.isEmpty(admin_email)){
                    e_Mail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(admin_password)){
                    pass_Word.setError("Email is required");
                    return;
                }

                if(admin_password.length() < 6){
                    pass_Word.setError("Password is too short");
                    return;
                }

                if(admin_email.equals(mail.trim()) && admin_password.equals(pass.trim())){
                    Intent intent = new Intent(AdminLogin.this, Dash_Board.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AdminLogin.this, "Wrong E-mail or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}