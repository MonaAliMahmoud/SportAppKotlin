package com.example.mona.sportapp

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val textView =findViewById<TextView>(R.id.details)
        val image=findViewById<ImageView>(R.id.imageView)

        textView.text=intent.getStringExtra("key").toString()

        var url=intent.getSerializableExtra("imagekey").toString()

        Glide.with(applicationContext)
            .load(url)
            .into(image)
    }
}
