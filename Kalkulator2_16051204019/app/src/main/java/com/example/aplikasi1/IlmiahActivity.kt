package com.example.aplikasi1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_ilmiah.*
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator

class IlmiahActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilmiah)

        //numbers
        tbSatu.setOnClickListener { appendOnExpresstion("1",true) }
        tbDua.setOnClickListener { appendOnExpresstion("2",true) }
        tbTiga.setOnClickListener { appendOnExpresstion("3",true) }
        tbEmpat.setOnClickListener { appendOnExpresstion("4",true) }
        tbLima.setOnClickListener { appendOnExpresstion("5",true) }
        tbEnam.setOnClickListener { appendOnExpresstion("6",true) }
        tbTujuh.setOnClickListener { appendOnExpresstion("7",true) }
        tbDelapan.setOnClickListener { appendOnExpresstion("8",true) }
        tbSembilan.setOnClickListener { appendOnExpresstion("9",true) }
        tbNol.setOnClickListener { appendOnExpresstion("0",true) }
        tbKoma.setOnClickListener { appendOnExpresstion(".",true) }

        //operator
        tbTambah.setOnClickListener { appendOnExpresstion("+", false)}
        tbKurang.setOnClickListener { appendOnExpresstion("-", false)}
        tbKali.setOnClickListener { appendOnExpresstion("x", false)}
        tbBagi.setOnClickListener { appendOnExpresstion("/", false)}
        tbOpen.setOnClickListener { appendOnExpresstion("(", false)}
        tbClear.setOnClickListener { appendOnExpresstion(")", false)}
        tbSin.setOnClickListener{ appendOnExpresstion("sin", false)}
        tbCos.setOnClickListener{ appendOnExpresstion("cos", false)}
        tbTan.setOnClickListener{ appendOnExpresstion("tan", false)}
        tbLn.setOnClickListener{ appendOnExpresstion("^", true)}
        tbLog.setOnClickListener{ appendOnExpresstion("log", false)}

        tbClear.setOnClickListener {
            AngkaMasuk.text = ""
            Hasil.text = ""
        }

        tbBack.setOnClickListener {
            val string = AngkaMasuk.text.toString()
            if(string.isNotEmpty()){
                AngkaMasuk.text = string.substring(0,string.length-1)
            }
            Hasil.text = ""
        }

        tbSamadengan.setOnClickListener {
            try {

                val expression = ExpressionBuilder(AngkaMasuk.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    Hasil.text = longResult.toString()
                else
                    Hasil.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }
    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(Hasil.text.isNotEmpty()){
            AngkaMasuk.text = ""
        }

        if (canClear) {
            Hasil.text = ""
            AngkaMasuk.append(string)
        } else {
            AngkaMasuk.append(Hasil.text)
            AngkaMasuk.append(string)
            Hasil.text = ""
        }
    }
}