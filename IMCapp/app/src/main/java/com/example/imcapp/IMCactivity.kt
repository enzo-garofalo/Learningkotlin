package com.example.imcapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMCactivity : AppCompatActivity()
{
    lateinit var btnCalculateIMC : Button
    lateinit var tvResult: TextView
    lateinit var etWeight : EditText
    lateinit var etHeight : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        tvResult = findViewById(R.id.tvResult)
        btnCalculateIMC = findViewById(R.id.btnCalculate)

        btnCalculateIMC.setOnClickListener{
            val weight : Double = etWeight.text.toString().toDouble()
            val height : Double = etHeight.text.toString().toDouble()
            val imc = weight / (height*height)

            val message : String = "Your IMC is $imc"
            tvResult.setText(message)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}