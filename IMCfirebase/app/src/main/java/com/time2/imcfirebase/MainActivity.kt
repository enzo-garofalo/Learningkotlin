package com.time2.imcfirebase

import android.R.attr.onClick
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.firestore
import com.time2.imcfirebase.ui.theme.IMCfirebaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMCfirebaseTheme {
                IMCPreview()
            }
        }
    }
}

@Composable
fun IMCView(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var imcResult by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Calculate IMC",
            color = Color.Blue,
            fontSize = 30.sp
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            textStyle = TextStyle(color = Color.Blue)
        )

        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height") },
            textStyle = TextStyle(color = Color.Blue)
        )

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") },
            textStyle = TextStyle(color = Color.Blue)
        )
        Button(
            onClick = {
                authenticateUser("enzo.garofalo07@gmail.com", "123456qwerty")
            }
        ) { Text("Log In") }

        Button(
            onClick = {
                val heightValue = height.toDoubleOrNull()
                val weightValue = weight.toDoubleOrNull()
                if (heightValue != null && weightValue != null) {
                    // Calculate IMC and update the state variable
                    val imc = getIMC(heightValue, weightValue)
                    imcResult = imc

                    // Optionally, save the data to Firebase
                    saveData(name, heightValue, weightValue)
                } else {
                    Log.w("Input Error", "Height or Weight is not a valid number")
                }
            }
        ) {
            Text("Calculate")
        }

        // Conditionally show the calculated IMC
        imcResult?.let { result ->
            Text(
                text = "Your IMC is: ${"%.2f".format(result)}",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

fun saveData(name : String, height : Double, weight : Double)
{
    val db = Firebase.firestore;
    val imc = getIMC(height, weight);


    val IMCData = hashMapOf(
        "name" to name,
        "height" to height,
        "weight" to weight,
        "imc" to imc
    )

    db.collection("IMCCollection").document()
        .set(IMCData)
        .addOnSuccessListener { Log.w("Save Data", "Saved") }
        .addOnFailureListener { e -> Log.w("Save Data", "Failed") }
}

fun getIMC(height : Double, weight : Double) : Double = weight / (height*height);

fun authenticateUser(name: String, password: String)
{
   val auth : FirebaseAuth = Firebase.auth
    auth.signInWithEmailAndPassword(name, password)
        .addOnSuccessListener { Log.w("Log In", "Success on LogIn") }
        .addOnFailureListener { e -> Log.w("Log In", "Failed on LogIn") }

}


@Preview(showBackground = true)
@Composable
fun IMCPreview() {
    IMCfirebaseTheme {
        IMCView()
    }
}