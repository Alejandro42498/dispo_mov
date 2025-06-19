package com.example.imccalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BMICalculatorViewModel : ViewModel() {

    private val _bmiResult = MutableLiveData<String>()
    val bmiResult: LiveData<String> = _bmiResult

    private val _bmiCategory = MutableLiveData<String>()
    val bmiCategory: LiveData<String> = _bmiCategory

    fun calculateBMI(weight: String, height: String) {
        val w = weight.toFloatOrNull()
        val h = height.toFloatOrNull()

        if (w != null && h != null && h > 0) {
            val bmi = w / (h * h)
            _bmiResult.value = String.format("%.2f", bmi)
            _bmiCategory.value = getBMICategory(bmi)
        } else {
            _bmiResult.value = "Error"
            _bmiCategory.value = ""
        }
    }

    private fun getBMICategory(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Bajo peso"
            bmi < 24.9 -> "Normal"
            bmi < 29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }
}
