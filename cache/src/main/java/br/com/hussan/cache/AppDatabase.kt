package br.com.hussan.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.hussan.cache.dao.ProductDao
import br.com.hussan.cache.model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
