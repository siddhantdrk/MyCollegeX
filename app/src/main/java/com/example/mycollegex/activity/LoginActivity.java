package com.example.mycollegex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycollegex.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextView mSignUpTextView;
    private ImageView mLogoImage;
    private MaterialButton mGoogleLoginButton,mSignInButton;
    private TextInputEditText mEmailLogin,mPasswordLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        mSignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        mSignUpTextView = (TextView)findViewById(R.id.signUp_txt);
        mLogoImage = (ImageView)findViewById(R.id.logo_image_view);
        mGoogleLoginButton = (MaterialButton)findViewById(R.id.google_login_btn);
        mSignInButton = (MaterialButton)findViewById(R.id.sign_in_btn);
        mEmailLogin = (TextInputEditText)findViewById(R.id.email_edit_text_login);
        mPasswordLogin = (TextInputEditText)findViewById(R.id.pass_edit_text_login);
    }
}