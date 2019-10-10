package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Math
import kotlinx.android.synthetic.main.biner.*

open class biner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biner)

        nol.setOnClickListener{clik("0")}
        one.setOnClickListener{clik("1")}
        two.setOnClickListener{clik("2")}
        three.setOnClickListener{clik("3")}
        four.setOnClickListener{clik("4")}
        five.setOnClickListener{clik("5")}
        six.setOnClickListener{clik("6")}
        seven.setOnClickListener{clik("7")}
        eight.setOnClickListener{clik("8")}
        nine.setOnClickListener{clik("9")}
        clear.setOnClickListener {
            dispFirst.text = ""
            dispSecond.text = ""
        }

        back.setOnClickListener {
            val string = dispFirst.text.toString()
            if(string.isNotEmpty()) {
                dispFirst.text = string.substring(0, string.length - 1)
                val y = dispFirst.text.toString()
                if(y.isNotEmpty()){
                    dispSecond.text = toBinary(y.toInt())
                    dispSecond.text = toOctal(y.toInt())
                    dispSecond.text = toHex(y.toInt())
                }
                else{
                    dispSecond.text = ""
                }
            }
        }
    }

    fun clik(x: String){
        if(dispSecond.text.toString().isNotEmpty()){
            dispSecond.text = ""
            dispFirst.append(x)
            val y = dispFirst.text.toString().toInt()
            dispSecond.text = toBinary(y)
            dispSecond.text = toOctal(y)
            dispSecond.text = toHex(y)
        }
        else{
            dispFirst.append(x)
            val y = dispFirst.text.toString().toInt()
            dispSecond.text = toBinary(y)
            dispSecond.text = toOctal(y)
            dispSecond.text = toHex(y)
        }
    }

    fun pow(base: Int, exponent: Int) = Math.pow(base.toDouble(), exponent.toDouble()).toInt()

//Decimal to biner function

    fun toBinary(decimalNumber: Int, binaryNumber: String="", n: Int) : Long {
        var decimalNumber = decimalNumber
        var new : Int
        var i = 1
        var step = 1

        while(decimalNumber != 0)
        {
            new = decimalNumber % 2
            new /= 2
            binaryNumber += (new * i).toLong()
            i *= 10
        }
        return binaryNumber
    }

//Decimal to octal function

    fun toOctal(decimalNumber: Int, octalNumber: String="", binaryNumber: Int) : Long{
        var i = 0
        var octalNumber = octalNumber
        var x = decimalNumber

        while (binaryNumber.toInt() != 0)
        {
            x += (binaryNumber % 10 * Math.pow(2.0, i.toDouble())).toInt()
            i++
            binaryNumber /= 10
        }
        i = 1
        while(x != 0) {
            octalNumber += x % 8 * i
            x /= 8
            i *= 10
        }
        return octalNumber
    }

//Decimal to hex function

    fun toHex(decimalNumber: Int, hexNumber: String="", binaryNumber: Int) : Long{
        var x = decimalNumber
        var hexNumber = hexNumber
        var new: int
        var i = 1
        var step = 1

        while (x != 0){
            new = x % 16
            x /= 16
            when(new) {
                0 -> hexNumber+="0"
                1 -> hexNumber+="1"
                2 -> hexNumber+="2"
                3 -> hexNumber+="3"
                4 -> hexNumber+="4"
                5 -> hexNumber+="5"
                6 -> hexNumber+="6"
                7 -> hexNumber+="7"
                8 -> hexNumber+="8"
                9 -> hexNumber+="9"
                10 -> hexNumber+="A"
                11 -> hexNumber+="B"
                12 -> hexNumber+="C"
                13 -> hexNumber+="D"
                14 -> hexNumber+="E"
                15 -> hexNumber+="F"
            }
        }
        return hexNumber
    }

}