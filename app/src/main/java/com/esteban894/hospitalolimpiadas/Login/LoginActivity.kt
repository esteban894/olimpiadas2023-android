package com.esteban894.hospitalolimpiadas.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.esteban894.hospitalolimpiadas.PersonalView.PersonalView
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
            val result = getUserData()

            when (result) {
                is ValidationResult.Success -> {
                    val intent = Intent(this, PersonalView::class.java)
                    startActivity(intent)
                }

                is ValidationResult.Error -> {
                    Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show()
                    etEmail.text.clear()
                    etPassword.text.clear()
                }
            }
        }
    }

    private fun getUserData(): ValidationResult {
        val userEmail = etEmail.text.toString()
        val userPassword = etPassword.text.toString()

        if (userEmail.isEmpty() || userPassword.isEmpty()) {
            return ValidationResult.Error("Error en tus credenciales")
        }

        // TODO validación de datos con el backend web
        if(userEmail == "asd@asd.com" && userPassword == "asd") {
            return ValidationResult.Success
        } else {
            return ValidationResult.Error("Error en tus credenciales")
        }

        return ValidationResult.Success
    }
}