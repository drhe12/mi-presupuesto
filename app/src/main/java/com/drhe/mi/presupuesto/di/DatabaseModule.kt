package com.drhe.mi.presupuesto.di

import android.content.Context
import androidx.room.Room
import com.drhe.mi.presupuesto.data.BudgetDatabase
import com.drhe.mi.presupuesto.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideBudgetDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BudgetDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideTransactionDao(database: BudgetDatabase) = database.transactionDao()

    @Singleton
    @Provides
    fun provideCategoryDao(database: BudgetDatabase) = database.categoryDao()
}