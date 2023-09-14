package com.esteban894.hospitalolimpiadas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.esteban894.hospitalolimpiadas.Login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun initListeners() {
        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}