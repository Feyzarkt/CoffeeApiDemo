package com.example.coffeeapidemo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coffeeapidemo.data.model.CoffeeResponseItem

@Dao
interface CoffeeDAO {
    @Query("SELECT * FROM coffee_response")
    fun getAll(): List<CoffeeResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(coffeeResponse: List<CoffeeResponseItem>)
}