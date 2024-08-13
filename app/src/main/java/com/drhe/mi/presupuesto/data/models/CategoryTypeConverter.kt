package com.drhe.mi.presupuesto.data.models

import androidx.room.TypeConverter
import com.google.gson.Gson

class CategoryTypeConverter {

    @TypeConverter
    fun fromCategory(category: Category?) : String? {
        return Gson().toJson(category)
    }

    @TypeConverter
    fun toCategory(category: String?) : Category? {
        return Gson().fromJson(category, Category::class.java) // , object : TypeToken<Category>() {}.type)
    }
}