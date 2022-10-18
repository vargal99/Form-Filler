package com.example.android.urlap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var checkBox_result = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        checkbox.setOnCheckedChangeListener { button, b ->
            if (checkbox.isChecked) {
                checkBox_result = true
            } else checkBox_result = false
        }
    }

    fun onSaveButton(view: View) {
        val nameET: EditText = findViewById(R.id.editTextName)
        val markET: EditText = findViewById(R.id.editText)
        val pointsET: EditText = findViewById(R.id.editTextPoints)

        if (nameET.text.toString() != "" && markET.text.toString() != "" && pointsET.text.toString() != "") {
        val name = nameET.text.toString()
        val mark = markET.text.toString().toInt()
        val points = pointsET.text.toString().toDouble()

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("Mark", mark)
            intent.putExtra("Points", points)
            intent.putExtra("Complete", checkBox_result)

            startActivity(intent)
        } else {
            Toast.makeText(this, "Hiányos kitöltés!", Toast.LENGTH_SHORT).show()
        }
    }
}