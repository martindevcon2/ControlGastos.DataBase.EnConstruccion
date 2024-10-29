package com.appeando.controldegastosdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gastos")
data class Gasto(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val categoría: String,
    val cantidad: Double,
    val fecha: Long
)
