/*
 * PageIndicator.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.travelonboarding.mobile.R

@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        repeat(pageCount) { index ->
            IndicatorDot(isSelected = index == currentPage)
        }
    }
}

@Composable
fun IndicatorDot(isSelected: Boolean) {
    val dotWidth by animateDpAsState(
        targetValue = if (isSelected) 32.dp else 16.dp,
        label = "DotWidth"
    )
    val dotColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
        label = "DotColor",
    )
    Box(
        modifier = Modifier
            .height(16.dp)
            .width(dotWidth)
            .clip(CircleShape)
            .background(dotColor)
            .animateContentSize(),
    )
}

@Preview(showBackground = true)
@Composable
private fun PageIndicatorPreview() {
    PageIndicator(
        pageCount = 5,
        currentPage = 1,
        modifier = Modifier.padding(2.dp),
    )
}
