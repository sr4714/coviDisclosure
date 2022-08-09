package com.example.covidisclosure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubmitStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_stats);
    }

    public void gotoIA(View view) {
        Intent initialChoice = new Intent(SubmitStatsActivity.this, InitialChoiceActivity.class);
        startActivity(initialChoice);
    }

    public void gotoVStats(View view) {
        Intent initialChoice = new Intent(SubmitStatsActivity.this, ViewStatsActivity.class);
        startActivity(initialChoice);
    }
}