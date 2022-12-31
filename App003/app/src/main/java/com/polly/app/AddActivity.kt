package com.polly.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val txtAdd = findViewById<TextView>(R.id.result_add)
        val txtSubtract = findViewById<TextView>(R.id.result_subtract)
        val txtMultiply = findViewById<TextView>(R.id.result_multiply)
        val txtDivide = findViewById<TextView>(R.id.result_divide)

        val intNum1 = intent.getIntExtra("number1",0)
        val intNum2 = intent.getIntExtra("number2", 0)


        txtAdd.text = "$intNum1 + $intNum2 = ${intNum1 + intNum2}"
        txtSubtract.text = "$intNum1 - $intNum2 = ${intNum1 - intNum2}"
        txtMultiply.text = "$intNum1 * $intNum2 = ${intNum1 * intNum2}"
        txtDivide.text = "$intNum1 / $intNum2 = ${intNum1 / intNum2}"

    }
}