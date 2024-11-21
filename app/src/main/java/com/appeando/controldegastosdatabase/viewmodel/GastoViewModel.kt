package com.appeando.controldegastosdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appeando.controldegastosdatabase.model.Gasto
import com.appeando.controldegastosdatabase.repository.GastoRepository
import kotlinx.coroutines.launch

class GastoViewModel(private val repository: GastoRepository) : ViewModel() {

    val obtenerGastos: LiveData<List<Gasto>> = repository.obtenerGastos

    fun insertarGasto(gasto: Gasto) {
        viewModelScope.launch {
            repository.insertarGasto(gasto)
        }
    }

    fun actualizarGasto(gasto: Gasto) {
        viewModelScope.launch {
            repository.actualizarGasto(gasto)
        }
    }

    fun eliminarGasto(gasto: Gasto) {
        viewModelScope.launch {
            repository.eliminarGasto(gasto)
        }
    }

    fun obtenerTotalGastado(fechaInicio: Long, fechaFin: Long) = viewModelScope.launch {
        repository.obtenerTotalGastado(fechaInicio, fechaFin)
    }

    fun obtenerGastosPorCategoria(categoria: String): LiveData<List<Gasto>> {
        return repository.obtenerGastosPorCategoria(categoria)
    }
}