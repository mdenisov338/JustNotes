package com.mdenisov338.justnotesapp

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class ExampleAdapter: RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)
        val textView1: TextView = itemView.findViewById(R.id.textView)
    }
}