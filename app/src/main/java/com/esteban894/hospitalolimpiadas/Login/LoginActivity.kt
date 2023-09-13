package com.esteban894.hospitalolimpiadas.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.esteban894.hospitalolimpiadas.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginActivity : AppCompatActivity() {
    private lateinit var btnBack: FloatingActionButton
    private lateinit var btnLogin: MaterialButton
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnBack = findViewById(R.id.btnBack)
        btnLogin = findViewById(R.id.btnLogin)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
    }

    private fun initListeners() {
        btnBack.setOnClickListener { onBackPressed() }
        btnLogin.setOnClickListener {
            Toast.makeText(this, getUserData(), Toast.LENGTH_LONG).show()
        }
    }

    private fun getUserData(): String {
        val userEmail = etEmail.text.toString()
        val userPassword = etPassword.text.toString()
        return "$userEmail, $userPassword"
    }
}