package com.example.bmicalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Set the Toolbar title
        binding.toolbar.title = "BMI Calculator"

        // Function to calculate BMI
        fun calculateBMI() {
            if (binding.etKg.text.isNotEmpty() && binding.etHeight.text.isNotEmpty()) {
                val weight = binding.etKg.text.toString().toDouble()
                val height = binding.etHeight.text.toString().toDouble() / 100
                val bmi = weight / (height * height)

                binding.tvResult.text = when {
                    bmi < 18.5 -> "Underweight"
                    bmi in 18.5..24.9 -> "Normal weight"
                    bmi in 25.0..29.9 -> "Overweight"
                    else -> "Obesity"
                }
            } else {
                // Show a Toast message if inputs are empty
                Toast.makeText(this, "Please enter your weight and height", Toast.LENGTH_SHORT).show()
            }
        }

        // Set OnClickListener for Calculate button
        binding.btnCalculate.setOnClickListener {
            calculateBMI()
        }
    }
}
