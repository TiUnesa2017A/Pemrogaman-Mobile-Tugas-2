package com.example.Kalkulator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kalkulator.R
import kotlinx.android.synthetic.main.activity_biner.*

import kotlin.text.clear

open class biner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biner)

        tbNol.setOnClickListener{clik("0")}
        tbSatu.setOnClickListener{clik("1")}
        tbDua.setOnClickListener{clik("2")}
        tbTiga.setOnClickListener{clik("3")}
        tbEmpat.setOnClickListener{clik("4")}
        tbLima.setOnClickListener{clik("5")}
        tbEnam.setOnClickListener{clik("6")}
        tbTujuh.setOnClickListener{clik("7")}
        tbDelapan.setOnClickListener{clik("8")}
        tbSembilan.setOnClickListener{clik("9")}
        tbClear.setOnClickListener {
            AngkaMasuk.text = ""
            Hasil.text = ""
        }

        tbBack.setOnClickListener {
            val string = AngkaMasuk.text.toString()
            if(string.isNotEmpty()) {
                AngkaMasuk.text = string.substring(0, string.length - 1)
                val y = AngkaMasuk.text.toString()
                if(y.isNotEmpty()){
                    Hasil.text = toBinary(y.toInt())
                }
                else{
                    Hasil.text = ""
                }
            }
        }
    }

    fun clik(x: String){
        if(Hasil.text.toString().isNotEmpty()){
            Hasil.text = ""
            AngkaMasuk.append(x)
            val y = AngkaMasuk.text.toString().toInt()
            Hasil.text = toBinary(y)
        }
        else{
            AngkaMasuk.append(x)
            val y = AngkaMasuk.text.toString().toInt()
            Hasil.text = toBinary(y)
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