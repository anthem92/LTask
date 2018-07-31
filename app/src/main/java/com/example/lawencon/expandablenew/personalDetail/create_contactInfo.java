package com.example.lawencon.expandablenew.personalDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lawencon.expandablenew.MainActivity;
import com.example.lawencon.expandablenew.R;

public class create_contactInfo extends AppCompatActivity {

    ImageButton imageBackToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_info);

        imageBackToMainActivity = (ImageButton) findViewById(R.id.button_BackMainActivity);
        imageBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainFromCreateContactInf = new Intent(create_contactInfo.this, MainActivity.class);
                startActivity(backToMainFromCreateContactInf);
                finish();
            }
        });
    }
}
