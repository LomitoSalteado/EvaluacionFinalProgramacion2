package com.example.prueba2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba2.R
import com.example.prueba2.database.AppDatabase
import com.example.prueba2.repository.MedicionAdapter
import com.example.prueba2.repository.MedicionRepository
import com.example.prueba2.viewmodel.MedicionViewModel
import com.example.prueba2.viewmodel.MedicionViewModelFactory

class ListaActivity : AppCompatActivity() {
    private lateinit var viewModel: MedicionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        // Obtén tu MedicionDao
        val medicionDao = AppDatabase.getDatabase(this).medicionDao()
        val repository = MedicionRepository(medicionDao)
        val viewModelFactory = MedicionViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MedicionViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar el adaptador
        val adapter = MedicionAdapter(emptyList())
        recyclerView.adapter = adapter

        // Observa los cambios en los datos
        viewModel.mediciones.observe(this) { mediciones ->
            // Actualiza la lista en el adaptador cuando los datos cambien
            adapter.myDataset = mediciones
            adapter.notifyDataSetChanged()
        }

        // Configurar el botón "Agregar Cuentas"
        val agregarCuentasButton = findViewById<Button>(R.id.btnAgregarCuentas)
        agregarCuentasButton.setOnClickListener {
            navegarAPagina()
        }
    }

    private fun navegarAPagina() {
        val intent = Intent(this, FormularioActivity::class.java)
        startActivity(intent)
    }
}