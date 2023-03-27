package com.natansin.doguinhos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashScreendoguinho : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screendoguinho)


        // criamos uma intencao onde iremos inflar a mainactivity com delay
        Handler().postDelayed({
            val intencao = Intent(
                this,MainActivity::class.java)
            startActivity(intencao)
            finish()

        },3000)


    }





}