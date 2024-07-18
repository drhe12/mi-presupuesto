package com.drhe.mi.presupuesto.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.drhe.mi.presupuesto.util.Constants.TRANSACTION_TABLE

@Entity(tableName = TRANSACTION_TABLE)
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val amount: Double,
    val type: TransactionType,
    val date: Long,
    val category: Category?
)
