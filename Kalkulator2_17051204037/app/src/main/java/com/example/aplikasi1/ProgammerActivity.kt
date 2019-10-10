package com.example.aplikasi1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_progammer.*
import kotlin.text.clear

class ProgammerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progammer)

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
        }
        else{
            dispFirst.append(x)
            val y = dispFirst.text.toString().toInt()
            dispSecond.text = toBinary(y)
        }
    }

    fun pow(base: Int, exponent: Int) = Math.pow(base.toDouble(), exponent.toDouble()).toInt()

    fun toBinary(decimalNumber: Int, binaryString: String = "") : String {
        while (decimalNumber > 0) {
            val temp = "${binaryString}${decimalNumber%2}"
            return toBinary(decimalNumber/2, temp)
        }
        return binaryString.reversed()
    }
}