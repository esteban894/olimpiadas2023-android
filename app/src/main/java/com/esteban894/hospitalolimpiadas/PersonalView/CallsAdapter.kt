package com.esteban894.hospitalolimpiadas.PersonalView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.esteban894.hospitalolimpiadas.DetailCall.DetailCallActivity
import com.esteban894.hospitalolimpiadas.R

class CallsAdapter(private val calls: List<Calls>, private val context: Context) : RecyclerView.Adapter<CallsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_call_list, parent,false)
        return  CallsViewHolder(view)
    }

    override fun getItemCount() = calls.size

    override fun onBindViewHolder(holder: CallsViewHolder, position: Int) {
        holder.render(calls[position])

        val call = calls[position]

        holder.itemView.setOnClickListener {
            // Aquí maneja el clic en el elemento
            val intent = Intent(context, DetailCallActivity::class.java)
            intent.putExtra("sector", call.sector)
            intent.putExtra("tipo", call.tipo.toString())
            intent.putExtra("estado", call.estado.toString())
            context.startActivity(intent)
        }
    }

    fun getItem(position: Int): Any {
        return calls[position]
    }

}