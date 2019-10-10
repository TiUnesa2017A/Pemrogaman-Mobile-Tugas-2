package com.example.newcalculator

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.programmer.*

class Biner : Biasa() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.programmer)



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
        }
        backs.setOnClickListener {
            val string = tvOperasi.text.toString()
            if (string.isNotEmpty()) {
                tvOperasi.text = string.substring(0, string.length - 1)

            }

        }

    }

    fun toHex(decimal: Int):String{
        var n =decimal
        var HexNumber:String =""
        var remainder: Int
        var i=1
        var step=1

        while(n!=0){
            remainder=n%16
            n/=16
            when(remainder){
                0->HexNumber+="0"
                1->HexNumber+="1"
                2->HexNumber+="2"
                3->HexNumber+="3"
                4->HexNumber+="4"
                5->HexNumber+="5"
                6->HexNumber+="6"
                7->HexNumber+="7"
                8->HexNumber+="8"
                9->HexNumber+="9"
                10->HexNumber+="A"
                11->HexNumber+="B"
                12->HexNumber+="C"
                13->HexNumber+="D"
                14->HexNumber+="E"
                15->HexNumber+="F"
            }
        }
        return HexNumber
    }

    fun toOctal(decimal: Int): Int{
        var decimal=decimal
        var octalNumber=0
        var i=1
        while(decimal!=0){
            octalNumber+=decimal%8*i
            decimal/=8
            i*=8
        }
        return octalNumber
    }

    fun toBinary(n: Int): Long {
        var n = n
        var binaryNumber: Long=0
        var remainder:Int
        var i=1
        var step=1

        while(n!=0){
            remainder=n%2
            n/=2
            binaryNumber+=(remainder*i).toLong()
            i*=10
        }
        return binaryNumber
    }


    fun appendOnOperasi(string: String) {
        tvOperasi.append(string)
        Biner.text=toBinary(tvOperasi.text.toString().toInt()).toString()
        Oktal.text=toOctal(tvOperasi.text.toString().toInt()).toString()
        Hexa.text=toHex(tvOperasi.text.toString().toInt()).toString()
    }

    override fun finish() {
        super.finish()
    }
}