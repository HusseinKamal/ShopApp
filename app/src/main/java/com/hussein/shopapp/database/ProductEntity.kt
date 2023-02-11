package com.hussein.shopapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_entity")
class ProductEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id:Int=0,

    @ColumnInfo(name = "name")val name:String,
    @ColumnInfo(name = "price")val price:Int,
    @ColumnInfo(name = "image")val image:String,
    @ColumnInfo(name = "brand")val brand:String,
    @ColumnInfo(name = "rate")val rate:Double
)