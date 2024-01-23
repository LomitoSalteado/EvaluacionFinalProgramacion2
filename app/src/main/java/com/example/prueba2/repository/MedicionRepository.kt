package com.example.prueba2.repository

import androidx.lifecycle.LiveData
import com.example.prueba2.database.MedicionDao
import com.example.prueba2.model.Medicion

class MedicionRepository(private val medicionDao: MedicionDao) {
    val mediciones: LiveData<List<Medicion>> = medicionDao.getAll()

    suspend fun insert(medicion: Medicion) {
        medicionDao.insert(medicion)
    }
}

