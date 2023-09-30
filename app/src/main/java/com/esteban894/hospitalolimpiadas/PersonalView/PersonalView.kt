package com.esteban894.hospitalolimpiadas.PersonalView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esteban894.hospitalolimpiadas.DetailCall.DetailCallActivity
import com.esteban894.hospitalolimpiadas.Login.ApiService
import com.esteban894.hospitalolimpiadas.Login.Models.UserDto
import com.esteban894.hospitalolimpiadas.Login.Models.UserDtoResponse
import com.esteban894.hospitalolimpiadas.MainActivity
import com.esteban894.hospitalolimpiadas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PersonalView : AppCompatActivity() {

    private lateinit var calls: List<Calls>

    private lateinit var rvCalls: RecyclerView
    private lateinit var callsAdapter: CallsAdapter
    private lateinit var btnBack: FloatingActionButton

    private var baseUrl: String = "http://10.0.2.2:4000/"

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_view)

        val username = intent.getStringExtra("username").toString()
        retrofit = getRetrofit()
        initComponents()
        getData()
        initUI()
        initListeners()
    }

    private fun getData() {

        calls = runBlocking { sendReq() }
        Log.i("esteban894", calls.toString())
    }

    private suspend fun sendReq(): List<Calls> {

        val deferred = CompletableDeferred<List<Calls>>()

        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getCalls()

            if (myResponse.isSuccessful) {
//                Log.i("esteban894", "=================Funciona")
                val response: List<Calls>? = myResponse.body()
                if (response != null) {
                    Log.i("esteban894", response.toString())
                    deferred.complete(response)
                }
            }
        }
        return deferred.await()
    }

    private fun initComponents() {
        rvCalls = findViewById(R.id.rvCalls)
        btnBack = findViewById(R.id.btnBack)
    }

    private fun initUI() {
        callsAdapter = CallsAdapter(calls, this)
        rvCalls.layoutManager = LinearLayoutManager(this)
        rvCalls.adapter = callsAdapter
    }

    private fun initListeners() {
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}