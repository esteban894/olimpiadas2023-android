package com.esteban894.hospitalolimpiadas.PersonalView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esteban894.hospitalolimpiadas.R

class CallsAdapter(private val calls: List<Calls>) : RecyclerView.Adapter<CallsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_call_list, parent,false)
        return  CallsViewHolder(view)
    }

    override fun getItemCount() = calls.size

    override fun onBindViewHolder(holder: CallsViewHolder, position: Int) {
        holder.render(calls[position])
    }

}