package com.example.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.menu_awal.*

class menu_awal : AppCompatActivity(){
    private lateinit var button: ImageButton
    private lateinit var button1: ImageButton
    private lateinit var button2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_awal)
        button = findViewById(R.id.btn_standar)
        button1= findViewById(R.id.btn_science)
        button2= findViewById(R.id.btn_biner)
        button.setOnClickListener{
            startActivity(Intent(this, standar::class.java))
        }
        button1.setOnClickListener {
            startActivity(Intent(this, science::class.java))
        }
        button2.setOnClickListener {
            startActivity(Intent(this, biner::class.java))
        }
    }

}
