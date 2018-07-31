package com.example.lawencon.expandablenew;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lawencon.expandablenew.event.Event;
import com.example.lawencon.expandablenew.timesheet.TimeSheet;

public class Splashscreen extends AppCompatActivity {

    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Splashscreen.this, MainActivity.class));
                //startActivity(new Intent(Splashscreen.this, TimeSheet.class));
                //startActivity(new Intent(Splashscreen.this, Event.class));

                finish();
            }
        }, splashInterval);

    }
}