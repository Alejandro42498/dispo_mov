package com.example.imccalculator

import android.os.Bundle
import androidx.activity.viewModels
import com.example.imccalculator.databinding.ActivityMainBinding

class MainActivity : ActivityMainBinding() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BMICalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botón calcular
        binding.calculateButton.setOnClickListener {
            val weight = binding.weightInput.text.toString()
            val height = binding.heightInput.text.toString()
            viewModel.calculateBMI(weight, height)
        }

        // Observadores
        viewModel.bmiResult.observe(this) {
            binding.resultText.text = "Resultado: $it"
        }

        viewModel.bmiCategory.observe(this) {
            binding.categoryText.text = it
        }
    }
}
