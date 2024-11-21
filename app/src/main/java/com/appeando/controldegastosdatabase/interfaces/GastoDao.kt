package com.appeando.controldegastosdatabase.interfaces


import androidx.lifecycle.LiveData
import androidx.room.*
import com.appeando.controldegastosdatabase.model.Gasto


@Dao
interface GastoDao {
    @Insert
    suspend fun insertarGasto(gasto: Gasto)

    @Update
    suspend fun actualizarGasto(gasto: Gasto)

    @Delete
    suspend fun eliminarGasto(gasto: Gasto)

    @Query("SELECT * FROM gastos ORDER BY fecha DESC")
    fun obtenerGastos(): LiveData<List<Gasto>>

    @Query("SELECT SUM(cantidad) FROM gastos WHERE fecha BETWEEN :fechaInicio AND :fechaFin")
    suspend fun obtenerTotalGastado(fechaInicio: Long, fechaFin: Long): Double

    @Query("SELECT * FROM gastos WHERE categoría = :categoría")
    fun obtenerGastosPorCategoria(categoría: String): LiveData<List<Gasto>>
}


