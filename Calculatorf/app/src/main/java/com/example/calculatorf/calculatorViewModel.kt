package com.example.calculatorf

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.mozilla.javascript.Context




class calculatorViewModel: ViewModel () {

    private val _equationText = MutableLiveData("")
    val equationText: LiveData<String> = _equationText

    private val _resultText = MutableLiveData("0")
    val resultText: LiveData<String> = _resultText

    fun onButtonClick(btn: String) {
           Log.i("Click Button", btn)

        _equationText.value?.let {
            if (btn == "AC") {
                _equationText.value = ""
                _resultText.value = "0"
                return
            }

            if (btn == "C") {
                if (it.isNotEmpty()) {
                    _equationText.value = it.substring(0, it.length - 1)
                }
                return
            }

            if (btn == "=") {
                _equationText.value = resultText.value
                return
            }

            _equationText.value = it + btn

            //Calcular
            try {
                _resultText.value = calculateResult(_equationText.value.toString())
            }catch (_: Exception){}
        }
        }

    fun calculateResult(equation: String): String {
        val context = Context.enter()
        context.optimizationLevel = -1
        return try {
            val scriptable = context.initStandardObjects()
            val result = context.evaluateString(scriptable, equation, "JavaScript", 1, null)
            var finalResult = result.toString()
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "")
            }
            finalResult
        } finally {
            Context.exit()
        }
    }

}

