package com.appeando.controldegastosdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appeando.controldegastosdatabase.interfaces.GastoDao
import com.appeando.controldegastosdatabase.model.Gasto

@Database(entities = [Gasto::class], version = 1, exportSchema = false)
abstract class GastosDatabase : RoomDatabase() {

    abstract fun gastoDao(): GastoDao

    companion object {
        @Volatile
        private var INSTANCE: GastosDatabase? = null

        fun getDatabase(context: Context): GastosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GastosDatabase::class.java,
                    "gastos_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}