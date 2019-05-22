package com.example.testedois

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConsultarr.setOnClickListener {
            val intent = Intent(this, ExibirdadosActivity::class.java)
            startActivity(intent)
        }
    }
}
