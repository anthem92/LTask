package com.example.lawencon.expandablenew.personalDetail;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lawencon.expandablenew.MainActivity;
import com.example.lawencon.expandablenew.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class create_document extends AppCompatActivity {

    ImageButton imageBackToMainActivity;
    ImageView expiredDateCalendar;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;
    TextView tvExpDate_Document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_document);

        imageBackToMainActivity = (ImageButton) findViewById(R.id.button_BackMainActivity);
        imageBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainFromCreateDocument = new Intent(create_document.this, MainActivity.class);
                startActivity(backToMainFromCreateDocument);
                finish();
            }
        });

        //below code for the Calendar
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvExpDate_Document = (TextView) findViewById(R.id.tv_expDate_Document);

        expiredDateCalendar = (ImageView) findViewById(R.id.ExpiredDateCalendar);
        expiredDateCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog_ExpDateCreateDocument();
            }
        });

    }

    private void showDateDialog_ExpDateCreateDocument(){

        Calendar newCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);

                    tvExpDate_Document.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        // to show the datePicker
        datePickerDialog.show();
    }
}
