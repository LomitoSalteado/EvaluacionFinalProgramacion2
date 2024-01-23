package com.example.prueba2.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba2.R
import com.example.prueba2.model.Medicion

class MedicionAdapter(private val myDataset: List<Medicion>) :
    RecyclerView.Adapter<MedicionAdapter.MyViewHolder>() {

    class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val medidorTextView: TextView = view.findViewById(R.id.medidorTextView)
        val tipoGastoTextView: TextView = view.findViewById(R.id.rdTipoGasto)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_formulario, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val medicion = myDataset[position]
        holder.medidorTextView.text = medicion.valorMedidor.toString()
        holder.tipoGastoTextView.text = medicion.tipoGasto
    }

    override fun getItemCount() = myDataset.size
}
