package com.example.aplikasi1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var Btn_standar: Button
    private lateinit var Btn_ilmiah: Button
    private lateinit var Btn_progammer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btn_standar = findViewById(R.id.btn_standar)
        Btn_standar.setOnClickListener {
            startActivity(Intent(this, StandarActivity::class.java))
        }

        Btn_ilmiah = findViewById(R.id.btn_ilmiah)
        Btn_ilmiah.setOnClickListener {
            startActivity(Intent(this, IlmiahActivity::class.java))
        }

        Btn_progammer = findViewById(R.id.btn_progammer)
        Btn_progammer.setOnClickListener {
            startActivity(Intent(this, ProgammerActivity::class.java))
        }
    }
}