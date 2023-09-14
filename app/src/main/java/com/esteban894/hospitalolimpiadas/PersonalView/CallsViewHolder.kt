package com.esteban894.hospitalolimpiadas.PersonalView

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esteban894.hospitalolimpiadas.R

class CallsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTitleItem: TextView = view.findViewById(R.id.tvTitleItem)
    private val tvTypeItem: TextView = view.findViewById(R.id.tvTypeItem)
    private var tvStatusItem: TextView = view.findViewById(R.id.tvStatusItem)
    private val ivStatusItem: ImageView = view.findViewById(R.id.ivStatusItem)

    @SuppressLint("ResourceAsColor")
    fun render(calls: Calls) {

        tvTitleItem.text = calls.sector

        tvTypeItem.text = calls.tipo.toString()
        tvTypeItem.setTextColor(if (calls.tipo == TypeCall.NORMAL) R.color.call_item_normal else R.color.call_item_emergency)

        tvStatusItem.setText(if (calls.estado) R.string.personal_item_status_taked else R.string.personal_item_status_no_taked)

        ivStatusItem.setImageResource(if (calls.estado) R.drawable.shape_circle_green else R.drawable.shape_circle_grey)
    }
}