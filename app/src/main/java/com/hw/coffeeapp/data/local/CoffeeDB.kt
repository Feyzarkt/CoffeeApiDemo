package com.hw.coffeeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hw.coffeeapp.data.model.CoffeeResponseItem
import com.hw.coffeeapp.util.DatabaseConverter

@Database(entities = [CoffeeResponseItem::class], version = 2)
@TypeConverters(DatabaseConverter::class)
abstract class CoffeeDB: RoomDatabase() {
    abstract fun coffeeDao() : CoffeeDAO
}