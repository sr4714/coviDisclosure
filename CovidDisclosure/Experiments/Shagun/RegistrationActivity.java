package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(validate()){
                //upload data to the database
            }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this, Activity.class))
            }
        });


    }

    private void setupUIViews(){
        userName=(EditText)findViewById(R.id.etUserName);
        userPassword=(EditText)findViewById(R.id.etUserPassword);
        userEmail=(EditText)findViewById(R.id.etUserEmail);
        regButton=(Button)findViewById(R.id.btnRegister);
        userLogin=(TextView)findViewById(R.id.tvUserLogin);
    }

    private Boolean validate(){
        Boolean result=false;

        String name=userName.getText().toString();
        String password= userPassword.getText().toString();
        String email=userEmail.getText().toString();
        if(name.isEmpty() && password.isEmpty() && email.isEmpty()){
            Toast.makeText(this,"PLease enter all details",Toast.LENGTH_SHORT).show();
        }
        else
            result=true;

        return result;

    }
}