package com.example.prueba2.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba2.R
import com.example.prueba2.model.Medicion

class MedicionAdapter(var myDataset: List<Medicion>) :
    RecyclerView.Adapter<MedicionAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val medidorTextView: TextView = view.findViewById(R.id.medidorTextView)
        val fechaTextView: TextView = view.findViewById(R.id.fechaTextView)
        val tipoGastoTextView: TextView = view.findViewById(R.id.tipoGastoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // Infla el nuevo layout que contiene las vistas medidorTextView, fechaTextView y tipoGastoTextView
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medicion_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val medicion = myDataset[position]
        holder.medidorTextView.text = medicion.valorMedidor.toString()
        holder.fechaTextView.text = medicion.fecha
        holder.tipoGastoTextView.text = medicion.tipoGasto
    }

    override fun getItemCount() = myDataset.size
}
