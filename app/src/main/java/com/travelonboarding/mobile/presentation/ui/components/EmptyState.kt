/*
 * EmptyState.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.travelonboarding.mobile.R

@Composable
fun EmptyState(
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            alignment = Alignment.CenterVertically,
            space = dimensionResource(id = R.dimen.padding_big),
        ),
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.il_logo),
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)
                .clip(MaterialTheme.shapes.small),
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterStatusPreview() {
    EmptyState(
        title = stringResource(R.string.example),
        modifier = Modifier.fillMaxSize(),
    )
}
