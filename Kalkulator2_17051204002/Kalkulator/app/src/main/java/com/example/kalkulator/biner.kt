package com.example.kalkulator

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import kotlinx.android.synthetic.main.activity_biner.*


public class biner:science() {

    public String masuk,obiner,ooctal,ohexa;
    public int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText dob    =   (EditText) findViewById(R.id.input);
        final TextView biner  =   (TextView) findViewById(R.id.biner);
        final TextView octal  =   (TextView) findViewById(R.id.octal);
        final TextView hexa   =   (TextView) findViewById(R.id.hexa);
        Button convertbin  =   (Button) findViewById(R.id.convertbin);
        Button reset      =   (Button) findViewById(R.id.reset);
        Button convertokt  =   (Button) findViewById(R.id.convertokt);
        Button converthex  =   (Button) findViewById(R.id.converthex);


        convertbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispFirst   =   dispFirst.getText().toString();
                a       =   Integer.parseInt(masuk);
                obiner  =   Integer.toBinaryString(a);

                biner.setText("Biner\t\t\t\t\t\t\t: "+ obiner);

                dispSecond.setText("Hexadecimal \t : "+ ohexa);
            }
        });

        convertokt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispFirst   =   dispFirst.getText().toString();
                a       =   Integer.parseInt(masuk);

                ooctal  =   Integer.toOctalString(a);

                octal.setText("Octal\t\t\t\t\t\t\t: "+ ooctal);
                dispSecond.setText("Hexadecimal \t : "+ ohexa);
            }
        });

        converthex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispFirst   =   dispFirst.getText().toString();
                a       =   Integer.parseInt(masuk);

                ohexa   =   Integer.toHexString(a);

                dispSecond.setText("Hexadecimal \t : "+ ohexa);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dob.setText("0");
                biner.setText("Biner\t\t\t\t\t\t\t: ");
                octal.setText("Octal\t\t\t\t\t\t\t: ");
                hexa.setText("Hexadecimal \t : ");

            }
        });

    }
    //public void konversi()
    //{


    //}
}