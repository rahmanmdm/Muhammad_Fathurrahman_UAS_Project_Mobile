package com.stmik.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //fungsi untuk
        val dataIntent = intent.getParcelableExtra<Book>( "extra_detail")

        val image = findViewById<ImageView>(R.id.detail_image)
        val title = findViewById<TextView>(R.id.textJudul)
        val desc = findViewById<>()
    }
}