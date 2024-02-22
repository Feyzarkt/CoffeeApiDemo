package com.hw.coffeeapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hw.coffeeapp.data.model.CoffeeResponseItem

@Dao
interface CoffeeDAO {
    @Query("SELECT * FROM coffee_response")
    fun getAll(): List<CoffeeResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(coffeeResponse: List<CoffeeResponseItem>)
}