@file:OptIn(ExperimentalMaterial3Api::class)

package com.drhe.mi.presupuesto.feature.home.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.drhe.mi.presupuesto.R
import com.drhe.mi.presupuesto.ui.theme.LARGE_PADDING
import com.drhe.mi.presupuesto.ui.theme.TOP_APP_BAR_HEIGHT

@Composable
fun HomeAppBar() {
    DefaultHomeAppBar(
        onSearchClicked = { /*TODO*/ },
        onDeleteAllClicked = { /*TODO*/ }
    )
    //SearchAppBar(text = "", onTextChanged = {}, onSearchClicked = { }, onCloseClicked = { })
}

@Composable
fun DefaultHomeAppBar(
    onSearchClicked: () -> Unit,
    onDeleteAllClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home_title),
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        actions = {
            HomeAppBarActions(
                onSearchClicked = onSearchClicked,
                onDeleteAllClicked = onDeleteAllClicked
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    )
}

@Composable
fun HomeAppBarActions(
    onSearchClicked: () -> Unit,
    onDeleteAllClicked: () -> Unit
) {
    //SearchAction(onSearchClicked = onSearchClicked)
    DeleteAllAction(onDeleteAllClicked = onDeleteAllClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick = { onSearchClicked() }
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_action),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun DeleteAllAction(
    onDeleteAllClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = MaterialTheme.colorScheme.onPrimary
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteAllClicked()
                },
                text = {
                    Text(
                        modifier = Modifier.padding(start = LARGE_PADDING),
                        text = stringResource(id = R.string.delete_all_action)
                    )
                }
            )
        }
    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        color = MaterialTheme.colorScheme.primary,
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChanged(it)
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colorScheme.primaryContainer,
                containerColor = Color.Transparent,
                focusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primaryContainer
            ),
            placeholder = {
                Text(
                    modifier = Modifier.alpha(0.5f),
                    text = stringResource(id = R.string.search_action),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(0.38f),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.search_action),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(0.38f),
                    onClick = { onCloseClicked() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.close_action),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            )
        )
    }
}

@Composable
@Preview
private fun ListAppBarPreview() {
    DefaultHomeAppBar(
        onSearchClicked = { },
        onDeleteAllClicked = { }
    )
}