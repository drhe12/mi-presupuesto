package com.drhe.mi.presupuesto.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.drhe.mi.presupuesto.data.models.Category
import com.drhe.mi.presupuesto.data.models.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Query("SELECT * FROM transaction_table order by date desc")
    fun getAllTransactions() : Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE id = :transactionId")
    fun getTransaction(transactionId: Int) : Flow<Transaction>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTransaction(transaction: Transaction)

    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("DELETE FROM transaction_table")
    suspend fun deleteAllTransactions()

    @Query("SELECT * FROM transaction_table WHERE type = 'INCOME' order by date desc")
    fun searchIncomeTransactions() : Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE type = 'EXPENSE' order by date desc")
    fun searchExpenseTransactions() : Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE name LIKE :searchQuery OR description LIKE :searchQuery order by date desc")
    fun searchTransactionDatabase(searchQuery: String) : Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE category = :category order by date desc")
    fun searchCategoryTransactions(category: Category) : Flow<List<Transaction>>
}