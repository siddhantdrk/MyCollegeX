package com.example.mycollegex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycollegex.R;
import com.google.android.material.button.MaterialButton;

public class WelcomeActivity extends AppCompatActivity {
    private MaterialButton mRegisterButton,mLoginButton;
    private TextView mAboutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();

//        mAboutApp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent signUpIntent = new Intent(WelcomeActivity.this,AboutAppActivity.class);
//                startActivity(signUpIntent);
//            }
//        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(WelcomeActivity.this,SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(signUpIntent);
            }
        });

    }

    private void initViews() {
        mAboutApp=(TextView)findViewById(R.id.about_app_textView);
        mRegisterButton =(MaterialButton)findViewById(R.id.login_register_btn);
        mLoginButton = (MaterialButton)findViewById(R.id.login_btn);
    }
}