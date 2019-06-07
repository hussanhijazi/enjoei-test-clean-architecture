package br.com.hussan.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.hussan.cache.model.ProductEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<ProductEntity>): Completable

    @Query("SELECT * from product")
    fun loadProducts(): Single<List<ProductEntity>>

}
