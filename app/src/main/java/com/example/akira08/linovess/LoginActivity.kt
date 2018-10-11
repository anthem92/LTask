package com.example.akira08.linovess

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun validateUser(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
