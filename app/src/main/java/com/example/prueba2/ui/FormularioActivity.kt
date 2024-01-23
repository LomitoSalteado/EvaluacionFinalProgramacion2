package com.example.prueba2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.prueba2.R
import com.example.prueba2.database.AppDatabase
import com.example.prueba2.model.Medicion
import com.example.prueba2.repository.MedicionRepository
import com.example.prueba2.viewmodel.MedicionViewModel
import com.example.prueba2.viewmodel.MedicionViewModelFactory

class FormularioActivity : AppCompatActivity() {
    private lateinit var viewModel: MedicionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Obtén tu MedicionDao
        val medicionDao = AppDatabase.getDatabase(this).medicionDao()
        val repository = MedicionRepository(medicionDao)
        val viewModelFactory = MedicionViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MedicionViewModel::class.java)

        val medidorEditText = findViewById<EditText>(R.id.etMedidor)
        val fechaEditText = findViewById<EditText>(R.id.etFecha)
        val tipoGastoRadioGroup = findViewById<RadioGroup>(R.id.rdTipoGasto)
        val registrarButton = findViewById<Button>(R.id.btnRegistrar)

        registrarButton.setOnClickListener {
            val medidor = medidorEditText.text.toString().toDouble()
            val fecha = fechaEditText.text.toString()
            val selectedId = tipoGastoRadioGroup.checkedRadioButtonId
            val tipoGastoRadioButton = findViewById<RadioButton>(selectedId)
            val tipoGasto = tipoGastoRadioButton.text.toString()

            val medicion = Medicion(0, tipoGasto, medidor, fecha)

            // Insertar la nueva medición en el ViewModel
            viewModel.insert(medicion)

            // Navegar de vuelta a la primera página
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}

