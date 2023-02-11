package com.hussein.shopapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopDao {
    //Database keywords for any query is not case sensitive
    @Query("SELECT * FROM shop_entity ORDER BY id ASC")
    fun getAllRecordsFromDB():List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(productEntity: ProductEntity)

    @Query("DELETE FROM shop_entity")
    fun deleteAllRecords()
}