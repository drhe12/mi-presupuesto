package com.drhe.mi.presupuesto.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.drhe.mi.presupuesto.util.Constants.BUDGET_TABLE

//TODO: review to use
@Entity(tableName = BUDGET_TABLE)
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val amount: Double,
    val startDate: Long,
    val endDate: Long
)
