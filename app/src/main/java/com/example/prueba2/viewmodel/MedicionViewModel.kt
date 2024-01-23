package com.example.prueba2.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba2.model.Medicion
import com.example.prueba2.repository.MedicionRepository
import kotlinx.coroutines.launch

class MedicionViewModel(private val repository: MedicionRepository) : ViewModel() {
    val mediciones: LiveData<List<Medicion>> = repository.mediciones

    fun insert(medicion: Medicion) = viewModelScope.launch {
        repository.insert(medicion)
    }
}
