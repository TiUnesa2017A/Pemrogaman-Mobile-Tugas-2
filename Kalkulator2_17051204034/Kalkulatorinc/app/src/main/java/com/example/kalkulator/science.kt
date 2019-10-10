package com.example.kalkulator


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.science.*
import net.objecthunter.exp4j.ExpressionBuilder

class science : common() {
    private lateinit var tombolBiasa : Button
    private lateinit var tombolProgrammer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.science)

        tombolBiasa = findViewById(R.id.biasa)
        tombolProgrammer = findViewById(R.id.programmer)

        tombolProgrammer.setOnClickListener {
            startActivity(Intent(this, com.example.kalkulator.programmer::class.java))
            finish()
        }
        tombolBiasa.setOnClickListener {
            startActivity(Intent(this, common::class.java))
            finish()
        }

        Satu.setOnClickListener { appendOnOperasi("1", true) }
        Dua.setOnClickListener { appendOnOperasi("2", true) }
        Tiga.setOnClickListener { appendOnOperasi("3", true) }
        Empat.setOnClickListener { appendOnOperasi("4", true) }
        Lima.setOnClickListener { appendOnOperasi("5", true) }
        Enam.setOnClickListener { appendOnOperasi("6", true) }
        Tujuh.setOnClickListener { appendOnOperasi("7", true) }
        Delapan.setOnClickListener { appendOnOperasi("8", true) }
        Sembilan.setOnClickListener { appendOnOperasi("9", true) }
        Nol.setOnClickListener { appendOnOperasi("0", true) }
        Koma.setOnClickListener { aturanPenulisan(".", true) }

        Tambah.setOnClickListener { aturanPenulisan("+", false) }
        Kurang.setOnClickListener { aturanPenulisan("-", false) }
        Kali.setOnClickListener { aturanPenulisan("*", false) }
        Bagi.setOnClickListener { aturanPenulisan("/", false) }
        Open.setOnClickListener { appendOnOperasi("(", false) }
        Close.setOnClickListener { appendOnOperasi(")", false) }
        Sin.setOnClickListener{ appendOnOperasi("sin", false)}
        Cos.setOnClickListener{ appendOnOperasi("cos", false)}
        Tan.setOnClickListener{ appendOnOperasi("tan", false)}
        Lg.setOnClickListener{ appendOnOperasi("log", false)}
        Pangkat.setOnClickListener{ aturanPenulisan("^", false)}

        Clear.setOnClickListener {
            tvHasil.text = ""
            tvOperasi.text = ""
        }
        BS.setOnClickListener {
            val string = tvOperasi.text.toString()
            if (string.isNotEmpty()) {
                tvOperasi.text = string.substring(0, string.length - 1)

            }
            tvHasil.text = ""

        }
        SD.setOnClickListener {
            try {
                val operasi = ExpressionBuilder(tvOperasi.text.toString()).build()
                val hasil = operasi.evaluate()
                val longHasil = hasil.toLong()
                if (hasil == longHasil.toDouble())
                    tvHasil.text = longHasil.toString()
                else
                    tvHasil.text = hasil.toString()

            } catch (e: Exception) {
                Log.d("Exception", " message" + e.message)
            }
        }

    }



    override fun finish() {
        super.finish()
    }
}