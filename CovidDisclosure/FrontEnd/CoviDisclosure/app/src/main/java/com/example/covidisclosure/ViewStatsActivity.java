package com.example.covidisclosure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);
    }

    public void gotoInAct(View view) {
        Intent initialChoice = new Intent(ViewStatsActivity.this, InitialChoiceActivity.class);
        startActivity(initialChoice);
    }
}