package com.example.prueba2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prueba2.model.Medicion

@Dao
interface MedicionDao {
    @Query("SELECT * FROM medicion")
    fun getAll(): LiveData<List<Medicion>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(medicion: Medicion)
}
