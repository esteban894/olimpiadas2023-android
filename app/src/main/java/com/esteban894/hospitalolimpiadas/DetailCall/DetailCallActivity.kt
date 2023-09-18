package com.esteban894.hospitalolimpiadas.DetailCall

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.esteban894.hospitalolimpiadas.MainActivity
import com.esteban894.hospitalolimpiadas.PersonalView.TypeCall
import com.esteban894.hospitalolimpiadas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailCallActivity : AppCompatActivity() {

    private lateinit var btnBack: FloatingActionButton
    private lateinit var tvSector: TextView
    private lateinit var tvTipo: TextView
    private lateinit var cbEstado: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_call)

        initComponents()
        initListeners()
        initUI()
    }


    private fun initComponents() {
        btnBack = findViewById(R.id.btnBack)
        tvSector = findViewById(R.id.tvSector)
        tvTipo = findViewById(R.id.tvTipo)
        cbEstado = findViewById(R.id.cbEstado)
    }

    private fun initListeners() {
        btnBack.setOnClickListener { onBackPressed() }

        cbEstado.setOnClickListener {
            if (cbEstado.isChecked) {
                cbEstado.text = getString(R.string.personal_item_status_taked)
                cbEstado.isEnabled = false
                cbEstado.setTextColor(
                    ContextCompat.getColor(
                        cbEstado.context,
                        R.color.call_item_taked
                    )
                )

                cbEstado.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbEstado.context, R.color.call_item_taked))
            } else {
                cbEstado.text = getString(R.string.personal_item_status_no_taked)
                cbEstado.setTextColor(
                    ContextCompat.getColor(
                        cbEstado.context,
                        R.color.call_item_no_taked
                    )
                )
                cbEstado.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbEstado.context, R.color.call_item_no_taked))
            }
        }
    }

    private fun initUI() {
        val sector = intent.getStringExtra("sector").toString()
        val tipo = intent.getStringExtra("tipo").toString()
        val estado = intent.getStringExtra("estado").toBoolean()

        tvSector.text = sector

        when (tipo) {
            TypeCall.NORMAL.toString() -> tvTipo.setTextColor(
                ContextCompat.getColor(
                    tvTipo.context, R.color.call_item_normal
                )
            )

            TypeCall.EMERGENCIA.toString() -> tvTipo.setTextColor(
                ContextCompat.getColor(
                    tvTipo.context, R.color.call_item_emergency
                )
            )
        }

        tvTipo.text = tipo

        cbEstado.isChecked = estado

        cbEstado.setText(if (estado) R.string.personal_item_status_taked else R.string.personal_item_status_no_taked)

        if (estado) {
            cbEstado.setTextColor(
                ContextCompat.getColor(
                    cbEstado.context,
                    R.color.call_item_taked
                )
            )

            cbEstado.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbEstado.context, R.color.call_item_taked))
            cbEstado.isEnabled = false
        } else {
            ContextCompat.getColor(cbEstado.context, R.color.call_item_no_taked)
            cbEstado.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbEstado.context, R.color.call_item_no_taked))
        }
    }
}