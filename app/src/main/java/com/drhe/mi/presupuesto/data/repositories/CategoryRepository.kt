package com.drhe.mi.presupuesto.data.repositories

import com.drhe.mi.presupuesto.data.dao.CategoryDao
import com.drhe.mi.presupuesto.data.models.Category
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CategoryRepository @Inject constructor(private val categoryDao: CategoryDao) {

    val getAllCategories = categoryDao.getAllCategories()

    fun getCategory(categoryId: Int) = categoryDao.getCategory(categoryId = categoryId)

    suspend fun addCategory(category: Category) {
        categoryDao.addCategoryIfNotExists(category = category)
    }

    suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category = category)
    }

    suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category = category)
    }

    suspend fun deleteAllCategories() {
        categoryDao.deleteAllCategories()
    }

    fun searchCategoryDatabase(searchQuery: String) =
        categoryDao.searchCategoryDatabase(searchQuery = searchQuery)
}