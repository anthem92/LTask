package com.example.lawencon.expandablenew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lawencon.expandablenew.timesheet.AddActivity_TimeSheet;
import com.example.lawencon.expandablenew.timesheet.TimeSheet;
import com.example.lawencon.expandablenew.timesheet.ViewActivity_Timesheet;

public class Login extends Activity {

    EditText usernameEdit, passwordEdit;
    private Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdit = (EditText) findViewById(R.id.username_editText);
        passwordEdit = (EditText) findViewById(R.id.password_editText);
        signInButton = (Button) findViewById(R.id.button_SignIn);

        signInButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if( usernameEdit.getText().toString().equals("user1")
                        && passwordEdit.getText().toString().equals("123456")) {
                    Intent signIn_Intent = new Intent(Login.this, Splashscreen.class);
                    startActivity(signIn_Intent);

                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your correct username and password!",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}
