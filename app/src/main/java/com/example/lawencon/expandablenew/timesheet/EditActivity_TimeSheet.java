package com.example.lawencon.expandablenew.timesheet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lawencon.expandablenew.R;

public class EditActivity_TimeSheet extends AppCompatActivity {

    ImageButton imageBackToTimesheetViewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timesheet_editactivity);

        // Back to Timesheet ViewActivity from Timesheet AddActivity
        imageBackToTimesheetViewActivity = (ImageButton) findViewById(R.id.button_BacktoTimesheetViewActivity);
        imageBackToTimesheetViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBackToTimesheetViewActivity = new Intent(EditActivity_TimeSheet.this, ViewActivity_Timesheet.class);
                startActivity(intentBackToTimesheetViewActivity);
                finish();
            }
        });

    }
}
