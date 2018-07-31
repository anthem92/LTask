package com.example.lawencon.expandablenew.personalDetail;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lawencon.expandablenew.MainActivity;
import com.example.lawencon.expandablenew.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class create_familyMember extends AppCompatActivity {

    ImageButton imageBackToMainActivity;

    ImageView birthDateCalendar;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;
    TextView tvBirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_family_member);

        imageBackToMainActivity = (ImageButton) findViewById(R.id.button_BackMainActivity);
        imageBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainFromFamilyMember = new Intent(create_familyMember.this, MainActivity.class);
                startActivity(backToMainFromFamilyMember);
                finish();
            }
        });

        //below code for the Calendar
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvBirthDate = (TextView) findViewById(R.id.tv_birthDate);

        birthDateCalendar = (ImageView) findViewById(R.id.BirthDateCalendar);
        birthDateCalendar.setOnClickListener(new View.OnClickListener() {
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

                tvBirthDate.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        // to show the datePicker
        datePickerDialog.show();
    }

}
