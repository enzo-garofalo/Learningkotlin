package com.example.orgs

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity()
{

    val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showState(TAG, "Eita mundo bom")
        // Indica para activity qual view será exibido
        setContentView(R.layout.activity_main)

    }
}

fun showState(TAG : String, message : String)
{
    Log.i(TAG, message)
}

