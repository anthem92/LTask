package com.example.lawencon.expandablenew.personalDetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lawencon.expandablenew.MainActivity;
import com.example.lawencon.expandablenew.R;

public class create_personality extends AppCompatActivity {

    ImageButton imageBackToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_personality);

        imageBackToMainActivity = (ImageButton) findViewById(R.id.button_BackMainActivity);
        imageBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainFromCreatePersonality = new Intent(create_personality.this, MainActivity.class);
                startActivity(backToMainFromCreatePersonality);
                finish();
            }
        });
    }
}
