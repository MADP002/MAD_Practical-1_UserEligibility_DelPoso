package com.example.imeligible

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainact)

        val nameInput = findViewById<EditText>(R.id.name)
        val ageInput = findViewById<EditText>(R.id.age)
        val genderInput = findViewById<EditText>(R.id.gender)
        val checkButton = findViewById<Button>(R.id.checkButton)
        val resultText = findViewById<TextView>(R.id.result)

        checkButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val ageText = ageInput.text.toString().trim()
            val gender = genderInput.text.toString().trim()
//final change
            val age = ageText.toIntOrNull()
            if (age == null) {
                Toast.makeText(
                    this,
                    "Invalid age. Please enter a valid number.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (age >= 18) {
                resultText.text = "$name,($gender), you can drink. "
            } else {
                resultText.text = "$name,($gender), you cannot drink. "
            }
        }
    }
}

