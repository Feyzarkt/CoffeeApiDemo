package com.example.coffeeapidemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coffeeapidemo.data.model.CoffeeResponseItem
import com.example.coffeeapidemo.util.DatabaseConverter

@Database(entities = [CoffeeResponseItem::class], version = 2)
@TypeConverters(DatabaseConverter::class)
abstract class CoffeeDB: RoomDatabase() {
    abstract fun coffeeDao() : CoffeeDAO
}