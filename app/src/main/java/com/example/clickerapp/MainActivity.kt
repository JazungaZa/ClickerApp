package com.example.clickerapp

import android.content.Context
import android.content.SharedPreferences
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
    var userAllTime : Int = 0

    lateinit var sharedPreferences: SharedPreferences

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

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        retriveData()
    }




    fun saveData(){

        sharedPreferences = this.getSharedPreferences("saveData",Context.MODE_PRIVATE)

        userName = name.text.toString()
        userAllTime += count

        var editor =sharedPreferences.edit()

        editor.putString("key name",userName)
        editor.putInt("key counter",userAllTime)

        editor.apply()

    }
    fun retriveData(){

        sharedPreferences = this.getSharedPreferences("saveData",Context.MODE_PRIVATE)

        userName = sharedPreferences.getString("key name", null)
        userAllTime = sharedPreferences.getInt("key counter", 0)

        name.setText(userName)
        allTime.setText("" + userAllTime)


    }
}