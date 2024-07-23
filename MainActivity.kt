package com.example.menuoptions

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtxt1: EditText = findViewById(R.id.editTextNumber)
        val edtxt2: EditText = findViewById(R.id.editTextNumber2)
        val resultTV: TextView = findViewById(R.id.textView3)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)

        buttonAdd.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "add")
        }

        buttonSubtract.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "subtract")
        }

        buttonMultiply.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "multiply")
        }

        buttonDivide.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "divide")
        }
    }

    private fun performOperation(edtxt1: EditText, edtxt2: EditText, resultTV: TextView, operation: String) {
        val x = edtxt1.text.toString().toDoubleOrNull()
        val y = edtxt2.text.toString().toDoubleOrNull()

        if (x == null || y == null) {
            resultTV.text = "Invalid input"
            return
        }

        val result = when (operation) {
            "add" -> sum(x, y)
            "subtract" -> subtract(x, y)
            "multiply" -> multiply(x, y)
            "divide" -> divide(x, y)
            else -> 0.0
        }
        resultTV.text = result.toString()
    }

    private fun sum(a: Double, b: Double): Double {
        return a + b
    }

    private fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    private fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    private fun divide(a: Double, b: Double): Double {
        return if (b != 0.0) a / b else Double.NaN
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.my_first_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show()
            R.id.subitem1 -> Toast.makeText(this, "Sub-item 1 selected", Toast.LENGTH_SHORT).show()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
