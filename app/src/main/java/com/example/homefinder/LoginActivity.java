package com.example.homefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.loginTextView)
    TextView mLoginTextView;
    @BindView(R.id.userNameEditText)
    EditText mUserNameEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.loginButton)
    MaterialButton mLoginButton;
    @BindView(R.id.others) TextView mOthers;
    @BindView(R.id.forgotpass) TextView mForgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Binding views
        ButterKnife.bind(this);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUserNameEditText.getText().toString().equals("admin") && mPasswordEditText.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
                }else{
                    // Incorrect
                    Toast.makeText(LoginActivity.this,"LOGIN FAILED",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(LoginActivity.this, LocationActivity.class);
                startActivity(intent);
            }
        });
    }
}