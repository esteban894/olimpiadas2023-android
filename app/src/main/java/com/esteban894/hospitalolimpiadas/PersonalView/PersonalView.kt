package com.esteban894.hospitalolimpiadas.PersonalView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esteban894.hospitalolimpiadas.DetailCall.DetailCallActivity
import com.esteban894.hospitalolimpiadas.MainActivity
import com.esteban894.hospitalolimpiadas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PersonalView : AppCompatActivity() {

    private val calls = mutableListOf(
        Calls("Quirofano 1", TypeCall.NORMAL, false),
        Calls("Quirofano 2", TypeCall.EMERGENCIA, true),
        Calls("Quirofano 3", TypeCall.NORMAL, true),
        Calls("Quirofano 4", TypeCall.EMERGENCIA, false),
        Calls("Quirofano 4", TypeCall.EMERGENCIA, false),
        Calls("Quirofano 4", TypeCall.EMERGENCIA, false),
        Calls("Quirofano 5", TypeCall.NORMAL, true)
    )

    private lateinit var rvCalls: RecyclerView
    private lateinit var callsAdapter: CallsAdapter
    private lateinit var btnBack: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_view)
        initComponents()
        initUI()
        initListeners()
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
}