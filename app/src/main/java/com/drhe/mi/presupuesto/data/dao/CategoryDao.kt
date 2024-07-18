package com.drhe.mi.presupuesto.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.drhe.mi.presupuesto.data.models.Category
import kotlinx.coroutines.flow.Flow

interface CategoryDao {

    @Query("SELECT * FROM category_table order by name desc")
    fun getAllCategories() : Flow<Category>

    @Query("SELECT * FROM category_table WHERE id = :categoryId")
    fun getCategory(categoryId: Int) : Flow<Category>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("DELETE FROM category_table")
    suspend fun deleteAllCategories()

    @Query("SELECT * FROM category_table WHERE name LIKE :searchQuery order by name desc")
    fun searchCategoryDatabase(searchQuery: String) : Flow<Category>

    @Query("SELECT COUNT(id) FROM category_table WHERE LOWER(name) = LOWER(:name)")
    suspend fun checkCategory(name: String) : Int

    suspend fun addCategoryIfNotExists(category: Category) {
        if (checkCategory(category.name) == 0) {
            addCategory(category)
        }
    }
}