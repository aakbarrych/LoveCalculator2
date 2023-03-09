package com.example.lovecalculator2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator2.remote.LoveModel


@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun loveDao(): LoveDao
}