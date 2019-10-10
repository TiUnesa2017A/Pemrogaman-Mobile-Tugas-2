package com.example.kalkulator


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import net.objecthunter.exp4j.ExpressionBuilder

class Main2Activity : AppCompatActivity() {
    private lateinit var tombolBiasa : Button
    private lateinit var tombolProgrammer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(titleBar2)

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

    fun aturanPenulisan(string: String, cekKoma: Boolean) {
        if (tvOperasi.text.toString().isNotEmpty()) {
            val cekstr = tvOperasi.text.toString().substring(tvOperasi.text.toString().length - 1)
            if (cekKoma) {
                if (cekstr == "+" || cekstr == "-" || cekstr == "*" || cekstr == "/" || cekstr == "^") {
                    appendOnOperasi("0" + string, true)
                } else if (cekstr != ".")
                    appendOnOperasi(string, true)
            } else {
                if (cekstr == "+" || cekstr == "-" || cekstr == "*" || cekstr == "/" || cekstr == "^") {
                    tvOperasi.text =
                        tvOperasi.text.toString().substring(0, tvOperasi.text.toString().length - 1)
                    appendOnOperasi(string, false)
                } else if (cekstr == ".") {
                    appendOnOperasi("0" + string, false)
                } else
                    appendOnOperasi(string, false)
            }

        } else {
            if (cekKoma)
                appendOnOperasi("0" + string, true)
            else
                appendOnOperasi("0" + string, false)
        }
    }

    open fun appendOnOperasi(string: String, canClear: Boolean) {
        if (tvHasil.text.isNotEmpty()) {
            tvOperasi.text = ""
        }
        if (canClear) {
            tvHasil.text = ""
            tvOperasi.append(string)
        } else {
            tvOperasi.append(tvHasil.text)
            tvOperasi.append(string)
            tvHasil.text = ""
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem)= when (item.itemId) {
        R.id.menuStandart -> {
            val intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
            Toast.makeText(this, "Calculator Standart", Toast.LENGTH_LONG).show()
            true
        } R.id.menuScience -> {
            Toast.makeText(this, "Calculator Science", Toast.LENGTH_LONG).show()
            true
        } R.id.menuProgrammer -> {
            val intent = Intent(this, Main3Activity::class.java)
            finish()
            startActivity(intent)
            Toast.makeText(this, "Calculator Programmer", Toast.LENGTH_LONG).show()
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}