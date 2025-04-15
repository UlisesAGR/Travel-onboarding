/*
 * LottieWithPlaceholder.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.travelonboarding.mobile.R

@Composable
fun LottieWithPlaceholder(
    animationRes: Int,
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))

    Crossfade(targetState = composition) { comp ->
        if (comp == null) {
            Box(
                modifier = modifier
                    .background(Color.LightGray, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LottieAnimation(
                composition = comp,
                iterations = LottieConstants.IterateForever,
                modifier = modifier,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LottieWithPlaceholderPreview() {
    LottieWithPlaceholder(
        animationRes = R.raw.suitcases,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
    )
}
