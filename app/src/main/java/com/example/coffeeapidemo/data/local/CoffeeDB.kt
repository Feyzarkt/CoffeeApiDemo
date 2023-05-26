package com.example.coffeeapidemo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coffeeapidemo.data.model.CoffeeResponseItem

@Database(entities = [CoffeeResponseItem::class], version = 1)
abstract class CoffeeDB: RoomDatabase() {

    abstract fun coffeeDao() : CoffeeDAO

}