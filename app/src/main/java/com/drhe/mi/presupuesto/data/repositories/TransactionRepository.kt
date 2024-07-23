package com.drhe.mi.presupuesto.data.repositories

import com.drhe.mi.presupuesto.data.dao.TransactionDao
import com.drhe.mi.presupuesto.data.models.Category
import com.drhe.mi.presupuesto.data.models.Transaction
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepository @Inject constructor(private val transactionDao: TransactionDao) {

    val getAllTransactions : Flow<List<Transaction>> =
        transactionDao.getAllTransactions()
    val searchIncomeTransactions : Flow<List<Transaction>> =
        transactionDao.searchIncomeTransactions()
    val searchExpenseTransactions : Flow<List<Transaction>> =
        transactionDao.searchExpenseTransactions()

    fun getTransaction(transactionId: Int) : Flow<Transaction> =
        transactionDao.getTransaction(transactionId = transactionId)

    suspend fun addTransaction(transaction: Transaction) {
        transactionDao.addTransaction(transaction = transaction)
    }

    suspend fun updateTransaction(transaction: Transaction) {
        transactionDao.updateTransaction(transaction = transaction)
    }

    suspend fun deleteTransaction(transaction: Transaction) {
        transactionDao.deleteTransaction(transaction = transaction)
    }

    suspend fun deleteAllTransactions() {
        transactionDao.deleteAllTransactions()
    }

    fun searchTransactionDatabase(searchQuery: String) : Flow<List<Transaction>> =
        transactionDao.searchTransactionDatabase(searchQuery = searchQuery)

    fun searchCategoryTransactions(category: Category) : Flow<List<Transaction>> =
        transactionDao.searchCategoryTransactions(category = category)
}