package com.example.perhitungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val dataset: ArrayList<dataprhtngan>) :
    RecyclerView.Adapter<Adapter.ViweHolder>() {
    class ViweHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Hasil = view.findViewById<TextView>(R.id.hasiladpter)
        val btnHapus = view.findViewById<ImageView>(R.id.btnhapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViweHolder {
        return ViweHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViweHolder, position: Int) {
        val data = dataset[position]
        holder.Hasil.text = data.Hasil.toString().toDouble().toString()
        holder.btnHapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position,dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = dataset.size
}
