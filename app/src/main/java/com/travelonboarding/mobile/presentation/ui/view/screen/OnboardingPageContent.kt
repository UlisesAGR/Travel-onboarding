/*
 * OnboardingPageContent.kt
 * Created by Ulises Gonzalez
 * Copyright (c) 2025. All rights reserved
 */
package com.travelonboarding.mobile.presentation.ui.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.travelonboarding.mobile.R
import com.travelonboarding.mobile.domain.model.PageModel
import com.travelonboarding.mobile.presentation.ui.components.ButtonPrimary
import com.travelonboarding.mobile.presentation.ui.components.LottieWithPlaceholder

@Composable
fun OnboardingPageContent(
    page: PageModel,
    modifier: Modifier = Modifier,
    onPlayAudio: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            alignment = Alignment.CenterVertically,
            space = dimensionResource(id = R.dimen.padding_big),
        ),
        modifier = modifier,
    ) {
        LottieWithPlaceholder(
            animationRes = page.animation,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
        )
        Text(
            text = page.title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = page.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
        )
        ButtonPrimary(
            text = stringResource(R.string.immerse_yourself),
            onClick = {
                onPlayAudio()
            },
        )
    }
}
