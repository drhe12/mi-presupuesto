package com.drhe.mi.presupuesto.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drhe.mi.presupuesto.data.models.Transaction
import com.drhe.mi.presupuesto.data.repositories.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository,
) : ViewModel() {

    private val _allTransactions = MutableStateFlow<List<Transaction>>(emptyList())
    val allTransactions : StateFlow<List<Transaction>> = _allTransactions

    fun getAllTransactions() {
        viewModelScope.launch {
            transactionRepository.getAllTransactions.collect { transactions ->
                _allTransactions.value = transactions
            }
        }
    }
}