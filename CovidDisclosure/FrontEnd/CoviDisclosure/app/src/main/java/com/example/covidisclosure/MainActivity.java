package com.example.covidisclosure;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnJson, btnString, btnSubmit;
    private EditText inUsername;
    private String username;


    Button btn;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button_login);
        register = findViewById(R.id.textViewSignUp);



//        inUsername = (EditText) findViewById(R.id.editTextEmailAddressUser);
//
//        inUsername.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.length() > 0) {
//                    btnSubmit.setEnabled(true);
//                } else {
//                    btnSubmit.setEnabled(false);
//                }
//            }
//        }
    }


    //Create Buttons to move to next page
    public void gotoNext(View view) {
        Intent initialChoice = new Intent(MainActivity.this, InitialChoiceActivity.class);
        startActivity(initialChoice);
    }

    public void gotoSignUp(View view) {
        Intent signUp = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(signUp);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnSubmitUsername:
//                username = inUsername.getText().toString();
//                btnString.setEnabled(true);
//                btnJson.setEnabled(true);
//                break;
//            case R.id.btnStringRequest:
//                startActivity(new Intent(MainActivity.this,
//                        StringRequestActivity.class).putExtra("username",username));
//                break;
//            case R.id.btnJsonRequest:
//                startActivity(new Intent(MainActivity.this,
//                        JsonRequestActivity.class).putExtra("username",username));
//                break;
//            default:
//                break;
//       }
    }


}