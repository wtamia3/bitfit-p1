package com.example.bitfit_p1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BitFitAdapter(private val entries: List<BitFitEntry>) :
    RecyclerView.Adapter<BitFitAdapter.EntryViewHolder>() {

    class EntryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val metricTypeTextView: TextView = view.findViewById(R.id.metricTypeTextView)
        val valueTextView: TextView = view.findViewById(R.id.valueTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entry, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.metricTypeTextView.text = entry.metricType
        holder.valueTextView.text = entry.value
        holder.dateTextView.text = entry.date
    }

    override fun getItemCount() = entries.size
}
