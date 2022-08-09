package com.example.myapplication1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {


    final int[] seconds = {0};
    final boolean[] running = new boolean[1];
    void runTimer()
    {

        final TextView resultText = findViewById(R.id.result);
        resultText.setText("00:00");
        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run() {
                int hours = seconds[0] / 3600;
                int minutes = (seconds[0] % 3600) / 60;
                int secs = seconds[0] % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text.
                resultText.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running[0]) {
                    seconds[0]++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button startButton = findViewById(R.id.start);
        final Button endButton = findViewById(R.id.stop);
        final Button resetButton = findViewById(R.id.reset);
       // TextView currentTime = findViewById(R.id.clock);
        // TextClock clock1 = null;

        // currentTime.setText(clock1.setFormat24Hour());


      //  final TextView resultText = findViewById(R.id.result);
       // resultText.setText("00:00");
        runTimer();
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running[0] = true;


            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                running[0] = false;
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running[0] = false;
                seconds[0] = 0;
            }
        });




    }
}