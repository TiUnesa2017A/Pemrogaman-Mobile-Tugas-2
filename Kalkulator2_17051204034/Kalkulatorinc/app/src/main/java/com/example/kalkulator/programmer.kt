package com.example.kalkulator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.programmer.*
import net.objecthunter.exp4j.ExpressionBuilder

open class programmer :common() {
    private lateinit var tombolScience : Button
    private lateinit var tombolBiasa: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.programmer)
        tombolScience = findViewById(R.id.science)
        tombolBiasa = findViewById(R.id.biasa)

        tombolBiasa.setOnClickListener {
            startActivity(Intent(this, common::class.java))
            finish()
        }
        tombolScience.setOnClickListener {
            startActivity(Intent(this, com.example.kalkulator.science::class.java))
            finish()
        }


        one.setOnClickListener { appendOnOperasi("1") }
        two.setOnClickListener { appendOnOperasi("2") }
        three.setOnClickListener { appendOnOperasi("3") }
        four.setOnClickListener { appendOnOperasi("4") }
        five.setOnClickListener { appendOnOperasi("5") }
        six.setOnClickListener { appendOnOperasi("6") }
        seven.setOnClickListener { appendOnOperasi("7") }
        eight.setOnClickListener { appendOnOperasi("8") }
        nine.setOnClickListener { appendOnOperasi("9") }
        zero.setOnClickListener { appendOnOperasi("0") }

        cl.setOnClickListener {
            tvOperasi.text = ""
            Oktal.text = ""
            Biner.text = ""
            Hexa.text = ""
        }
        backs.setOnClickListener {
            val string = tvOperasi.text.toString()
            if (string.isNotEmpty()) {
                tvOperasi.text = string.substring(0, string.length - 1)
            }
            Oktal.text = ""
            Biner.text = ""
            Hexa.text = ""

        }

    }


    fun decimalToHexa(decimal: Int): String{
        var n = decimal
        var hexaNumber: String =""
        var remainder: Int

        while(n!=0) {
            remainder = n % 16
            n/=16
            when (remainder){
                0 -> hexaNumber+="0"
                1 -> hexaNumber+="1"
                2 -> hexaNumber+="2"
                3 -> hexaNumber+="3"
                4 -> hexaNumber+="4"
                5 -> hexaNumber+="5"
                6 -> hexaNumber+="6"
                7 -> hexaNumber+="7"
                8 -> hexaNumber+="8"
                9 -> hexaNumber+="9"
                10 -> hexaNumber+="A"
                11 -> hexaNumber+="B"
                12 -> hexaNumber+="C"
                13 -> hexaNumber+="D"
                14 -> hexaNumber+="E"
                15 -> hexaNumber+="F"
            }
        }
        return hexaNumber
    }

    fun decimalToOktal(decimal: Int): String{
        var n = decimal
        var oktalNumber: String = ""
        var remainder: Int
        var i = 1
        var step = 1

        while(n!=0) {
            remainder = n % 8
            n/=8
            when(remainder){
                0 -> oktalNumber+="0"
                1 -> oktalNumber+="1"
                2 -> oktalNumber+="2"
                3 -> oktalNumber+="3"
                4 -> oktalNumber+="4"
                5 -> oktalNumber+="5"
                6 -> oktalNumber+="6"
                7 -> oktalNumber+="7"
            }
        }
        return oktalNumber
    }
    fun decimalToBiner(decimal: Int): String{
        var n = decimal
        var binaryNumber: String = ""
        var remainder: Int
        var i = 1
        var step = 1

        while(n!=0) {
            remainder = n % 2
            n/=2
            when(remainder){
                0 -> binaryNumber+="0"
                1 -> binaryNumber+="1"
            }
        }
        return binaryNumber
    }

    fun appendOnOperasi(string: String) {
            tvOperasi.append(string)
            Biner.text = decimalToBiner(tvOperasi.text.toString().toInt()).reversed()
            Oktal.text = decimalToOktal(tvOperasi.text.toString().toInt()).reversed()
            Hexa.text = decimalToHexa(tvOperasi.text.toString().toInt()).reversed()
    }

    override fun finish() {
        super.finish()
    }
}