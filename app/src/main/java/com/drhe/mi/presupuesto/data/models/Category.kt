package com.drhe.mi.presupuesto.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.drhe.mi.presupuesto.util.Constants.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val icon: Int?
)
