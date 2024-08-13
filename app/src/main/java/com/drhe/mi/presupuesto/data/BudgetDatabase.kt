package com.drhe.mi.presupuesto.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.drhe.mi.presupuesto.data.dao.CategoryDao
import com.drhe.mi.presupuesto.data.dao.TransactionDao
import com.drhe.mi.presupuesto.data.models.Category
import com.drhe.mi.presupuesto.data.models.CategoryTypeConverter
import com.drhe.mi.presupuesto.data.models.Transaction

@Database(entities = [Transaction::class, Category::class], version = 1, exportSchema = false)
@TypeConverters(CategoryTypeConverter::class)
abstract class BudgetDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
}