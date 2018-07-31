package com.example.lawencon.expandablenew.personalDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lawencon.expandablenew.MainActivity;
import com.example.lawencon.expandablenew.R;

public class create_address extends AppCompatActivity {

    ImageButton imageBackToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_address);

        imageBackToMainActivity = (ImageButton) findViewById(R.id.button_BackMainActivity);
        imageBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainFromCreateAddress = new Intent(create_address.this, MainActivity.class);
                startActivity(backToMainFromCreateAddress);
                finish();
            }
        });
    }

//    @Override
//    public void onBackPressed(){
//        Intent intentBack = new Intent(create_address.this, MainActivity.class);
//        startActivity(intentBack);
//
////        finish();
//    }
}
