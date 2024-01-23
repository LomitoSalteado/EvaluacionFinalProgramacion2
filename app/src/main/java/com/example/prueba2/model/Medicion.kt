package com.example.prueba2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicion(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val tipoGasto: String,
    val valorMedidor: Double,
    val fecha: String
)
