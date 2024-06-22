package com.example.clickerapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var now : TextView
    lateinit var allTime : TextView
    lateinit var click : Button

    var count : Int = 0
    var userName : String? = null
    var userNow : Int = 0
    var userAllTime : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        name = findViewById(R.id.editTextName)
        now = findViewById(R.id.textViewNow)
        allTime = findViewById(R.id.textViewAllTime)
        click = findViewById(R.id.button)




        click.setOnClickListener {
            count++
            now.setText("" + count)
        }


    }
}