package com.drhe.mi.presupuesto.feature.home.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.drhe.mi.presupuesto.R

@Composable
fun HomeFab(
    onFabClicked: (transactionId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = { onFabClicked(-1) },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_button)
        )
    }
}