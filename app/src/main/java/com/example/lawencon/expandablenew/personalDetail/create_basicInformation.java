package com.example.lawencon.expandablenew.personalDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lawencon.expandablenew.MainActivity;
import com.example.lawencon.expandablenew.R;

import java.util.ArrayList;
import java.util.List;

public class create_basicInformation extends AppCompatActivity{

    ImageButton imageBackToMainActivity;
    RadioGroup radioGroup;
    RadioButton radioButton;

    //Spinner spinnerReligion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_basic_information);

        imageBackToMainActivity = (ImageButton) findViewById(R.id.button_BackMainActivity);
        radioGroup = (RadioGroup) findViewById(R.id.radio_gender);

        imageBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainFromCreateBInf = new Intent(create_basicInformation.this, MainActivity.class);
                startActivity(backToMainFromCreateBInf);
                finish();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                //if (checkedId == R.id.radio_male) {
                    //radioButton.setText("Male");
                    //set male
                //} else if (checkedId == R.id.radio_female) {
                    //set female
                //}
            }

        });

//        spinnerReligion = (Spinner) findViewById(R.id.spinnerReligion);
//        spinnerReligion.setOnItemSelectedListener(this);
//
//        List<String> religions = new ArrayList<String>();
//        religions.add("ISLAM");
//        religions.add("KRISTEN KATOLIK");
//        religions.add("KRISTEN PROTESTAN");
//        religions.add("HINDU");
//        religions.add("BUDDHA");
//        religions.add("dll");
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, religions);
//
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinnerReligion.setAdapter(dataAdapter);
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        // On selecting a spinner item
//        String item = parent.getItemAtPosition(position).toString();
//
//        // Showing selected spinner item
//        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//    }
//    public void onNothingSelected(AdapterView<?> arg0) {
//        // TODO Auto-generated method stub
//    }



}
