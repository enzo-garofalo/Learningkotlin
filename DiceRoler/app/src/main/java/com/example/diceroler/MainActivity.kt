package com.example.diceroler

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroler.ui.theme.DiceRolerTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            DiceRolerTheme {
//                DiceRolerApp()
//            }
//        }
//    }
//}
//@Preview
//@Composable
//fun DiceRolerApp()
//{
//    DiceWithButtonAndImage(modifier = Modifier)
//}
//
//@Composable
//fun DiceWithButtonAndImage(modifier : Modifier = Modifier)
//{
//    var result by remember { mutableStateOf(1) }
//    val imageResource = when( result ){
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Image(
//            painter = painterResource(imageResource),
//            contentDescription = result.toString()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = {
//            result = (1..6).random()
//        }){
//            Text(stringResource(R.string.roll))
//        }
//    }
//}

class IMCActivity : AppCompatActivity()
{
    lateinit var btnCalcularImc : Button
    lateinit var etPeso : EditText
    lateinit var etAltura : EditText
    lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Referencias e instaciar as VIEWS
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        btnCalcularImc = findViewById(R.id.btnCalcularIMC)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcularImc.setOnClickListener()
        {
            val imc = etPeso.text.toString().toDouble() / math.pow
        }



    }
}