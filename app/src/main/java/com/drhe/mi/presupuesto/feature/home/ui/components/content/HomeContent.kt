package com.drhe.mi.presupuesto.feature.home.ui.components.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.drhe.mi.presupuesto.data.models.Transaction
import com.drhe.mi.presupuesto.ui.theme.ELEVATION
import com.drhe.mi.presupuesto.ui.theme.EXTRA_LARGE_PADDING
import com.drhe.mi.presupuesto.ui.theme.LARGE_PADDING

@Composable
fun HomeContent(
    modifier: Modifier,
    transactions: List<Transaction>,
    navigateToTransactionScreen: (transactionId: Int) -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        HomeCard(transactions, navigateToTransactionScreen)
        //HomeBody()
    }
}

@Composable
fun HomeCard(
    transactions: List<Transaction>,
    navigateToTransactionScreen: (transactionId: Int) -> Unit
) {
    Column(
        modifier = Modifier.padding(
                top = EXTRA_LARGE_PADDING,
                end = EXTRA_LARGE_PADDING,
                start = EXTRA_LARGE_PADDING
        )
    ) {
        ElevatedCard(
            modifier = Modifier.wrapContentWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = ELEVATION
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = LARGE_PADDING,
                        top = LARGE_PADDING,
                        end = LARGE_PADDING
                    )
            ) {
                Text(
                    modifier = Modifier
                        .alpha(0.8f),
                    text = "Balance",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
                Text(
                    modifier = Modifier,
                    text = "S/ 600.00",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = LARGE_PADDING,
                        top = LARGE_PADDING,
                        end = LARGE_PADDING,
                        bottom = LARGE_PADDING
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        modifier = Modifier.alpha(0.7f),
                        text = "Ingresos",
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = "S/ 700.00",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                Column {
                    Text(
                        modifier = Modifier.alpha(0.7f),
                        text = "Egresos",
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = "S/ 100.00",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
        HomeBody(transactions, navigateToTransactionScreen)
    }
}

@Composable
fun HomeBody(
    transactions: List<Transaction>,
    navigateToTransactionScreen: (transactionId: Int) -> Unit
) {
    Column(
         modifier = Modifier
             .fillMaxWidth()
             .wrapContentHeight()
             .padding(top = EXTRA_LARGE_PADDING)
    ) {
        Text(
            modifier = Modifier,
            text = "Movimientos",
            color = MaterialTheme.colorScheme.secondary,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
        )
        ListTransaction(
            transactions,
            navigateToTransactionScreen
        )
    }
}