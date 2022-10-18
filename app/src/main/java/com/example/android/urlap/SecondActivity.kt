package com.example.android.urlap

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = getIntent()

        val name = intent.getStringExtra("Name")
        val mark = intent.getIntExtra("Mark", 0)
        val points = intent.getDoubleExtra("Points", 0.0)
        val complete = intent.getBooleanExtra("Complete", false)


        val resultTV: TextView = findViewById(R.id.textView_result)

        var mark_text = when (mark) {
            5 -> "Kiváló"
            4 -> "Jó"
            3 -> "Közepes"
            2 -> "Elégséges"
            1 -> "Elégtelen"
            else -> "Nincs ilyen jegy"

        }


        var max_points = 50

        if (points <= 50) {
            resultTV.text =
                "Név: " + name + "\nÉrdemjegy: " + mark + " (" + (mark_text) + ")" + "\nPontok: " + points + " (" + (points / max_points * 100).roundToInt() + "% )" + "\nFeladat teljesitve: " + complete
        } else {
            resultTV.text = "Tisztelt " + name +"!\nNem megfelelő a pontszám."
        }
    }

    fun onTakePhotoButtonClick(view: View) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivity(takePictureIntent)

        }catch (e: ActivityNotFoundException){
            Toast.makeText(this, "Nincs megfelelő alkalmazás", Toast.LENGTH_SHORT).show()
        }

    }
}