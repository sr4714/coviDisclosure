package com.example.covidisclosure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InitialChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_choice);
    }

    public void gotoSubmitStats(View view) {
        Intent ss = new Intent(InitialChoiceActivity.this, SubmitStatsActivity.class);
        startActivity(ss);
    }

    public void gotoViewStats(View view) {
        Intent vs = new Intent(InitialChoiceActivity.this, ViewStatsActivity.class);
        startActivity(vs);
    }
}