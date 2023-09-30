package com.esteban894.hospitalolimpiadas.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.esteban894.hospitalolimpiadas.Login.Models.UserDto
import com.esteban894.hospitalolimpiadas.Login.Models.UserDtoResponse
import com.esteban894.hospitalolimpiadas.Login.Models.ValidationResult
import com.esteban894.hospitalolimpiadas.PersonalView.PersonalView
import com.esteban894.hospitalolimpiadas.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var btnBack: FloatingActionButton
    private lateinit var btnLogin: MaterialButton
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    private var baseUrl: String = "http://10.0.2.2:4000/"

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        retrofit = getRetrofit()
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnBack = findViewById(R.id.btnBack)
        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
    }

    private fun initListeners() {
        btnBack.setOnClickListener { onBackPressed() }
        btnLogin.setOnClickListener {
            val result = getUserData()

            when (result) {
                is ValidationResult.Success -> {
                    val intent = Intent(this, PersonalView::class.java)
                    intent.putExtra("username", etUsername.text)
                    startActivity(intent)
                }

                is ValidationResult.Error -> {
                    Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show()
                    etUsername.text.clear()
                    etPassword.text.clear()
                }
            }
        }
    }

    private fun getUserData(): ValidationResult {
        val userName = etUsername.text.toString()
        val userPassword = etPassword.text.toString()

        if (userName.isEmpty() || userPassword.isEmpty()) {
            return ValidationResult.Error("Error en tus credenciales")
        }

        val user = UserDto(userName, userPassword)

        val result = runBlocking { sendReq(user) }

        if (result) {
            return ValidationResult.Success
        } else {
            return ValidationResult.Error("Error en tus credenciales")
        }
    }

    private suspend fun sendReq(user: UserDto): Boolean {

        val deferred = CompletableDeferred<Boolean>()

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).login(user)

            if (myResponse.isSuccessful) {
//                Log.i("esteban894", "=================Funciona")
                val response: UserDtoResponse? = myResponse.body()
                if (response != null) {
                    Log.i("esteban894", response.toString())
                    deferred.complete(true)
                }
            } else {
//                Log.i("esteban894", "=================No funciona")
                deferred.complete(false)
            }
        }
        return deferred.await()
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}