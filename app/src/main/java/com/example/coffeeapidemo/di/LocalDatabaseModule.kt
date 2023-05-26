package com.example.coffeeapidemo.di

import android.content.Context
import androidx.room.Room
import com.example.coffeeapidemo.data.local.CoffeeDAO
import com.example.coffeeapidemo.data.local.CoffeeDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        CoffeeDB::class.java,
        "coffee_response_database"
    ).build()

    @Provides
    @Singleton
    fun provideDao(coffeeDB: CoffeeDB): CoffeeDAO =  coffeeDB.coffeeDao()
}