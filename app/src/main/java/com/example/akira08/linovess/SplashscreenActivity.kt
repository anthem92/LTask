package com.example.akira08.linovess

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.net.sip.SipErrorCode.TIME_OUT
import android.content.Intent
import android.os.Handler
import android.support.v4.os.HandlerCompat.postDelayed



class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed(Runnable {
            val i =  Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}
