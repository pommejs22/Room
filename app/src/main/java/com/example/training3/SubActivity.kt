package com.example.training3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val state = intent.getSerializableExtra("Onepiece") as Onepiece

        val imageView = findViewById<ImageView>(R.id.icon)
//        imageView.setImageResource(state.imageId)

        val textView1 = findViewById<TextView>(R.id.tv)
//        textView1.text = state.title

        val textView2 = findViewById<TextView>(R.id.nv)
//        textView2.text = state.name


        if (state is Onepiece) {
//            when (state.name) {
//                "モンキー・D・ルフィ" -> {
//                    imageView.setImageResource(state.imageId)
//                    textView1.text = state.title
//                    textView2.text = state.name
//                }
//                "ロロノア・ゾロ" -> {
//                    imageView.setImageResource(state.imageId)
//                    textView1.text = state.title
//                    textView2.text = state.name
//                }
//                "ナミ" -> {
//                    imageView.setImageResource(state.imageId)
//                    textView1.text = state.title
//                    textView2.text = state.name
//                }
//                "サンジ" -> {
//                    imageView.setImageResource(state.imageId)
//                    textView1.text = state.title
//                    textView2.text = state.name
//                }
//                "トニートニー・チョッパー" -> {
//                    imageView.setImageResource(state.imageId)
//                    textView1.text = state.title
//                    textView2.text = state.name
//                }
//
//            }
//
//        }
            if (state.name == "モンキー・D・ルフィ") {
                imageView.setImageResource(R.drawable.onepiece01_luffy2)
                textView1.text = state.name
                textView2.text = state.title
            } else if (state.name == "ロロノア・ゾロ") {
                imageView.setImageResource(R.drawable.onepiece02_zoro_bandana)
                textView1.text = state.name
                textView2.text = state.title
            } else if (state.name == "ナミ") {
                imageView.setImageResource(R.drawable.onepiece03_nami)
                textView1.text = state.name
                textView2.text = state.title
            } else if (state.name == "サンジ") {
                imageView.setImageResource(R.drawable.onepiece05_sanji)
                textView1.text = state.name
                textView2.text = state.title
            } else if (state.name == "トニートニー・チョッパー") {
                imageView.setImageResource(R.drawable.onepiece06_chopper)
                textView1.text = state.name
                textView2.text = state.title
            }
        }
    }
    //            　戻るボタンをタップした時の処理
    fun backButton(view: View) {
        finish()
    }
}

