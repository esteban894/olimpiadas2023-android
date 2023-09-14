package com.esteban894.hospitalolimpiadas.PersonalView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esteban894.hospitalolimpiadas.R

class PersonalView : AppCompatActivity() {

    private val calls = listOf(
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_view)
        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvCalls = findViewById(R.id.rvCalls)
    }

    private fun initUI() {
        callsAdapter = CallsAdapter(calls)
        rvCalls.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvCalls.adapter = callsAdapter
    }
}