package com.cidetraq.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import io.kaen.dagger.ExpressionParser
class calcScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_screen)
        println("button2 id:" + R.id.btnNum7)
    }

    fun btnPress(v: View?) {
        var calcBar = findViewById<EditText>(R.id.calcBar)
        if (v != null) {
            when(v.id){
                R.id.btnClear -> calcBar.text.clear()
                R.id.btnEquals -> runCalculation()
                else -> {
                    var whichBtn = findViewById<Button>(v.id)
                    calcBar.setText(calcBar.text.toString() + whichBtn.text.toString())
                }
            }

        }
    }

    private fun runCalculation() {
        var calcBar = findViewById<EditText>(R.id.calcBar)
        var currentCalculation = calcBar.text.toString()
        if (currentCalculation == "monke")
            Toast.makeText(applicationContext,
                "Reject humanity", Toast.LENGTH_SHORT).show()
        if (currentCalculation.isEmpty() or currentCalculation.contains(Regex("[a-zA-Z]")))
            currentCalculation = "0"
        if (currentCalculation == "420")
            Toast.makeText(applicationContext,
                "Blaze it", Toast.LENGTH_SHORT).show()

        val parser = ExpressionParser()
        val result = parser.evaluate(currentCalculation)
        calcBar.setText(result.toString())
    }
}