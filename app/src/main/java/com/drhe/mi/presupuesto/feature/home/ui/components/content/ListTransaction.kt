package com.drhe.mi.presupuesto.feature.home.ui.components.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.drhe.mi.presupuesto.data.models.Transaction
import com.drhe.mi.presupuesto.data.models.TransactionType
import com.drhe.mi.presupuesto.ui.theme.MEDIUM_PADDING
import com.drhe.mi.presupuesto.ui.theme.MINI_SMALL_PADDING
import com.drhe.mi.presupuesto.ui.theme.SMALL_PADDING
import com.drhe.mi.presupuesto.ui.theme.primaryContainerDark
import com.drhe.mi.presupuesto.ui.theme.surfaceBrightLight
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ListTransaction(
    transactions: List<Transaction>,
    navigateToTransactionScreen: (transactionId: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = SMALL_PADDING)
    ) {
        LazyColumn {
            items(transactions) { transaction ->
                TransactionItem(
                    transaction = transaction,
                    navigateToTransactionScreen = navigateToTransactionScreen
                )
            }
        }
    }
}

@Composable
fun TransactionItem(
    transaction: Transaction,
    navigateToTransactionScreen: (transactionId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = SMALL_PADDING),
        color = primaryContainerDark,
        shape = RoundedCornerShape(8.dp),
        onClick = {
            navigateToTransactionScreen(transaction.id)
        }
    ) {
        Row (
            modifier = Modifier.padding(MEDIUM_PADDING)
        ) {
            Column(
                Modifier.weight(8f)
            ) {
                Text(
                    text = transaction.name,
                    style = MaterialTheme.typography.labelLarge,
                    color = surfaceBrightLight
                )
                Text(
                    modifier = Modifier
                        .alpha(0.7f)
                        .padding(top = MINI_SMALL_PADDING),
                    text = formatDate(transaction.date),
                    style = MaterialTheme.typography.labelMedium,
                    color = surfaceBrightLight
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "${if (transaction.type == TransactionType.EXPENSE) "-" else ""} " + transaction.amount.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    color = surfaceBrightLight
                )
            }
        }
    }
}

fun formatDate(timestamp: Long): String {
    val date = Date(timestamp)
    val formatDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatDate.format(date)
}