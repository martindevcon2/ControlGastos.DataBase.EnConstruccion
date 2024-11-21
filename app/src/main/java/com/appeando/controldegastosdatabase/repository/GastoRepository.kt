package com.appeando.controldegastosdatabase.repository

import androidx.lifecycle.LiveData
import com.appeando.controldegastosdatabase.interfaces.GastoDao
import com.appeando.controldegastosdatabase.model.Gasto


class GastoRepository(private val gastoDao: GastoDao) {

    val obtenerGastos: LiveData<List<Gasto>> = gastoDao.obtenerGastos()
    suspend fun insertarGasto(gasto: Gasto) {
        gastoDao.insertarGasto(gasto)
    }

    suspend fun actualizarGasto(gasto: Gasto) {
        gastoDao.actualizarGasto(gasto)
    }

    suspend fun eliminarGasto(gasto: Gasto) {
        gastoDao.eliminarGasto(gasto)
    }

    suspend fun obtenerTotalGastado(fechaInicio: Long, fechaFin: Long): Double {
        return gastoDao.obtenerTotalGastado(fechaInicio, fechaFin)
    }

    fun obtenerGastosPorCategoria(categoria: String): LiveData<List<Gasto>> {
        return gastoDao.obtenerGastosPorCategoria(categoria)
    }
}