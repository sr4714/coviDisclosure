package com.example.covidisclosure;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button_login);
        register = findViewById(R.id.textView_signup);


        //take in username and password (store somewhere? springboard)
        //
    }

    public void gotoNext(View view) {
        Intent initialChoice = new Intent(MainActivity.this, InitialChoiceActivity.class);
        startActivity(initialChoice);
    }

    //sign up page
    public void gotoSignUp(View view) {
        Intent signUp = new Intent(MainActivity.this, InitialChoiceActivity.class);
        startActivity(signUp);
    }
}